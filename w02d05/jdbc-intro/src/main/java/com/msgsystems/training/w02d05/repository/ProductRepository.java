package com.msgsystems.training.w02d05.repository;

import com.msgsystems.training.w02d05.model.Product;
import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductRepository {

    @SuppressWarnings("unused")
    private static Server H2_SERVER;

    static {
        try {
            H2_SERVER = Server.createTcpServer();
        } catch (final SQLException e) {
            e.printStackTrace();
            System.exit(13);
        }
    }

    public ProductRepository() {
        try {
            Class.forName("org.h2.Driver");

            getConnection().prepareCall("DROP TABLE Product IF EXISTS;").execute();
            getConnection().prepareCall("CREATE TABLE Product(id INTEGER NOT NULL, name CHAR(30), PRIMARY KEY (id))").execute();

            getConnection().prepareCall("INSERT INTO Product (id, name) VALUES (1, 'Dell XPS')").execute();
            getConnection().prepareCall("INSERT INTO Product (id, name) VALUES (2, 'Asus UX530')").execute();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT count(*) FROM Product");
            resultSet.next();
            return resultSet.getInt(1);
        } catch (final SQLException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        } finally {
            closeResources(resultSet, statement);
        }
    }

    public Product getProduct(final int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();

            resultSet = statement.executeQuery("SELECT * FROM Product WHERE ID = " + id);
            if (resultSet.next()) {
                final Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                return product;
            } else {
                throw new IllegalArgumentException("There is no product with the ID " + id);
            }
        } catch (final SQLException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        } finally {
            closeResources(resultSet, statement);
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        } catch (final SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void closeResources(final ResultSet resultSet, final Statement statement) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
