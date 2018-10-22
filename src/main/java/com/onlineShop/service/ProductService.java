package com.onlineShop.service;

/*
 *  Created by Solomon 10/14/2018
 *  Online Shopping
 * */
import com.onlineShop.model.Product;

public interface ProductService {
    void saveProduct(Product product);
    void editProduct(Product id);
    void deletProductById(long ProductId);
    Product getProductById(long id);

}
