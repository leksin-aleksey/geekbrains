import db.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionFactory.getInstance();
        System.out.println(connection.getSchema());
    }
}
