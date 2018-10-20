package com.onlineShop.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mingwei on 10/14/2018.
 */
//sdf
@Entity
@DynamicUpdate
public class Customer {

    @Id
    @GeneratedValue
    private int customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
