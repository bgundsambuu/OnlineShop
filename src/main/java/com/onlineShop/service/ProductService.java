package com.onlineShop.service;

import com.onlineShop.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(Integer prodId);
    List<Product> findByCategoryId(Integer categoryId);
    List<Product> findAll();
    void saveProduct(Product product);
    void editProduct(Product id);
    void deletProductById(long ProductId);
    Product getProductById(long id);
}
