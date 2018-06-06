package com.bugpass.service.impl;

import java.net.Socket;
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
    public User findByKeyword(String keyword) {

        List<User> userList = null;
        UserDAO dao = new UserDAOImpl();

        try {
            userList = dao.findByKeyword(keyword);
        } catch (Exception e) {
            // TODO 异常！DAO异常提示优化
            packet.setSuccess(false);
            packet.setMessage(e.getMessage());
            sendResponse(socket, packet);
            return;
        }

        if (userList != null) {
            packet.setSuccess(true);
            packet.setContent(userList);
        } else {
            packet.setSuccess(false);
            packet.setMessage(StringConst.NO_USER_HAS_BEEN_FOUND);
        }
        sendResponse(socket, packet);
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

}
