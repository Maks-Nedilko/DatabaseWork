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
import ua.itea.dao.AddressDao;
import ua.itea.entity.Address;

public class AddressService implements AddressDao {

    @Override
    public void add(Address address) {

        Connection connection = Connector.getConnection();

        if (connection == null) {
            System.out.println("No connection to the database");
            return;
        }
        String sql = "INSERT INTO ADDRESS VALUES (?,?,?,?)";

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, address.getId());
            statement.setString(2, address.getCountry());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getStreet());

            statement.executeUpdate();

            System.out.println("Address added to the database");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Problems of forming/executing a query to the database");
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
    public Address getById(long id) {

        Address address = null;

        Connection connect = Connector.getConnection();
        if (connect == null) {
            System.out.println("No connection to the database");
            return null;
        }

        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql = "SELECT ID, COUNTRY, CITY, STREET FROM ADDRESS WHERE ID=?";

        try {
            statement = connect.prepareStatement(sql);
            statement.setLong(1, id);

            rs = statement.executeQuery();

            while (rs.next()) {
                address = new Address();
                address.setId(id);
                address.setCountry(rs.getNString("COUNTRY"));
                address.setCity(rs.getNString("CITY"));
                address.setStreet(rs.getNString("STREET"));

            }

        } catch (SQLException ex) {
            System.out.println("Problems of forming/executing a query to the database ");
            ex.printStackTrace();
            return null;
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("It is impossible to close the connection to the database correctly");
                }

            }
        }
        return address;
    }

    @Override
    public List<Address> getAll() {
        List<Address> list = new ArrayList<>(100);

        Connection connect = Connector.getConnection();

        if (connect == null) {
            System.out.println("No connection to the database");
            return null;
        }

        Statement statement = null;
        ResultSet rs = null;
        String sql = "SELECT ID, COUNTRY, CITY, STREET FROM ADDRESS";

        try {
            statement = connect.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {

                Address address = new Address();
                address.setId(rs.getLong("ID"));
                address.setCountry(rs.getNString("COUNTRY"));
                address.setCity(rs.getNString("CITY"));
                address.setStreet(rs.getNString("STREET"));

                list.add(address);

            }

        } catch (SQLException ex) {
            System.out.println("Problems forming/executing a query to the database");
            ex.printStackTrace();//последовательность
            return null;
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException ex) {
                    System.out.println("It is impossible to close the connection to the database correctly");
                }
            }
        }
        if (list.size() == 0) {
            return null;
        } else {
            return list;
        }

    }

    @Override
    public void update(Address address) {
        Connection connection = Connector.getConnection();

        if (connection == null) {
            System.out.println("No connection to the database");
            return ;
        }
        String sql = "UPDATE ADDRESS SET COUNTRY=?,CITY=?,STREET=? WHERE ID=?";

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);

            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setLong(4, address.getId());

            statement.executeUpdate();

            System.out.println("Address update");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Problems forming/executing a query to the database ");
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
    public void delete(Address address) {

        Connection connection = Connector.getConnection();

        if (connection == null) {
            System.out.println("No connection to the database");
            return;
        }
        String sql = "DELETE FROM ADDRESS WHERE ID =?";

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, address.getId());

            statement.executeUpdate();

            System.out.println("Address delete");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Problems forming/executing a query to the database");
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

}
