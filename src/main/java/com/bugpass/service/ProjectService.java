package com.bugpass.service;

import com.bugpass.entity.Project;

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
	Project findById(long projectId);
	
}
