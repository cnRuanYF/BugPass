package com.bugpass.dao.impl;

import java.util.List;

import com.bugpass.dao.StatisticsDAO;
import com.bugpass.entity.Statistics;
import com.bugpass.entity.Version;
import com.bugpass.util.DBUtil;

public class StatisticsDAOImpl implements StatisticsDAO {

	@Override
	public List<Statistics> findAllStatistics() {
		// TODO Auto-generated method stub
		return (List<Statistics>)DBUtil.execQuery("SELECT project.projectName,version.versionName,problem.problemTitle,problem.problemLevel,problem.problemStatus,problem.createTime,problem.updateTime,`user`.realname AS senderName,`user`.realname AS receiverName "
				+ "FROM project,version,problem,`user`  "
				+ "WHERE project.projectId=version.projectId AND version.versionId=problem.versionId AND problem.senderId=`user`.id", Statistics.class);
	}	

}
