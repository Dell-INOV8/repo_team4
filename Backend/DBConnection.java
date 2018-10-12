/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dellconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Handles a database connection and provides instances of a db connection
 * @author Chance
 */
public class DBConnection {

    private static ThreadLocal<Connection> con = new ThreadLocalConnection();
    private static Properties props = null;

    public static Connection getConnection() {
        if (props == null) {
            throw new RuntimeException("DatabaseConnection not initialized");
        }
        try {
            Connection c = con.get();
            if (c == null || !c.isValid(0)) {
                con.set(null);
                con.remove();
            }
        } catch (SQLException ex) {
        }

        return con.get();
    }

    public static boolean isInitialized() {
        return props != null;
    }

    public static void setProps(Properties aProps) {
        props = aProps;
    }

    private static class ThreadLocalConnection extends ThreadLocal<Connection> {
        
        @Override
        protected Connection initialValue() {
            final String driver = props.getProperty("driver");
            final String url = props.getProperty("url");
            final String user = props.getProperty("user");
            final String password = props.getProperty("password");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
            }
            try {
                final Connection con = DriverManager.getConnection(url, user, password);
                return con;
            } catch (SQLException e) {
                return null;
            }
        }
    }
}