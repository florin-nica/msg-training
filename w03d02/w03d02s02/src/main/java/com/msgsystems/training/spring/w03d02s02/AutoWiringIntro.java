package com.msgsystems.training.spring.w03d02s02;

import com.msgsystems.training.spring.w03d02s02.controller.ProductController;
import com.msgsystems.training.spring.w03d02s02.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demonstrates the wiring of an {@link ApplicationContext} using a auto-wired beans
 */
public class AutoWiringIntro {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final ProductController productController = applicationContext.getBean(ProductController.class);

        final Product product = productController.getProduct(23);
        System.out.println(product.getName());
    }
}
