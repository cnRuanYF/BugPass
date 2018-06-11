package com.bugpass.dao.impl;

import java.util.List;

import com.bugpass.dao.ProjectDAO;
import com.bugpass.entity.Project;
import com.bugpass.util.DBUtil;

/**
 * 项目DAO实现类
 * 
 * @author QiuWenYi
 * @date 2018年6月10日 下午2:12:20
 */
public class ProjectDAOImpl implements ProjectDAO {

    @Override
    public boolean add(Project obj) throws Exception {
//        return DBUtil.execUpdate("insert into project values(null,?,?)", obj.getProjectId(), obj.getProjectName()) > 0;
        return DBUtil.execUpdate("insert into project values(null,?,now(),?)", obj.getProjectName(), obj.getProjectDesc()) > 0;
    }

    @Override
    public boolean delete(Project obj) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteByProjectId(int ProjectId) throws Exception {
        // TODO Auto-generated method stub
        return DBUtil.execUpdate("delete from project where projectId=?", ProjectId) > 0;
    }

    @Override
    public boolean update(Project Project) throws Exception {
        // return DBUtil.execUpdate("update project set ProjectName=? where
        // projectId=?", Project.getProjectName(),Project.getProjectId())>0;
        return DBUtil.execUpdate("update project set ProjectName=?,ProjectDesc=? where projectId=?",
                Project.getProjectName(), Project.getProjectDesc(), Project.getProjectId()) > 0;
    }

    @Override
    public List<Project> findAll() throws Exception {
        // TODO Auto-generated method stub
        return (List<Project>) DBUtil.execQuery("select * from project ", Project.class);
    }

    @Override
    public List<Project> findAllByProjectid(int projectId) throws Exception {
        // TODO Auto-generated method stub
        return (List<Project>) DBUtil.execQuery("select * from project where projectId=?", Project.class, projectId);
    }

    @Override
    public Project findById(long id) throws Exception {

        List<Project> list = (List<Project>) DBUtil.execQuery("select * from project where projectId=?", Project.class,
                id);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Project> findByProjectname(String projectName) {
        // TODO Auto-generated method stub
        return (List<Project>) DBUtil.execQuery("select * from project where projectName=?", Project.class,
                projectName);
    }

    @Override
    public List<Project> findByLikename(String projectName) {
        // TODO Auto-generated method stub
        return (List<Project>) DBUtil.execQuery("select * from project where projectName like ?", Project.class,
                "%" + projectName + "%");
    }
}
