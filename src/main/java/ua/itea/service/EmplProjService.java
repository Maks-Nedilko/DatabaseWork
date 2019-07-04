/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import ua.itea.dao.EmplProjDao;
import ua.itea.entity.EmplProj;

/**
 *
 * @author makst
 */
public class EmplProjService implements EmplProjDao {

    @Override
    public void add(EmplProj emplproj) {

        Connection connection = Connector.getConnection();

        if (connection == null) {
            System.out.println("No conection to the database");
            return;
        }

        String sql = "INSERT INTO EMPL_PROJ VALUES(?, ?) ";

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, emplproj.getEmplId());
            statement.setLong(2, emplproj.getProjId());

            statement.executeUpdate();
            System.out.println("EmplProj added to the database");

        } catch (SQLException ex) {
            System.out.println("Problems forming/executing a query to the database");
            ex.printStackTrace();
            return;
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
    public EmplProj getById(long emplId, long projId) {

        EmplProj emplproj = null;

        Connection connection = Connector.getConnection();
        if (connection == null) {
            System.out.println("No connection to the database");
            return null;
        }

        String sql = "SELECT EMPLOYRR_ID, PROJECT_ID FROM EMPL_PROJ WHERE EMPLOYRR_ID=? AND PROJECT_ID=?";

        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, emplId);
            statement.setLong(2, projId);

            rs = statement.executeQuery();

            while (rs.next()) {
                emplproj = new EmplProj();
                emplproj.setEmplId(emplId);
                emplproj.setProjId(projId);

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
        return emplproj;
    }

    @Override
    public List<EmplProj> getAll() {

        List<EmplProj> list = new ArrayList<>(100);

        Connection connection = Connector.getConnection();
        if (connection == null) {
            System.out.println("No connection to the database");
            return null;
        }

        String sql = "SELECT EMPLOYRR_ID, PROJECT_ID FROM EMPL_PROJ";
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {

                EmplProj emplproj = new EmplProj();
                emplproj.setEmplId(rs.getLong("EMPLOYRR_ID"));
                emplproj.setProjId(rs.getLong("PROJECT_ID"));

                list.add(emplproj);
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
            if (list.size() == 0) {
                return null;
            } else {
                return list;
            }

        }

    }

    @Override
    public void update(EmplProj emplproj) {

        Connection connection = Connector.getConnection();

        if (connection == null) {
            System.out.println("No connection to the database");
            return;
        }

        String sql = "UPDATE EMPL_PROJ SET EMPLOYRR_ID=?, PROJECT_ID=? WHERE EMPLOYRR_ID=? AND PROJECT_ID=?";

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);

            statement.setLong(1, emplproj.getEmplId());
            statement.setLong(2, emplproj.getProjId());
            statement.setLong(3, emplproj.getEmplId());
            statement.setLong(4, emplproj.getProjId());

            statement.executeUpdate();
            System.out.println("emplproj update");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Problems forming/executing a query to the database ");
        }finally {
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
    public void delete(EmplProj emplproj) {
    
        Connection connection = Connector.getConnection();
        if(connection==null){
            System.out.println("No connection to the database");
            return ;
        }
    
        String sql = "DELETE FROM EMPL_PROJ WHERE EMPLOYRR_ID=? AND PROJECT_ID=?";
        
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            
            statement.setLong(1, emplproj.getEmplId());
            statement.setLong(2, emplproj.getProjId());
            
            statement.executeUpdate();
            
            System.out.println("emplproj delete");
            
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
