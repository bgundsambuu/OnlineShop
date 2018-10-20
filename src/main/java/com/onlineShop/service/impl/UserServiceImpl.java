package com.onlineShop.service.impl;

import com.onlineShop.Constant;
import com.onlineShop.dao.*;
import com.onlineShop.model.Customer;
import com.onlineShop.model.User;
import com.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Mingwei on 10/12/2018
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    AdministratorDao administratorDao;
    @Autowired
    AddressDao addressDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    VendorDao vendorDao;

    /**
     * getUserByUserId
     *
     * @param userId
     * @return
     */
    public User getUserByUserId(int userId) {
        User user = userDao.getUserByUserId(userId);
        if (user != null) {
            if (Constant.Role.ADMIN.equals(user.getRole()))
                user.setAdministrator(administratorDao.getAdminByUserId(userId));
            else if (Constant.Role.VENDOR.equals(user.getRole()))
                user.setVendor(vendorDao.getVendorByUserId(userId));
            else if (Constant.Role.CUSTOMER.equals(user.getRole()))
                user.setCustomer(customerDao.getCustomerByUserId(userId));
        }
        return user;
    }

    /**
     * Edit User
     * Created by Mingwei
     * @param user
     * @return
     */
    public User editUser(User user) {
        userDao.editUser(user);
        if (Constant.Role.ADMIN.equals(user.getRole()) && user.getAdministrator() != null) {
            // TODO
            administratorDao.editAdmin(user.getAdministrator());
            user.setAdministrator(administratorDao.getAdminByUserId(user.getUserId()));
        } else if (Constant.Role.VENDOR.equals(user.getRole()) && user.getVendor() != null) {
            // TODO
            vendorDao.editVendor(user.getVendor());
            user.setVendor(vendorDao.getVendorByUserId(user.getUserId()));
        } else if (Constant.Role.CUSTOMER.equals(user.getRole()) && user.getCustomer() != null) {
            Customer customer = customerDao.getCustomerByUserId(user.getUserId());
            String newFirstName = user.getCustomer().getFirstName();
            String newLastName = user.getCustomer().getLastName();
            String newPhone = user.getCustomer().getPhoneNumber();
            if(!StringUtils.isEmpty(newFirstName)) customer.setFirstName(newFirstName);
            if(!StringUtils.isEmpty(newLastName)) customer.setLastName(newLastName);
            if(!StringUtils.isEmpty(newPhone)) customer.setPhoneNumber(newPhone);
            customerDao.editCustomer(customer);
            user.setCustomer(customerDao.getCustomerByUserId(user.getUserId()));
        }
        return user;
    }

    /**
     * User delete
     *
     * created by Mingwei
     *
     * @param userId
     * @return
     */
    public String delete(int userId) {
        User user = userDao.getUserByUserId(userId);
        user.setIsActive(Constant.Active.NO);
        userDao.editUser(user);
        return Constant.Message.SUCCESS;
    }
}
