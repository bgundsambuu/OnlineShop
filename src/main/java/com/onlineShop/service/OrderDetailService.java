package com.onlineShop.service;

import com.onlineShop.model.OrderDetail;

public interface OrderDetailService {
    void addOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(OrderDetail orderDetail);

    OrderDetail findById(Integer orderDetailId);
}
