package com.bugpass.service;

import com.bugpass.entity.Version;

public interface VersionService {
	
boolean returnAdd(Version version);
boolean returnDeleteByVersioname(String versionName);


}
