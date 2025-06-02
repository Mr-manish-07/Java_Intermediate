package Transection_Handling;

import java.sql.*;
import java.util.Scanner;

public class Bank_Management {
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

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ? ";
            String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ? ";
            PreparedStatement debitPreparedStatement = connection.prepareStatement(debitQuery);
            PreparedStatement creditPreparedStatement = connection.prepareStatement(creditQuery);
            connection.setAutoCommit(false);
            System.out.println("Enter Amount debit : ");
            int withdraw = scanner.nextInt();
            System.out.println("Enter Account Number for debit: ");
            String debit_acc = scanner.next();
            System.out.println("Enter Account Number for credit: ");
            String credit_acc = scanner.next();
            debitPreparedStatement.setInt(1,withdraw);
            debitPreparedStatement.setString(2,debit_acc);
            creditPreparedStatement.setInt(1,withdraw);
            creditPreparedStatement.setString(2,credit_acc);
            if(balanceChecking(connection,debit_acc,withdraw)){
                debitPreparedStatement.executeUpdate();
                creditPreparedStatement.executeUpdate();
                connection.commit();
                System.out.println("Payment Successfully ");
            }else {
                connection.rollback();
                System.out.println("Transaction Failed");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    static boolean balanceChecking(Connection connection,String account_number,int amount){
        try{
            String query = "SELECT balance FROM accounts WHERE account_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,account_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int balance = resultSet.getInt("balance");
                System.out.println(balance+" "+amount);
                return amount <= balance;
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }
}
