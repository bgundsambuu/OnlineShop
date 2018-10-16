package com.onlineShop.service;

import com.onlineShop.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by Mingwei on 10/12/2018
 */
//asdas
public interface UserService {
    User getUserByUserId(String userId);
    User editUser(User user);
    String delete(String userId);
}
