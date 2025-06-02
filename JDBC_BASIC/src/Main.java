import java.sql.*;

public class Main {

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
            Statement statement = connection.createStatement();

            // Queries
//            String insertQuery = String.format("INSERT INTO students(student_id, name, age) VALUES(%o,'%s',%o)",232,"Suraj",21);
//            int noOfRowsEffected = statement.executeUpdate(insertQuery);
//            if(noOfRowsEffected > 0){
//                System.out.println("Data Inserted");
//            }else{
//                System.out.println("Data Not Inserted");
//            }

//            String insertQuery = String.format("INSERT INTO students(student_id, name, age) VALUES(%o,'%s',%o)",231,"Manish",20);
//            int noOfRowsEffected = statement.executeUpdate(insertQuery);
//
//            if(noOfRowsEffected > 0){
//                System.out.println("Data Inserted");
//            }else{
//                System.out.println("Data Not Inserted");
//            }


//            String updateQuery = String.format("UPDATE students SET gender='%s' WHERE student_id=%d","male",1);
//            int noOfRowsEffected = statement.executeUpdate(updateQuery);
//
//            if(noOfRowsEffected > 0){
//                System.out.println("Database updated");
//            }else{
//                System.out.println("Database Not updated");
//            }

//            String deleteQuery = String.format("DELETE FROM students WHERE student_id=%d",1);
//            int noOfRowsEffected = statement.executeUpdate(deleteQuery);
//
//            if(noOfRowsEffected > 0){
//                System.out.println("Data Deleted From Database");
//            }else{
//                System.out.println("Data Can't be Deleted");
//            }

//------------------------------PREPARED STATEMENT------------------------------------

//            String insertQuery = "INSERT INTO students(name,age,gender,email) VALUES(?,?,?,?)";
//            String insertQuery = "SELECT age FROM students WHERE student_id=?";
            String updateQuery = "UPDATE students SET age = ? WHERE student_id = ?";
            String deleteQuery = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
//            preparedStatement.setString(1,"Ankita" );
//            preparedStatement.setInt(2,21);
//            preparedStatement.setString(3,"Female");
//            preparedStatement.setString(4,"ankita12@gmail.com");
//            preparedStatement.setInt(1,2);
            preparedStatement.setInt(1,2);
//            preparedStatement.setInt(2,350);
//            ResultSet resultSet2 = preparedStatement.executeQuery();
//            if(resultSet2.next()){
////                int age = resultSet2.getInt("age");
////                System.out.println("Age of Ankita is : " + age);
//                System.out.println("Updated age");
//            }else{
//                System.out.println("Can't updated");
//            }



            int noOfRowsEffected = preparedStatement.executeUpdate();
            if(noOfRowsEffected>0){
                System.out.println("Data Inserted into database");
            }else {
                System.out.println("Data Can't Inserted");
            }

            String query = "select * from students";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement1.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                System.out.println("Id is : " + id + "\nName is : " + name+ "\nAge is :" +age+"\n" +
                        "Gender is "+gender );
                System.out.println();
            }



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }









    }
}