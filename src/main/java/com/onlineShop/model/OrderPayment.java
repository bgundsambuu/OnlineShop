package com.onlineShop.model;

/*
 *  Created by Solomon
 * */
//asdas
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DynamicUpdate
public class OrderPayment {

    @Id
    @GeneratedValue
    private int orderPaymentId;
    private Date OrderDate;
    @OneToMany
    @JoinColumn(name = "orderPaymentId")
    private List<OrderDetail> orderDetailList;
    @ManyToOne
    @JoinColumn(name = "cardId")
    private CardDetail cardId;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;
    private String orderStatus;
    private Date paidDate;
    private int total;
    private int totalAmount;
    private int taxAmount;
    @Transient
    private int zipCode;
    public OrderPayment() {

    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(int taxAmount) {
        this.taxAmount = taxAmount;
    }

    public int getOrderPaymentId() {
        return orderPaymentId;
    }

    public void setOrderPaymentId(int orderPaymentId) {
        this.orderPaymentId = orderPaymentId;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public CardDetail getCard() {
        return cardId;
    }

    public void setCard(CardDetail card) {
        this.cardId = card;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
