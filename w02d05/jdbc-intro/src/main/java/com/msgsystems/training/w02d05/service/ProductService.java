package com.msgsystems.training.w02d05.service;

import com.msgsystems.training.w02d05.model.Product;
import com.msgsystems.training.w02d05.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int getCount() {
        return productRepository.getCount();
    }

    public Product getProduct(final int id) {
        return productRepository.getProduct(id);
    }
}
