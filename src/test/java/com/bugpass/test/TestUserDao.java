package com.bugpass.test;

import com.bugpass.dao.UserDAO;
import com.bugpass.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * TestUserDao
 *
 * @author RuanYaofeng
 * @date 2018/6/30 13:09
 **/
@RunWith(SpringJUnit4ClassRunner.class) // 配置单元测试的Runner
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:mybatis-config.xml"})
// 配置Spring配置文件路径
public class TestUserDao {

    @Autowired
    private UserDAO userDao;

    @Test
    public void testQueryAll() {
        List<User> users = userDao.queryAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testQueryByKeyword() {
        List<User> users = userDao.queryByKeyword("123");
        users.forEach(System.out::println);
    }
}
