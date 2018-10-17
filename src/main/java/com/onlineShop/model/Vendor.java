package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


/**
 * Created by Mingwei on 10/14/2018.
 */
@Entity
@DynamicUpdate
public class Vendor {

    @Id
    @GeneratedValue
    private int vendorId;
    private String firstName;
    private String lastName;
    private String name;
    private String phoneNumber;
    private String status;
    @OneToOne
    @JoinColumn(name = "userId")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "vendorCategoryID", nullable = false)
    private VendorCategory vendorCategory;
//    @OneToMany
//    @JoinColumn
//    private List<Product> productList;

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

//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }
}
