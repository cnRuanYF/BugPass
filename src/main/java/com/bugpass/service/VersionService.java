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
	 * 根据版本名字查询
	 * 
	 * @param versionName
	 * @return
	 */
	boolean returnFindByVersionName(String versionName);

	/**
	 * 根据版本名模糊查询
	 * 
	 * @param versionName
	 * @return
	 */
	List<Version> returnListFindByVersionName(String versionName);

	/**
	 * 根据项目ID查询
	 * 
	 * @param projectId
	 * @return
	 */
	List<Version> returnFindAllByProjectid(int projectId);

	/**
	 * 根据版本ID删除
	 * 
	 * @param versionId
	 * @return
	 */
	boolean returndeleteByVersionId(int versionId);

	/**
	 * 修改
	 * 
	 * @param version
	 * @return
	 */
	boolean returnUpdate(Version version);
}
