package com.bugpass.test;


import java.util.List;

import com.bugpass.dao.StatisticsDAO;
import com.bugpass.dao.impl.StatisticsDAOImpl;
import com.bugpass.entity.Statistics;

public class StatisticsTest {
	/**
	 * 统计表格数据测试类
	 * @author YeHandsome
	 * @date 2018-06-07 23:12
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StatisticsDAO sd=new StatisticsDAOImpl();
		List<Statistics> list=sd.findAllStatistics();
		System.out.println(list);
	}

}
