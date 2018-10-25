package com.onlineShop.service;
/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.model.OrderPayment;
import com.onlineShop.model.Result;

public interface PaymentService {
    OrderPayment getOrderPayment(int userId);
    Result doPayment(OrderPayment orderPayment, boolean newAddress);
}
