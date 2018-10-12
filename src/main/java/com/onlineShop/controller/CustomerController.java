package com.onlineShop.controller;

import com.onlineShop.model.Customer;
import com.onlineShop.model.Users;
import com.onlineShop.service.CustomerService;
import com.onlineShop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Mingwei on 10/12/2018
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String viewProduct(@Valid @ModelAttribute("customer") Customer customer, Model model) {

        Users user = usersService.getUserByUsername(customer.getUsername());
        // existing validation TODO
        if(user == null) return "template/shop/editCustomer";
        if(!StringUtils.isEmpty(customer.getPassword()))
            user.setPassword(customer.getPassword());
        else user = null;
        customerService.editCustomer(customer, user);
        model.addAttribute("customer", customer);
        return "template/shop/editCustomer";
    }

}
