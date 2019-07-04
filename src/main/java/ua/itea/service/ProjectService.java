package ua.itea.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.itea.dao.ProjectDao;
import ua.itea.entity.Project;

public class ProjectService implements ProjectDao {

    @Override
    public void add(Project project) {

        Connection connection = Connector.getConnection();
        if (connection == null) {
            System.out.println("No connection to the database");
            return;
        }

        String sql = "INSERT INTO PROJECT VALUES (?, ?)";

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, project.getId());
            statement.setString(2, project.getTitle());

            statement.executeUpdate();

            System.out.println("Project added to the database");

        } catch (SQLException ex) {

            System.out.println("Problems forming/executing a query to the database");
            ex.printStackTrace();

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("It is impossible to close the connection to the database correctly");
                }
            }
        }

    }

    @Override
    public Project getById(long id) {

        Project project = null;

        Connection connection = Connector.getConnection();
        if (connection == null) {
            System.out.println("Nio connection to the database");
            return null;
        }
        String sql = "SELECT ID, TITLE FROM PROJECT WHERE ID=?";

        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            rs = statement.executeQuery();

            while (rs.next()) {
                project = new Project();
                project.setId(id);
                project.setTitle(rs.getNString("TITLE"));
            }

        } catch (SQLException ex) {

            System.out.println("Problems forming/executing a query to the database");
            ex.printStackTrace();
            return null;

        } finally {

            if (connection != null) {
                try {

                    connection.close();

                } catch (SQLException ex) {

                    System.out.println("It is impossible to close the connection to the database correctly");
                }
            }
        }

        return project;
    }

    @Override
    public List<Project> getAll() {
        List<Project> list = new ArrayList<>(100);

        Connection connection = Connector.getConnection();
        if(connection==null){
            System.out.println("No connection to the database");
            return null;
        }
        
        String sql = "SELECT ID, TITLE FROM PROJECT";
        Statement statement = null;
        ResultSet rs = null;
        
        try {
            statement=connection.createStatement();
            rs = statement.executeQuery(sql);
            
            while(rs.next()){
                
                Project project = new Project();
                project.setId(rs.getLong("ID"));
                project.setTitle(rs.getString("TITLE"));
                
                list.add(project);
            }
            
        } catch (SQLException ex) {
          
            System.out.println("Problems forming/executing a query to the database ");
            ex.printStackTrace();
            return null;
        }finally{
            if(connection!=null){
                try {
                    connection.close();
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
    public void update(Project project) {
     
        Connection connection = Connector.getConnection();
        if(connection==null){
            System.out.println("No connection to the database");
            return;
        }
        
        String sql = "UPDATE PROJECT SET TITLE=? WHERE ID=?";
        
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getTitle());
            statement.setLong(2, project.getId());
            
            statement.executeUpdate();
            
            System.out.println("Address update");
            
        } catch (SQLException ex) {
            
            System.out.println("Problems forming/executing a query to the database");
            ex.printStackTrace();
            return ;
            
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println(" It is impossible to close the connection to the database correctly");
                }
            }
        }
    
    }

    @Override
    public void delete(Project project) {
     
        Connection connection = Connector.getConnection();
        if(connection==null){
            System.out.println("No connection to the database");
            return;
        }
    
        String sql = "DELETE FROM PROJECT WHERE ID=?";
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, project.getId());
            
            statement.executeUpdate();
            
            System.out.println("Project delete");
            
        } catch (SQLException ex) {
            
            System.out.println("Problems forming/executing a query to the database");
            ex.printStackTrace();
            return ;
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
