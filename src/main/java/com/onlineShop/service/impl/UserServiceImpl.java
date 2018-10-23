package com.onlineShop.service.impl;

import com.onlineShop.Constant;
import com.onlineShop.dao.*;
import com.onlineShop.model.Customer;
import com.onlineShop.model.User;
import com.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Mingwei on 10/12/2018
 * Modified by Andres on 10/23/2018
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
     * Get User By User Id
     * @Author Mingwei
     * @Date 10/12/2018
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
     * @Author Mingwei
     * @Date 10/12/2018
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
     * @Author Mingwei
     * @Date 10/12/2018
     * @param userId
     * @return
     */
    public String delete(int userId) {
        User user = userDao.getUserByUserId(userId);
        user.setIsActive(Constant.Active.NO);
        userDao.editUser(user);
        return Constant.Message.SUCCESS;
    }

    //Added by Andres
    public void addUser(User user) { userDao.addUser(user); }

    //Added by Andres
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    //Added by Andres
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    //Added by Andres
    public User getUserByEmail(String username) {
        User user = userDao.getUserByEmail(username);
        if (user != null) {
            if (Constant.Role.ADMIN.equals(user.getRole()))
                user.setAdministrator(administratorDao.getAdminByUserId(user.getUserId()));
            else if (Constant.Role.VENDOR.equals(user.getRole()))
                user.setVendor(vendorDao.getVendorByUserId(user.getUserId()));
            else if (Constant.Role.CUSTOMER.equals(user.getRole()))
                user.setCustomer(customerDao.getCustomerByUserId(user.getUserId()));
        }
        return user;
    }

    //Added by Andres
    public int getNextId() {
        List<User> userList = getAllUsers();
        int NextId = 1;
        for (int i=0; i< userList.size(); i++) {
            if(userList.get(i).getUserId()>NextId){
                NextId = userList.get(i).getUserId();
            }
        }
        NextId = NextId+1;
        return NextId;
    }

}
