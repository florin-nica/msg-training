package com.msg.springtraining.myproject.service;

import com.msg.springtraining.myproject.model.Product;
import com.msg.springtraining.myproject.model.Store;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.List;
import java.util.Set;

public class SerializingService {

    public void serializeProductInTheXMLFormat(String file, Product product) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)))) {
            xmlEncoder.writeObject(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void serializeProductsInTheXMLFormat(String file, Set<Product> products) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)))) {
            xmlEncoder.writeObject(products);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void serializeProductsInTheClassicWay(String file, Set<Product> products) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(products);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void serializeProductInTheClassicWay(String file, Product product) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Product deserializeProductInTheClassicWay(String file) {
        Product product = null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
             product = (Product) objectInputStream.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public Set<Product> deserializeProductsInTheClassicWay(String file) {
        Set<Product> products = null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            products = (Set<Product>) objectInputStream.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public Product deserializeProductInTheXMLFormat(String file) {
        Product product = null;
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)))) {
            product = (Product) xmlDecoder.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public Set<Product> deserializeProductsInTheXMLFormat(String file) {
        Set<Product> products = null;
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)))) {
            products = (Set<Product>) xmlDecoder.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public void serializeStoresInTheXMLFormat(String file, List<Store> stores) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)))) {
            xmlEncoder.writeObject(stores);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
