package com.onlineShop.service.impl;

import com.onlineShop.dao.ProductDao;
import com.onlineShop.model.Product;
import com.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Integer prodId) {
        return productDao.findById(prodId);
    }
}
