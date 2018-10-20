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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping("/card")
    public String cardDetail(Model model)
    {
        List<CardDetail> carDetailList = cardService.getCardList(1);
        model.addAttribute("cards", carDetailList);
        CardDetail cardDetail = new CardDetail();
        model.addAttribute("cardDetail", cardDetail);

        return "template/shop/cardDetail";
    }

    @RequestMapping(value = "/addCardDetail", method = RequestMethod.POST)
    public String addCardDetail(@ModelAttribute("cardDetail") @Valid CardDetail cardDetail,
                                BindingResult result, HttpServletRequest request,
                                Locale locale, Model model,
                                RedirectAttributes redirectAttributes) {
        List<CardDetail> carDetailList = cardService.getCardList(1);
        model.addAttribute("cards", carDetailList);

        if (result.hasErrors()) {
            return "template/shop/cardDetail";
        }

        if(cardDetail.getCardType().equals("VISA")) {
            if (!cardDetail.getCardNumber().startsWith("4"))
            {
                model.addAttribute("ERROR_MESSAGE","Visa card number must starts with 4.");
                return "template/shop/cardDetail";
            }
        }
        else{
            if (!cardDetail.getCardNumber().startsWith("5"))
            {
                model.addAttribute("ERROR_MESSAGE","Master card number must starts with 5.");
                return "template/shop/cardDetail";
            }
        }

        Date date = new Date(cardDetail.getExpYear(),cardDetail.getExpMonth(),1);
        cardDetail.setCardExp(date);

        boolean b = cardService.addCardDetail(cardDetail);
        if(b) {
            redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","Successfully added new card.");
            return "redirect:/card";
        }
        model.addAttribute("ERROR_MESSAGE", "Error occurred when add new card.");
        return "template/shop/cardDetail";
    }
}

