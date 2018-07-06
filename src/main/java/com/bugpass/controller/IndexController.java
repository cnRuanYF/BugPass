package com.bugpass.controller;

import com.bugpass.entity.Project;
import com.bugpass.entity.User;
import com.bugpass.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import java.util.List;

import static com.bugpass.constant.PageConst.*;

/**
 * 处理用户登录注册相关操作的Controller
 */
@Controller
public class IndexController {

    @Autowired
    ProjectService projectService;

    /**
     * 跳转到首页
     */
    @RequestMapping(value = CTRL_INDEX, method = RequestMethod.GET)
    public String showIndex() {
        return PAGE_INDEX;
    }

    /**
     * (系统入口) 项目概述
     */
    @RequestMapping(value = CTRL_ENTER, method = RequestMethod.GET)
    public String enterSystem(HttpSession session) {
        // 获取当前用户
        User currentUser = (User) session.getAttribute("currentUser");

        // 获取当前用户加入的项目
        List<Project> projectList = projectService.queryProjectByUserId(currentUser.getId());
        session.setAttribute("projectList", projectList);


        if (session.getAttribute("currentProject") == null) {
            return PAGE_TIP_CHOOSE_PROJECT;
        }
        return redirect(CTRL_PROJECT_SUMMARY);
    }

}
