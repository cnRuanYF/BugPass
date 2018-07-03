package com.bugpass.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bugpass.dao.ProjectDao;
import com.bugpass.entity.Project;
import com.bugpass.service.ProjectService;


/**
 * 项目业务实现类
 * 
 * @author ChenZhiJun
 * @date 2018-07-03 14:18
 */
@Service(value="projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
		@Autowired
		private ProjectDao projectDao;
	
		@Override
	public Project findById(long projectId) {
			return projectDao.queryById(projectId);
		}

}
