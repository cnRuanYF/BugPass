package com.bugpass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugpass.entity.Project;
import com.bugpass.service.ProjectService;

/**
 * @author ChenZhiJun
 * @date 2018-07-03 14:27
 */
@Controller
public class ProjectCotroller {

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/api/showProject/{projectId}", method = RequestMethod.GET)
	public String showProject(@PathVariable(value = "projectId") long projectId, Model model) {
		Project project = projectService.findById(projectId);
		model.addAttribute("project", project);
		return "project_info";
	}

}
