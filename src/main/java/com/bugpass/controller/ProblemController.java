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

		List<ProblemType> listType=problemService.getAllType();
		List<ProblemLevel> listLevel=problemService.getAllLevel();
		List<ProblemStatus> listStatus=problemService.getAllStatus();
	
		model.addAttribute("listType", listType);
		model.addAttribute("listLevel", listLevel);
		model.addAttribute("listStatus", listStatus);
		
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
			Map mapNewBuild = new HashMap();
			mapNewBuild.put("publisher",publisher);
			mapNewBuild.put("problemStatusName","新建");
			
			Map mapRunning = new HashMap();
			mapRunning.put("publisher",publisher);
			mapRunning.put("problemStatusName","进行中");
			
			Map mapReOpen = new HashMap();
			mapReOpen.put("publisher",publisher);
			mapReOpen.put("problemStatusName","重新打开");
			
			Map mapResolved = new HashMap();
			mapResolved.put("publisher",publisher);
			mapResolved.put("problemStatusName","已解决");
			
			Map mapWaitSolve = new HashMap();
			mapWaitSolve.put("publisher",publisher);
			mapWaitSolve.put("problemStatusName","留待解决");
			
			Map mapIgnored = new HashMap();
			mapIgnored.put("publisher",publisher);
			mapIgnored.put("problemStatusName","已忽略");
			
			Map mapClosed = new HashMap();
			mapClosed.put("publisher",publisher);
			mapClosed.put("problemStatusName","已关闭");
			
		int newBuildCount=problemService.getStatusCount(mapNewBuild);
		int runningCount=problemService.getStatusCount(mapRunning);	
		int reOpenCount=problemService.getStatusCount(mapReOpen);	
		int resolvedCount=problemService.getStatusCount(mapResolved);	
		int waitSolveCount=problemService.getStatusCount(mapWaitSolve);	
		int ignoredCount=problemService.getStatusCount(mapIgnored);	
		int closedCount=problemService.getStatusCount(mapClosed);
		int problemCount=problemService.getProblemCount(publisher);
		
		Map mapSubmitNewBulid = new HashMap();
		mapSubmitNewBulid.put("publisher",publisher);
		mapSubmitNewBulid.put("problemStatusName","新建");
		
		Map mapSubmitRunning = new HashMap();
		mapSubmitRunning.put("publisher",publisher);
		mapSubmitRunning.put("problemStatusName","进行中");
		
		Map mapSubmitReOpen = new HashMap();
		mapSubmitReOpen.put("publisher",publisher);
		mapSubmitReOpen.put("problemStatusName","重新打开");
		
		Map mapSubmitResolved = new HashMap();
		mapSubmitResolved.put("publisher",publisher);
		mapSubmitResolved.put("problemStatusName","已解决");
		int submitNewBuildCount=problemService.getCountByUid(mapSubmitNewBulid);
		int submitRunningCount=problemService.getCountByUid(mapSubmitRunning);
		int submitReOpenCount=problemService.getCountByUid(mapSubmitReOpen);
		int submitResolvedCount=problemService.getCountByUid(mapSubmitResolved);
		
		
		
		
		   
		model.addAttribute("submitNewBuildCount",submitNewBuildCount);
		model.addAttribute("submitRunningCount",submitRunningCount);
		model.addAttribute("submitReOpenCount",submitReOpenCount);
		model.addAttribute("submitResolvedCount",submitResolvedCount);
		model.addAttribute("problemCount", problemCount);//每个人提交问题的全部数量
		model.addAttribute("newBuildCount", newBuildCount);
		model.addAttribute("runningCount",runningCount);
		model.addAttribute("reOpenCount",reOpenCount);
		model.addAttribute("resolvedCount", resolvedCount);
		model.addAttribute("waitSolveCount",waitSolveCount);
		model.addAttribute("ignoredCount", ignoredCount);
		model.addAttribute("closedCount",closedCount);
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
		List<ProblemType> listType=problemService.getAllType();
		List<ProblemLevel> listLevel=problemService.getAllLevel();
		List<ProblemStatus> listStatus=problemService.getAllStatus();
	
		model.addAttribute("listType", listType);
		model.addAttribute("listLevel", listLevel);
		model.addAttribute("listStatus", listStatus);
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
		
		
		
		List<ProblemAll> allProblem=problemService.getProblemAll(publisher);
		model.addAttribute("allProblem",allProblem);
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
		
		
		
		List<ProblemAll> allProblem=problemService.getProblemAll(publisher);
		model.addAttribute("allProblem",allProblem);
		
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
		
		
		
		List<ProblemAll> allProblem=problemService.getProblemByStatus(map);
		model.addAttribute("allProblem",allProblem);
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
		
		List<ProblemAll> allProblem=problemService.getProblemByStatus(map);
		model.addAttribute("allProblem",allProblem);
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
		
		List<ProblemAll> allProblem=problemService.getProblemByStatus(map);
		model.addAttribute("allProblem",allProblem);
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
		
		List<ProblemAll> allProblem=problemService.getProblemByStatus(map);
		model.addAttribute("allProblem",allProblem);
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
		
		List<ProblemAll> allProblem=problemService.getProblemByStatus(map);
		model.addAttribute("allProblem",allProblem);
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
		
		List<ProblemAll> allProblem=problemService.getProblemByStatus(map);
		model.addAttribute("allProblem",allProblem);
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
		
		List<ProblemAll> allProblem=problemService.getProblemByStatus(map);
		model.addAttribute("allProblem",allProblem);
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
		List<ProblemAll> allProblem=problemService.getProblemByUid(map);
		model.addAttribute("allProblem",allProblem);
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
		List<ProblemAll> allProblem=problemService.getProblemByUid(map);
		model.addAttribute("allProblem",allProblem);
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
		List<ProblemAll> allProblem=problemService.getProblemByUid(map);
		model.addAttribute("allProblem",allProblem);
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
		List<ProblemAll> allProblem=problemService.getProblemByUid(map);
		model.addAttribute("allProblem",allProblem);
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




