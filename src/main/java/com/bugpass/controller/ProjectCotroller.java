package com.bugpass.controller;

import com.bugpass.constant.MemberRoleType;
import com.bugpass.entity.Member;
import com.bugpass.entity.Project;
import com.bugpass.entity.User;
import com.bugpass.service.MemberService;
import com.bugpass.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ChenZhiJunSB
 * @date 2018-07-03 14:27
 */
@Controller
public class ProjectCotroller {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private MemberService memberService;

    
    /**
     * 添加项目并重定向
     * 
     * @param project
     * @param model
     * @return
     */
    @RequestMapping(value = "project/create", method = RequestMethod.POST)
    public String createProjectPost(Project project, HttpSession session, Model model) {
        // 获取登录的用户
        User user = (User) session.getAttribute("currentUser");
        System.out.println("controllerUser:" + user.getId());
        // 添加项目信息
        boolean flag = projectService.addProject(project, user);
        // 根据显示ID查询完整的项目信息
        Project newProject = projectService.findProjectByDisplayId(project.getDisplayId());
        System.out.println("controllerProject:" + newProject.getId());
        return "redirect:/api/showProject/" + newProject.getId();
    }
    
    /**
     * 根据项目ID查询一条记录
     * 
     * @param projectId
     * @return
     */
    @RequestMapping(value = "project/delete/{projectId}", method = RequestMethod.GET)
    public String delProject(@PathVariable(value = "projectId") long projectId) {
        boolean flag = projectService.delProjectById(projectId);
        return "project_info";
    }
    
    
    /**
     * 根据项目ID查询一条记录
     * 
     * @param projectId
     * @param model
     * @return
     */
    @RequestMapping(value = "/api/showProject/{projectId}", method = RequestMethod.GET)
    public String showProject(@PathVariable(value = "projectId") long projectId, Model model) {
        Project project = projectService.findProjectById(projectId);
        model.addAttribute("project", project);
        //TODO 待处理:成员表里项目Id不存在没有list返回,有越界错误
        List<Member> listMem = memberService.queryByProjectId(projectId);
        User projectCreator = new User();
        for (Member member : listMem) {
            //获取创建者
            if (member.getMemberRole() == MemberRoleType.ROLE_CREATOR) {
                projectCreator = member.getUser();
            }
        }
        model.addAttribute("projectCreator", projectCreator);
        return "project_info";
    }

    /**
     * 根据用户id查询用户参与的所有项目
     * 
     * @param userId
     * @param model
     * @return List<Project>
     */
    @RequestMapping(value = "/api/getProjectByUserId/{userId}", method = RequestMethod.GET)
    public String getProjectByUserId(@PathVariable(value = "userId") long userId, Model model) {
        List<Project> listPro = projectService.queryProjectByUserId(userId);
        model.addAttribute("listPro", listPro);
        return "project_showList";
    }

    /**
     * 跳转到添加项目界面
     * 
     * @return
     */
    @RequestMapping(value = "/toAddProject")
    public String toAddProject() {
        return "project_add";
    }
    
}
