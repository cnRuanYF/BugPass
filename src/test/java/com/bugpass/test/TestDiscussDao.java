package com.bugpass.test;

import com.bugpass.dao.DiscussDao;
import com.bugpass.dao.UserDAO;
import com.bugpass.entity.Discuss;
import com.bugpass.entity.User;
import com.bugpass.service.DiscussService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import javax.annotation.Resource;

/**
 * TestDiscuss
 * @author QiuWenYi
 * @date 2018年7月3日 下午3:11:02
 */
@RunWith(SpringJUnit4ClassRunner.class) // 配置单元测试的Runner
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:mybatis-config.xml"})
// 配置Spring配置文件路径
public class TestDiscussDao {

    @Resource
    private DiscussDao discussDao;
    /**
     * 获取所有
     */
    @Test
    public void testQueryAll() {
        List<Discuss> discuss = discussDao.queryAll();
        discuss.forEach(System.out::println);
    }
    
    /**
     * 根据问题id查找对应的讨论返回list
     */
    @Test
    public void testQueryByProblemId() {
        List<Discuss> discuss = discussDao.queryByProblemId(1);
         System.out.println(discuss);
    }
    
    /**
     * 查询单个记录
     */
    @Test
    public void testQueryById() {
         Discuss discuss = discussDao.queryById(1);
         System.out.println(discuss);
    }
    /**
     * 删除单条记录
     */
    @Test
    public void testDelete() {
         boolean flag = discussDao.delete(3);
         if(flag) {
             System.out.println("成功");
         }else {
             System.out.println("失败");
         }
    }
    /**
     * 插入
     */
    @Test
    public void testAdd() {
          Discuss obj=new Discuss();
          User publisherUser=new User();
          publisherUser.setId(2);
//          publisherUser.setUsername("test2");
          obj.setPublisherUser(publisherUser);
          obj.setProblemId(1);
          obj.setDiscussContent("test2");
        boolean flag = discussDao.add(obj);
        if(flag) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
    /**
     * 暂时不用
     */
    @Test
    public void testUpdate() {
        Discuss obj=new Discuss();
        
        boolean flag = discussDao.update(obj);
        if(flag) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
    /**************************************业务测试**********************************************/
    
    @Autowired
    private DiscussService discussService;
    
    /**
     * 根据问题id查找对应的讨论返回list
     */
    @Test
    public void testQueryByProblemIdInService() {
        List<Discuss> discuss = discussService.findByProblemId(1);
         System.out.println(discuss);
    }
    
    /**
     * 删除单条记录
     */
    @Test
    public void testDeleteInService() {
         boolean flag = discussService.delDiscussById(5);
         if(flag) {
             System.out.println("成功");
         }else {
             System.out.println("失败");
         }
    }
    
    /**
     * 插入
     */
    @Test
    public void testAddInService() {
          Discuss obj=new Discuss();
          User publisherUser=new User();
          publisherUser.setId(2);
          obj.setPublisherUser(publisherUser);
          obj.setProblemId(1);
          obj.setDiscussContent("test2");
        boolean flag = discussDao.add(obj);
        if(flag) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
}
