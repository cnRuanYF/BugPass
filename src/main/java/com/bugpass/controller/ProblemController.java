package com.bugpass.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.bugpass.constant.PageConst;
import com.bugpass.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.bugpass.service.ProblemService;




/**
 * 处理问题相关操作的Controller
 * @author xhh
 *
 */

@Controller
public class ProblemController {
	
	@Resource
	private ProblemService problemService;
	/**
	 * 跳转到新建问题界面并显示问题的所有类型，所有级别，以及所有状态
	 * @param model
	 * @param publisher
	 * @return
	 * TODO Editing by RuanYaofeng
	 */
	@RequestMapping(value= "problem/add")
	public String getProblem(Model model,HttpSession session)
	{
		User currentUser = (User) session.getAttribute("currentUser");
		int publisher = (int) currentUser.getId();

		List<ProblemType> list=problemService.getAllType();
		List<ProblemLevel> list2=problemService.getAllLevel();
		List<ProblemStatus> list3=problemService.getAllStatus();
	
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		
		model.addAttribute("publisher", publisher);
		return "6";
	}
	

	/**
	 * 添加问题
	 * @param request
	 * @param model
	 * @param ptitle
	 * @param pdescripe
	 * @param protypeid
	 * @param plevelid
	 * @param pstatusid
	 * @param publisher
	 * @return
	 */
	@RequestMapping("/myupload")
	public String reqFileUpload(HttpServletRequest request,Model model,String ptitle,String pdescripe,String protypeid,String plevelid,String pstatusid,int publisher) {
		
	    int protypeid2=Integer.valueOf(protypeid);
		int plevelid2=Integer.valueOf(plevelid);
		int pstatusid2=Integer.valueOf(pstatusid);
		

		Map map = new HashMap();
		map.put("problemTitle",ptitle);
		map.put("problemDesc",pdescripe);
		map.put("problemType",protypeid2);
		map.put("problemLevel",plevelid2);
		map.put("problemStatus",pstatusid2);
		map.put("publisher",publisher);
		
		

		boolean flag=problemService.addProblem(map);
		if(flag){
			Map map1 = new HashMap();
			map1.put("publisher",publisher);
			map1.put("problemStatusName","新建");
			
			Map map2 = new HashMap();
			map2.put("publisher",publisher);
			map2.put("problemStatusName","进行中");
			
			Map map3 = new HashMap();
			map3.put("publisher",publisher);
			map3.put("problemStatusName","重新打开");
			
			Map map4 = new HashMap();
			map4.put("publisher",publisher);
			map4.put("problemStatusName","已解决");
			
			Map map5 = new HashMap();
			map5.put("publisher",publisher);
			map5.put("problemStatusName","留待解决");
			
			Map map6 = new HashMap();
			map6.put("publisher",publisher);
			map6.put("problemStatusName","已忽略");
			
			Map map7 = new HashMap();
			map7.put("publisher",publisher);
			map7.put("problemStatusName","已关闭");
			
		int scount=problemService.getStatusCount(map1);
		int scount2=problemService.getStatusCount(map2);	
		int scount3=problemService.getStatusCount(map3);	
		int scount4=problemService.getStatusCount(map4);	
		int scount5=problemService.getStatusCount(map5);	
		int scount6=problemService.getStatusCount(map6);	
		int scount7=problemService.getStatusCount(map7);
		int pcount=problemService.getProblemCount(publisher);
		
		Map map8 = new HashMap();
		map8.put("publisher",publisher);
		map8.put("problemStatusName","新建");
		
		Map map9 = new HashMap();
		map9.put("publisher",publisher);
		map9.put("problemStatusName","进行中");
		
		Map map10 = new HashMap();
		map10.put("publisher",publisher);
		map10.put("problemStatusName","重新打开");
		
		Map map11 = new HashMap();
		map11.put("publisher",publisher);
		map11.put("problemStatusName","已解决");
		int countUid=problemService.getCountByUid(map8);
		int countUid2=problemService.getCountByUid(map9);
		int countUid3=problemService.getCountByUid(map10);
		int countUid4=problemService.getCountByUid(map11);
		
		
		Map map16 = new HashMap();
		map16.put("publisher",publisher);
		map16.put("problemStatusName","新建");
		
		
		Map map17 = new HashMap();
		map17.put("publisher",publisher);
		map17.put("problemStatusName","进行中");
		
		
		Map map18 = new HashMap();
		map18.put("publisher",publisher);
		map18.put("problemStatusName","重新打开");
		
		
		Map map19 = new HashMap();
		map19.put("publisher",publisher);
		map19.put("problemStatusName","已解决");
		
		   
		model.addAttribute("countUid",countUid);
		model.addAttribute("countUid2",countUid2);
		model.addAttribute("countUid3",countUid3);
		model.addAttribute("countUid4",countUid4);
		model.addAttribute("pcount", pcount);
		model.addAttribute("scount", scount);
		model.addAttribute("scount2", scount2);
		model.addAttribute("scount3", scount3);
		model.addAttribute("scount4", scount4);
		model.addAttribute("scount5", scount5);
		model.addAttribute("scount6", scount6);
		model.addAttribute("scount7", scount7);
		model.addAttribute("publisher", publisher);
		
		
		
			
			
				return "1";
			
			

			
			
		}
	

		return "6";
	}
	/**
	 * 跳转到问题界面并显示问题的所有类型，所有级别，以及所有状态
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/problem")
	public String getProblemm(Model model,int publisher)
	{
		List<ProblemType> list=problemService.getAllType();
		List<ProblemLevel> list2=problemService.getAllLevel();
		List<ProblemStatus> list3=problemService.getAllStatus();
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的所有问题的信息
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/checkAll")
	public String getProblemAll(Model model,int publisher)
	{
		
		
		
		List<ProblemAll> all=problemService.getProblemAll(publisher);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	/**
	 * 根据问题的某种类型显示每个人所提交的所有问题的信息
	 * @param model
	 * @param protypeid
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/checktype")
	public String getProblemTypeId(Model model,int protypeid,int publisher)
	{
		
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemTypeId",protypeid);
		
	    List<ProblemAll> problem=problemService.getAllTypeById(map);
		model.addAttribute("problem",problem);
		
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 根据问题的某种级别显示每个人所提交的所有问题的信息
	 * @param model
	 * @param plevelid
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/checklevel")
	public String getProblemLevelId(Model model,int plevelid,int publisher)
	{
		
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemLevelId",plevelid);
		List<ProblemAll> problem=problemService.getAllLevelById(map);
		model.addAttribute("problem",problem);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	/**
	 * 根据问题的某种状态显示每个人所提交的所有问题的信息
	 * @param model
	 * @param pstatusid
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/checkstatus")
	public String getProblemStatusId(Model model,int pstatusid,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusId",pstatusid);
		
		List<ProblemAll> problem=problemService.getAllStatusById(map);
		model.addAttribute("problem",problem);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的所有问题的信息
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/selectAll")
	public String getProblemAll2(Model model,int publisher)
	{
		
		
		
		List<ProblemAll> all=problemService.getProblemAll(publisher);
		model.addAttribute("all",all);
		
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	/**
	 * 显示每个人所提交的新建状态的所有问题的信息
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/getstatus")
	public String getProblemByStatus(Model model,int publisher)
	{
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","新建");
		
		
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	/**
	 * 显示每个人所提交的进行中状态的所有问题的信息
	 * @param model
	 * @param publisher
	 * @return
	 */
	
