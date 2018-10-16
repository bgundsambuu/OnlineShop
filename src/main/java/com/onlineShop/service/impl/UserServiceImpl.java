package com.onlineShop.service.impl;

import com.onlineShop.Constant;
import com.onlineShop.dao.*;
import com.onlineShop.model.User;
import com.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
//asdas
    /**
     * getUserByUserId
     *
     * @param userId
     * @return
     */



    public User getUserByUserId(String userId) {
        User user = userDao.getUserByUserId(userId);
        if (user != null) {
            user.setAddress(addressDao.getAddressByUserId(userId));
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
     * editUser
     *
     * @param user
     * @return
     */
    public User editUser(User user) {
        userDao.editUser(user);
        addressDao.editAddress(user.getAddress());
        User userInDB = userDao.getUserByUserId(user.getUserId());
        if (userInDB != null) {
            userInDB.setAddress(addressDao.getAddressByUserId(user.getUserId()));
            if (Constant.Role.ADMIN.equals(userInDB.getRole()) && user.getAdministrator() != null) {
                administratorDao.editAdmin(user.getAdministrator());
                userInDB.setAdministrator(administratorDao.getAdminByUserId(user.getUserId()));
            } else if (Constant.Role.VENDOR.equals(userInDB.getRole()) && user.getVendor() != null) {
                vendorDao.editVendor(user.getVendor());
                userInDB.setVendor(vendorDao.getVendorByUserId(user.getUserId()));
            } else if (Constant.Role.CUSTOMER.equals(userInDB.getRole()) && user.getCustomer() != null) {
                customerDao.editCustomer(user.getCustomer());
                userInDB.setCustomer(customerDao.getCustomerByUserId(user.getUserId()));
            }
        }
        return userInDB;
    }

    /**
     * delete
     *
     * @param userId
     * @return
     */
    public String delete(String userId) {
        User user = userDao.getUserByUserId(userId);
        user.setIsActive(Constant.Active.NO);
        userDao.editUser(user);
        return Constant.Message.SUCCESS;
    }
}
