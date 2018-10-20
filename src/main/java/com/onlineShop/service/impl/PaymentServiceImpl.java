package com.onlineShop.service.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.dao.CardDao;
import com.onlineShop.dao.PaymentDao;
import com.onlineShop.model.OrderPayment;
import com.onlineShop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public OrderPayment getOrderPayment(int userId) {
        return paymentDao.getOrderPayment(userId);
    }
}
