package com.bugpass.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bugpass.dao.MemberDao;
import com.bugpass.dao.ProjectDao;
import com.bugpass.entity.Member;
import com.bugpass.entity.Project;
import com.bugpass.entity.User;
import com.bugpass.service.ProjectService;
import com.bugpass.util.EncryptUtil;

/**
 * 项目业务实现类
 * 
 * @author ChenZhiJun
 * @date 2018-07-03 14:18
 */
@Service(value = "projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private MemberDao memberDao;

	@Override
	public Project findProjectById(long projectId) {
		return projectDao.queryById(projectId);
	}

	@Override
	public Project findProjectByDisplayId(String displayId) {
		return projectDao.queryByDisplayId(displayId);
	}

	@Override
		public boolean addProject(Project project,User user) {
			//设置加盐ID字符串,用于获取唯一project对象,在业务里方便获取这个对象ID添加到其他表
			String displayId = EncryptUtil.createSalt();
			project.setDisplayId(displayId);
			//添加项目记录
			boolean flagPro = projectDao.add(project);
			if (flagPro) {
				//获取已添加项目的记录
				Project newProject = projectDao.queryByDisplayId(displayId);
				//TODO 获取session用户id
				System.out.println("serviceUser:"+user.getId());
				System.out.println("serviceProject:"+newProject.getProjectId());
				Member member = new Member(newProject.getProjectId(),user.getId(),1);
				//添加成员记录
				boolean flagMem = memberDao.add(member);
				if (flagMem) {
					return true;
				}
				return false;
			}
			return false;
		}

}
