package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import jm.task.core.jdbc.model.User;

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

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            configuration.setProperty("hibernate.connection.url", dbURL);
            configuration.setProperty("hibernate.connection.username", dbUserName);
            configuration.setProperty("hibernate.connection.password", dbPassword);
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
