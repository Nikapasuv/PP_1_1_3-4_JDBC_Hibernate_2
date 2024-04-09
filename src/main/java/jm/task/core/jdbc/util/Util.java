package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static String dbURL = "jdbc:mysql://localhost:3306/test1";
    private static String dbUserName = "root";
    private static String dbPassword = "Nikapasuv";

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
