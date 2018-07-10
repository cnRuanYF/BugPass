package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Problem;
import com.bugpass.entity.Project;
import com.bugpass.entity.User;

/**
 * 项目相关的业务接口
 * 
 * @author ChenZhiJun
 * @date 2018-07-03 14:12
 */
public interface ProjectService {

    /**
     * 添加项目记录
     * 
     * @param project
     * @return
     */
    boolean addProject(Project project, User user);

    /**
     * 删除项目记录
     * 
     * @param projectId
     * @return
     */
    boolean delProjectById(long projectId);

    /**
     * 更新项目记录
     * 
     * @param project
     * @return
     */
    boolean updProject(Project project);

    /**
     * 根据ID查找项目记录
     * 
     * @param projectId
     * @return
     */
    Project findProjectById(long projectId);

    /**
     * 根据显示ID查找对象
     * 
     * @param displayId
     * @return
     */
    Project findProjectByDisplayId(String displayId);

    /**
     * 根据用户id查询用户参与的所有项目
     * 
     * @param userId
     * @return List<Project>
     */
    List<Project> queryProjectByUserId(long userId);

    /**
     * 根据项目id获取项目创建者
     * 
     * @param projectId
     * @return User对象:项目创建者
     */
    User getProjectCreatorByProjectId(long projectId);

    /**
     * 根据项目id查询项目对象(包含项目成员和创建者)
     * 
     * @param projectId
     * @return Project对象
     */
    Project getMemberCreatorOfProjectByProjectId(long projectId);

    /**
     * 根据项目id查询项目对象(包含项目所有信息:成员、模块、版本，创建者在服务层调用方法得到)
     * 
     * @param projectId
     * @return Project对象
     */
    Project getProjectAllInfoByProjectId(long projectId);

}
