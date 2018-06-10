package com.bugpass.dao;

import java.util.List;

import com.bugpass.entity.Project;
/**
 * 项目DAO接口
 * 
 * @author QiuWenYi
 * @date 2018年6月10日 下午2:08:23
 */
public interface ProjectDAO extends BaseDAO<Project> {
	/**
	 * 根据项目名查询项目
	 * @param vaersionName 传入项目名
	 * @return 返回查询结果（Project对象）
	 * @throws Exception
	 */
	List<Project> findByProjectname(String projectName) throws Exception;
	/**
	 * 根据项目ID查询项目
	 * @param projectId 传入项目ID
	 * @return 返回查询结果（Project对象集合）
	 * @throws Exception
	 */
	List<Project> findAllByProjectid(int projectId) throws Exception;
	/**
	 * 根据项目ID删除项目
	 * @param ProjectName 传入项目ID
	 * @return 返回删除结果（成功返回true，失败返回false）
	 * @throws Exception
	 */
	boolean deleteByProjectId(int projectId) throws Exception;
	/**
	 * 根据项目名模糊查询
	 * @param vaersionName 模糊查询字段
	 * @return 返回项目集合
	 */
	List<Project> findByLikename(String projectName);
}
