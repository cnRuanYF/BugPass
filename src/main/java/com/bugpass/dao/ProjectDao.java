package com.bugpass.dao;

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
	
	
	
}
