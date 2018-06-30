package com.bugpass.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用SpringJUnit进行单元测试
 * @author RuanYaofeng
 * @date 2018/6/29 15:41
 **/
@RunWith(SpringJUnit4ClassRunner.class) // 配置单元测试的Runner
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:mybatis-config.xml"}) // 配置Spring配置文件路径
public class TestSpringJUnit {

    @Test
    public void springTest(){
        System.out.println("Hello JUnit");
    }
}
