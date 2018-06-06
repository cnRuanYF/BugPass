package com.bugpass.service;

import com.bugpass.entity.User;

/**
 * 用户相关业务接口
 * 
 * @author RuanYaofeng
 * @date 2018-06-06 15:01
 */
public interface UserService {

    /**
     * 根据关键字查找用户
     * 
     * @param keyword 关键字
     * @return 查找到的对象
     */
    User findByKeyword(String keyword);

    /**
     * 根据ID查找用户
     * 
     * @param userId 用户ID
     * @return 查找到的对象
     */
    User findById(long userId);

    /**
     * 修改个人资料
     * 
     * @param user 新的User对象
     * @return 是否修改成功
     */
    boolean updateUserProfile(User user);
}
