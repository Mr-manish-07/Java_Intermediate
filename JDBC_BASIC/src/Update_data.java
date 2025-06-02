import java.sql.*;

public class Update_data {

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

//----------------------------------PREPARED STATEMENT--------------------------------

//            String updateQuery = String.format("UPDATE students SET gender='%s' WHERE student_id=%d","male",1);
//            int noOfRowsEffected = statement.executeUpdate(updateQuery);
//
//            if(noOfRowsEffected > 0){
//                System.out.println("Database updated");
//            }else{
//                System.out.println("Database Not updated");
//            }

//------------------------------FETCHING DATA---------------------------------------
            String query = "select * from students";
            ResultSet resultSet = statement.executeQuery(query);

//------------------------------USING PREPARED-------------------------------------
            String deleteQuery = "UPDATE students SET gender = ? WHERE student_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, "N/A");
            preparedStatement.setInt(2, 12);
            int noOfRowsEffected = preparedStatement.executeUpdate();
            if(noOfRowsEffected>0){
                System.out.println("Data Manipulated");
            }else {
                System.out.println("Configuration Mismatch");
            }

//----------------------------------PRINTING DATA-------------------------------------

            while (resultSet.next()){
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                System.out.println("Id is : " + id + "\nName is : " + name+ "\nAge is :" +age+"\n" +
                        "Gender is "+gender );
                System.out.println();
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }




}
