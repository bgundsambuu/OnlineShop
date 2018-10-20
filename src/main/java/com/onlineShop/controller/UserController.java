package com.onlineShop.controller;

import com.onlineShop.Constant;
import com.onlineShop.model.Administrator;
import com.onlineShop.model.User;
import com.onlineShop.model.Customer;
import com.onlineShop.model.Vendor;
import com.onlineShop.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 *
 * User Controller
 *
 * Created by Mingwei on 10/12/2018
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable int userId, Model model, HttpServletRequest request) {
        try{
            String msg = request.getParameter(Constant.MSG);
            if(!StringUtils.isEmpty(msg)) model.addAttribute(Constant.MSG, msg);
            User user = userService.getUserByUserId(userId);
            if(user == null){
                model.addAttribute(Constant.MSG, Constant.Message.USER_NOT_EXIST);
                user = new User();
                user.setCustomer(new Customer());
                user.setVendor(new Vendor());
                user.setAdministrator(new Administrator());
            }
            model.addAttribute("user", user);
        }catch(Exception e){
            model.addAttribute(Constant.MSG, Constant.Message.FAILURE);
            Logger.getLogger(UserController.class).error(e);
        }
        // dispatch to different profile: Customer/Vendor/Admin TODO
        return "template/shop/editCustomer";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("customer") Customer customer) {
        return "template/shop/user";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@Valid @ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView("redirect:"+"/user/"+user.getUserId());
        try{
            User userInDb = userService.getUserByUserId(user.getUserId());
            if(!StringUtils.isEmpty(user.getNewPassword())) user.setPassword(user.getNewPassword());
            else user.setPassword(userInDb.getPassword());
            if(userInDb == null){
                model.getModel().put(Constant.MSG, Constant.Message.USER_NOT_EXIST);
                user = new User();
                user.setCustomer(new Customer());
                user.setVendor(new Vendor());
                user.setAdministrator(new Administrator());
                return model;
            }
            user = userService.editUser(user);
            model.getModel().put("user", user);
            model.getModel().put(Constant.MSG, Constant.Message.SUCCESS);
        }catch(Exception e){
            model.getModel().put(Constant.MSG, Constant.Message.FAILURE);
            Logger.getLogger(UserController.class).error(e);
        }
        return model;

    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int userId, Model model ) {
        try{
            model.addAttribute(Constant.MSG, userService.delete(userId));
        }catch (Exception e){
            model.addAttribute(Constant.MSG, Constant.Message.FAILURE);
            Logger.getLogger(UserController.class).error(e);
        }
        return "redirect:/";
    }

}
