package by.grovs.util;

import by.grovs._5_dao.impl.BookDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static final String URL = "url";
    public static final String USER = "username";
    public static final String PASSWORD = "password";

    static {
        initDriver();
    }


    private static void initDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection get() throws SQLException {

        return DriverManager.getConnection(
                PropertiesHelper.get(URL),
                PropertiesHelper.get(USER),
                PropertiesHelper.get(PASSWORD)
        );


    }

}
