package com.bugpass.dao;

import java.util.List;

import com.bugpass.entity.Statistics;
import com.bugpass.entity.Version;

public interface StatisticsDAO {
	/**
	 * 统计表格数据接口
	 * 
	 * @author YeHandsome
	 * @date 2018-06-06 21:32
	 */
	List<Statistics> findAllStatistics();
}
