package com.bugpass.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bugpass.dao.ModuleDao;
import com.bugpass.entity.Module;
import com.bugpass.service.ModuleService;

/**
 * TestDiscuss
 * 
 * @author QiuWenYi
 * @date 2018年7月3日 下午3:11:02
 */
@RunWith(SpringJUnit4ClassRunner.class) // 配置单元测试的Runner
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
// 配置Spring配置文件路径
public class TestModuleDao {

    @Resource
    private ModuleDao moduleDao;
    @Resource
    private ModuleService moduleService;

    /**
     * 获取所有
     */
    @Test
    public void testQueryAll() {
        List<Module> list = moduleDao.queryAll();
        list.forEach(System.out::println);
    }

    /**
     * 根据项目id查找对应的讨论返回list
     */
    @Test
    public void testQueryByProblemId() {
        List<Module> list = moduleDao.queryByProjectId(1);
        list.forEach(System.out::println);
    }

    /**
     * 查询单个记录
     */
    @Test
    public void testQueryById() {
        Module module = moduleDao.queryById(1);
        System.out.println(module);
    }

    /**
     * 删除单条记录
     */
    @Test
    public void testDelete() {
        boolean flag = moduleDao.delete(4);
        if (flag) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    /**
     * 插入
     */
    @Test
    public void testAdd() {
        Module obj = new Module();
        obj.setModuleName("test");
        obj.setProjectId(1);
        boolean flag = moduleDao.add(obj);
        if (flag) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
    /**
     * 更新
     */
    @Test
    public void testUpdate() {
        Module obj = new Module();
        obj.setModuleId(5);
        obj.setModuleName("test2");
        obj.setProjectId(1);
        boolean flag = moduleDao.update(obj);
        if(flag) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
    /**************************************业务测试**********************************************/
    
    /**
     * 更新
     */
    @Test
    public void testUpdateInService() {
        Module module=new Module();
        module.setModuleId(5);
        module.setModuleName("testxxx");
        module.setProjectId(1);
        boolean flag = moduleService.udpModuleById(module);
        if(flag) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
    /**
     * 查询单个记录
     */
    @Test
    public void testQueryByIdInService() {
        Module module = moduleService.findByModuleId(1);
        System.out.println(module);
    }
    
}
