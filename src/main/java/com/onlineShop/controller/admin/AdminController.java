package com.onlineShop.controller.admin;

import com.onlineShop.model.Customer;
import com.onlineShop.model.Product;
import com.onlineShop.service.CustomerService;
import com.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Le on 1/24/2016.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminPage() {
        return "template/dashboard/home";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "template/shop/productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {

        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "template/shop/customerManagement";
    }

    @RequestMapping("/login")
    public String login() {
        return "template/dashboard/login";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "template/dashboard/profile";
    }

    @RequestMapping("/list")
    public String list() {
        return "template/dashboard/list";
    }
}
