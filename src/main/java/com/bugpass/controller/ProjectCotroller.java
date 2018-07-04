package com.bugpass.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugpass.entity.Project;
import com.bugpass.entity.User;
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
		Project project = projectService.findProjectById(projectId);
		model.addAttribute("project", project);
		return "project_info";
	}

	/**
	 * 跳转到添加项目界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toAddProject")
	public String toAddProject() {
		return "project_add";
	}
	
	/**
	 * 添加项目并重定向
	 * 
	 * @param project
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/api/addProject",method = RequestMethod.POST)
	public String addProject(Project project,HttpSession session,Model model) {
		User user = (User) session.getAttribute("currentUser");
		System.out.println("controllerUser:"+user.getId());
		boolean flag = projectService.addProject(project, user);
		Project newProject = projectService.findProjectByDisplayId(project.getDisplayId());
		System.out.println("controllerProject:"+newProject.getProjectId());
		return "redirect:/api/showProject/"+newProject.getProjectId();
	}
}
