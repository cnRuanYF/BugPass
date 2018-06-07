package com.bugpass.service.impl;

import java.util.List;

import com.bugpass.dao.UserDAO;
import com.bugpass.dao.impl.UserDAOImpl;
import com.bugpass.entity.User;
import com.bugpass.service.UserService;

/**
 * 用户业务实现类
 * 
 * @author RuanYaofeng
 * @date 2018-06-06 15:17
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean register(User user) {
        UserDAO dao = new UserDAOImpl();

        boolean isSuccess = false;
        try {
            isSuccess = dao.add(user);
        } catch (Exception e) {
            e.printStackTrace(); // XXX 处理异常
        }

        return isSuccess;
    }

    @Override
    public boolean updateUserProfile(User user) {

        UserDAO dao = new UserDAOImpl();

        boolean isSuccess = false;
        try {
            isSuccess = dao.update(user);
        } catch (Exception e) {
            e.printStackTrace(); // XXX 处理异常
        }

        return isSuccess;
    }

    @Override
    public User findById(long userId) {

        UserDAO dao = new UserDAOImpl();
        User user = null;

        try {
            user = dao.findById(userId);
        } catch (Exception e) {
            e.printStackTrace(); // XXX 处理异常
        }

        return user;
    }

    @Override
    public User findByUsername(String username) {

        UserDAO dao = new UserDAOImpl();
        User user = null;

        try {
            user = dao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace(); // XXX 处理异常
        }

        return user;
    }

    @Override
    public List<User> findByKeyword(String keyword) {

        List<User> userList = null;
        UserDAO dao = new UserDAOImpl();

        try {
            userList = dao.findByKeyword(keyword);
        } catch (Exception e) {
            e.printStackTrace(); // XXX 处理异常
        }

        return userList;
    }

    @Override
    public boolean checkUsernameExist(String username) {
        UserDAO dao = new UserDAOImpl();

        boolean isExist = false;
        try {
            isExist = dao.checkUsernameExist(username);
        } catch (Exception e) {
            e.printStackTrace(); // XXX 处理异常
        }

        return isExist;
    }

    @Override
    public boolean checkEmailExist(String email) {
        UserDAO dao = new UserDAOImpl();

        boolean isExist = false;
        try {
            isExist = dao.checkEmailExist(email);
        } catch (Exception e) {
            e.printStackTrace(); // XXX 处理异常
        }

        return isExist;
    }

    @Override
    public boolean checkPhoneExist(String phone) {
        UserDAO dao = new UserDAOImpl();

        boolean isExist = false;
        try {
            isExist = dao.checkPhoneExist(phone);
        } catch (Exception e) {
            e.printStackTrace(); // XXX 处理异常
        }

        return isExist;
    }

}
