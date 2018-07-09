package com.bugpass.controller;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bugpass.entity.Statistics;
import com.bugpass.service.StatisticsService;

@Controller
@RequestMapping(value="/api")
public class StatisticsController {
	//注入StatisticsService
	@Resource(name="statisticsService")
	private StatisticsService statisticsService;
	
	//转发至Statistics_info页面
	@RequestMapping(value="/statistics",method=RequestMethod.GET)
	public String getBugNumberByProjectName(Model model) {
		List<Statistics> list=statisticsService.returnQueryALLProjcetBugs();
		model.addAttribute("statistics", list);
		System.out.println(list);//测试
		return "Statistics_info";
	}
}