	@RequestMapping(value= "/getstatus2")
	public String getProblemByStatus2(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","进行中");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的重新打开状态的所有问题的信息
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/getstatus3")
	public String getProblemByStatus3(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","重新打开");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的已解决状态的所有问题的信息
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/getstatus4")
	public String getProblemByStatus4(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","已解决");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的留待解决状态的所有问题的信息
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/getstatus5")
	public String getProblemByStatus5(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","留待解决");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的已忽略状态的所有问题的信息
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/getstatus6")
	public String getProblemByStatus6(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","已忽略");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的已关闭状态的所有问题的信息
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value= "/getstatus7")
	public String getProblemByStatus7(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","已关闭");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 删除某个问题
	 * @param pid
	 * @param model
	 * @param publisher
	 * @return
	 */
	@RequestMapping({"/deleteproblem"})
	public String deleteUser(int pid,Model model,int publisher) {
		boolean flag=problemService.deleteProblemById(pid);
		if(flag){
			model.addAttribute("publisher", publisher);
			return "2";
			
		}
		return "1";
	}
	
	/**
	 * 显示每个人所提交的新建状态的所有问题的信息
	 * @param publisher
	 * @param model
	 * @return
	 */
	@RequestMapping({"/getstatusbypublisher"})
	public String getStatusBypublisher(int publisher,Model model) {
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","新建");
		List<ProblemAll> all=problemService.getProblemByUid(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的进行中状态的所有问题的信息
	 * @param publisher
	 * @param model
	 * @return
	 */
	@RequestMapping({"/getstatusbypublisher2"})
	public String getStatusBypublisher2(int publisher,Model model) {
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","进行中");
		List<ProblemAll> all=problemService.getProblemByUid(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的重新打开状态的所有问题的信息
	 * @param publisher
	 * @param model
	 * @return
	 */
	@RequestMapping({"/getstatusbypublisher3"})
	public String getStatusBypublisher3(int publisher,Model model) {
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","重新打开");
		List<ProblemAll> all=problemService.getProblemByUid(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	/**
	 * 显示每个人所提交的已解决状态的所有问题的信息
	 * @param publisher
	 * @param model
	 * @return
	 */
	@RequestMapping({"/getstatusbypublisher4"})
	public String getStatusBypublisher4(int publisher,Model model) {
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemStatusName","已解决");
		List<ProblemAll> all=problemService.getProblemByUid(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
/**
 * 跳转到概述界面并显示每种状态的问题的数量
 * @param model
 * @param publisher
 * @return
 * TODO Editing by RuanYaofeng
 */
	@RequestMapping(value= "xhh/summary")
	    public String summary(Model model, HttpSession session)
	    {

			User currentUser = (User) session.getAttribute("currentUser");
int publisher = (int) currentUser.getId();

			Map map1 = new HashMap();
	    	map1.put("publisher",publisher);
	    	map1.put("problemStatusName","新建");
	    	
	    	Map map2 = new HashMap();
	    	map2.put("publisher",publisher);
	    	map2.put("problemStatusName","进行中");
	    	
	    	Map map3 = new HashMap();
	    	map3.put("publisher",publisher);
	    	map3.put("problemStatusName","重新打开");
	    	
	    	Map map4 = new HashMap();
	    	map4.put("publisher",publisher);
	    	map4.put("problemStatusName","已解决");
	    	
	    	Map map5 = new HashMap();
	    	map5.put("publisher",publisher);
	    	map5.put("problemStatusName","留待解决");
	    	
	    	Map map6 = new HashMap();
	    	map6.put("publisher",publisher);
	    	map6.put("problemStatusName","已忽略");
	    	
	    	Map map7 = new HashMap();
	    	map7.put("publisher",publisher);
	    	map7.put("problemStatusName","已关闭");
	    	
	    int scount=problemService.getStatusCount(map1);
	    int scount2=problemService.getStatusCount(map2);	
	    int scount3=problemService.getStatusCount(map3);	
	    int scount4=problemService.getStatusCount(map4);	
	    int scount5=problemService.getStatusCount(map5);	
	    int scount6=problemService.getStatusCount(map6);	
	    int scount7=problemService.getStatusCount(map7);
	    	int pcount=problemService.getProblemCount(publisher);
	    	model.addAttribute("pcount", pcount);
	    	model.addAttribute("scount", scount);
	    	model.addAttribute("scount2", scount2);
	    	model.addAttribute("scount3", scount3);
	    	model.addAttribute("scount4", scount4);
	    	model.addAttribute("scount5", scount5);
	    	model.addAttribute("scount6", scount6);
	    	model.addAttribute("scount7", scount7);
	    	
	    	model.addAttribute("publisher",publisher);
	    	
	    	Map map8 = new HashMap();
	    	map8.put("publisher",publisher);
	    	map8.put("problemStatusName","新建");
	    	
	    	Map map9 = new HashMap();
	    	map9.put("publisher",publisher);
	    	map9.put("problemStatusName","进行中");
	    	
	    	Map map10 = new HashMap();
	    	map10.put("publisher",publisher);
	    	map10.put("problemStatusName","重新打开");
	    	
	    	Map map11 = new HashMap();
	    	map11.put("publisher",publisher);
	    	map11.put("problemStatusName","已解决");
	    	int countUid=problemService.getCountByUid(map8);
	    	int countUid2=problemService.getCountByUid(map9);
	    	int countUid3=problemService.getCountByUid(map10);
	    	int countUid4=problemService.getCountByUid(map11);
	    	
	    	
	    	
	    	
	    	   
	    	model.addAttribute("countUid",countUid);
	    	model.addAttribute("countUid2",countUid2);
	    	model.addAttribute("countUid3",countUid3);
	    	model.addAttribute("countUid4",countUid4);
	    	model.addAttribute("publisher",publisher);
	    	
	
	    return PageConst.PAGE_PROJECT_SUMMARY;
	    }
	
	
	
	
}
