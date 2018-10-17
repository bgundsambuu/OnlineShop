package com.onlineShop.service;

import com.onlineShop.model.User;

/**
 * Created by Mingwei on 10/12/2018
 */
public interface UserService {
    User getUserByUserId(int userId);
    User editUser(User user);
    String delete(int userId);
}
