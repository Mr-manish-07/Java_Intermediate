import java.sql.*;
import java.util.Scanner;

public class Batch_Data_Processing {

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres"; // Or your actual username
    private static final String password = "Manish@7200"; // The password you set during setup

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        // IN BATCH DATA MANIPULATION WE HAVE MULTIPLE DATA AT A TIME TO PROCESS SO WE CAN ADD ALL
        //      THOSE DATA IN A SINGLE COMPILE, WE DON'T NEED TO COMPILE AGAIN AND AGAIN.

        try{
            Connection connection = DriverManager.getConnection(url,user,password);
            String query = "INSERT INTO students(name,age,gender,email) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            while(true){
                System.out.println("-----------Enter Student Details-----------");
                System.out.print("\nEnter Name : ");
                String name = scanner.next();
                System.out.print("\nEnter Gender : ");
                String gender = scanner.next();
                System.out.print("\nEnter Email : ");
                String email = scanner.next();
                System.out.print("\nEnter Age : ");
                int age = scanner.nextInt();
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setString(3,gender);
                preparedStatement.setString(4,email);

                preparedStatement.addBatch();

                System.out.println("Would You like to Insert More Data : Y/N");
                String breakLoop = scanner.next();
                if(breakLoop.equalsIgnoreCase("N")){
                    break;
                }
            }
            int[] arrOfRow = preparedStatement.executeBatch();
            for(int i = 0; i<arrOfRow.length; i++){
                if(arrOfRow[i]==0){
                    System.out.println("Data at Position "+i+1+" is not inserted.");
                }
            }

//----------------------------------PRINTING DATA FROM DB-----------------------------

            String printDb = "select * FROM students";
            PreparedStatement preparedStatement1 = connection.prepareStatement(printDb);
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString( "email");
                String gender = resultSet.getString("gender");
                System.out.println("Name is : " + name+ "\nAge is :" +age+"\n" +
                        "Gender is "+gender + "\nEmail is : "+ email);
                System.out.println();
            }





        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



}
