package com.onlineShop.service.impl;

import com.onlineShop.dao.VendorDao;
import com.onlineShop.model.Vendor;
import com.onlineShop.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created By krish on Oct, 2018
 */

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorDao vendorDao;

    @Override
    public List<Vendor> getAllVendor() {
        return vendorDao.getAllVendor();
    }

    @Override
    public void addVendor(Vendor vendor) {
        vendorDao.addVendor(vendor);
    }

    @Override
    public List<Vendor> getAllPendingVendor() {
        return vendorDao.getAllPendingVendor();
    }

    @Override
    public Vendor getPendingVendorById(int vendorId) {
        return vendorDao.getVendorByUserId(vendorId);
    }

    @Override
    public void updateVendorStatus(Vendor vendor) {
        vendorDao.updateVendorStatus(vendor);
    }
}
