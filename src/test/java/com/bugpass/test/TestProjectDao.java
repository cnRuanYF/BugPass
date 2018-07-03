package com.bugpass.test;

import com.bugpass.dao.ProjectDao;
import com.bugpass.dao.UserDAO;
import com.bugpass.entity.Project;
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
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })// 配置Spring配置文件路径
public class TestProjectDao {

	@Autowired
	private ProjectDao projectDao;

	@Test
	public void testFindById() {
		Project project = projectDao.queryById(1);
		System.out.println(project);
	}

}
