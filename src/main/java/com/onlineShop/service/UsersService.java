package com.onlineShop.service;

import com.onlineShop.model.Users;

/**
 * Created by Mingwei on 10/12/2018
 */
public interface UsersService {
    Users getUserByUserId(String userId);
    Users getUserByUsername(String username);
    String delete(String userId);
}
