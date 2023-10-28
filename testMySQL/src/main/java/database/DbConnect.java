/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author hocin
 */
public class DbConnect {
    
//        private static String HOST = "127.0.0.1";
//        private static int PORT = 3305;
//        private static String DB_NAME = "my_classicmodels";
//        private static String USERNAME = "root";
//        private static String PASSWORD = "22021182";
        private static Connection connection ;
        
        
        public static Connection getConnect (){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3305/my_classicmodels";
            String username = "root";
            String password = "22021182";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return  connection;
        }
        
        
        

    
}
