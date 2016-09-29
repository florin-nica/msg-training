package com.msgsystems.training.w02d05.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import static com.msgsystems.training.w02d05.model.Product.GET_PRODUCTS_BY_NAME;

@Entity
@Table(name = "PRODUCT")
@NamedQuery(
        name = GET_PRODUCTS_BY_NAME,
        query = "SELECT product " +
                "FROM Product product " +
                "WHERE product.name = :name"
)
public class Product implements Serializable {

    public static final String GET_PRODUCTS_BY_NAME = "Product.getByName";

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Store store;

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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
