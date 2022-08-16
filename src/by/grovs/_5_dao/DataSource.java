package by.grovs._5_dao;


import by.grovs._3_service.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource {
    Connection connection;
    Util util = new Util();

    //properties
    String url = util.getPropertiesValue("url");
    String username = util.getPropertiesValue("username");
    String password = util.getPropertiesValue("password");

    public Connection getConnection() {

        if (connection == null) {

            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return connection;
    }
}
