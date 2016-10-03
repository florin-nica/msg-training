package com.msgsystems.training.spring.w03d02s01.config;

import com.msgsystems.training.spring.w03d02s01.repository.ProductRepository;
import com.msgsystems.training.spring.w03d02s01.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextConfig {

    @Bean
    public ProductService productService() {
        return new ProductService(productRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }
}
