package com.bugpass.service.impl;

import com.bugpass.dao.VersionDAO;
import com.bugpass.dao.impl.VersionDAOImpl;
import com.bugpass.entity.Version;
import com.bugpass.service.VersionService;

public class VersionServiceImpl implements VersionService {
	VersionDAO vd=new VersionDAOImpl();
	@Override
	public boolean returnAdd(Version version) {
		try {
			return vd.add(version);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean returnDeleteByVersioname(String versionName) {
		try {
			return vd.deleteByVersionname(versionName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
