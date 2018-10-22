package com.onlineShop.dao.impl;

import com.onlineShop.Constant;
import com.onlineShop.dao.UserDao;
import com.onlineShop.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mingwei on 10/12/2018
 */
@Repository
@DynamicUpdate
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    /**
     * Edit User
     * @Author Mingwei
     * @Date 10/12/2018
     * @param user
     */
    public void editUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        session.flush();
    }

    /**
     * Get User By UserId
     * @Author Mingwei
     * @Date 10/12/2018
     * @param userId
     * @return
     */
    public User getUserByUserId(int userId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where userId = ? and isActive = ?");
        query.setInteger(0, userId);
        query.setString(1, Constant.Active.YES);
        return (User) query.uniqueResult();
    }
}
