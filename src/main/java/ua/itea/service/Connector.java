
package ua.itea.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connector {
    
    private static final String URL="jdbc:h2:~/employee";
    private static final String USER="sa";
    private static final String PASSWORD="";
    
    public static Connection getConnection(){
        
        Connection connection = null;
        
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error connection");
            return null;
        }
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Can not connect to DB");
        return null;
        }
        
        System.out.println("Connected successfully...");
        
        return connection;
    }
    
    public static void main(String[] args) {
        
        Connection connection = getConnection();
        
    }
    
}
