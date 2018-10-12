package com.onlineShop.dao;

import com.onlineShop.model.Users;
/**
 * Created by Mingwei on 10/12/2018
 */
public interface UsersDao {
    void editUser(Users user);

    Users getUserByUsername(String username);
}
