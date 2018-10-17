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
    @JoinColumn(name = "addressId")
    private Address address;
    @OneToMany
    @JoinColumn(name = "customerId")
    private List<CardDetail> cardDetailList;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<CardDetail> getCardDetailList() {
        return cardDetailList;
    }

    public void setCardDetailList(List<CardDetail> cardDetailList) {
        this.cardDetailList = cardDetailList;
    }
}
