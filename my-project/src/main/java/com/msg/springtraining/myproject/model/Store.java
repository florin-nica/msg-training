package com.msg.springtraining.myproject.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Store implements Serializable {

    private int id;
    private String name;
    private String type;
    private String location;
    private int zipCode;
    private Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return zipCode == store.zipCode &&
                Objects.equals(name, store.name) &&
                Objects.equals(type, store.type) &&
                Objects.equals(location, store.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, location, zipCode);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", zipCode=" + zipCode + '\n' +
                ", products=" + products +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
