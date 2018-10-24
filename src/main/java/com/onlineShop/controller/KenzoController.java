package com.onlineShop.controller;

import com.onlineShop.model.Category;
import com.onlineShop.model.Product;
import com.onlineShop.service.CategoryService;
import com.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Le on 1/24/2016.
 */

@Controller
public class KenzoController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/product/view")
    public String productview() {
        return "template/shop/productview";
    }

    @RequestMapping("/product/list")
    public String viewProd(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("products", productService.findAll());
        return "template/shop/productlist";
    }

    @RequestMapping(value="/category/{categoryId}", method = RequestMethod.GET)
    public String viewProdByCategory(@PathVariable int categoryId, Model model) {
        Category category = categoryService.findById(categoryId);
        model.addAttribute("category_id", category.getCategoryID());
        model.addAttribute("category_name", category.getCategoryName());
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("products", productService.findByCategoryId(categoryId));
        return "template/shop/productlist";
    }

    @RequestMapping(value="/product/{productId}", method = RequestMethod.GET)
    public String viewProdById(@PathVariable int productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("category_name", product.getCategory().getCategoryName());
        model.addAttribute("category_id", product.getCategory().getCategoryID());
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("product", product);
        return "template/shop/productview";
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

    @RequestMapping("/profileaddress")
    public String profileaddress() {
        return "template/shop/profileaddress";
    }

    @RequestMapping("/profilepage")
    public String profilepage() {
        return "template/shop/profilepage";
    }

    @RequestMapping("/paymentpage")
    public String paymentpage() {
        return "template/shop/paymentpage";
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

    @RequestMapping("/admin/category")
    public String admincategory() {
        return "template/dashboard/category";
    }

    @RequestMapping("/admin/category/new")
    public String admincategorynew() {
        return "template/dashboard/categorynew";
    }

    @RequestMapping("/admin/product")
    public String adminproduct() {
        return "template/dashboard/product";
    }


    @RequestMapping("/vendor")
    public String vendor() {
        return "template/dashboard/vendorhome";
    }

    @RequestMapping("/vendor/login")
    public String vendorlogin() {
        return "template/dashboard/vendorlogin";
    }

    @RequestMapping("/vendor/product/new")
    public String vendorproductnew() {
        return "template/dashboard/vendorproductnew";
    }

    @RequestMapping("/vendor/product")
    public String vendorproduct() {
        return "template/dashboard/vendorproduct";
    }

    @RequestMapping("/vendor/registration")
    public String vendorregister() {
        return "template/dashboard/vendorregister";
    }

    @RequestMapping("/vendor/profile")
    public String vendorprofile() {
        return "template/dashboard/vendorprofile";
    }
}
