package com.onlineShop.service.impl;

/*
 *   Created by Solomon.
 *   10/19/2018
 *   online shopping.
 * */

import com.onlineShop.dao.VendorDao;
import com.onlineShop.model.Vendor;
import com.onlineShop.service.VendorService;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DynamicUpdate
public class VendorServiceImpl implements VendorService {

    @Autowired
    VendorDao vendorDao;

    @Override
    public Vendor findVendorById(int vendorId) {

        return vendorDao.getVendorByUserId(vendorId);
    }

}
