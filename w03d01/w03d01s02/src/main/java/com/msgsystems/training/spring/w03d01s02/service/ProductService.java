package com.msgsystems.training.spring.w03d01s02.service;

import com.msgsystems.training.spring.w03d01s02.model.Product;
import com.msgsystems.training.spring.w03d01s02.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository, final ProductRepository secondRepo) {
        this.productRepository = productRepository;
    }

    public void init() {
        System.out.println("Do stuff on init");
    }

    public Product getProduct(final int id) {
        return productRepository.get(id);
    }

    public void destroy() {
        System.err.println("Do stuff on destroy");
    }
}
