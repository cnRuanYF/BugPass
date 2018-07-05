package com.bugpass.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bugpass.entity.Project;

/**
 * 项目Dao接口
 * 
 * @author ChenZhiJun
 * @date 2018-07-03 13:06
 */
@Repository(value="projectDao")
public interface ProjectDao extends BaseDAO<Project> {
	
	/**
	 * 根据显示ID查找对象
	 * 
	 * @param displayId 显示ID
	 * @return Project对象
	 */
	Project queryByDisplayId(String displayId);
	
	/**
	 * 根据用户id查询用户参与的所有项目
	 * @param userId
	 * @return List<Project>
	 */
	List<Project> queryProjectByUserId(long userId);
	
}
