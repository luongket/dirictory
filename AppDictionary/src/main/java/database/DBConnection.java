package database;

import java.sql.*;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection con = DBConnection.getConnection();
    public static PreparedStatement ps;
    public static ResultSet result;

    public static Connection getConnection() {
        final String url = "jdbc:mysql://localhost:3305/libraly";
        final String username = "root";
        final String password = "22021182";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}