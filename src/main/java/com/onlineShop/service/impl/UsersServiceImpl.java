package com.onlineShop.service.impl;

import com.onlineShop.dao.UsersDao;
import com.onlineShop.model.Users;
import com.onlineShop.service.UsersService;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Mingwei on 10/12/2018
 */
@Repository
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDao usersDao;

    public Users getUserByUserId(String userId){
        return usersDao.getUserByUsername(userId);
    }

    public Users getUserByUsername(String username){
        return usersDao.getUserByUsername(username);
    }

    public String delete(String userId){
        Users u = new Users();
        u.setUsersId(Integer.parseInt(userId));
        u.setEnabled(true);
        usersDao.editUser(u);
        return "message";
    }
}
