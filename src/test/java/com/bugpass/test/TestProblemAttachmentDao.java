package com.bugpass.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bugpass.dao.ModuleDao;
import com.bugpass.dao.ProblemAttachmentDao;
import com.bugpass.entity.Module;
import com.bugpass.entity.ProblemAttachment;
import com.bugpass.service.ModuleService;
import com.bugpass.service.ProblemAttachmentService;

/**
 * TestProblemAttachment
 * 
 * @author QiuWenYi
 * @date 2018年7月3日 下午3:11:02
 */
@RunWith(SpringJUnit4ClassRunner.class) // 配置单元测试的Runner
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
// 配置Spring配置文件路径
public class TestProblemAttachmentDao {

    @Resource
    private ProblemAttachmentDao problemAttachmentDao;
    @Resource
    private ProblemAttachmentService problemAttachmentService;

    /**
     * 获取所有
     */
    @Test
    public void testQueryAll() {
        List<ProblemAttachment> list = problemAttachmentDao.queryAll();
        list.forEach(System.out::println);
    }

    /**
     * 根据问题id查找对应的讨论返回list
     */
    @Test
    public void testQueryByProblemId() {
        List<ProblemAttachment> list = problemAttachmentDao.queryAllProblemAttachmentByProblemId(3);
        list.forEach(System.out::println);
    }

    /**
     * 根据问题id+索引查询单个wen文件
     */
    @Test
    public void testQueryById() {
         ProblemAttachment problemAttachment = problemAttachmentDao.queryProblemAttachmentByProblemIdAndAttachIndex(4,1);
        System.out.println(problemAttachment);
    }

    /**
     * 删除单条记录
     */
    @Test
    public void testDelete() {
        boolean flag = problemAttachmentDao.deleteAttachmentByProblemIdAndAttachIndex(1, 3);
        if (flag) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
    /**
     * 删除单条记录法2
     */
    @Test
    public void testDeleteAttachment() {
        ProblemAttachment obj = new ProblemAttachment(1,3,1,"1");
        boolean flag = problemAttachmentDao.deleteProblemAttachment(obj);
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
//        ProblemAttachment obj = new ProblemAttachment(1,4,1,"test");
        /*ProblemAttachment obj = new ProblemAttachment();
        obj.setProblemId(1);
        obj.setAttachIndex(4);
        obj.setAttachType(1);
        obj.setAttachPath("test");*/
       Map map = new HashMap();
       map.put("id", 1);
       map.put("problemId",1);
       map.put("attachIndex",4);
       map.put("attachType", 1);
       map.put("attachPath", "test");
       System.out.println(map);
        boolean flag = problemAttachmentDao.addProblemAttachment2(map);
        if (flag) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
    /**
     * 插入2
     */
    @Test
    public void testAdd2() {
//        ProblemAttachment obj = new ProblemAttachment(1,4,1,"test");
        ProblemAttachment obj = new ProblemAttachment();
        obj.setProblemId(1);
        obj.setAttachIndex(7);
        obj.setAttachType(1);
        obj.setAttachPath("test");
        System.out.println(obj);
        boolean flag = problemAttachmentDao.addProblemAttachment(obj);
        if (flag) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
    
    
    /**************************************业务测试**********************************************/
    
 
    
}
