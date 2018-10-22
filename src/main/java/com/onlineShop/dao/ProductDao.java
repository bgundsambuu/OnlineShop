package com.onlineShop.dao;

import com.onlineShop.model.Product;

public interface ProductDao {
    Product findById(Integer prodId);
}
