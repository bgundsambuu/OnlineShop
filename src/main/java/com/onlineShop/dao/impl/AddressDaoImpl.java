package com.onlineShop.dao.impl;

import com.onlineShop.dao.AddressDao;
import com.onlineShop.model.Address;
import com.onlineShop.model.Administrator;
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
public class AddressDaoImpl implements AddressDao {
    @Autowired
    SessionFactory sessionFactory;

    public void editAddress(Address address){
        Session session = sessionFactory.getCurrentSession();
        session.update(address);
        session.flush();
    }

    @Override
    public Address getAddressByAddressId(int addressId) {
        return null;
    }

    public Address getAddressByUserId(int userId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Vendor where address_Id = ?");
        query.setInteger(0, userId);
        return (Address) query.uniqueResult();}
}
