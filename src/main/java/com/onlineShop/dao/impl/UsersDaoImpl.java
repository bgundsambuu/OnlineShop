package com.onlineShop.dao.impl;

import com.onlineShop.dao.UsersDao;
import com.onlineShop.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Mingwei on 10/12/2018
 */
@Repository
@DynamicUpdate
public class UsersDaoImpl implements UsersDao {

    @Autowired
    SessionFactory sessionFactory;

    public void editUser(Users user){
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        session.flush();
    }

    public Users getUserByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users where username = ?");
        query.setString(0, username);
        return (Users) query.uniqueResult();
    }
}
