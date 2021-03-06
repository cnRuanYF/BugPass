package com.bugpass.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bugpass.entity.Version;

@Repository(value="versionDAO")
public interface VersionDAO extends BaseDAO<Version> {
	/**
	 * 查询版本名是否存在
	 * @param vaersionName 传入版本名
	 * @return 返回查询结果（version对象）
	 * @throws Exception
	 */
	List<Version> findVersionNameByProjectId(String versionName,long projectId) throws Exception;
	/**
	 * 根据项目ID查询版本
	 * @param projectId 传入项目ID
	 * @return 返回查询结果（version对象集合）
	 * @throws Exception
	 */
	List<Version> findAllByProjectid(long projectId) throws Exception;
	/**
	 * 根据版本ID删除版本
	 * @param versionName 传入版本ID
	 * @return 返回删除结果（成功返回true，失败返回false）
	 * @throws Exception
	 */
	boolean deleteByVersionId(long versionId) throws Exception;
	/**
	 * 根据版本名模糊查询
	 * @param vaersionName 模糊查询字段
	 * @return 返回版本集合
	 */
	List<Version> findByLikename(String versionName,long projectId);
}
