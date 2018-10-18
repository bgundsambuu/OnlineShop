package com.onlineShop.service;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.model.CardDetail;
import com.onlineShop.model.Customer;

import java.util.List;


public interface CardService {

    Customer getCustomer(int userId);
    List<CardDetail> getCardList(int userId);
    boolean addCardDetail(CardDetail cardDetail);
}
