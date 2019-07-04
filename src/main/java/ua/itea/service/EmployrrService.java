
package ua.itea.service;

import static java.lang.ProcessBuilder.Redirect.to;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.itea.dao.EmployrrDao;
import ua.itea.entity.Employrr;


public class EmployrrService implements EmployrrDao{

    @Override
    public void add(Employrr employrr) {
     
      Connection connection = Connector.getConnection();
        
        if(connection == null){
            System.out.println("No connection to the database");
            return;
        }
        String sql  ="INSERT INTO EMPLOYRR VALUES (?,?,?,?,?)";
        
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
        statement.setLong(1, employrr.getId());
        statement.setString(2, employrr.getFirst_name());
        statement.setString(3, employrr.getLast_name());
        statement.setDate(4, employrr.getBirthday());
        statement.setLong(5, employrr.getAddress());
        
        statement.executeUpdate();
        
            System.out.println("Address added to the database");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Problems forming/executing a query to the database");
        } finally{
            if(connection !=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("It is impossible to close the connection to the database correctly");
                }
            }
        }
    
    }

    @Override
    public Employrr getById(long id) {
    
        Employrr employrr = null;
        
        Connection connect = Connector.getConnection();
        if(connect==null){
            System.out.println("No connection to the database");
            return null;
        }
        
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID FROM EMPLOYRR WHERE ID=?";
        
        try {
            statement = connect.prepareStatement(sql);
            statement.setLong(1, id);
            
            rs = statement.executeQuery();
            
            while(rs.next()){
                employrr = new Employrr();
                employrr.setId(id);
                employrr.setFirst_name(rs.getNString("FIRST_NAME"));
                employrr.setLast_name(rs.getNString("LAST_NAME"));
                employrr.setBirthday(rs.getDate("BIRTHDAY"));
                employrr.setAddress(rs.getLong("ADDRESS_ID"));
            }
            
        }catch (SQLException ex){
             System.out.println("Problems of forming/executing a query to the database ");
            ex.printStackTrace();
            return null;
        }finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("It is impossible to close the connection to the database correctly");
                }

            }
        }
        
        return employrr;
    }

    @Override
    public List<Employrr> getAll() {
       
        List<Employrr> list = new ArrayList<>(100);
        
        Connection connect = Connector.getConnection();
        
        if(connect==null){
            System.out.println("No connection to the database");
            return null;
        }
        
        Statement statement = null;
        ResultSet rs = null;
        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID FROM EMPLOYRR";
        
        
            try {
                statement = connect.createStatement();
                rs = statement.executeQuery(sql);
                
                while(rs.next()){
                    
                    Employrr employrr = new Employrr();
                    employrr.setId(rs.getLong("ID"));
                    employrr.setFirst_name(rs.getNString("FIRST_NAME"));
                    employrr.setLast_name(rs.getNString("LAST_NAME"));
                    employrr.setBirthday(rs.getDate("BIRTHDAY"));
                    employrr.setAddress(rs.getLong("ADDRESS_ID"));
                    
                    list.add(employrr);
                    
                }
                
            } catch (SQLException ex) {
                System.out.println("Problems forming/executing a query to the database");
                ex.printStackTrace();
                return null;
            }finally{
                if(connect!=null){
                    try {
                        connect.close();
                    } catch (SQLException ex) {
                       System.out.println("It is impossible to close the connection to the database correctly");
                    }
                }
            }
            if(list.size()==0){
                return null;
            }else{
                return list;
            }
      
    }

    @Override
    public void update(Employrr employrr) {
    
        Connection connection = Connector.getConnection();
        if(connection==null){
            System.out.println("No connection to the database");
            return ;
        }
        
        String sql = "UPDATE EMPLOYRR SET FIRST_NAME=?, LAST_NAME=?, BIRTHDAY=?, ADDRESS_ID=? WHERE ID=?";
        
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, employrr.getFirst_name());
            statement.setString(2, employrr.getLast_name());
            statement.setDate(3, employrr.getBirthday());
            statement.setLong(4, employrr.getAddress());
            statement.setLong(5, employrr.getId());
            
            statement.executeUpdate();
            
            System.out.println("Address update");
            
        } catch (SQLException ex) {
            System.out.println("Problems forming/executing a query to the database");
            ex.printStackTrace();
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("It is impossible to close the connection to the database correctly");
                }
            }
        }
        
    }

    @Override
    public void delete(Employrr employrr) {
    
        Connection connection = Connector.getConnection();
        if(connection==null){
            System.out.println("No connection to the database");
            return ;
        }
    
        String sql = "DELETE FROM EMPLOYRR WHERE ID =? ";
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, employrr.getId());
            
            statement.executeUpdate();
            
            System.out.println("Address delete!!!");
            
        } catch (SQLException ex) {
           
            System.out.println("Problems forming/executing a query to the database");
            ex.printStackTrace();
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("It is impossible to close the connection to the database correctly");
                }
            }
        }
    }
    
}
