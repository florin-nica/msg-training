package com.msgsystems.training.w02d05;

import com.msgsystems.training.w02d05.model.Product;
import com.msgsystems.training.w02d05.model.Store;
import com.msgsystems.training.w02d05.repository.ProductRepository;
import com.msgsystems.training.w02d05.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
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

        // jpqlSample();
        // criteriaAPISample();

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
        // productRepository.deleteProduct(savedProduct);

        System.out.println("There is no product with the ID 1 - " + (productRepository.getProduct(1) == null));
    }

    @SuppressWarnings("unchecked")
    private static void jpqlSample() {
        final Query query = entityManager.createNamedQuery(Product.GET_PRODUCTS_BY_NAME, Product.class)
                                         .setParameter("name", "an updated name");
        final List<Product> products = (List<Product>) query.getResultList();

        System.out.println("Found the following products:");
        products.forEach(product -> System.out.println("\t" + product.getId() + ", " + product.getName()));
    }

    private static void criteriaAPISample() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

        final Root<Product> from = criteriaQuery.from(Product.class);
        final CriteriaQuery<Product> select = criteriaQuery.select(from);
        final TypedQuery<Product> typedQuery = entityManager.createQuery(select);

        final List<Product> products = typedQuery.getResultList();
        products.forEach(product -> System.out.println(product.getName()));
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