Map mapNewBuild = new HashMap();
mapNewBuild.put("publisher",publisher);
mapNewBuild.put("problemStatusName","新建");

Map mapRunning = new HashMap();
mapRunning.put("publisher",publisher);
mapRunning.put("problemStatusName","进行中");

Map mapReOpen = new HashMap();
mapReOpen.put("publisher",publisher);
mapReOpen.put("problemStatusName","重新打开");

Map mapResolved = new HashMap();
mapResolved.put("publisher",publisher);
mapResolved.put("problemStatusName","已解决");

Map mapWaitSolve = new HashMap();
mapWaitSolve.put("publisher",publisher);
mapWaitSolve.put("problemStatusName","留待解决");

Map mapIgnored = new HashMap();
mapIgnored.put("publisher",publisher);
mapIgnored.put("problemStatusName","已忽略");

Map mapClosed = new HashMap();
mapClosed.put("publisher",publisher);
mapClosed.put("problemStatusName","已关闭");

int newBuildCount=problemService.getStatusCount(mapNewBuild);
int runningCount=problemService.getStatusCount(mapRunning);	
int reOpenCount=problemService.getStatusCount(mapReOpen);	
int YiJieJueCount=problemService.getStatusCount(mapResolved);	
int waitSolveCount=problemService.getStatusCount(mapWaitSolve);	
int ignoredCount=problemService.getStatusCount(mapIgnored);	
int closedCount=problemService.getStatusCount(mapClosed);
int problemCount=problemService.getProblemCount(publisher);

Map mapSubmitNewBulid = new HashMap();
mapSubmitNewBulid.put("publisher",publisher);
mapSubmitNewBulid.put("problemStatusName","新建");

Map mapSubmitRunning = new HashMap();
mapSubmitRunning.put("publisher",publisher);
mapSubmitRunning.put("problemStatusName","进行中");

Map mapSubmitReOpen = new HashMap();
mapSubmitReOpen.put("publisher",publisher);
mapSubmitReOpen.put("problemStatusName","重新打开");

Map mapSubmitResolved = new HashMap();
mapSubmitResolved.put("publisher",publisher);
mapSubmitResolved.put("problemStatusName","已解决");
int submitNewBuildCount=problemService.getCountByUid(mapSubmitNewBulid);
int submitRunningCount=problemService.getCountByUid(mapSubmitRunning);
int submitReOpenCount=problemService.getCountByUid(mapSubmitReOpen);
int submitResolvedCount=problemService.getCountByUid(mapSubmitResolved);





model.addAttribute("submitNewBuildCount",submitNewBuildCount);
model.addAttribute("submitRunningCount",submitRunningCount);
model.addAttribute("submitReOpenCount",submitReOpenCount);
model.addAttribute("submitResolvedCount",submitResolvedCount);
model.addAttribute("problemCount", problemCount);//每个人提交问题的全部数量
model.addAttribute("newBuildCount", newBuildCount);
model.addAttribute("runningCount",runningCount);
model.addAttribute("reOpenCount",reOpenCount);
model.addAttribute("YiJieJueCount", YiJieJueCount);
model.addAttribute("waitSolveCount",waitSolveCount);
model.addAttribute("ignoredCount", ignoredCount);
model.addAttribute("closedCount",closedCount);
model.addAttribute("publisher", publisher);
	    	
	
	    return PageConst.PAGE_PROJECT_SUMMARY;
	    }
	
	
	
	
}
