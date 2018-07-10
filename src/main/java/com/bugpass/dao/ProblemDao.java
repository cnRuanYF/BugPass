package com.bugpass.dao;

import java.util.List;
import java.util.Map;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.springframework.stereotype.Repository;

import com.bugpass.entity.Problem;
import com.bugpass.entity.ProblemAll;
import com.bugpass.entity.ProblemLevel;
import com.bugpass.entity.ProblemStatus;
import com.bugpass.entity.ProblemType;

/**
 * 问题Dao接口
 * @author xhh
 *
 */
@Repository("problemDao")
public interface ProblemDao extends BaseDAO<Problem> {
	/**
	 * 查询问题的所有类型
	 * @return
	 */
	public List<ProblemType> getAllType();
	/**
	 * 查询问题的所有级别
	 * @return
	 */
	public List<ProblemLevel> getAllLevel();
	/**
	 * 查询问题的所有状态
	 * @return
	 */
	public List<ProblemStatus> getAllStatus();
	/**
	 * 添加问题
	 * @param map
	 * @return
	 */
	public boolean addProblem(Map map);
	/**
	 * 查询所有问题信息
	 * @return
	 */
	public List<Problem> getAllProblem();
	/**
	 * 根据问题类型编号查询每个人所提交的某种类型的所有问题的信息
	 * @param map
	 * @return
	 */
	public List<ProblemAll> getAllTypeById(Map map);
	/**
	 * 根据问题级别编号查询每个人所提交的某种级别的所有问题的信息
	 * @param map
	 * @return
	 */
    public List<ProblemAll> getAllLevelById(Map map);
    /**
	 * 根据问题状态编号查询每个人所提交的某种状态的所有问题的信息
	 * @param map
	 * @return
	 */
    public List<ProblemAll> getAllStatusById(Map map);
    /**
     * 根据问题编号删除某个问题
     * @param pid
     * @return
     */
	public boolean deleteProblemById(int pid);
	/**
	 * 查询每个人所提交的所有问题的信息
	 * @param uid
	 * @return
	 */
    public List<ProblemAll> getProblemAll(int uid);
    /**
     * 
     * 查询 每个人所提交的问题数量
     * @param uid
     * @return
     */
    public int getProblemCount(int uid);
    /**
     * 查询每个人所提交的某种状态的所有问题的数量
     * @param map
     * @return
     */
    public int getStatusCount(Map map);
    /**
     * 查询每个人所提交的某种状态的所有问题的信息
     * @param map
     * @return
     */
    public List<ProblemAll> getProblemByStatus(Map map);
    /**
     * 查询每个人所提交的某种状态的所有问题的数量
     * @param map
     * @return
     */
    public int getCountByUid(Map map);
    /**
     * 查询每个人所提交的某种状态的所有问题的信息
     * @param map
     * @return
     */
    public List<ProblemAll> getProblemByUid(Map map);

	/**
	 * 按照项目ID查询所有问题
	 * @param projectId 项目ID
	 * @return 问题集合
	 */
    List<Problem> queryProjectByProjectId(long projectId);
}
