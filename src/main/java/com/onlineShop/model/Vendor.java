package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/*
 *  Created by Solomon 10/21/2018
 *  Online Shopping
 * */

@Entity
@DynamicUpdate
public class Vendor {

    @Id
    @GeneratedValue
    private int vendorId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String firstName;
    private String lastName;
    private String name;
    private String phoneNumber;
    private String status;
    @OneToOne
    @JoinColumn(name = "address_Id")
    private Address address;
//    @OneToMany
//    @JoinColumn(name = "vendorCategoryID", nullable = false)
//    private List<VendorCategory> vendorCategory;

    @OneToMany(mappedBy = "vendor_id", fetch = FetchType.EAGER)
    private List<Product> productList;

    public Vendor() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//    public VendorCategory getVendorCategory() {
//        return vendorCategory;
//    }
//
//    public void setVendorCategory(VendorCategory vendorCategory) {
//        this.vendorCategory = vendorCategory;
//    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
