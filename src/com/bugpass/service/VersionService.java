package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Version;

public interface VersionService {
	
boolean returnAdd(Version version);
boolean returnFindByVersionName(String versionName);
List<Version>returnfindAllByProjectid(int projectId);

}
