package com.msgsystems.training.spring.w03d01s02.repository;

import com.msgsystems.training.spring.w03d01s02.model.Product;

public class ProductRepository {

    private String repositoryName;

    @SuppressWarnings("unused")
    public Product get(int id) {
        final Product product = new Product();
        product.setId(24);
        product.setName("Dell XPS 9350");

        return product;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }
}
