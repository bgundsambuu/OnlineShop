package com.onlineShop.service;

import com.onlineShop.model.Customer;
import com.onlineShop.model.Users;

import java.util.List;

/**
 * Created by Le on 1/25/2016.
 */
public interface CustomerService {

    void addCustomer (Customer customer);

    /**
     * Edit customer, user,
     * billing address and shipping address
     *
     * @author Mingwei He
     * @param customer
     * @param user
     */
    void editCustomer(Customer customer, Users user);

    Customer getCustomerById (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);
}
