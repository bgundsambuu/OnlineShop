package com.onlineShop.model;
/*
 *  Created by Solomon
 *
 * */

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
public class OrderDetail {

    @Id
    @GeneratedValue
    private int orderDetailId;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product productList;
//    @OneToMany
//    @JoinColumn(name="product_id")
//    private List<Product> productList;

    public OrderDetail() {
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }

    public Product getProductList() {
        return productList;
    }

    public void setProductList(Product productList) {
        this.productList = productList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
