package com.example.appdictionary;

import java.sql.*;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection con= DBConnection.getConnection();
    public static PreparedStatement ps;
    public static ResultSet result;

    public static Connection getConnection() {
        final String url = "jdbc:mysql://localhost:3306/dictionaryApp";
        final String username = "root";
        final String password = "Khaiconvn06";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
