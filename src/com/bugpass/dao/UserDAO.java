package com.bugpass.dao;

import java.util.List;

import com.bugpass.entity.User;

/**
 * 用户DAO接口
 * 
 * @author RuanYaofeng
 * @date 2018年4月15日 下午3:34:14
 */
public interface UserDAO extends BaseDAO<User> {

    /**
     * 根据用户名查找用户
     * 
     * @param username 用户的用户名
     * @return 查找到的用户对象，未找到则返回null
     * @throws Exception 处理过程中发生错误均抛出异常到业务层处理
     */
    User findByUsername(String username) throws Exception;

    /**
     * 根据关键字查询用户
     * 
     * @param keyword 要查找的关键字
     * @return 查找到的用户对象集合
     * @throws Exception 处理过程中发生错误均抛出异常到业务层处理
     */
    List<User> findByKeyword(String keyword) throws Exception;

    /**
     * 查询用户名是否存在
     * 
     * @param username 用户名
     * @return 若已存在返回true，否则返回false
     * @throws Exception
     */
    boolean checkUsernameExist(String username) throws Exception;

    /**
     * 查询电子邮箱地址是否存在
     * 
     * @param email 电子邮箱
     * @return 若已存在返回true，否则返回false
     * @throws Exception
     */
    boolean checkEmailExist(String email) throws Exception;

    /**
     * 查询手机号是否存在
     * 
     * @param phone 手机号
     * @return 若已存在返回true，否则返回false
     * @throws Exception
     */
    boolean checkPhoneExist(String phone) throws Exception;
}
