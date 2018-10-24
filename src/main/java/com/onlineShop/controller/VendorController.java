package com.onlineShop.controller;

import com.onlineShop.model.*;
import com.onlineShop.model.model_DTO.Product_Dao;
import com.onlineShop.service.AddressService;
import com.onlineShop.service.CategoryService;
import com.onlineShop.service.ProductService;
import com.onlineShop.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
 *  Created by Solomon 10/19/2018
 *  Online Shopping
 *
 *      Vendor Product Controller
 * */
@Controller
@SessionAttributes("currentuser")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.GET)
    public String vendorProfile(@PathVariable int vendorId, Model model,
                                HttpServletRequest request) {
        try {

            Vendor vendor = vendorService.findVendorById(vendorId);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            Address address = addressService.getAddressByUserId(vendorId);
//            vendor.setAddress(address);

            System.out.println(vendor.getFirstName() + "===============================================");

            List<Product> productList = vendor.getProductList();
            System.out.println(vendor.getName() + "--------------------------------------------------------------------------");
            model.addAttribute("vendor", vendor);
            model.addAttribute("product", productList);
        } catch (Exception e) {
            System.out.println(e.getCause() + "" + e.getMessage());
        }

        return "template/shop/productlist";
    }

    @RequestMapping(value = "/vendor/product/edit/{vendorId}")
    public String EditVendor() {

        return "";
    }

    @RequestMapping(value = "/vendor/product/view", method = RequestMethod.GET)
    public String viewProduct(@ModelAttribute("product") Product product, Model model) {

        return "template/shop/productview";
    }

    @RequestMapping(value = "/vendor/product/new", method = RequestMethod.GET)
    public String doAdd(@ModelAttribute("product") Product_Dao product, Model model) {
        System.out.println("1111111111111111111111111111111111111111-----------------------1111111111111111111111111111111111");
        return "template/dashboard/vendorproductnew";
    }


    @RequestMapping(value = "/vendor/product/new", method = RequestMethod.POST)
    public String addproductbyVendor(@ModelAttribute("product") @Valid Product_Dao productToBeAdded,
                                     BindingResult result, RedirectAttributes redirectAttributes,
                                     Model model,
                                     HttpSession session) {
        /*
         *
         * vendorId_solo have to be changed after integration in to the sessionName
         * */
        // Integer vendorId_solo = (Integer s)session.getAttribute("currentVendor");
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        session.setAttribute("currentuser", 1);
        if (result.hasErrors()) {
            System.out.println("0000000000000000000-------------------------------------000000000000000000000000000000000" + result.getFieldErrors());
            return "template/dashboard/vendorproductnew";
        }
        Vendor loginuser = new Vendor();
        if (session.getAttribute("currentuser") != null) {
            Integer vendorId = (Integer) session.getAttribute("currentuser");
            loginuser = vendorService.findVendorById(vendorId);
        }
        System.out.println(loginuser.getName() + " = 00000000000000000000000000000000000000000000000000000000000000000000000000");
        Product product = (Product) ProductFactory.getINSTANCE().createUserFromDto(productToBeAdded);
        product.setVendor_id(loginuser);

        List<ProductImage> productImages = new ArrayList<ProductImage>();
        List<MultipartFile> multipartFiles = productToBeAdded.getInputImages();
        String imagename = null;

        System.out.println("EMpty +++++++++++++++++" + "0000000000000000000000000000000000" + "------------------");

        if (multipartFiles != null) {
            for (MultipartFile malti : multipartFiles) {
                if (malti != null && !malti.isEmpty()) {
                    try {
                        manageDirectory("c:\\images");
                        imagename = new Date().getDate() + "" + malti.getOriginalFilename();
                        malti.transferTo(new File("c:\\images\\" + imagename));
                        productImages.add(new ProductImage(imagename));
                    } catch (Exception e) {
                        //     throw new FileNotFoundException("Unable to save image: " + malti.getOriginalFilename());
                        System.out.println("picture problem" + malti.getOriginalFilename() + "   ==============================00000000000000000000000000000--------------------------");
                    }
                }
            }

        }
        product.setProductImageList(productImages);
        if (productImages.size() > 0)
            product.setMainPicturePath(productImages.get(0).getUrl());
        System.out.println("-----------------------------------------------11111111111111111111111111111111111111111111111111111111111111111111111");
        try {
            productService.saveProduct(product);
        } catch (Exception s) {
            s.getCause();
        }

        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:/vendor/product";
    }


    private void manageDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}
