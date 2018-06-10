package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Project;
/**
 * 项目业务接口类
 * 
 * @author QiuWenYi
 * @date 2018年6月10日 下午9:45:04
 */
public interface ProjectService {

	boolean returnAdd(Project project);
	
	Project returnFindById(long id);

	boolean returnFindByProjectName(String projectName);
	
	List<Project> returnListFindByProjectName(String projectName);
	
	List<Project> returnfindAllByProjectid(int projectId);
	
	List<Project> returnfindAll();
	
	boolean returndeleteByProjectId(int projectId);

	boolean returnUpdate(Project project);
}
