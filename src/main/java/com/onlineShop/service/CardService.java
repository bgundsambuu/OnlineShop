package com.onlineShop.service;

import com.onlineShop.model.CardDetail;

import java.util.List;


public interface CardService {

    List<CardDetail> getCardList(int custId);

}
