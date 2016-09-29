package com.msgsystems.training.w02d05.repository;

import com.msgsystems.training.w02d05.model.Product;
import org.h2.tools.Server;
import org.jooq.lambda.Unchecked;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

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
        Connection connection = null;
        try {
            // load the H2 driver
            Class.forName("org.h2.Driver");

            connection = getConnection();

            connection.prepareCall("DROP TABLE Product IF EXISTS;").execute();
            connection.prepareCall("CREATE TABLE Product(id INTEGER NOT NULL, name CHAR(30), PRIMARY KEY (id))").execute();

            connection.prepareCall("INSERT INTO Product (id, name) VALUES (1, 'Dell XPS')").execute();
            connection.prepareCall("INSERT INTO Product (id, name) VALUES (2, 'Asus UX530')").execute();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, null, null);
        }
    }

    public int getCount() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT count(*) FROM Product");
            resultSet.next();
            return resultSet.getInt(1);
        } catch (final SQLException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        } finally {
            closeResources(connection, resultSet, statement);
        }
    }

    public Product getProduct(final int id) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();

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
            closeResources(connection, resultSet, statement);
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        } catch (final SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void closeResources(final Connection connection, final ResultSet resultSet, final Statement statement) {
        Optional.ofNullable(connection)
                .ifPresent(Unchecked.consumer(Connection::close));
        Optional.ofNullable(resultSet)
                .ifPresent(Unchecked.consumer(ResultSet::close));
        Optional.ofNullable(statement)
                .ifPresent(Unchecked.consumer(Statement::close));
    }
}
