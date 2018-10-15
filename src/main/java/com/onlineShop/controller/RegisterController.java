package com.onlineShop.controller;

import com.onlineShop.model.Customer;
import com.onlineShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Le on 1/25/2016.
 */

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {

//        Customer customerBackup = new Customer();
//        BillingAddress billingAddress = new BillingAddress();
//        ShippingAddress shippingAddress = new ShippingAddress();
//        customerBackup.setBillingAddress(billingAddress);
//        customerBackup.setShippingAddress(shippingAddress);
//
//        model.addAttribute("customer", customerBackup);

        return "template/shop/registerCustomer";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customerBackup, BindingResult result,
                                       Model model) {

//        if (result.hasErrors()) {
//            return "template/shop/registerCustomer";
//        }
//
//        List<Customer> customerBackupList =customerService.getAllCustomers();
//
//        for (int i = 0; i< customerBackupList.size(); i++) {
//            if(customerBackup.getCustomerEmail().equals(customerBackupList.get(i).getCustomerEmail())) {
//                model.addAttribute("emailMsg", "Email already exists");
//
//                return "template/shop/registerCustomer";
//            }
//
//            if(customerBackup.getUsername().equals(customerBackupList.get(i).getUsername())) {
//                model.addAttribute("usernameMsg", "Username already exists");
//
//                return "template/shop/registerCustomer";
//            }
//        }
//
//        customerBackup.setEnabled(true);
//        customerService.addCustomer(customerBackup);

        return "template/shop/registerCustomerSuccess";

    }

}
