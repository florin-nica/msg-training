package com.msgsystems.training.spring.w03d02s02.repository;

import com.msgsystems.training.spring.w03d02s02.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @SuppressWarnings("unused")
    public Product get(int id) {
        final Product product = new Product();
        product.setId(24);
        product.setName("Dell XPS 9350");

        return product;
    }
}
