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
			Map mapXinJian = new HashMap();
			mapXinJian.put("publisher",publisher);
			mapXinJian.put("problemStatusName","新建");
			
			Map mapJinXingZhong = new HashMap();
			mapJinXingZhong.put("publisher",publisher);
			mapJinXingZhong.put("problemStatusName","进行中");
			
			Map mapChongXinOpen = new HashMap();
			mapChongXinOpen.put("publisher",publisher);
			mapChongXinOpen.put("problemStatusName","重新打开");
			
			Map mapYiJieJue = new HashMap();
			mapYiJieJue.put("publisher",publisher);
			mapYiJieJue.put("problemStatusName","已解决");
			
			Map mapLiuDaiJieJue = new HashMap();
			mapLiuDaiJieJue.put("publisher",publisher);
			mapLiuDaiJieJue.put("problemStatusName","留待解决");
			
			Map mapYiHuLve = new HashMap();
			mapYiHuLve.put("publisher",publisher);
			mapYiHuLve.put("problemStatusName","已忽略");
			
			Map mapYiGuanBi = new HashMap();
			mapYiGuanBi.put("publisher",publisher);
			mapYiGuanBi.put("problemStatusName","已关闭");
			
		int XinJianCount=problemService.getStatusCount(mapXinJian);
		int JinXingZhongCount=problemService.getStatusCount(mapJinXingZhong);	
		int ChongXinOpenCount=problemService.getStatusCount(mapChongXinOpen);	
		int YiJieJueCount=problemService.getStatusCount(mapYiJieJue);	
		int LiuDaiJieJueCount=problemService.getStatusCount(mapLiuDaiJieJue);	
		int YiHuLveCount=problemService.getStatusCount(mapYiHuLve);	
		int YiGuanBiCount=problemService.getStatusCount(mapYiGuanBi);
		int problemcount=problemService.getProblemCount(publisher);
		
		Map mapTiJiaoXinJian = new HashMap();
		mapTiJiaoXinJian.put("publisher",publisher);
		mapTiJiaoXinJian.put("problemStatusName","新建");
		
		Map mapTiJiaoJinXinZhong = new HashMap();
		mapTiJiaoJinXinZhong.put("publisher",publisher);
		mapTiJiaoJinXinZhong.put("problemStatusName","进行中");
		
		Map mapTiJiaoChongXinOpen = new HashMap();
		mapTiJiaoChongXinOpen.put("publisher",publisher);
		mapTiJiaoChongXinOpen.put("problemStatusName","重新打开");
		
		Map mapTiJiaoYiJieJue = new HashMap();
		mapTiJiaoYiJieJue.put("publisher",publisher);
		mapTiJiaoYiJieJue.put("problemStatusName","已解决");
		int TiJiaoXinJianCount=problemService.getCountByUid(mapTiJiaoXinJian);
		int TiJiaoJinXinZhongCount=problemService.getCountByUid(mapTiJiaoJinXinZhong);
		int TiJiaoChongXinOpenCount=problemService.getCountByUid(mapTiJiaoChongXinOpen);
		int TiJiaoYiJieJueCount=problemService.getCountByUid(mapTiJiaoYiJieJue);
		
		
		
		
		   
		model.addAttribute("TiJiaoXinJianCount",TiJiaoXinJianCount);
		model.addAttribute("TiJiaoJinXinZhongCount",TiJiaoJinXinZhongCount);
		model.addAttribute("TiJiaoChongXinOpenCount",TiJiaoChongXinOpenCount);
		model.addAttribute("TiJiaoYiJieJueCount",TiJiaoYiJieJueCount);
		model.addAttribute("problemcount", problemcount);//每个人提交问题的全部数量
		model.addAttribute("XinJianCount", XinJianCount);
		model.addAttribute("JinXingZhongCount",JinXingZhongCount);
		model.addAttribute("ChongXinOpenCount",ChongXinOpenCount);
		model.addAttribute("YiJieJueCount", YiJieJueCount);
		model.addAttribute("LiuDaiJieJueCount",LiuDaiJieJueCount);
		model.addAttribute("YiHuLveCount", YiHuLveCount);
		model.addAttribute("YiGuanBiCount",YiGuanBiCount);
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




