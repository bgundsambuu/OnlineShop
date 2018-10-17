package com.onlineShop.dao;

import com.onlineShop.model.Vendor;

public interface VendorDao {
    void editVendor(Vendor vendor);
    Vendor getVendorByUserId(int userId);
}
