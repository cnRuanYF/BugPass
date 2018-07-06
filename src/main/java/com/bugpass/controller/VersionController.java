package com.bugpass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugpass.entity.Version;
import com.bugpass.service.VersionService;

@Controller
public class VersionController {

	@Autowired
	VersionService versionService;
	
	/**
	 * 查询所有版本
	 */
	@RequestMapping(value = "api/selectAllVersion", method = RequestMethod.GET)
	@ResponseBody
	public List<Version> selectVersionByProjectId(long projectId,Model model) {
		List<Version> list = versionService.returnFindAllByProjectid(projectId);
		list.forEach(System.out::println);
		model.addAttribute("versions", list);
		return list;
	}
	/**
	 * 修改版本
	 */
	@RequestMapping(value = "api/updateVersion", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updateVersion(Version version) {
		
		return versionService.returnUpdate(version);
	}

	/**
	 * 检查版本名是否重复
	 */
	@RequestMapping(value = "api/checkVersionName", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkVersionName(String versionName, int projectId) {
		System.out.println(versionName + "." + projectId);
		boolean flag = versionService.returnFindVersionNameByProjectId(versionName, projectId);
		System.out.println(flag);
		return versionService.returnFindVersionNameByProjectId(versionName, projectId);
	}
	
	/**
	 * 添加
	 */
	@RequestMapping(value="api/addVersion",method=RequestMethod.POST)
	@ResponseBody
	public boolean addVersion(Version version) {
		return versionService.returnAdd(version);
	}
	
	/**
	 * 根据版本ID查询
	 */
	@RequestMapping(value="api/selectByVersionId",method=RequestMethod.GET)
	@ResponseBody
	public Version selectVersionByVersionId(long versionId) {
		return versionService.returnFindByVersionId(versionId);
	}
	
	/**
	 * 模糊查询
	 */
	@RequestMapping(value="api/selectLikeVersionName",method=RequestMethod.GET)
	@ResponseBody
	public List<Version> selectLikeVersionName(String likeVersionName,long projectId){
		return versionService.returnListFindByVersionName(likeVersionName, projectId);
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="api/deleteVersion",method=RequestMethod.POST)
	@ResponseBody
	public boolean deleteVersion(long versionId) {
		return versionService.returndeleteByVersionId(versionId);
	}
}
