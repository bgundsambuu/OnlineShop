package com.onlineShop.dao.impl;

import com.onlineShop.dao.VendorDao;
import com.onlineShop.model.Vendor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mingwei on 10/12/2018
 */
@Repository
@DynamicUpdate
@Transactional
public class VendorDaoImpl implements VendorDao {
    @Autowired
    SessionFactory sessionFactory;

    public void editVendor(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(vendor);
        session.flush();
    }

    public Vendor getVendorByUserId(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Vendor where userId = ?");
        query.setInteger(0, userId);
        return (Vendor) query.uniqueResult();
    }
}
