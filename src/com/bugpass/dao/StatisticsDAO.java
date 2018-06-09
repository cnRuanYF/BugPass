package com.bugpass.dao;

import java.util.List;

import com.bugpass.entity.Statistics;
import com.bugpass.entity.Version;

public interface StatisticsDAO {
	/**
	 * 查询统计信息
	 * @return 统计结果集
	 */
	List<Statistics> findAllStatistics();
}
