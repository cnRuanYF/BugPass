package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Version;

public interface VersionService {
	/**
	 * 添加版本
	 */
	boolean returnAdd(Version version);

	/**
	 * 根据版本ID查询
	 */
	Version returnFindByVersionId(long id);

	/**
	 * 查询版本名是否存在
	 * 
	 * @param versionName
	 * @return
	 */
	boolean returnFindVersionNameByProjectId(String versionName,long projectId);

	/**
	 * 根据版本名模糊查询
	 * 
	 * @param versionName
	 * @return
	 */
	List<Version> returnListFindByVersionName(String versionName,long projectId);

	/**
	 * 根据项目ID查询
	 * 
	 * @param projectId
	 * @return
	 */
	List<Version> returnFindAllByProjectid(long projectId);

	/**
	 * 根据版本ID删除
	 * 
	 * @param versionId
	 * @return
	 */
	boolean returndeleteByVersionId(long versionId);

	/**
	 * 修改
	 * 
	 * @param version
	 * @return
	 */
	boolean returnUpdate(Version version);
}
