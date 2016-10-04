package com.msg.springtraining.myproject.repository;

import com.msg.springtraining.myproject.model.Product;
import com.msg.springtraining.myproject.service.FilesService;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductRepository {

    private FilesService filesService;
    private Set<Product> products;
    private String filePath;

    public ProductRepository(FilesService filesService, String filePath) {
        this.filesService = filesService;
        setProductsFromFile(filePath);
    }

    private Function<String, Product> setProduct = string -> {
        Product product = new Product();
        final String[] split = string.split(",");
        product.setId(Integer.parseInt(split[0]));
        product.setName(split[1]);
        product.setProducer(split[2]);
        product.setDescription(split[3]);
        product.setPrice(Double.parseDouble(split[4]));
        return product;
    };

    public void setProductsFromFile(String filePath) {

        Set<Product> products = new HashSet<>();
        try {
            products = filesService.readFromCSVFile(filePath)
                                   .stream()
                                   .map(string -> setProduct.apply(string))
                                   .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.products = products;
    }

    public FilesService getFilesService() {
        return filesService;
    }

    public void setFilesService(FilesService filesService) {
        this.filesService = filesService;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
