package com.onlineShop;


import com.onlineShop.model.User;
import com.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionUtil {
    private static UserService us;
    @Autowired
    UserService userService;
    @PostConstruct
    public void init(){
        us = userService;
    }
    public static User getUser(){
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        return us.getUserByEmail(currentUserName);
    }
}
