package com.bugpass.controller;

import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bugpass.entity.Version;
import com.bugpass.service.VersionService;

@Controller
@RequestMapping(value = "/api")
public class VersionController {

	@Resource(name = "versionService")
	VersionService versionService;

	@RequestMapping(value = "selectAllVersion", method = RequestMethod.GET)
	public String selectVersionByProjectId(Model model) {
		List<Version> list = versionService.returnFindAllByProjectid(1);
		System.out.println("******************************");
		list.forEach(System.out::println);
		model.addAttribute("versions",list);
		return "showVersions";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateVersion() {
		
		return "showVersions";
	}
}
