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
	 * 根据显示ID查找项目对象
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
	
	/**
	 * 根据项目id查询项目对象(包含项目成员)
	 * 
	 * @param projectId
	 * @return Project对象
	 */
	Project getProjectMemberByProjectId(long projectId);
	
	/**
   * 根据项目id查询项目对象(包含项目所有信息:成员、模块、版本，创建者在服务层调用方法得到)
   * 
   * @param projectId
   * @return Project对象
   */
  Project getProjectAllInfoByProjectId(long projectId);
}
