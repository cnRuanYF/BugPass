package com.bugpass.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import com.bugpass.entity.ProblemAll;
import com.bugpass.entity.ProblemLevel;
import com.bugpass.entity.ProblemStatus;
import com.bugpass.entity.ProblemType;
import com.bugpass.service.ProblemService;






@Controller
public class ProblemController {
	
	@Resource
	private ProblemService problemService;
	@RequestMapping(value= "/newproblem")
	public String getProblem(Model model,int publisher)
	{
		
		List<ProblemType> list=problemService.getAllType();
		List<ProblemLevel> list2=problemService.getAllLevel();
		List<ProblemStatus> list3=problemService.getAllStatus();
	
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		
		model.addAttribute("publisher", publisher);
		return "6";
	}
	
	@RequestMapping("/myupload")
	public String reqFileUpload(HttpServletRequest request,Model model,String ptitle,String pdescripe,String protypeid,String plevelid,String pstatusid,int publisher) {
		// 转型为MulltipartHttpServletRequest
//		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//		
//
//		// 得到上传的文件
//		MultipartFile multiFile = multiRequest.getFile("myfile");
//		// 得到文件上传的文件名
//		String fileName = multiFile.getOriginalFilename();
//		String path = request.getServletPath();
	    int protypeid2=Integer.valueOf(protypeid);
		int plevelid2=Integer.valueOf(plevelid);
		int pstatusid2=Integer.valueOf(pstatusid);
		
//		if(pislock==null){
//			pislock="0";
//		}
//		
//		if(istrack==null){
//			istrack="0";
//		}
//		int pislock2=Integer.valueOf(pislock);
//		int istrack2=Integer.valueOf(istrack);
		
	
		// 得到目标路径
//		String destPath = request.getRealPath("/images") + "/" + fileName;
//		String pimage="/" + fileName;
//		
//
//		// 将文件上传的目标位置对象穿件出来(File)
//		File destFile = new File(destPath);
//
//		// 上传的动作 (从原位置读取文件 将文件写入目标位置)
//		// 第一个参数 InputStream
//		// 第二个参数 File类型 目标位置的一个文件对象(完整的路径 xxx/xx/xx.jpg )
//		try {
//			FileUtils.copyInputStreamToFile(multiFile.getInputStream(), destFile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Map map = new HashMap();
		map.put("problem_title",ptitle);
		map.put("problem_desc",pdescripe);
		//map.put("pislock",pislock2);
		//map.put("pimage",pimage);
		map.put("problem_type",protypeid2);
		map.put("problem_level",plevelid2);
		map.put("problem_status",pstatusid2);
		map.put("publisher",publisher);
		//map.put("istrack",istrack2);
		

		boolean flag=problemService.addProblem(map);
		if(flag){
			Map map1 = new HashMap();
			map1.put("publisher",publisher);
			map1.put("problemstatus_name","新建");
			
			Map map2 = new HashMap();
			map2.put("publisher",publisher);
			map2.put("problemstatus_name","进行中");
			
			Map map3 = new HashMap();
			map3.put("publisher",publisher);
			map3.put("problemstatus_name","重新打开");
			
			Map map4 = new HashMap();
			map4.put("publisher",publisher);
			map4.put("problemstatus_name","已解决");
			
			Map map5 = new HashMap();
			map5.put("publisher",publisher);
			map5.put("problemstatus_name","留待解决");
			
			Map map6 = new HashMap();
			map6.put("publisher",publisher);
			map6.put("problemstatus_name","已忽略");
			
			Map map7 = new HashMap();
			map7.put("publisher",publisher);
			map7.put("problemstatus_name","已关闭");
			
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
		map8.put("problemstatus_name","新建");
		
		Map map9 = new HashMap();
		map9.put("publisher",publisher);
		map9.put("problemstatus_name","进行中");
		
		Map map10 = new HashMap();
		map10.put("publisher",publisher);
		map10.put("problemstatus_name","重新打开");
		
		Map map11 = new HashMap();
		map11.put("publisher",publisher);
		map11.put("problemstatus_name","已解决");
		int countUid=problemService.getCountByUid(map8);
		int countUid2=problemService.getCountByUid(map9);
		int countUid3=problemService.getCountByUid(map10);
		int countUid4=problemService.getCountByUid(map11);
		
		
//		Map map12 = new HashMap();
//		map12.put("publisher",publisher);
//		map12.put("pstatusname","新建");
//		map12.put("istrack",1);
//		
//		Map map13 = new HashMap();
//		map13.put("publisher",publisher);
//		map13.put("pstatusname","进行中");
//		map13.put("istrack",1);
//		
//		Map map14 = new HashMap();
//		map14.put("publisher",publisher);
//		map14.put("pstatusname","重新打开");
//		map14.put("istrack",1);
//		
//		Map map15 = new HashMap();
//		map15.put("publisher",publisher);
//		map15.put("pstatusname","已解决");
//		map15.put("istrack",1);
		
		
		Map map16 = new HashMap();
		map16.put("publisher",publisher);
		map16.put("problemstatus_name","新建");
		
		
		Map map17 = new HashMap();
		map17.put("publisher",publisher);
		map17.put("problemstatus_name","进行中");
		
		
		Map map18 = new HashMap();
		map18.put("publisher",publisher);
		map18.put("problemstatus_name","重新打开");
		
		
		Map map19 = new HashMap();
		map19.put("publisher",publisher);
		map19.put("problemstatus_name","已解决");
		
		
//		int istrackCount=problemService.getCountByIsTrack(map12);
//		int istrackCount2=problemService.getCountByIsTrack(map13);
//		int istrackCount3=problemService.getCountByIsTrack(map14);
//		int istrackCount4=problemService.getCountByIsTrack(map15);
		
//		int usubmitCount=problemService.getCountByUsubmit(map16);
//		int usubmitCount2=problemService.getCountByUsubmit(map17);
//		int usubmitCount3=problemService.getCountByUsubmit(map18);
//		int usubmitCount4=problemService.getCountByUsubmit(map19);
		   
		model.addAttribute("countUid",countUid);
		model.addAttribute("countUid2",countUid2);
		model.addAttribute("countUid3",countUid3);
		model.addAttribute("countUid4",countUid4);
		
//		model.addAttribute("istrackCount",istrackCount);
//		model.addAttribute("istrackCount2",istrackCount2);
//		model.addAttribute("istrackCount3",istrackCount3);
//		model.addAttribute("istrackCount4",istrackCount4);
		
//		model.addAttribute("usubmitCount",usubmitCount);
//		model.addAttribute("usubmitCount2",usubmitCount2);
//		model.addAttribute("usubmitCount3",usubmitCount3);
//		model.addAttribute("usubmitCount4",usubmitCount4);
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
	
	@RequestMapping(value= "/checkAll")
	public String getProblemAll(Model model,int publisher)
	{
		
		
		
		List<ProblemAll> all=problemService.getProblemAll(publisher);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	
	@RequestMapping(value= "/checktype")
	public String getProblemTypeId(Model model,int protypeid,int publisher)
	{
		
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemtype_id",protypeid);
		
	    List<ProblemAll> problem=problemService.getAllTypeById(map);
		model.addAttribute("problem",problem);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping(value= "/checklevel")
	public String getProblemLevelId(Model model,int plevelid,int publisher)
	{
		
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemlevel_id",plevelid);
		List<ProblemAll> problem=problemService.getAllLevelById(map);
		model.addAttribute("problem",problem);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	
	@RequestMapping(value= "/checkstatus")
	public String getProblemStatusId(Model model,int pstatusid,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_id",pstatusid);
		
		List<ProblemAll> problem=problemService.getAllStatusById(map);
		model.addAttribute("problem",problem);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping(value= "/selectAll")
	public String getProblemAll2(Model model,int publisher)
	{
		
		
		
		List<ProblemAll> all=problemService.getProblemAll(publisher);
		model.addAttribute("all",all);
		
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	
	@RequestMapping(value= "/getstatus")
	public String getProblemByStatus(Model model,int publisher)
	{
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","新建");
		
		
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping(value= "/getstatus2")
	public String getProblemByStatus2(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","进行中");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping(value= "/getstatus3")
	public String getProblemByStatus3(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","重新打开");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping(value= "/getstatus4")
	public String getProblemByStatus4(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","已解决");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping(value= "/getstatus5")
	public String getProblemByStatus5(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","留待解决");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping(value= "/getstatus6")
	public String getProblemByStatus6(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","已忽略");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping(value= "/getstatus7")
	public String getProblemByStatus7(Model model,int publisher)
	{
		
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","已关闭");
		
		List<ProblemAll> all=problemService.getProblemByStatus(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	@RequestMapping({"/deleteproblem"})
	public String deleteUser(int pid,Model model,int publisher) {
		boolean flag=problemService.deleteProblemById(pid);
		if(flag){
			model.addAttribute("publisher", publisher);
			return "2";
			
		}
		return "1";
	}
	
	
	@RequestMapping({"/getstatusbypublisher"})
	public String getStatusBypublisher(int publisher,Model model) {
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","新建");
		List<ProblemAll> all=problemService.getProblemByUid(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping({"/getstatusbypublisher2"})
	public String getStatusBypublisher2(int publisher,Model model) {
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","进行中");
		List<ProblemAll> all=problemService.getProblemByUid(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping({"/getstatusbypublisher3"})
	public String getStatusBypublisher3(int publisher,Model model) {
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","重新打开");
		List<ProblemAll> all=problemService.getProblemByUid(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}
	
	@RequestMapping({"/getstatusbypublisher4"})
	public String getStatusBypublisher4(int publisher,Model model) {
		Map map = new HashMap();
		map.put("publisher",publisher);
		map.put("problemstatus_name","已解决");
		List<ProblemAll> all=problemService.getProblemByUid(map);
		model.addAttribute("all",all);
		model.addAttribute("publisher", publisher);
		return "2";
	}

	@RequestMapping(value= "/summary")
	    public String summary(Model model,int publisher)
	    {
	    	
	    	
	        
	    	
	    	Map map1 = new HashMap();
	    	map1.put("publisher",publisher);
	    	map1.put("problemstatus_name","新建");
	    	
	    	Map map2 = new HashMap();
	    	map2.put("publisher",publisher);
	    	map2.put("problemstatus_name","进行中");
	    	
	    	Map map3 = new HashMap();
	    	map3.put("publisher",publisher);
	    	map3.put("problemstatus_name","重新打开");
	    	
	    	Map map4 = new HashMap();
	    	map4.put("publisher",publisher);
	    	map4.put("problemstatus_name","已解决");
	    	
	    	Map map5 = new HashMap();
	    	map5.put("publisher",publisher);
	    	map5.put("problemstatus_name","留待解决");
	    	
	    	Map map6 = new HashMap();
	    	map6.put("publisher",publisher);
	    	map6.put("problemstatus_name","已忽略");
	    	
	    	Map map7 = new HashMap();
	    	map7.put("publisher",publisher);
	    	map7.put("problemstatus_name","已关闭");
	    	
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
	    	map8.put("problemstatus_name","新建");
	    	
	    	Map map9 = new HashMap();
	    	map9.put("publisher",publisher);
	    	map9.put("problemstatus_name","进行中");
	    	
	    	Map map10 = new HashMap();
	    	map10.put("publisher",publisher);
	    	map10.put("problemstatus_name","重新打开");
	    	
	    	Map map11 = new HashMap();
	    	map11.put("publisher",publisher);
	    	map11.put("problemstatus_name","已解决");
	    	int countUid=problemService.getCountByUid(map8);
	    	int countUid2=problemService.getCountByUid(map9);
	    	int countUid3=problemService.getCountByUid(map10);
	    	int countUid4=problemService.getCountByUid(map11);
	    	
	    	
	//    	Map map12 = new HashMap();
	//    	map12.put("publisher",publisher);
	//    	map12.put("pstatusname","新建");
	//    	map12.put("istrack",1);
	//    	
	//    	Map map13 = new HashMap();
	//    	map13.put("publisher",publisher);
	//    	map13.put("pstatusname","进行中");
	//    	map13.put("istrack",1);
	//    	
	//    	Map map14 = new HashMap();
	//    	map14.put("publisher",publisher);
	//    	map14.put("pstatusname","重新打开");
	//    	map14.put("istrack",1);
	//    	
	//    	Map map15 = new HashMap();
	//    	map15.put("publisher",publisher);
	//    	map15.put("pstatusname","已解决");
	//    	map15.put("istrack",1);
	    	
	    	
	    	Map map16 = new HashMap();
	    	map16.put("publisher",publisher);
	    	map16.put("pstatusname","新建");
	    	
	    	Map map17 = new HashMap();
	    	map17.put("publisher",publisher);
	    	map17.put("pstatusname","进行中");
	    	
	    	
	    	Map map18 = new HashMap();
	    	map18.put("publisher",publisher);
	    	map18.put("pstatusname","重新打开");
	    	
	    	
	    	Map map19 = new HashMap();
	    	map19.put("publisher",publisher);
	    	map19.put("pstatusname","已解决");
	    	
	    	
	//    	int istrackCount=pproblemService.getCountByIsTrack(map12);
	//    	int istrackCount2=pproblemService.getCountByIsTrack(map13);
	//    	int istrackCount3=pproblemService.getCountByIsTrack(map14);
	//    	int istrackCount4=pproblemService.getCountByIsTrack(map15);
	    	
	//    	int usubmitCount=pproblemService.getCountByUsubmit(map16);
	//    	int usubmitCount2=pproblemService.getCountByUsubmit(map17);
	//    	int usubmitCount3=pproblemService.getCountByUsubmit(map18);
	//    	int usubmitCount4=pproblemService.getCountByUsubmit(map19);
	    	   
	    	model.addAttribute("countUid",countUid);
	    	model.addAttribute("countUid2",countUid2);
	    	model.addAttribute("countUid3",countUid3);
	    	model.addAttribute("countUid4",countUid4);
	    	model.addAttribute("publisher",publisher);
	    	
	//    	model.addAttribute("istrackCount",istrackCount);
	//    	model.addAttribute("istrackCount2",istrackCount2);
	//    	model.addAttribute("istrackCount3",istrackCount3);
	//    	model.addAttribute("istrackCount4",istrackCount4);
	    	
	//    	model.addAttribute("usubmitCount",usubmitCount);
	//    	model.addAttribute("usubmitCount2",usubmitCount2);
	//    	model.addAttribute("usubmitCount3",usubmitCount3);
	//    	model.addAttribute("usubmitCount4",usubmitCount4);
	
	    return "1";
	    }
	
	
	
	
	
	
	
	
	
	

	
}
