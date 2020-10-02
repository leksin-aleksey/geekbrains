package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:8889/warehouse", "leksin-aleksey", "12345");
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong during establishing DB connection");
        }
    }
}
