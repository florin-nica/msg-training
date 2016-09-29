package com.msgsystems.training.w02d05.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Store implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "STORE_NAME", nullable = false, length = 50)
    private String storeName;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(final String storeName) {
        this.storeName = storeName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(final Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return id == store.id &&
                Objects.equals(storeName, store.storeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeName);
    }
}
