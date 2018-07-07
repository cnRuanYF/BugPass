package com.bugpass.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugpass.constant.MemberRoleType;
import com.bugpass.dao.MemberDao;
import com.bugpass.dao.ProjectDao;
import com.bugpass.entity.Member;
import com.bugpass.entity.Project;
import com.bugpass.entity.User;
import com.bugpass.service.MemberService;
import com.bugpass.service.ProjectService;
import com.bugpass.util.EncryptUtil;

/**
 * 项目业务实现类
 * 
 * @author ChenZhiJun
 * @date 2018-07-03 14:18
 */
@Service(value = "projectService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberService memberService;

    // 增

    @Override
    public boolean addProject(Project project, User user) {
        // 设置加盐ID字符串,用于获取唯一project对象,在业务里方便获取这个对象ID添加到其他表
        String displayId = EncryptUtil.createSalt();
        project.setDisplayId(displayId);
        // 添加项目记录
        boolean flagPro = projectDao.add(project);
        if (flagPro) {
            // 获取已添加项目记录的id
            long projectId = projectDao.queryByDisplayId(displayId).getId();
            // TODO 获取session用户id
            System.out.println("serviceUser:" + user.getId());
            System.out.println("serviceProject:" + projectId);
            Member member = new Member(projectId,(int)user.getId(),1);
            // 添加成员记录
            boolean flagMem = memberDao.add(member);
            if (flagMem) {
                return true;
            }
            return false;
        }
        return false;
    }

    // 删

    @Override
    public boolean delProjectById(long projectId) {
        return projectDao.delete(projectId);
    }
    
    // 改
    
    @Override
    public boolean updProject(Project project) {
        return projectDao.update(project);
    }
    
    // 查

    @Override
    public Project findProjectById(long projectId) {
        return projectDao.queryById(projectId);
    }

    @Override
    public Project findProjectByDisplayId(String displayId) {
        return projectDao.queryByDisplayId(displayId);
    }

    @Override
    public List<Project> queryProjectByUserId(long userId) {
        //TODO
        //查询当前用户加入项目的所有信息
        List<Project> projectList = projectDao.queryProjectByUserId(userId);
        //遍历每个项目获取每个项目的成员和创建者
        for (int i = 0; i < projectList.size(); i++) {
            //将每个项目的对象完整化
            projectList.set(i, getMemberCreatorOfProjectByProjectId(projectList.get(i).getId()));
        }
        return projectList;
    }

    @Override
    public User getProjectCreatorByProjectId(long projectId) {
        //根据项目id查询参加项目的所有成员
        List<Member> members = memberService.queryByProjectId(projectId);
        User projectCreator = null;
        //遍历参见项目成员找出创建者
        for(Member member:members){
            if(member.getMemberRole() == MemberRoleType.ROLE_CREATOR){
                projectCreator = member.getUser();
                break;
            }
        }
        return projectCreator;
    }

    @Override
    public Project getMemberCreatorOfProjectByProjectId(long projectId) {
        //根据项目id获得参加项目的成员
        Project project = projectDao.getProjectMemberByProjectId(projectId);
        //查找项目成员的信息并设置
        project.setMemberList(memberService.queryByProjectId(projectId));
        //查找项目创建者的信息并设置
        project.setCreator(getProjectCreatorByProjectId(projectId));
        return project;
    }
}
