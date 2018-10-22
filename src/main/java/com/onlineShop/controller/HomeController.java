package com.onlineShop.controller;

import com.onlineShop.model.*;
import com.onlineShop.service.CustomerService;
import com.onlineShop.service.OrderDetailService;
import com.onlineShop.service.ProductService;
import com.onlineShop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Le on 1/24/2016.
 */

@Controller
@SessionAttributes({"shoppingCart", "user"})
public class HomeController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home(HttpSession session) {
        return "template/shop/home";
//        return "redirect:user/3";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout",
            required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!!!");
        }

        if (logout != null) {
            model.addAttribute("msg", "You have been logged out correctly!!!!!!!!!!! test12");
        }
        return "login";
    }

    @RequestMapping(value = "/addItemToShoppingCart", method = RequestMethod.POST)
    public String addItemToShoppingCart(@ModelAttribute("shoppingCartItems") ShoppingCartItems shoppingCartItems, HttpSession session) {
        HashMap<Long, Integer> cartItems;

        Long cartItemId = shoppingCartItems.getProductId();
        int cartItemQuantity = shoppingCartItems.getQuantity();

        if (session.getAttribute("shoppingCart") == null) {
            System.out.println("Add New Prod");
            cartItems = new HashMap<>();
            cartItems.put(cartItemId, cartItemQuantity);
            session.setAttribute("shoppingCart", cartItems);
        } else {
            System.out.println("old session");
            cartItems = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
            if (cartItems.containsKey(cartItemId)) {
                cartItems.put(cartItemId, cartItems.get(cartItemId) + cartItemQuantity);
                for (Long name : cartItems.keySet()) {
                    String key = name.toString();
                    String value = cartItems.get(name).toString();
                    System.out.println("key = " + key + " value = " + value);
                }
            } else {
                cartItems.put(cartItemId, cartItemQuantity);
            }
        }
        return "redirect:/viewProd";
    }

    @RequestMapping(value = "/ajaxAddItemToShoppingCart", method = RequestMethod.POST)
    public @ResponseBody ShoppingCartItems ajaxAddItemToShoppingCart(@RequestBody ShoppingCartItems shoppingCartItems, HttpSession session) {
        HashMap<Long, Integer> cartItems;

        System.out.println(shoppingCartItems.getProductId()+"------------------------------------");

        Long cartItemId = shoppingCartItems.getProductId();
        int cartItemQuantity = shoppingCartItems.getQuantity();

        if (session.getAttribute("shoppingCart") == null) {
            System.out.println("Add New Prod");
            cartItems = new HashMap<>();
            cartItems.put(cartItemId, cartItemQuantity);
            session.setAttribute("shoppingCart", cartItems);
        } else {
            System.out.println("old session");
            cartItems = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
            if (cartItems.containsKey(cartItemId)) {
                cartItems.put(cartItemId, cartItems.get(cartItemId) + cartItemQuantity);
                for (Long name : cartItems.keySet()) {
                    String key = name.toString();
                    String value = cartItems.get(name).toString();
                    System.out.println("key = " + key + " value = " + value);
                }
            } else {
                cartItems.put(cartItemId, cartItemQuantity);
            }
        }

        return shoppingCartItems;
    }

    @RequestMapping(value = "/viewProd", method = RequestMethod.GET)
    public ModelAndView viewProd() {
        return new ModelAndView("addProdToShoppingCart", "shoppingCartItems", new ShoppingCartItems());
    }

    @RequestMapping(value = "/deleteShoppingCart", method = RequestMethod.POST)
    public String deleteShoppingCard(@ModelAttribute("shoppingCartItems") ShoppingCartItems shoppingCartItems, HttpSession session) {
        System.out.println("delete");
        Long cartItemId = shoppingCartItems.getProductId();
        int cartItemQuantity = shoppingCartItems.getQuantity();
        HashMap<Long, Integer> cartItems;
        if (session.getAttribute("shoppingCart") != null) {
            cartItems = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
            if (cartItems.containsKey(cartItemId)) {
                int quantity = cartItems.get(cartItemId).intValue() - cartItemQuantity < 0 ? 0 : cartItems.get(cartItemId).intValue() - cartItemQuantity;
                if (quantity == 0) {
                    cartItems.remove(cartItems.remove(cartItemId));
                    System.out.println("Item remover from shopping cart");
                } else {
                    cartItems.put(cartItemId, quantity);
                    for (Long name : cartItems.keySet()) {
                        String key = name.toString();
                        String value = cartItems.get(name).toString();
                        System.out.println("key = " + key + " value = " + value);
                    }
                }
            }
        }
        return "redirect:/viewProd";
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public String deleteShoppingCard(HttpSession session) {
        session.setAttribute("user", 1);
        if (session.getAttribute("user") == null) {
            return "redirect:/loginpage";
        }

        if (session.getAttribute("shoppingCart") == null) {
            return "redirect:/viewProd";
        }

        HashMap<Long, Integer> hashMap = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (Long prodId : hashMap.keySet()) {
            OrderDetail orderDetail = new OrderDetail();
            int quantity = hashMap.get(prodId);
            orderDetail.setProduct(productService.findById(prodId.intValue()));//retrieve product information
            orderDetail.setQuantity(quantity);
            orderDetailService.addOrderDetail(orderDetail);
            orderDetailList.add(orderDetail);
        }

        int userID = (Integer) session.getAttribute("user");
        Customer customer = customerService.getCustomerById(userID);
        OrderPayment orderPayment = new OrderPayment();
        orderPayment.setCustomer(customer);
        orderPayment.setOrderDetailList(orderDetailList);
        orderPayment.setOrderStatus("ready");
        shoppingCartService.add(orderPayment);
        return "redirect:/";
    }
}
