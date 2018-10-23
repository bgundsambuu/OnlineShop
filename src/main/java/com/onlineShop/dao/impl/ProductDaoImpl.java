package com.onlineShop.dao.impl;

/*
 * Created by Solomon.
 * 10/17/2018.
 * Online Shopping.
 *
 * */
import com.onlineShop.dao.ProductDao;
import com.onlineShop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@DynamicUpdate
public class ProductDaoImpl implements ProductDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void Save(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        session.flush();
    }

    @Override
    public void update(Product product) {

        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        session.flush();
    }

    @Override
    public Product getProductById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select * FROM Product where productId=? and flag eq 2");

        query.setString(0,String.valueOf(id));
        return (Product) query.uniqueResult();
    }
}
