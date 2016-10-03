package com.msgsystems.training.spring.w03d02s02.controller;

import com.msgsystems.training.spring.w03d02s02.model.Product;
import com.msgsystems.training.spring.w03d02s02.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product getProduct(final int id) {
        return productService.getProduct(id);
    }
}
