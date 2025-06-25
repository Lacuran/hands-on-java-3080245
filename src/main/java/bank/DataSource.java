package bank;

import lombok.NoArgsConstructor;

import java.sql.*;

@NoArgsConstructor
public class DataSource {

    public static Connection connect() {
        String db_file = "jdbc:sqlite:resources/bank.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(db_file);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Customer getCustomer(String username) {
        String sqlQuery = "select * from customers where username = ?";
        Customer customer = null;

        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sqlQuery)){

            statement.setString(1, username);
            try(ResultSet resultSet = statement.executeQuery()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("account_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public static Account getAccount(int accountId) {
        String sqlQuery = "select * from accounts where id = ?";
        Account account = null;

        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sqlQuery)){

            statement.setInt(1, accountId);
            try(ResultSet resultSet = statement.executeQuery()) {
                account = new Account(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getDouble("balance")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
