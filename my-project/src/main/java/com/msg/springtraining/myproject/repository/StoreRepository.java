package com.msg.springtraining.myproject.repository;

import com.msg.springtraining.myproject.model.Product;
import com.msg.springtraining.myproject.model.Store;
import com.msg.springtraining.myproject.service.FilesService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StoreRepository {

    private FilesService filesService;
    private List<Store> stores;
    private Set<Product> products;

    public StoreRepository(FilesService filesService, String filePath, ProductRepository productRepository) {
        this.filesService = filesService;
        products = productRepository.getProducts();
        setStoresFromFile(filePath);
    }

    private Function<String, Store> setStore = string -> {
        Store store = new Store();
        final String[] split = string.split(",");
        store.setId(Integer.parseInt(split[0]));
        store.setName(split[1]);
        store.setType(split[2]);
        store.setLocation(split[3]);
        store.setZipCode(Integer.parseInt(split[4]));
        store.setProducts(products);
        return store;
    };

    public void setStoresFromFile(String file) {

        List<Store> stores = new ArrayList<>();
        try {
            stores = filesService.readFromCSVFile(file)
                                 .stream()
                                 .map(string -> setStore.apply(string))
                                 .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.stores = stores;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
