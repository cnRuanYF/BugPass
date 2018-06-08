package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Version;

public interface VersionService {

	boolean returnAdd(Version version);
	
	Version returnFindById(long id);

	boolean returnFindByVersionName(String versionName);
	
	List<Version> returnListFindByVersionName(String versionName);
	
	List<Version> returnfindAllByProjectid(int projectId);
	
	boolean returndeleteByVersionId(int versionId);

	boolean returnUpdate(Version version);
}
