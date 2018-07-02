package com.bugpass.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bugpass.entity.Version;
import com.bugpass.service.VersionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:mybatis-config.xml"})
public class TestVersion {
	
	@Resource(name="versionService")
	VersionService versionService;

	/**
	 * 根据项目ID查找
	 */
	@Test
	public void getVersionByProjectId() {
		List<Version> list= versionService.returnFindAllByProjectid(1);
		list.forEach(System.out::println);
	}
	
	/**
	 * 根据版本ID查找
	 */
	@Test
	public void getVersionByVersionId() {
		Version version=versionService.returnFindByVersionId(5);
		System.out.println(version);
	}
	
	/**
	 * 添加版本
	 */
	@Test
	public void updateVersion() {
		Version version=new Version();
		version.setVersionId(10);
		version.setProjectId(1);
		version.setVersionName("1.1版");
		System.out.println(versionService.returnUpdate(version));
	}
	
	
}
