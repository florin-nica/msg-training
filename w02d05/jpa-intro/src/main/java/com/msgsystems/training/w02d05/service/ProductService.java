package com.msgsystems.training.w02d05.service;

import com.msgsystems.training.w02d05.model.Product;
import com.msgsystems.training.w02d05.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(final Product product) {
        productRepository.saveProduct(product);
    }

    public Product getProduct(final int id) {
        return productRepository.getProduct(id);
    }

    public void updateProduct(final Product product) {
        productRepository.updateProduct(product);
    }

    public void deleteProduct(final Product product) {
        productRepository.deleteProduct(product);
    }
}
