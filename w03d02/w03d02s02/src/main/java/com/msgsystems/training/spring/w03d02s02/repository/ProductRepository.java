package com.msgsystems.training.spring.w03d02s02.repository;

import com.msgsystems.training.spring.w03d02s02.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProductRepository {

    @Value("${aBooleanValue}")
    private boolean theBooleanValue;

    @Value("${anIntegerValue}")
    private int theIntValue;

    private List<Product> products;

    @SuppressWarnings("unused")
    public Product get(int id) {
        final Product product = new Product();
        product.setId(24);
        product.setName("Dell XPS 9350");

        return product;
    }

    public void displayTheBooleanValue() {
        System.out.println("The boolean value is " + theBooleanValue);
    }

    public void displayTheInt() {
        System.out.println("The int is " + theIntValue);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void displayTheProducts() {
        products.forEach(product -> System.out.println(product.getId() + ", " + product.getName()));
    }

    @PostConstruct
    public void composeProductsList() {
        System.out.println("Composing the list of products...");
    }
}
