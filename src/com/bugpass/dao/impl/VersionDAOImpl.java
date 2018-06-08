package com.bugpass.dao.impl;

import java.util.List;

import com.bugpass.dao.VersionDAO;
import com.bugpass.entity.Version;
import com.bugpass.util.DBUtil;

public class VersionDAOImpl implements VersionDAO {

	@Override
	public boolean add(Version obj) throws Exception {
		return DBUtil.execUpdate("insert into version values(null,?,?)", obj.getProjectId(), obj.getVersionName()) > 0;
	}

	@Override
	public boolean delete(Version obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByVersionId(int versionId) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.execUpdate("delete from version where versionId=?", versionId) > 0;
	}

	@Override
	public boolean update(Version version) throws Exception {
		return DBUtil.execUpdate("update version set versionName=? where versionId=?", version.getVersionName(),version.getVersionId())>0;
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
		
		List<Version> list= (List<Version>) DBUtil.execQuery("select * from version where versionId=?", Version.class, id);
		if (list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<Version> findByVersionname(String vaersionName) {
		// TODO Auto-generated method stub
		return (List<Version>) DBUtil.execQuery("select * from version where versionName=?", Version.class,
				vaersionName);
	}
	@Override
	public List<Version> findByLikename(String vaersionName) {
		// TODO Auto-generated method stub
		return (List<Version>) DBUtil.execQuery("select * from version where versionName like ?", Version.class,
				"%"+vaersionName+"%");
	}
}
