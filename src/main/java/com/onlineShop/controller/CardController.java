package com.onlineShop.controller;

/*
        Project Management class - Somesh Rao
        Developer: Bayarjargal
        Date: 10/16/2018 /October/
*/
import com.onlineShop.model.CardDetail;
import com.onlineShop.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping("/card")
    public String payment(Model model)
    {
        List<CardDetail> carDetailList = cardService.getCardList(1);
        model.addAttribute("cards", carDetailList);
        CardDetail cardDetail = new CardDetail();
        model.addAttribute("cardDetail", cardDetail);

        return "template/shop/cardDetail";
    }

    @RequestMapping(value = "/addCardDetail", method = RequestMethod.POST)
    public String addCardDetail(@ModelAttribute("cardDetail") @Valid CardDetail cardDetail,
                                BindingResult result, HttpServletRequest request, Locale locale) {

        cardService.addCardDetail(cardDetail);
        return "template/shop/cardDetail";
    }
}

