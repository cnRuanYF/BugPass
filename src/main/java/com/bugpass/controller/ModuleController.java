package com.bugpass.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bugpass.constant.MessageType;
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

import static com.bugpass.constant.PageConst.*;

/**
 * 模块相关操作的Controller
 *
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:59:06
 */
@Controller
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    /**
     * 展示模块列表
     */
    @RequestMapping(value = CTRL_MODULE, method = RequestMethod.GET)
    public String showModule(HttpSession session, Model model) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");
        List<Module> moduleList = moduleService.findByProjectId(project.getId());
        model.addAttribute("moduleList", moduleList);
        return PAGE_MODULE_MANAGE;
    }

    /**
     * 添加模块
     */
    @RequestMapping(value = CTRL_MODULE_ADD, method = RequestMethod.POST)
    public String addModule(Module module, HttpSession session, Model model) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");
        long currentProjectId = project.getId();

        // 将session中的当前项目id存入module中
        module.setProjectId(currentProjectId);

        if (moduleService.addModule(module)) {
            session.setAttribute(MessageType.SUCCESS, "模块添加成功");
        } else {
            session.setAttribute(MessageType.ERROR, "操作失败，请稍后再试");
        }

        return redirect(CTRL_MODULE);
    }

    /**
     * 修改模块
     */
    @RequestMapping(value = CTRL_MODULE_UPDATE, method = RequestMethod.POST)
    public String updateModule(Module module, HttpSession session) {
        if (moduleService.udpModuleById(module)) {
            session.setAttribute(MessageType.SUCCESS, "模块修改成功");
        } else {
            session.setAttribute(MessageType.ERROR, "操作失败，请稍后再试");
        }

        return redirect(CTRL_MODULE);
    }

    /**
     * [RESTful] 删除模块
     */
    @RequestMapping(value = "api/module/{moduleId}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean restDeleteModule(@PathVariable("moduleId") long moduleId) {
        return moduleService.delModuleById(moduleId);
    }

}
