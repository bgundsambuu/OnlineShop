package com.onlineShop.service.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.model.Result;
import com.onlineShop.service.BankAPIService;
import com.onlineShop.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public Result sendEmail() {
        return new Result(0, "");
    }
}
