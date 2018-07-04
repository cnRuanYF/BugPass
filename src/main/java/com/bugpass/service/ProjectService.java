package com.bugpass.service;

import com.bugpass.entity.Project;
import com.bugpass.entity.User;

/**
 * 项目相关的业务接口
 * 
 * @author ChenZhiJun
 * @date 2018-07-03 14:12
 */
public interface ProjectService {
	
	/**
	 * 根据ID查找项目
	 * 
	 * @param projectId
	 * @return
	 */
	Project findProjectById(long projectId);
	
	/**
	 * 根据显示ID查找对象
	 * 
	 * @param displayId
	 * @return
	 */
	Project findProjectByDisplayId(String displayId);
	
	/**
	 * 添加项目信息
	 * 
	 * @param project
	 * @return
	 */
	boolean addProject(Project project,User user);
	
}
