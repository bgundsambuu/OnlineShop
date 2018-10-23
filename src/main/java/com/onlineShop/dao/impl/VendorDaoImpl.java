package com.onlineShop.dao.impl;

import com.onlineShop.dao.VendorDao;
import com.onlineShop.model.Address;
import com.onlineShop.model.Customer;
import com.onlineShop.model.User;
import com.onlineShop.model.Vendor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

/*    @Override
    public List<Customer> getAllCustomer() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;

    }*/

    @Override
    public List<Vendor> getAllVendor() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Vendor");
        List<Vendor> vendorList = query.list();

        //session.flush();

        return vendorList;
    }

    @Override
    public void addVendor(Vendor vendor) {

        Session session = sessionFactory.getCurrentSession();


        User newUser = new User();
        newUser.setUserName(vendor.getUser().getUserName());
        newUser.setPassword(vendor.getUser().getPassword());
        newUser.setIsActive(true);

        vendor.setStatus("pending");

        Address newAddress = new Address();
        newAddress.setCity(vendor.getAddress().getCity());
        newAddress.setCountry(vendor.getAddress().getCountry());
        newAddress.setState(vendor.getAddress().getState());
        newAddress.setZipCode(vendor.getAddress().getZipCode());
        newAddress.setStreet(vendor.getAddress().getStreet());

        session.saveOrUpdate(vendor);
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAddress);

        session.flush();

    }

    @Override
    public List<Vendor> getAllPendingVendor() {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Vendor where status = 'pending'");

        List<Vendor> vendors =query.list();
        if(vendors == null){
            System.out.println("No Vendors");
        }
        session.flush();

        return vendors;
    }

    @Override
    public Vendor getPendingVendorById(int vendorId) {
        Session session = sessionFactory.getCurrentSession();

//        String hql = "FROM Employee E WHERE E.id = :employee_id";
//        Query query = session.createQuery(hql);
//        query.setParameter("employee_id",10);
//        List results = query.list()

        Query query = session.createQuery("from Vendor where vendorId = :vendorId");
        query.setParameter("vendorId", vendorId);

        Vendor vendor = (Vendor) query.list();
        //Vendor vendor = (Vendor) session.get(Vendor.class, vendorId);
        session.flush();
        return vendor;
    }

    @Override
    public void updateVendorStatus(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(vendor);
        //session.saveOrUpdate(vendor);

        session.flush();
    }


}
