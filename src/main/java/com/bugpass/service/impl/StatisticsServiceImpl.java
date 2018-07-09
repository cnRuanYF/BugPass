package com.bugpass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bugpass.dao.StatisticsDAO;
import com.bugpass.entity.Statistics;
import com.bugpass.service.StatisticsService;

@Service(value = "statisticsService")
public class StatisticsServiceImpl implements StatisticsService {

	@Resource(name = "statisticsDao")
	private StatisticsDAO statisticsDao;

	// 查询所有项目bug，
	public List<Statistics> returnQueryALLProjcetBugs() {
		// TODO Auto-generated method stub
		
		List<Statistics> list=statisticsDao.queryALLProjcetBugs();
		List<Statistics> list2=new ArrayList<>();
		for (int j = 0; j < list.size(); j++) {
//			list=this.returnQueryProjectBugsByname(list.get(j).getProject_name());
			
			//调用returnQueryProjectBugsByname（根据项目名查询）结果集存入list3，一次循环为一个项目名存入list2这个集合
			List<Statistics> list3=this.returnQueryProjectBugsByname(list.get(j).getProject_name());
			//判断获得的集合是否为空，为空则只存项目名
			if (list3!=null) {
				for (int i = 0; i < list3.size(); i++) {
					list2.add(list3.get(i));
				}
			}else {
				list2.add(list.get(j));
			}
		} 
		System.out.println(list2);
		System.out.println(list2.size());
		return list2;
	}

	// 调用dao
	@Override
	public List<Statistics> returnQueryProjectBugsByname(String projectName) {
		// TODO Auto-generated method stub
		return statisticsDao.queryProjectBugsByname(projectName);
	}

}
