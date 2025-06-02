import java.sql.*;


public class Insert_Data {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres"; // Or your actual username
    private static final String password = "Manish@7200"; // The password you set during setup


    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

//-----------------------------INSERTING  DATA-------------------------------------

//            String insertQuery = String.format("INSERT INTO students(student_id, name, age) VALUES(%o,'%s',%o)", 229, "Arif", 21);
//            int noOfRowsEffected = statement.executeUpdate(insertQuery);
//            if (noOfRowsEffected > 0) {
//                System.out.println("Database updated");
//            } else {
//                System.out.println("Database Not updated");
//            }


//------------------------------------USING PREPARED STATEMENT-------------------------

            String insertQuery = "INSERT INTO students(name,age,gender,email) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "Jeet");
            preparedStatement.setInt(2, 21);
            preparedStatement.setString(3, "Male");
            preparedStatement.setString(4, "jeet292@gmail.com");
            int noOfRowsEffected = preparedStatement.executeUpdate();
            System.out.println("No of rows effected  : "+noOfRowsEffected );
            if (noOfRowsEffected > 0) {
                System.out.println("Database updated");
            } else {
                System.out.println("Database Not updated");
            }

//-------------------------------FETCHING AND PRINTING--------------------------------

            String query = "SELECT * from students";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement1.executeQuery();
//            ResultSet resultSet = statement.executeQuery(query);
            System.out.println(resultSet);
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                System.out.println("Id is : " + id + "\nName is : " + name +
                        "\nAge is :" + age + "\nEmail is : " + email);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }
}
