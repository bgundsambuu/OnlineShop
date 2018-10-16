package com.onlineShop.service.impl;

import com.onlineShop.dao.CardDao;
import com.onlineShop.model.CardDetail;
import com.onlineShop.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDao cardDao;

    public List<CardDetail> getCardList (int custId) {
        return cardDao.getCardList(custId);
    }
}
