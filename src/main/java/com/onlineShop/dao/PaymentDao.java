package com.onlineShop.dao;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.model.Messages;
import com.onlineShop.model.OrderPayment;
import com.onlineShop.model.Product;
import com.onlineShop.model.Subscription;

public interface PaymentDao {
        OrderPayment getOrderPayment(int userId);
        Subscription getSubscription();
        Product blockProduct(OrderPayment orderPaymentId);
        boolean checkOut(OrderPayment orderPaymentId);
        Messages getMsg(int msgId);
        boolean writeToFinTxns(OrderPayment orderPayment, Subscription subscription);
}
