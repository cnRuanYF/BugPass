package com.bugpass.service.impl;

import java.util.List;

import com.bugpass.dao.VersionDAO;
import com.bugpass.dao.impl.VersionDAOImpl;
import com.bugpass.entity.Version;
import com.bugpass.service.VersionService;

public class VersionServiceImpl implements VersionService {
	VersionDAO vd = new VersionDAOImpl();

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
	public List<Version> returnfindAllByProjectid(int projectId) {
		try {
			return vd.findAllByProjectid(projectId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean returnFindByVersionName(String versionName) {

		try {
			List<Version> versions = vd.findByVersionname(versionName);
			if (versions.size() == 0) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean returndeleteByVersionId(int versionId) {
		try {
			return vd.deleteByVersionId(versionId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
