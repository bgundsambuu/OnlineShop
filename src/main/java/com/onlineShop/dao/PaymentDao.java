package com.onlineShop.dao;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.model.OrderPayment;

public interface PaymentDao {
        OrderPayment getOrderPayment(int userId);
}
