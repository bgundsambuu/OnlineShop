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
@DynamicUpdate
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDao usersDao;

    public Users getUserByUsername(String username){
        return usersDao.getUserByUsername(username);
    }

}
