package com.onlineShop.controller;

import com.onlineShop.model.CardDetail;
import com.onlineShop.model.OrderPayment;
import com.onlineShop.service.CardService;
import com.onlineShop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private CardService cardService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/payment")
    public String payment(Model model)
    {
        List<CardDetail> carDetailList = cardService.getCardList(1);
        model.addAttribute("cards", carDetailList);

        OrderPayment orderPayment = paymentService.getOrderPayment(1);
        model.addAttribute("orderPayment", orderPayment);

        return "template/shop/payment";
    }
}

