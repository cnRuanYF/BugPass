package com.bugpass.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugpass.dao.VersionDAO;
import com.bugpass.entity.Version;
import com.bugpass.service.VersionService;

@Service("versionService")
public class VersionServiceImpl implements VersionService {
	
	@Autowired
	private VersionDAO versionDAO ;

	/**
	 * 根据项目ID查询
	 */
	@Override
	public List<Version> returnFindAllByProjectid(long projectId) {
		try {
			return versionDAO.findAllByProjectid(projectId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据版本ID查询
	 */
	@Override
	public Version returnFindByVersionId(long id) {
		try {
			return versionDAO.queryById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 添加
	 */
	@Override
	public boolean returnAdd(Version version) {
		return versionDAO.add(version);
	}

	/**
	 * 查询版本名是否存在
	 */
	@Override
	public boolean returnFindVersionNameByProjectId(String versionName,long projectId) {
		List<Version> list;
		try {
			list = versionDAO.findVersionNameByProjectId(versionName, projectId);
			if (list.size()==0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	/**
	 * 根据版本名模糊查询
	 */
	@Override
	public List<Version> returnListFindByVersionName(String versionName,long projectId) {
		List<Version>list =versionDAO.findByLikename(versionName,projectId);
		return list;
	}

	/**
	 * 删除
	 */
	@Override
	public boolean returndeleteByVersionId(long versionId) {
		try {
			return versionDAO.deleteByVersionId(versionId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * 修改
	 */
	@Override
	public boolean returnUpdate(Version version) {
		try {
			return versionDAO.update(version);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
