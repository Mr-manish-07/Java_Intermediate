import java.sql.*;

public class Connecting_DB {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "Manish@7200";


    public static void main(String[] args) {
        try {

            Class.forName("org.postgresql.Driver");
            try{

                Connection connection = DriverManager.getConnection(url,user,password);
                Statement statement = connection.createStatement();
                System.out.println("Database connected Successfully");

            }catch (SQLException e){

                System.out.println(e.getMessage());
                System.out.println("Fetching Error : Some connection problem occurs");

            }

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

    }
}
