package com.msgsystems.training.spring.w03d02s02;

import com.msgsystems.training.spring.w03d02s02.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demonstrates the wiring of an {@link ApplicationContext} using a auto-wired beans
 */
public class AutoWiringIntro {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        /*
        productRepository.displayTheBooleanValue();
        productRepository.displayTheInt();
        */
        productRepository.displayTheProducts();
    }
}
