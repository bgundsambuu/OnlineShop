package com.onlineShop.model;
/*
*  Created by Solomon
* */

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DynamicUpdate
public class CardDetail {

    @Id
    @GeneratedValue
    private int cardId;
    private String cardHolderName;
    private String cardType;
    private String cardNumber;
    private Date cardExp;
    private String securityNumber;

    @OneToMany
    @JoinColumn
    private List<OrderPayment> orderPaymentList;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getCardExp() {
        return cardExp;
    }

    public void setCardExp(Date cardExp) {
        this.cardExp = cardExp;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    public List<OrderPayment> getOrderPaymentList() {
        return orderPaymentList;
    }

    public void setOrderPaymentList(List<OrderPayment> orderPaymentList) {
        this.orderPaymentList = orderPaymentList;
    }
}
