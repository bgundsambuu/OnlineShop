package com.onlineShop.controller;

import com.onlineShop.model.Customer;
import com.onlineShop.model.User;
import com.onlineShop.service.EncryptionService;
import com.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

    //@Autowired
    //private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    private EncryptionService encryptionService;

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

    @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
    public String ChangePassword(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "recoverPassword";
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public String ChangePassword(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        String email=user.getUserName();
        User realuser =this.userService.getUserByEmail(email);
        if (result.hasErrors()) {
            return "recoverPassword";
        }
        if  ( realuser != null )
        {
            List<User> userList=userService.getAllUsers();
            boolean validuser = false;
            for (int i=0; i< userList.size(); i++) {
                if(email.equals(userList.get(i).getUserName())) {
                    validuser = true;
                }
            }
            if(validuser) {
                // SimpleMailMessage Msg = new SimpleMailMessage();
                // Msg.setFrom("andres.mendez.cor@gmail.com");
                //  Msg.setTo(email);
                // Msg.setSubject("Online Shopping Password recovery");
//                EncryptionService encryptionService = new EncryptionServiceImpl();
                String encryptedText = realuser.getPassword();
//                String DecryptedPass = encryptionService.DecryptPass(encryptedText);
                //Msg.setText("Your password is: " + encryptedText + "   --- Please change your password on next login.");
                // creates a simple e-mail object
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(email);
                mailMessage.setFrom("andres.mendez.cor@gmail.com");
                mailMessage.setSubject("Online Shopping Password recovery");
                mailMessage.setText("Your password is: " + encryptedText + "   --- Please change your password on next login.");

                // sends the e-mail
                //mailSender.send(mailMessage);
                return "login";
            }else{
                return "RecoverPasswordFail";
            }
        }
        return "RecoverPasswordFail";
    }

}
