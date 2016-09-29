package com.msgsystems.training.w02d05.repository;

import com.msgsystems.training.w02d05.model.Product;
import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProductRepository {

    @SuppressWarnings("unused")
    private static Server h2Server;

    private final EntityManager entityManager;

    static {
        try {
            h2Server = Server.createTcpServer();
            Class.forName("org.h2.Driver");
        } catch (final Exception e) {
            e.printStackTrace();
            System.exit(13);
        }
    }

    public ProductRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Product getProduct(final int id) {
        return entityManager.find(Product.class, id);
    }

    public void saveProduct(final Product product) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        try {
            entityManager.persist(product);
            entityManager.flush();

            transaction.commit();
        } catch (final Exception ex) {
            transaction.rollback();
        }
    }

    public void updateProduct(final Product product) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        try {
            entityManager.merge(product);
            entityManager.flush();

            transaction.commit();
        } catch (final Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void deleteProduct(final Product product) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        try {
            entityManager.remove(product);
            entityManager.flush();

            transaction.commit();
        } catch (final Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
}
