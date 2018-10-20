package com.onlineShop.service.impl;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/

import com.onlineShop.dao.CardDao;
import com.onlineShop.dao.PaymentDao;
import com.onlineShop.model.*;
import com.onlineShop.service.BankAPIService;
import com.onlineShop.service.EmailService;
import com.onlineShop.service.PaymentService;
import com.onlineShop.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private CardDao cardDao;

    @Autowired
    private SubscriptionService subscriptionService;

    @Override
    public OrderPayment getOrderPayment(int userId) {
        return paymentDao.getOrderPayment(userId);
    }

    @Override
    public Result doPayment(OrderPayment orderPayment) {
        List<CardDetail> carDetailList = cardDao.getCardList(1);
        if(carDetailList==null||carDetailList.isEmpty())
        {
            return new Result(40, "Please register card.");
        }
        Subscription subscription = subscriptionService.getSubscription();
        if(subscription==null)
        {
            return new Result(41, "Please configure subscription.");
        }
        Product product = paymentDao.blockProduct(orderPayment);
        if(product!=null)
        {
            return new Result(42, "We are sorry, We have only "+product.getUnitInStock()+ " "+product.getProductName()+".");
        }
        BankAPIService bankAPIService = new BankAPIServiceImpl();
        int bankResult = bankAPIService.callBankAPI();
        if(bankResult != 200)
        {
            Messages messages = paymentDao.getMsg(bankResult);
            if(messages==null)
                return new Result(43, "Unknown bank error: " + String.valueOf(messages.getMsgId()));
            else
                return new Result(bankResult, messages.getMsgValue());
        }
        if(!paymentDao.checkOut(orderPayment))
        {
            return new Result(44, "Error occurred on check out.");
        }
        if(!paymentDao.writeToFinTxns(orderPayment, subscription))
        {
            return new Result(44, "Error occurred on financial transaction.");
        }
        EmailService emailService = new EmailServiceImpl();
        Result result = emailService.sendEmail();
        if(result.getId()!=0)
            return result;

        return new Result(0,"");
    }
}
