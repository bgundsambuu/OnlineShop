package com.onlineShop.controller;

import com.onlineShop.model.Customer;
import com.onlineShop.model.Vendor;
import com.onlineShop.service.SubscriptionService;
import com.onlineShop.service.VendorService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created By krish on Oct, 2018
 */
@Controller
@RequestMapping(value = "/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(value = "/addVendor", method = RequestMethod.GET)
    public String registerVendor(Model model){
        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);

        return "/template/shop/adminview/vendor-form";
    }

    @RequestMapping(value = "/addVendor", method = RequestMethod.POST)
    public String saveVendor(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "/template/shop/adminview/vendor-form";
        }
//
//        List<Vendor> vendorList = vendorService.getAllVendor();
//        for(int i = 0; i< vendorList.size(); i++){
//            if (vendor.getUser().getUserName().equals(vendorList.get(i).getUser().getUserName())){
//                model.addAttribute("emailMsg", "Email Already Exist");
//
//                return "/template/shop/adminview/vendor-form";
//            }
//        }

        vendorService.addVendor(vendor);

        String url = "/template/shop/adminview/vendor-payment";

//        return "/template/shop/adminview/vendor-registration-success";
        return url;
//
    }

    @RequestMapping(value = "/getAllPendingVendors", method = RequestMethod.GET)
    public String getAllPendingVendors(Model model){

        List<Vendor> vendorList = vendorService.getAllPendingVendor();
        model.addAttribute("vendor", vendorList);
        return "/template/shop/adminview/new-vendor-list";
    }

    //Pulling pending vendor by Id to display in detail page

    @RequestMapping(value = "/getPendingVendorById/{vendorId}", method = RequestMethod.GET)
    public String getPendingVendorById(@PathVariable int vendorId, Model model){
        Vendor vendor = vendorService.getPendingVendorById(vendorId);
        System.out.println(vendorId+"==================");
        System.out.println(vendor.getFirstName()+"==================");
        model.addAttribute("vendor", vendor);

        return "/template/shop/adminview/new-vendor-detail";
    }

    @RequestMapping(value = "/vendorApprove", method = RequestMethod.GET)
    public String vendorApprovGet(Model model){
        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);

        return "/template/shop/adminview/new-vendor-detail";
    }


    @RequestMapping(value = "/vendorApprove", method = RequestMethod.POST)
    public String vendorApprovePost(@Valid @ModelAttribute("vendor") Vendor vendor, BindingResult result, Model model){
            vendor.setStatus("approved");
            vendorService.updateVendorStatus(vendor);
        return "/template/shop/adminview/new-vendor-approval-success";
    }
/*
    @RequestMapping(value = "/vendorPayment", method = RequestMethod.GET)
    public String vendorPayment(Model model){

        subscriptionService.getSubscription().getAmount();

        return "/template/shop/adminview/vendor-registration-success";

    }*/


}
