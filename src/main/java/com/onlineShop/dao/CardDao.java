package com.onlineShop.dao;

import com.onlineShop.model.CardDetail;

import java.util.List;

public interface CardDao {
        List<CardDetail> getCardList(int cardId);
}
