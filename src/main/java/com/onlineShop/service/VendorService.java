package com.onlineShop.service;

/*
*   Created by Solomon.
*   10/19/2018
*   online shopping.
* */

import com.onlineShop.model.Product;
import com.onlineShop.model.Vendor;

public interface VendorService {

    Vendor findVendorById(int vendorId);

}
