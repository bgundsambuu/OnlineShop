package com.onlineShop.dao.impl;

import com.onlineShop.Constant;
import com.onlineShop.dao.ProductDao;
import com.onlineShop.model.Product;
import com.onlineShop.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@DynamicUpdate
@Transactional
public class ProdDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Product findById(Integer prodId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productId = ?");
        query.setInteger(0, prodId);
        return (Product) query.uniqueResult();
    }

    @Override
    public List<Product> findByCategoryId(Integer categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where categoryID = ? and flag = 2");
        query.setInteger(0, categoryId);
        List<Product> prodList = query.list();
        return prodList;
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where flag = 2");
        List<Product> prodList = query.list();
        return prodList;
    }
}
