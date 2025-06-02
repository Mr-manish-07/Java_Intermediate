import java.sql.*;

public class Delete_Data {

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres"; // Or your actual username
    private static final String password = "Manish@7200"; // The password you set during setup

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,user,password);

            //------------------------ STATEMENT ---------------------------------
//            Statement statement = connection.createStatement();
//
//            String deleteQuery = String.format("DELETE FROM students WHERE student_id=%d",1);
//            int noOfRowsEffected = statement.executeUpdate(deleteQuery);
//
//            if(noOfRowsEffected > 0){
//                System.out.println("Data Deleted From Database");
//            }else{
//                System.out.println("Data Can't be Deleted");
//            }

//            -------------------------FETCHING DATA-------------------------------

//            String query = "SELECT * from students";
//            ResultSet resultSet = statement.executeQuery(query);


            //-------------------------PREPARED STATEMENT--------------------------

            String deleteQuery = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1,4);

            int rowEffected = preparedStatement.executeUpdate();
            if(rowEffected>0){
                System.out.println("Data Deleted From DataBase");
            }else {
                System.out.println("Configuration Mismatch");
            }


//            ---------------------------FETCHING DATA---------------------------

            String printQuery = "select * from students";
            PreparedStatement preparedStatement1 = connection.prepareStatement(printQuery);
            ResultSet resultSet = preparedStatement1.executeQuery();

//            -----------------------------PRINTING-------------------------------

            while (resultSet.next()){
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                System.out.println("Id is : " + id + "\nName is : " + name+ "\nAge is :" +age+
                        "\nGender is "+gender +"\nEmail is : "+email);
                System.out.println();
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }



    }
}
