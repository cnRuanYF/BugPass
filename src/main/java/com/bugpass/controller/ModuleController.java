package com.bugpass.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugpass.entity.Module;
import com.bugpass.entity.Project;
import com.bugpass.service.ModuleService;

/**
 * 模块相关操作的Controller
 * 
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:59:06
 */
@Controller
public class ModuleController {

    private static final String MODULE_PAGE = "module";// 展示页面
    private static final String ERROR_PAGE = "index";// TODO
    private static final String PAGE_ADD_MODULE = "module_add";// 添加页面
    private static final String PAGE_UPD_MODULE = "module_udp";// 更新页面

    @Autowired
    private ModuleService moduleService;

    /**
     * 根据projectId展示模块信息
     */
    @RequestMapping(value = "module/list", method = RequestMethod.GET)
    public String showModule(HttpSession session, Model model) {
        // 从session中获取当前项目
        // Project project = (Project) session.getAttribute("currentProject");
        // List<Module> moduleList =
        // moduleService.findByProjectId(project.getId());
        List<Module> moduleList = moduleService.findByProjectId(1);// 测试用
        model.addAttribute("moduleList", moduleList);
       // moduleList.forEach(System.out::println);// 测试用
        return MODULE_PAGE;
    }

    /**
     * 跳转到添加模块界面
     * 
     * @return
     */
    /*
     * @RequestMapping(value = "module/add", method = RequestMethod.GET) public
     * String toAddModule() { return PAGE_ADD_MODULE; }
     */

    /**
     * 添加模块
     */
    @RequestMapping(value = "module/add", method = RequestMethod.POST)
    public String addModule(Module module, HttpSession session, Model model) {
        // 获取当前项目的id
        Project project = (Project) session.getAttribute("currentProject");// 从session中取得
        System.out.println("currentProjectId:" + project.getId());
        long currentProjectId = project.getId();
        // 将session中的当前项目id传入module中
        module.setProjectId(currentProjectId);
        System.out.println(model);// 测试用
        // 添加评论
        boolean flag = moduleService.addModule(module);
        if (flag) {
            model.addAttribute("module", module);
            // return "redirect:/module/list/"+currentProjectId;
            return "redirect:/module/list/";
        } else {
            return ERROR_PAGE; // TODO 跳转到错误页
        }

    }

    /**
     * 跳转到修改界面
     * 
     * @return
     */
   /* @RequestMapping(value = "module/update/{moduleId}", method = RequestMethod.GET)
    public String toUpdModule(@PathVariable(value = "moduleId") long moduleId, Model model) {
        Module currentModule = moduleService.findByModuleId(moduleId);
        System.out.println(currentModule);// 测试用
        model.addAttribute("currentModule", currentModule);
        return PAGE_UPD_MODULE;
    }*/

    /**
     * 修改
     */
    // @RequestMapping(value = "api/module", method = RequestMethod.PUT)
    @RequestMapping(value = "module/update")
    public String updModule(Module module, HttpSession session, Model model) {
        System.out.println("currentModule" + module);
        Project project = (Project) session.getAttribute("currentProject");
        long currentProjectId = project.getId();
        boolean flag = moduleService.udpModuleById(module);
        if (flag) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
        return "redirect:/module/list";// 重新获取列表
    }

    /**
     * 删除模块
     */
    // @RequestMapping(value = "api/module/{moduleId}", method =
    // RequestMethod.DELETE)
    @RequestMapping(value = "module/remove/{moduleId}")
    public String delModule(@PathVariable("moduleId") long moduleId, HttpSession session) {
        moduleService.delModuleById(moduleId);
        Project project = (Project) session.getAttribute("currentProject");
        long currentProjectId = project.getId();
        // System.out.println(currentProjectId);
        return "redirect:/module/list/";// 重新获取列表
    }

}
