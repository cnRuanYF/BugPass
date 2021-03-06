package com.bugpass.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bugpass.dao.ProblemDao;
import com.bugpass.entity.Problem;
import com.bugpass.entity.ProblemAll;
import com.bugpass.entity.ProblemLevel;
import com.bugpass.entity.ProblemStatus;
import com.bugpass.entity.ProblemType;
import com.bugpass.service.ProblemService;
/**
 * 问题业务实现类
 * @author xhh
 *
 */
@Service("problemService")
public class ProblemServiceImpl implements ProblemService{
	@Resource
   private ProblemDao problemDao;
	@Override
	public List<ProblemType> getAllType() {
		// TODO Auto-generated method stub
		return problemDao.getAllType();
	}

	@Override
	public List<ProblemLevel> getAllLevel() {
		// TODO Auto-generated method stub
		return problemDao.getAllLevel();
	}

	@Override
	public List<ProblemStatus> getAllStatus() {
		// TODO Auto-generated method stub
		return problemDao.getAllStatus();
	}

//	@Override
//	public boolean addProblem(Map map) {
//		// TODO Auto-generated method stub
//		return problemDao.addProblem(map);
//	}

	@Override
	public List<Problem> getAllProblem() {
		// TODO Auto-generated method stub
		return problemDao.getAllProblem();
	}

	@Override
	public List<ProblemAll> getAllTypeById(Map map) {
		// TODO Auto-generated method stub
		return problemDao.getAllTypeById(map);
	}

	@Override
	public List<ProblemAll> getAllLevelById(Map map) {
		// TODO Auto-generated method stub
		return problemDao.getAllLevelById(map);
	}

	@Override
	public List<ProblemAll> getAllStatusById(Map map) {
		// TODO Auto-generated method stub
		return problemDao.getAllStatusById(map);
	}

	@Override
	public boolean deleteProblemById(int pid) {
		// TODO Auto-generated method stub
		return problemDao.deleteProblemById(pid);
	}

	@Override
	public List<ProblemAll> getProblemAll(int uid) {
		// TODO Auto-generated method stub
		return problemDao.getProblemAll(uid);
	}

	@Override
	public int getProblemCount(int uid) {
		// TODO Auto-generated method stub
		return problemDao.getProblemCount(uid);
	}

	@Override
	public int getStatusCount(Map map) {
		// TODO Auto-generated method stub
		return problemDao.getStatusCount(map);
	}

	@Override
	public List<ProblemAll> getProblemByStatus(Map map) {
		// TODO Auto-generated method stub
		return problemDao.getProblemByStatus(map);
	}

	@Override
	public int getCountByUid(Map map) {
		// TODO Auto-generated method stub
		return problemDao.getCountByUid(map);
	}

	@Override
	public List<ProblemAll> getProblemByUid(Map map) {
		// TODO Auto-generated method stub
		return problemDao.getProblemByUid(map);
	}

	@Override
	public Problem getProblemById(long id){
		return problemDao.queryById(id);
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public boolean addProblem(Problem problem) {
		return problemDao.add(problem);
	}

	@Override
	public boolean editProblem(Problem problem) {
		return problemDao.update(problem);
	}

	@Override
	public List<Problem> queryProblemByProjectId(long projectId) {
		return problemDao.queryProjectByProjectId(projectId);
	}

	@Override
	public List<Problem> queryProjectToMe(long projectId, long userId) {

		List<Problem> list = problemDao.queryProjectByProjectId(projectId);
		List<Problem> projectToMeList = new ArrayList<>();

		// 遍历该项目的问题集合，如果被指派用户为当前用户，则存入新集合
		list.forEach(problem -> {
			if (problem.getAssignedTo() == userId){
				projectToMeList.add(problem);
			}
		});

		return projectToMeList;
	}

	@Override
	public List<Problem> queryProjectFromMe(long projectId, long userId) {
		List<Problem> list = problemDao.queryProjectByProjectId(projectId);
		List<Problem> projectFromMeList = new ArrayList<>();

		// 遍历该项目的问题集合，如果创建问题的用户为当前用户，则把该对象存入新集合
		list.forEach(problem -> {
			if (problem.getPublisher() == userId){
				projectFromMeList.add(problem);
			}
		});

		return projectFromMeList;
	}


}
