package bank;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
