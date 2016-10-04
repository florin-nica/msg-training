package com.msg.springtraining.myproject.service;

import com.msg.springtraining.myproject.model.Store;
import com.msg.springtraining.myproject.repository.StoreRepository;

import java.util.List;

public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public StoreRepository getStoreRepository() {
        return storeRepository;
    }

    public void setStoresFromFile(String file) {
        storeRepository.setStoresFromFile(file);
    }

    public List<Store> getStores() {
        return storeRepository.getStores();
    }

    public void setStores(List<Store> stores) {
        storeRepository.setStores(stores);
    }
}
