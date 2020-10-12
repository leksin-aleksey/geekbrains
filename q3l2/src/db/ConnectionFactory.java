package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getInstance(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "leksin-aleksey", "12345");
//            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");

        } catch (Exception e) {
            throw new RuntimeException("Something went wrong during establishing DB connection", e.getCause());
        }
    }
}
