package com.onlineShop.controller;

import com.onlineShop.model.*;
import com.onlineShop.service.BankAPIService;
import com.onlineShop.service.CardService;
import com.onlineShop.service.PaymentService;
import com.onlineShop.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class PaymentController {

    @Autowired
    private CardService cardService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping("/payment")
    public String payment(Model model)
    {
        Subscription subscription = subscriptionService.getSubscription();
        if(subscription==null)
        {
            model.addAttribute("ERROR_MESSAGE", "Please configure subscription.");
            return "template/shop/payment";
        }
        List<CardDetail> cardDetailList = cardService.getCardList(1);
        if(cardDetailList==null||cardDetailList.size()==0)
        {
            model.addAttribute("ERROR_MESSAGE", "Please add card.");
        }
        model.addAttribute("cards", cardDetailList);

        OrderPayment orderPayment = paymentService.getOrderPayment(1);
        model.addAttribute("orderPayment", orderPayment);
        if(orderPayment==null)
        {
            model.addAttribute("ERROR_MESSAGE", "No pending cart is registered.");
            return "template/shop/payment";
        }
        if(orderPayment.getOrderDetailList().isEmpty())
        {
            model.addAttribute("ERROR_MESSAGE", "No pending available cart details.");
            return "template/shop/payment";
        }

        double total = 0;
        for(int i=0;i<orderPayment.getOrderDetailList().size();i++)
        {
            OrderDetail orderDetail = orderPayment.getOrderDetailList().get(i);
            total = total + orderDetail.getProduct().getProductPrice() * orderDetail.getQuantity();
        }
        double taxAmount = total*subscription.getTaxPercentage()/100;
        orderPayment.setTotal(total);
        orderPayment.setTaxAmount(taxAmount);
        orderPayment.setTotalAmount(orderPayment.getTotal()+taxAmount);
        model.addAttribute("orderPayment", orderPayment);
        return "template/shop/payment";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String addCardDetail(@ModelAttribute("orderPayment") @Valid OrderPayment orderPayment,
                                BindingResult result,
                                Locale locale, Model model, String card, boolean newaddress) {
        if (result.hasErrors()) {
            return "template/shop/payment";
        }

        if(card.isEmpty()||card==null)
        {
            model.addAttribute("ERROR_MESSAGE","Please select a card.");
            return "template/shop/payment";
        }

        //if(newaddress)
        Result result1 = paymentService.doPayment(orderPayment);

        /*
        if(cardDetail.getCardType().equals("VISA")) {
            if (!cardDetail.getCardNumber().startsWith("4"))
            {
                model.addAttribute("ERROR_MESSAGE","Visa card number must starts with 4.");
                return "template/shop/profilecard";
            }
        }
        else{
            if (!cardDetail.getCardNumber().startsWith("5"))
            {
                model.addAttribute("ERROR_MESSAGE","Master card number must starts with 5.");
                return "template/shop/profilecard";
            }
        }

        Date date = new Date(cardDetail.getExpYear(),cardDetail.getExpMonth(),1);
        cardDetail.setCardExp(date);

        boolean b = cardService.addCardDetail(cardDetail);
        if(b) {
            redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","Successfully added new card.");
            return "redirect:/card";
        }
        */
        model.addAttribute("ERROR_MESSAGE", "Error occurred when add new card.");
        return "template/shop/payment";
    }
}

