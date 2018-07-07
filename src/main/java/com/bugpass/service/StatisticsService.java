package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Statistics;

public interface StatisticsService {
	
//	List<Statistics> returnQueryALLProjcetBugs();

	List<Statistics> returnQueryProjectBugsByname(String projectName);
}
