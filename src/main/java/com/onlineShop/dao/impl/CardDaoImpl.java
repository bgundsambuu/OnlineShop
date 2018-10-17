package com.onlineShop.dao.impl;

import com.onlineShop.dao.CardDao;
import com.onlineShop.model.CardDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CardDaoImpl implements CardDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CardDetail> getCardList(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CardDetail where customerId = ? ");
        query.setString(0, Integer.toString(customerId));
        return (List<CardDetail>) query.list();

    }
}