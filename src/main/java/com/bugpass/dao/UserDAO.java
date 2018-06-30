package com.bugpass.dao;

import com.bugpass.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO接口
 *
 * @author RuanYaofeng
 * @date 2018/6/29 18:10
 **/
@Repository("userDao")
public interface UserDAO extends BaseDAO<User> {

    /**
     * 根据用户名查找用户
     *
     * @param username 用户的用户名
     * @return 查找到的用户对象，未找到则返回null
     */
    User queryByUsername(String username) ;

    /**
     * 根据关键字查询用户
     *
     * @param keyword 要查找的关键字
     * @return 查找到的用户对象集合
     */
    List<User> queryByKeyword(String keyword) ;

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @return 若已存在返回true，否则返回false
     * @throws Exception
     */
    boolean checkUsernameExist(String username) ;

    /**
     * 查询电子邮箱地址是否存在
     *
     * @param email 电子邮箱
     * @return 若已存在返回true，否则返回false
     */
    boolean checkEmailExist(String email) ;

    /**
     * 查询手机号是否存在
     *
     * @param phone 手机号
     * @return 若已存在返回true，否则返回false
     * @throws Exception
     */
    boolean checkPhoneExist(String phone) ;

}
