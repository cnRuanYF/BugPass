package com.bugpass.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bugpass.dao.StatisticsDAO;
import com.bugpass.entity.Statistics;
import com.bugpass.service.StatisticsService;

@Service(value="statisticsService")
public class StatisticsServiceImpl implements StatisticsService {

	@Resource(name="statisticsDao")
	private StatisticsDAO statisticsDao;
	
	/*查询所有项目bug，暂时搁置
	 * public List<Statistics> returnQueryALLProjcetBugs() {
		// TODO Auto-generated method stub
		return statisticsDao.queryALLProjcetBugs();
	}*/

	@Override
	public List<Statistics> returnQueryProjectBugsByname(String projectName) {
		// TODO Auto-generated method stub
		return statisticsDao.queryProjectBugsByname(projectName);
	}

}
