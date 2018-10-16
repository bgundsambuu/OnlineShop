package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mingwei on 10/14/2018.
 */
@Entity
@DynamicUpdate
public class Customer {

    @Id
    private String customerId;
    private String userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String orderId;
    @OneToOne
    @JoinColumn
    private Address address;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
