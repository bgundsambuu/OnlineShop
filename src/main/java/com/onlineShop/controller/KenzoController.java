package com.onlineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Le on 1/24/2016.
 */

@Controller
public class KenzoController {
    @RequestMapping("/product/view")
    public String productview() {
        return "template/shop/productview";
    }

    @RequestMapping("/product/list")
    public String productlist() {
        return "template/shop/productlist";
    }

    @RequestMapping("/shoppingcart")
    public String shoppingcart() {
        return "template/shop/shoppingcart";
    }

    @RequestMapping("/loginpage")
    public String loginpage() {
        return "template/shop/loginpage";
    }

    @RequestMapping("/registerpage")
    public String registerpage() {
        return "template/shop/registerpage";
    }

    @RequestMapping("/forgotpage")
    public String forgotpage() {
        return "template/shop/forgotpassword";
    }

    @RequestMapping("/passwordchange")
    public String passwordchange() {
        return "template/shop/passwordchange";
    }

    @RequestMapping("/profilecard")
    public String profilecard() {
        return "template/shop/profilecard";
    }

    @RequestMapping("/profilepage")
    public String profilepage() {
        return "template/shop/profilepage";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "template/dashboard/home";
    }

    @RequestMapping("/admin/login")
    public String adminlogin() {
        return "template/dashboard/login";
    }

    @RequestMapping("/admin/profile")
    public String adminprofile() {
        return "template/dashboard/profile";
    }

    @RequestMapping("/admin/list")
    public String adminlist() {
        return "template/dashboard/list";
    }

    @RequestMapping("/vendor/registration")
    public String vendorregister() {
        return "template/dashboard/vendorregister";
    }

}
