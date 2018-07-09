package com.bugpass.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bugpass.entity.Statistics;

/**
 * 统计DAO接口
 *
 * @author YeHandsome
 * @date 2018/7/5 10:10
 **/
@Repository(value="statisticsDao")
public interface StatisticsDAO {
	
	List<Statistics> queryALLProjcetBugs();
	
	List<Statistics> queryProjectBugsByname(String projectName);
}
