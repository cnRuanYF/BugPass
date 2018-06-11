package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.User;

/**
 * 用户相关业务接口
 * 
 * @author RuanYaofeng
 * @date 2018-06-06 15:01
 */
public interface UserService {
   
    /**
     * 注册新用户
     * @param user
     * @return 若成功返回true
     */
    boolean register(User user);

    /**
     * 修改个人资料
     * 
     * @param user 新的User对象
     * @return 是否修改成功
     */
    boolean updateUserProfile(User user);

    /**
     * 根据ID查找用户
     * 
     * @param userId 用户ID
     * @return 查找到的对象
     */
    User findById(long userId);

    /**
     * 根据用户名查找用户
     * 
     * @param username 用户名
     * @return 查找到的对象
     */
    User findByUsername(String username);

    /**
     * 根据关键字查找用户
     * 
     * @param keyword 关键字
     * @return 查找到的对象
     */
    List<User> findByKeyword(String keyword);
    
    /**
     * 查询用户名是否存在
     * 
     * @param username 用户名
     * @return 若已存在返回true，否则返回false
     * @throws Exception
     */
    boolean checkUsernameExist(String username);

    /**
     * 查询电子邮箱地址是否存在
     * 
     * @param email 电子邮箱
     * @return 若已存在返回true，否则返回false
     * @throws Exception
     */
    boolean checkEmailExist(String email);

    /**
     * 查询手机号是否存在
     * 
     * @param phone 手机号
     * @return 若已存在返回true，否则返回false
     * @throws Exception
     */
    boolean checkPhoneExist(String phone);

    /**
     * 修改个人中心用户部分信息
     * @param user 用户对象
     * @return 修改成功返回true，否则返回false
     */
    boolean updatePartUser(User user);
}
