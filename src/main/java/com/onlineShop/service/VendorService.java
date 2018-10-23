package com.onlineShop.service;

import com.onlineShop.model.Vendor;

import java.util.List;

/**
 * Created By krish on Oct, 2018
 */
public interface VendorService {

    public List<Vendor> getAllVendor();

    public void addVendor(Vendor vendor);

    public  List<Vendor> getAllPendingVendor();

    public Vendor getPendingVendorById(int vendorId);

    public void updateVendorStatus(Vendor vendor);
}
