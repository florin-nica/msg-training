package com.msgsystems.training.spring.w03d01s02.service;

import com.msgsystems.training.spring.w03d01s02.model.Product;
import com.msgsystems.training.spring.w03d01s02.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(final int id) {
        return productRepository.get(id);
    }
}
