package com.msgsystems.training.spring.w03d02s01.repository;

import com.msgsystems.training.spring.w03d02s01.model.Product;

public class ProductRepository {

    @SuppressWarnings("unused")
    public Product get(int id) {
        final Product product = new Product();
        product.setId(24);
        product.setName("Dell XPS 9350");

        return product;
    }
}
