package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@DynamicUpdate
public class VendorCategory {
    @Id
    @GeneratedValue
    private int vendorCategoryID;
    @OneToMany(mappedBy="vendorCategory")
    private List<Vendor> vendor;
    @OneToMany
    @JoinColumn(name="categoryID")
    private List<Category> category;

    public int getVendorCategoryID() {
        return vendorCategoryID;
    }

    public void setVendorCategoryID(int vendorCategoryID) {
        this.vendorCategoryID = vendorCategoryID;
    }

    public List<Vendor> getVendor() {
        return vendor;
    }

    public void setVendor(List<Vendor> vendor) {
        this.vendor = vendor;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }
}
