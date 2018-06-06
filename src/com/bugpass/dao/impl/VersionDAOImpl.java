package com.bugpass.dao.impl;

import java.util.List;

import com.bugpass.dao.VersionDAO;
import com.bugpass.entity.Version;
import com.bugpass.util.DBUtil;

public class VersionDAOImpl implements VersionDAO {
	
	@Override
	public boolean add(Version obj) throws Exception {
		return DBUtil.execUpdate("insert into version values(null,?,?)", obj.getVersionName(),obj.getProjectId())>0;
	}

	@Override
	public boolean delete(Version obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteByVersionname(String versionName) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.execUpdate("delete from version where versionName=?", versionName)>0;
	}

	@Override
	public boolean update(Version obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Version> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Version> findAllByProjectid(int projectId) throws Exception {
		// TODO Auto-generated method stub
		return (List<Version>) DBUtil.execQuery("select * from version where projectId=?", Version.class, projectId);
	}

	@Override
	public Version findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Version findByVersionname(String vaersionName) {
		// TODO Auto-generated method stub
		return (Version) DBUtil.execQuery("select * from version where versionName=?", Version.class, vaersionName);
	}
}
