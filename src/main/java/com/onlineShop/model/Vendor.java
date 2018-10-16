package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * Created by Mingwei on 10/14/2018.
 */
@Entity
@DynamicUpdate
public class Vendor {

    @Id
    private String vendorId;
    private String firstName;
    private String lastName;
    private String name;
    private String phoneNumber;
    private String userId;
    private String status;
    @OneToOne
    @JoinColumn
    private Address address;
//    @OneToMany
//    @JoinColumn
//    private List<Product> productList;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }
}