Map mapXinJian = new HashMap();
mapXinJian.put("publisher",publisher);
mapXinJian.put("problemStatusName","新建");

Map mapJinXingZhong = new HashMap();
mapJinXingZhong.put("publisher",publisher);
mapJinXingZhong.put("problemStatusName","进行中");

Map mapChongXinOpen = new HashMap();
mapChongXinOpen.put("publisher",publisher);
mapChongXinOpen.put("problemStatusName","重新打开");

Map mapYiJieJue = new HashMap();
mapYiJieJue.put("publisher",publisher);
mapYiJieJue.put("problemStatusName","已解决");

Map mapLiuDaiJieJue = new HashMap();
mapLiuDaiJieJue.put("publisher",publisher);
mapLiuDaiJieJue.put("problemStatusName","留待解决");

Map mapYiHuLve = new HashMap();
mapYiHuLve.put("publisher",publisher);
mapYiHuLve.put("problemStatusName","已忽略");

Map mapYiGuanBi = new HashMap();
mapYiGuanBi.put("publisher",publisher);
mapYiGuanBi.put("problemStatusName","已关闭");

int XinJianCount=problemService.getStatusCount(mapXinJian);
int JinXingZhongCount=problemService.getStatusCount(mapJinXingZhong);	
int ChongXinOpenCount=problemService.getStatusCount(mapChongXinOpen);	
int YiJieJueCount=problemService.getStatusCount(mapYiJieJue);	
int LiuDaiJieJueCount=problemService.getStatusCount(mapLiuDaiJieJue);	
int YiHuLveCount=problemService.getStatusCount(mapYiHuLve);	
int YiGuanBiCount=problemService.getStatusCount(mapYiGuanBi);
int problemcount=problemService.getProblemCount(publisher);

Map mapTiJiaoXinJian = new HashMap();
mapTiJiaoXinJian.put("publisher",publisher);
mapTiJiaoXinJian.put("problemStatusName","新建");

Map mapTiJiaoJinXinZhong = new HashMap();
mapTiJiaoJinXinZhong.put("publisher",publisher);
mapTiJiaoJinXinZhong.put("problemStatusName","进行中");

Map mapTiJiaoChongXinOpen = new HashMap();
mapTiJiaoChongXinOpen.put("publisher",publisher);
mapTiJiaoChongXinOpen.put("problemStatusName","重新打开");

Map mapTiJiaoYiJieJue = new HashMap();
mapTiJiaoYiJieJue.put("publisher",publisher);
mapTiJiaoYiJieJue.put("problemStatusName","已解决");
int TiJiaoXinJianCount=problemService.getCountByUid(mapTiJiaoXinJian);
int TiJiaoJinXinZhongCount=problemService.getCountByUid(mapTiJiaoJinXinZhong);
int TiJiaoChongXinOpenCount=problemService.getCountByUid(mapTiJiaoChongXinOpen);
int TiJiaoYiJieJueCount=problemService.getCountByUid(mapTiJiaoYiJieJue);





model.addAttribute("TiJiaoXinJianCount",TiJiaoXinJianCount);
model.addAttribute("TiJiaoJinXinZhongCount",TiJiaoJinXinZhongCount);
model.addAttribute("TiJiaoChongXinOpenCount",TiJiaoChongXinOpenCount);
model.addAttribute("TiJiaoYiJieJueCount",TiJiaoYiJieJueCount);
model.addAttribute("problemcount", problemcount);//每个人提交问题的全部数量
model.addAttribute("XinJianCount", XinJianCount);
model.addAttribute("JinXingZhongCount",JinXingZhongCount);
model.addAttribute("ChongXinOpenCount",ChongXinOpenCount);
model.addAttribute("YiJieJueCount", YiJieJueCount);
model.addAttribute("LiuDaiJieJueCount",LiuDaiJieJueCount);
model.addAttribute("YiHuLveCount", YiHuLveCount);
model.addAttribute("YiGuanBiCount",YiGuanBiCount);
model.addAttribute("publisher", publisher);
	    	
	
	    return PageConst.PAGE_PROJECT_SUMMARY;
	    }
	
	
	
	
}
