package com.bugpass.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bugpass.entity.Statistics;
import com.bugpass.service.StatisticsService;

/**
 * TestStatisticsService
 * @author YeHandsome
 * @date 2018年7月6日 上午9:58:02
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:mybatis-config.xml"})
public class TestStatisticsService {
	//注入实体类
	@Resource(name="statisticsService")
	StatisticsService statisticsService;
	
	//测试service
	@Test
	public void getStatistics() {
		List<Statistics> list=statisticsService.returnQueryProjectBugsByname("疯");
		list.forEach(System.out::println);
	}

}
