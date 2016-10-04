package com.msg.springtraining.myproject.service;

import com.msg.springtraining.myproject.model.Product;
import com.msg.springtraining.myproject.repository.ProductRepository;

import java.util.Set;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setProductsFromFile(String filePath) {
        productRepository.setProductsFromFile(filePath);
    }

    public Set<Product> getProducts() {
        return productRepository.getProducts();
    }

    public void setProducts(Set<Product> products) {
        productRepository.setProducts(products);
    }

}
