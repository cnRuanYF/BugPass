package com.bugpass.dao;

import java.util.List;

import com.bugpass.entity.Version;

public interface VersionDAO extends BaseDAO<Version> {
	/**
	 * 根据版本名查询版本
	 * @param vaersionName 传入版本名
	 * @return 返回查询结果（version对象）
	 * @throws Exception
	 */
	List<Version> findByVersionname(String vaersionName) throws Exception;
	/**
	 * 根据项目ID查询版本
	 * @param projectId 传入项目ID
	 * @return 返回查询结果（version对象集合）
	 * @throws Exception
	 */
	List<Version> findAllByProjectid(int projectId) throws Exception;
	/**
	 * 根据版本名删除版本
	 * @param versionName 传入版本名
	 * @return 返回删除结果（成功返回true，失败返回false）
	 * @throws Exception
	 */
	boolean deleteByVersionname(String versionName) throws Exception;
}
