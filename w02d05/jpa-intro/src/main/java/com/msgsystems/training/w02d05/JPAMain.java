package com.msgsystems.training.w02d05;

import com.msgsystems.training.w02d05.model.Product;
import com.msgsystems.training.w02d05.model.Store;
import com.msgsystems.training.w02d05.repository.ProductRepository;
import com.msgsystems.training.w02d05.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

public class JPAMain {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private static ProductRepository productRepository;
    private static ProductService productService;

    static {
        // disable Hibernate's logging messages
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-intro");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static void main(final String[] args) {
        productRepository = new ProductRepository(entityManager);
        productService = new ProductService(productRepository);

        productCRUD();
        // storeCRUD();

        closeEntityManagerObjects();
    }

    private static void productCRUD() {
        final Product product = new Product();
        product.setName("iSomething");

        // save product
        productService.saveProduct(product);

        // read product, by ID
        final Product savedProduct = productService.getProduct(1);
        System.out.println("The saved product is '" + savedProduct.getName() + "'");

        // update product
        product.setName("an updated name");
        productService.updateProduct(product);

        System.out.println("The updated product name is '" + savedProduct.getName() + "'");

        // delete the previously saved product
        productRepository.deleteProduct(savedProduct);

        System.out.println("There is no product with the ID 1 - " + (productRepository.getProduct(1) == null));
    }

    private static void storeCRUD() {
        final Store store = new Store();
        store.setStoreName("Zara");

        final Product product = new Product();
        product.setName("A fancy t-shirt");

        final Set<Product> products = new HashSet<Product>(1);
        products.add(product);

        store.setProducts(products);
    }

    private static void closeEntityManagerObjects() {
        if (entityManager != null) {
            entityManager.close();
        }

        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
