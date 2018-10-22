package com.onlineShop.dao;

import com.onlineShop.model.OrderDetail;

public interface OrderDetailDao {
    void addItem(OrderDetail orderDetail);
    void removeItem(OrderDetail orderDetail);
    OrderDetail findByID(int orderDetailId);
}
