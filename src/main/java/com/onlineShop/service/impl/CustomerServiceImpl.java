package com.onlineShop.service.impl;

import com.onlineShop.dao.BillingAddressDao;
import com.onlineShop.dao.CustomerDao;
import com.onlineShop.dao.ShippingAddressDao;
import com.onlineShop.dao.UsersDao;
import com.onlineShop.model.BillingAddress;
import com.onlineShop.model.Customer;
import com.onlineShop.model.ShippingAddress;
import com.onlineShop.service.CustomerService;
import com.onlineShop.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Le on 1/25/2016.
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private ShippingAddressDao shippingAddressDao;
    @Autowired
    private BillingAddressDao billingAddressDao;

    public void addCustomer (Customer customer) {
        customerDao.addCustomer(customer);
    }

    /**
     * Edit customer, user,
     * billing address and shipping address
     *
     * @author Mingwei He
     * @param customer
     * @param user
     */
    @Transactional
    public void editCustomer(Customer customer, Users user){
        // update customer
        customerDao.editCustomer(customer);
        // update billing address
        BillingAddress ba = customer.getBillingAddress();
        if (ba != null && !StringUtils.isEmpty(ba.getBillingAddressId()))
            billingAddressDao.editBillingAddress(ba);
        // update shipping address
        ShippingAddress sa = customer.getShippingAddress();
        if (sa != null && !StringUtils.isEmpty(sa.getShippingAddressId()))
            shippingAddressDao.editShippingAddress(sa);
        // update user
        if(user != null && !StringUtils.isEmpty(user.getUsersId()))
            usersDao.editUser(user);

    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username) {
        return customerDao.getCustomerByUsername(username);
    }
}
