package com.onlineShop.controller;

import com.onlineShop.model.*;
import com.onlineShop.model.model_DTO.Product_Dao;
import com.onlineShop.service.AddressService;
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
    ProductService productService;

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/vendor/{vendorId}",method = RequestMethod.GET)
    public String vendorProfile(@PathVariable int vendorId, Model model,
                                HttpServletRequest request){
        try {

            Vendor vendor = vendorService.findVendorById(vendorId);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            Address address = addressService.getAddressByUserId(vendorId);
//            vendor.setAddress(address);

            System.out.println(vendor.getFirstName()+"===============================================");

            List<Product> productList = vendor.getProductList();
            System.out.println(vendor.getName() + "--------------------------------------------------------------------------");
            model.addAttribute("vendor", vendor);
            model.addAttribute("product", productList);
        }catch (Exception e){
            System.out.println(e.getCause()+""+e.getMessage());
        }

        return "template/shop/productlist";
    }

    @RequestMapping(value = "/vendor/product/edit/{vendorId}")
    public String EditVendor(){

        return "";
    }
    @RequestMapping(value = "/vendor/product/view")
    public String viewProduct(@ModelAttribute("product") Product product, Model model) {

        return "template/shop/productview";
    }

    @RequestMapping(value = "/vendor/product/add", method = RequestMethod.GET)
    public String doAdd(@ModelAttribute("product") Product_Dao product, Model model) {
        return "template/shop/addProduct";
    }


    @RequestMapping(value = "/vendor/product/add", method = RequestMethod.POST)
    public String addproductbyVendor(@ModelAttribute("product") @Valid Product_Dao productToBeAdded,
                                     BindingResult result, RedirectAttributes redirectAttributes,
                                     Model model,
                                     HttpSession session) {
        /*
        *
        * vendorId_solo have to be changed after integration in to the sessionName
        * */
       // Integer vendorId_solo = (Integer )session.getAttribute("currentVendor");
        session.setAttribute("currentuser", 1);
        if (result.hasErrors()) {
            return "";
        }
        Vendor loginuser = new Vendor();
        if (session.getAttribute("currentuser") != null) {
            Integer vendorId = (Integer) session.getAttribute("currentuser");
            loginuser = vendorService.findVendorById(vendorId);
        }
        System.out.println(loginuser.getName()+" = 00000000000000000000000000000000000000000000000000000000000000000000000000");
        Product product = (Product) ProductFactory.getINSTANCE().createUserFromDto(productToBeAdded);
        product.setVendor_id(loginuser);

        List<ProductImage> productImages = new ArrayList<>();
        List<MultipartFile> multipartFiles = productToBeAdded.getInputImages();
        String imagename = null;
        for (MultipartFile malti : multipartFiles) {
            if (malti != null && !malti.isEmpty()) {
                try {
                    manageDirectory("c:\\images");
                    imagename = new Date().getDate() + "" + malti.getOriginalFilename();
                    malti.transferTo(new File("c:\\images\\" + imagename));
                    productImages.add(new ProductImage(imagename));
                } catch (Exception e) {
//                    throw new FileNotFoundException("Unable to save image: " + image.getOriginalFilename());
                }
            }
        }

        product.setProductImageList(productImages);
        if (productImages.size() > 0)
            product.setMainPicturePath(productImages.get(0).getUrl());
        try {
            productService.saveProduct(product);
        } catch (Exception s) {
            s.getCause();
        }

        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:/vendor/product/view";
    }


    private void manageDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}
