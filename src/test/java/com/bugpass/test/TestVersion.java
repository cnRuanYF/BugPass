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
		Version version=versionService.returnFindByVersionId(3);
		System.out.println(version);
	}
	
	/**
	 * 查询版本名是否存在
	 */
	@Test
	public void getVersionNameByProjectId() {
		boolean flag=versionService.returnFindVersionNameByProjectId("1.1", 1);
		System.out.println(flag);
	}
	
	/**
	 * 根据版本名模糊查询
	 */
	@Test
	public void getVersionLikeVersionName() {
		List<Version> list;
		list=versionService.returnListFindByVersionName("1.1",1);
		list.forEach(System.out::println);
	}
	/**
	 * 修改版本
	 */
	@Test
	public void updateVersion() {
		Version version=new Version();
		version.setVersionId(1);
		version.setProjectId(1);
		version.setVersionName("1.1版");
		System.out.println(versionService.returnUpdate(version));
	}
	/**
	 * 添加
	 */
	@Test
	public void addVersion() {
		Version version=new Version();
		version.setProjectId(1);
		version.setVersionName("1.2");
		boolean flag=versionService.returnAdd(version);
		System.out.println(flag);
	}
	/**
	 * 删除
	 */
	@Test
	public void deleteVersion() {
		boolean flag=versionService.returndeleteByVersionId(5);
		System.out.println(flag);
	}
	
}
