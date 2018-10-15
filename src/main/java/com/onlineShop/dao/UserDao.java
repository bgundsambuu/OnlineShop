package com.onlineShop.dao;

import com.onlineShop.model.User;
/**
 * Created by Mingwei on 10/12/2018
 */
public interface UserDao {
    void editUser(User user);
    User getUserByUserId(String userId);
}
