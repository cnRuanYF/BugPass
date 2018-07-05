package com.bugpass.service.impl;

import com.bugpass.dao.UserDAO;
import com.bugpass.entity.User;
import com.bugpass.service.UserService;
import com.bugpass.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户业务实现类
 *
 * @author RuanYaofeng
 * @version 2018-06-06 15:17
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    public boolean register(User user) {
        user.setPasswordSalt(EncryptUtil.createSalt());
        user.setPasswordHash(EncryptUtil.getSHA1(user.getPassword() + user.getPasswordSalt()));

        user.setPicture((int) (Math.random() * 189) + "");

        return userDao.add(user);
    }

    public boolean updateUserProfile(User user) {
        User fullUser = userDao.queryById(user.getId());

        if (fullUser != null) {
            fullUser.setEmail(user.getEmail());
            fullUser.setPhone(user.getPhone());
            fullUser.setQq(user.getQq());
            fullUser.setRealname(user.getRealname());
            fullUser.setPicture(user.getPicture());
            return userDao.update(fullUser);
        }
        return false;
    }

    public boolean updateUserPassword(User user) {
        User fullUser = userDao.queryById(user.getId());
        if (fullUser != null) {
            fullUser.setPasswordSalt(EncryptUtil.createSalt());
            fullUser.setPasswordHash(EncryptUtil.getSHA1(user.getPassword() + fullUser.getPasswordSalt()));
            return userDao.update(fullUser);
        }
        return false;
    }

    public User findById(long userId) {
        return userDao.queryById(userId);
    }

    public User findByUsername(String username) {
        return userDao.queryByUsername(username);
    }

    public List<User> findByKeyword(String keyword) {
        return userDao.queryByKeyword(keyword);
    }

    public boolean checkUsernameExist(String username) {
        return userDao.checkUsernameExist(username);
    }

    public boolean checkEmailExist(String email) {
        return userDao.checkEmailExist(email);
    }

    public boolean checkPhoneExist(String phone) {
        return userDao.checkPhoneExist(phone);
    }
}
