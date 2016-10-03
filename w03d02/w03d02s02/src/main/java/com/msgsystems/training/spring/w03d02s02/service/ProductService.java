package com.msgsystems.training.spring.w03d02s02.service;

import com.msgsystems.training.spring.w03d02s02.model.Product;
import com.msgsystems.training.spring.w03d02s02.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(final int id) {
        return productRepository.get(id);
    }
}
