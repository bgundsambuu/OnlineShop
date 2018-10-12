package com.onlineShop.dao.impl;

import com.onlineShop.dao.BillingAddressDao;
import com.onlineShop.model.BillingAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Mingwei on 10/12/2018
 */
@Repository
@DynamicUpdate
public class BillingAddressDaoImpl implements BillingAddressDao {

    @Autowired
    SessionFactory sessionFactory;

    public void editBillingAddress(BillingAddress ba){
        Session session = sessionFactory.getCurrentSession();
        session.update(ba);
        session.flush();
    }
}
