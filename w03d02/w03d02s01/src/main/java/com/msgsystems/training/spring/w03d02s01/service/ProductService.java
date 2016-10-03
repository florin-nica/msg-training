package com.msgsystems.training.spring.w03d02s01.service;

import com.msgsystems.training.spring.w03d02s01.model.Product;
import com.msgsystems.training.spring.w03d02s01.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(final int id) {
        return productRepository.get(id);
    }
}
