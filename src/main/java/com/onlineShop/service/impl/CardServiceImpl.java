package com.onlineShop.service.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.dao.CardDao;
import com.onlineShop.model.CardDetail;
import com.onlineShop.model.Customer;
import com.onlineShop.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDao cardDao;

    @Override
    public Customer getCustomer(int userId) {
        return cardDao.getCustomer(userId);
    }

    public List<CardDetail> getCardList (int custId) {
        return cardDao.getCardList(custId);
    }

    @Override
    public boolean addCardDetail(CardDetail cardDetail) {
        try {
            cardDao.addCardDetail(cardDetail);
        }
        catch(Exception ex)
        {
            return false;
        }
        return true;
    }

    @Override
    public CardDetail getCardById(int cardId) {
        return cardDao.getCardById(cardId);
    }
}
