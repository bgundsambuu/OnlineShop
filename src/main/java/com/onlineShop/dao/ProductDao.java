package com.onlineShop.dao;

import com.onlineShop.model.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Integer prodId);
    List<Product> findByCategoryId(Integer categoryId);
    List<Product> findAll();
}
