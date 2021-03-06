package com.bugpass.test;

import com.bugpass.dao.ProjectDao;
import com.bugpass.entity.Project;
import com.bugpass.service.ProjectService;
import com.bugpass.util.EncryptUtil;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TestUserDao
 *
 * @author RuanYaofeng
 * @date 2018/6/30 13:09
 **/
@RunWith(SpringJUnit4ClassRunner.class) // 配置单元测试的Runner
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" }) // 配置Spring配置文件路径
public class TestProjectDao {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private ProjectService projectService;

    // 增

    @Test
    public void testAddProject() {
        Project project = new Project();
        project.setProjectName("测试数据002");
        project.setProjectDesc("测试数据002");

        boolean flag = projectService.addProject(project, null);

        System.out.println(flag);
    }

    // 删

    @Test
    public void testDelProjectById() {
        boolean flag = projectService.delProjectById(5);
        System.out.println(flag);
    }

    // 改
    
    @Test
    public void testUpdProject() {
        Project project = new Project();
        project.setId(7);
        project.setProjectName("测试008");
        project.setProjectDesc("测试008");
//        project.setProjectDate(new Date());
//        project.setDisplayId(EncryptUtil.createSalt());
        boolean flag = projectService.updProject(project);
        System.out.println(flag);
    }
    // 查

    @Test
    public void testFindById() {
        Project project = projectDao.queryById(1);
        System.out.println(project);
    }

    @Test
    public void testFindByDisplayId() {
        Project project = projectDao.queryByDisplayId("3d5fb58aa496042c39ec4bd88737849e");
        System.out.println(project);
    }

    @Test
    public void testQueryProjectByUserId() {
        List<Project> project = projectService.queryProjectByUserId(1);
        System.out.println(project);
    }
    
    @Test
    public void testQueryProjectMemberByProjectId() {
        Project project = projectService.getMemberCreatorOfProjectByProjectId(1);
        System.out.println(project);
    }
    
    @Test
    public void testQueryProjectAllInfoByProjectId() {
        Project project = projectService.getProjectAllInfoByProjectId(1);
        System.out.println(project);
    }

}
