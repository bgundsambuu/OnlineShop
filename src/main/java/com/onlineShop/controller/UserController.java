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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable String userId, Model model) {
        Users u = usersService.getUserByUserId(userId);
        model.addAttribute("user", u);
        return "template/shop/user";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("customer") Customer customer, Model model) {
        return "template/shop/user";
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String editUser(@Valid @ModelAttribute("customer") Customer customer, Model model) {
        Users user = usersService.getUserByUsername(customer.getUsername());
        // existing validation TODO
        if(user == null) return "template/shop/user";
        if(!StringUtils.isEmpty(customer.getPassword()))
            user.setPassword(customer.getPassword());
        else user = null;
        customerService.editCustomer(customer, user);
        model.addAttribute("customer", customer);
        return "template/shop/user";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String userId, Model model) {
        usersService.delete(userId);
        return "template/shop/user";
    }

}
