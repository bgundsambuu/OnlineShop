package com.onlineShop.controller;

import com.onlineShop.model.CardDetail;
import com.onlineShop.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private CardService cardService;

    @RequestMapping("/payment")
    public String payment(Model model)
    {
        List<CardDetail> cards = cardService.getCardList(1);
        model.addAttribute("products", cards);

        return "template/shop/payment";
    }
}

