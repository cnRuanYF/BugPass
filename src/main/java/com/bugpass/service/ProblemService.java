package com.bugpass.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bugpass.entity.Problem;
import com.bugpass.entity.ProblemAll;
import com.bugpass.entity.ProblemLevel;
import com.bugpass.entity.ProblemStatus;
import com.bugpass.entity.ProblemType;

public interface ProblemService {
	public List<ProblemType> getAllType();
	public List<ProblemLevel> getAllLevel();
	public List<ProblemStatus> getAllStatus();
	public boolean addProblem(Map map);
	public List<Problem> getAllProblem();
	//public List<Problem> getAll();
	public List<ProblemAll> getAllTypeById(Map map);
    public List<ProblemAll> getAllLevelById(Map map);
    public List<ProblemAll> getAllStatusById(Map map);
	public boolean deleteProblemById(int pid);
    public List<ProblemAll> getProblemAll(int uid);
    public int getProblemCount(int uid);
    public int getStatusCount(Map map);
    public List<ProblemAll> getProblemByStatus(Map map);
    public int getCountByUid(Map map);
    //public int getCountByIsTrack(Map map);
    //public int getCountByUsubmit(Map map);
    public List<ProblemAll> getProblemByUid(Map map);
    //public List<ProblemAll> getProblemByIsTrack(Map map);
    //public List<ProblemAll> getProblemByUsubmit(Map map);
}
