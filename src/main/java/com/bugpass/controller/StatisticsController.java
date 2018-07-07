package com.bugpass.controller;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bugpass.entity.Statistics;
import com.bugpass.service.StatisticsService;

@Controller
@RequestMapping
public class StatisticsController {
	
	@Resource(name="statisticsService")
	private StatisticsService statisticsService;
	
	public String getBugNumberByProjectName(String projectName,Model model) {
		List<Statistics> list=statisticsService.returnQueryProjectBugsByname(projectName);
		model.addAttribute("statistics", list);
		return "statistics";
	}
}
