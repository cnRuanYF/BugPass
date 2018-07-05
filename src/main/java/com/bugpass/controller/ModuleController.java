package com.bugpass.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bugpass.entity.Discuss;
import com.bugpass.entity.Module;
import com.bugpass.entity.Project;
import com.bugpass.entity.User;
import com.bugpass.service.DiscussService;
import com.bugpass.service.ModuleService;

/**
 * 模块相关操作的Controller
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:59:06
 */
@Controller
public class ModuleController {

    private static final String MODULE_PAGE = "module";//展示页面
    private static final String ERROR_PAGE = "index";// TODO 
    private static final String PAGE_ADD_MODULE = "addModule";//添加页面
    private static final String PAGE_UPD_MODULE = "updModule";//添加页面

    @Autowired
    private ModuleService moduleService;

    /**
     * [RESTful] 根据projectId展示模块信息
     */
    @RequestMapping(value = "api/module/{projectId}", method = RequestMethod.GET)
    public String showModule(@PathVariable(value="projectId")long projectId, Model model) {
        List<Module> moduleList = moduleService.findByProjectId(projectId);
        model.addAttribute("moduleList", moduleList);
        moduleList.forEach(System.out::println);//测试用
        return MODULE_PAGE;
    }
    
    /**
     * 跳转到添加模块界面
     * 
     * @return
     */
    @RequestMapping(value = "api/module", method = RequestMethod.GET)
    public String toAddModule() {
        return PAGE_ADD_MODULE;
    }
    
    /**
     * 添加模块
     */
    @RequestMapping(value = "api/module", method = RequestMethod.POST)
    public String addModule(Module module,HttpSession session, Model model) {
        //获取当前项目的id
        Project project = (Project) session.getAttribute("currentProject");
        System.out.println("currentProjectId:"+project.getId());
        long currentProjectId = project.getId();
//        discuss.setPublisherUser(user);
        
        int problemId = (int)session.getAttribute("problemId");
        System.out.println(problemId);
        //添加评论
        boolean flag = moduleService.addModule(module);
        if (flag) {
            model.addAttribute("discuss", model);
            return "redirect:/api/model/"+currentProjectId; 
        }else {
            return ERROR_PAGE; // TODO 跳转到错误页
        }

    }


    /**
     * 删除模块
     */
//    @RequestMapping(value = "api/discuss/{discussId}", method = RequestMethod.DELETE)
//    public String delDiscuss(@PathVariable("discussId")long discussId,HttpSession session) {
//        int problemId = (int)session.getAttribute("problemId");
//        System.out.println(problemId);
//        discussService.delDiscussById(discussId);
//        return "redirect:/api/discuss/"+problemId;//重新获取讨论列表
//    }
    

}
