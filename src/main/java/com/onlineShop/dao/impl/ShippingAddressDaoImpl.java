package com.onlineShop.dao.impl;

import com.onlineShop.dao.ShippingAddressDao;
import com.onlineShop.model.ShippingAddress;
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
public class ShippingAddressDaoImpl implements ShippingAddressDao {
    @Autowired
    SessionFactory sessionFactory;

    public void editShippingAddress(ShippingAddress sa){
        Session session = sessionFactory.getCurrentSession();
        session.update(sa);
        session.flush();
    }
}
