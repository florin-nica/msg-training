package com.msgsystems.training.w02d05;

import com.msgsystems.training.w02d05.repository.ProductRepository;
import com.msgsystems.training.w02d05.service.ProductService;
import org.h2.tools.Server;

public class JDBCMain {

    static {
        try {
            Server.createTcpServer();
            Class.forName("org.h2.Driver");
        } catch (final Exception e) {
            e.printStackTrace();
            System.exit(13);
        }
    }

    public static void main(final String[] args) {
        final ProductRepository productRepository = new ProductRepository();
        final ProductService productService = new ProductService(productRepository);

        System.out.println("There are " + productService.getCount() + " products in the database");

        final int id = 1;
        System.out.println("The product with the ID " + id + " is '" + productService.getProduct(id).getName() + "'");
    }
}
