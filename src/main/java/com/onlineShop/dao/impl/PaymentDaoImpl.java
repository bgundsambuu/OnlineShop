package com.onlineShop.dao.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.dao.PaymentDao;
import com.onlineShop.model.OrderDetail;
import com.onlineShop.model.OrderPayment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public OrderPayment getOrderPayment(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderPayment where customerId = ? and orderStatus='PENDING'");
        query.setInteger(0, userId);
        OrderPayment orderPayment = (OrderPayment)query.uniqueResult();
        query = session.createQuery("from OrderDetail where orderPaymentId = ? ");
        query.setInteger(0, orderPayment.getOrderPaymentId());
        List<OrderDetail> orderDetailList = query.list();
        orderPayment.setOrderDetailList(orderDetailList);
        return orderPayment;
    }
}