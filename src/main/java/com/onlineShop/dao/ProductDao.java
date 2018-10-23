package com.onlineShop.dao;

import com.onlineShop.model.Product;
import java.util.List;


/*
 * Created by Solomon.
 * 10/17/2018.
 * Online Shopping.
 *
 * */
public interface ProductDao {
    Product findById(Integer prodId);
    List<Product> findByCategoryId(Integer categoryId);
    List<Product> findAll();
    void Save(Product product);
    void update(Product product);
    Product getProductById(long id);
}
