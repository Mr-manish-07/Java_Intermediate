import java.sql.*;

public class Fetching_Data {
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

            String query = "select * from students";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Id is : " + id + "\nName is : " + name+ "\nAge is :" +age );
                System.out.println();
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }








    }
}
