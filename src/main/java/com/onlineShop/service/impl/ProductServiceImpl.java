package com.onlineShop.service.impl;

import com.onlineShop.dao.ProductDao;
import com.onlineShop.model.Product;
import com.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * Created by Solomon.
 * 10/17/2018.
 * Online Shopping.
 *
 * */
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Integer prodId) {
        return
                productDao.findById(prodId);
    }
    public List<Product> findByCategoryId(Integer categoryId){
        return productDao.findByCategoryId(categoryId);
    }
    public List<Product> findAll() {

        return productDao.findAll();
    }

    /*
    * save a product
    * */
    @Override
    public void saveProduct(Product product) {

        productDao.Save(product);
    }
    /*
     * edit a product
     * */
    @Override
    public void editProduct(Product product) {

        productDao.update(product);
    }
    /*
     * delete a product by Id
     * string value 0 = deleted or inActive
     * String value 1= Out of Stock
     * String value 2= Active and ready for sale
     * */
    @Override
    public void deletProductById(long id) {

        Product product = productDao.getProductById(id);
        product.setFlag("0");
        productDao.update(product);

    }
    /*
     * get a product by Id
     * */
    @Override
    public Product getProductById(long id) {

        return productDao.getProductById(id);

    }
}
