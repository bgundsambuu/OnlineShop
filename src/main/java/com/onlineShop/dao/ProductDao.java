package com.onlineShop.dao;
/*
 * Created by Solomon
 * 10/16/2018
 * Online Shopping
 * */

import com.onlineShop.model.Product;

public interface ProductDao {

    void Save(Product product);
    void update(Product product);
    Product getProductById(long id);

}
