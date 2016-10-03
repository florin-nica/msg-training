package com.msgsystems.training.spring.w03d01s02;

import com.msgsystems.training.spring.w03d01s02.config.AppContextConfig;
import com.msgsystems.training.spring.w03d01s02.model.Product;
import com.msgsystems.training.spring.w03d01s02.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demonstrates the wiring of an {@link ApplicationContext} using a
 * {@link org.springframework.context.annotation.Configuration} annotated class
 */
public class ConfigurationWiringIntro {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppContextConfig.class);
        final ProductService productService = applicationContext.getBean(ProductService.class);

        final Product product = productService.getProduct(23);
        System.out.println(product.getName());
    }
}
