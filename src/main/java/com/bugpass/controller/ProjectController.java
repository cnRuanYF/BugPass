package com.bugpass.controller;

import com.bugpass.constant.MemberRoleType;
import com.bugpass.constant.MessageType;
import com.bugpass.entity.Member;
import com.bugpass.entity.Problem;
import com.bugpass.entity.Project;
import com.bugpass.entity.User;
import com.bugpass.service.MemberService;
import com.bugpass.service.ProblemService;
import com.bugpass.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.bugpass.constant.PageConst.*;

/**
 * @author ChenZhiJun
 * @date 2018-07-03 14:27
 */
@Controller
public class ProjectController {

    public static final String ATTRIB_CURRENT_PROJECT = "currentProject";
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ProblemService problemService;

    /**
     * 项目概述
     */
    @RequestMapping(value = CTRL_PROJECT_SUMMARY, method = RequestMethod.GET)
    public String showSummary(HttpSession session, Model model) {
        // 获取当前用户、项目
        User currentUser = (User) session.getAttribute("currentUser");
        Project currentProject = (Project) session.getAttribute(ATTRIB_CURRENT_PROJECT);

        // 获取当前用户加入的项目
        List<Project> projectList = projectService.queryProjectByUserId(currentUser.getId());
        session.setAttribute("projectList", projectList);

        // 查询项目创建者
        User projectCreator = projectService.getProjectCreatorByProjectId(currentProject.getId());
        session.setAttribute("currentProjectCreator", projectCreator);

        List<Problem> problemList = problemService.queryProblemByProjectId(currentProject.getId());

        List<Problem> problemFromMeList = problemService.queryProjectFromMe(currentProject.getId(), currentUser.getId());
        List<Problem> problemToMeList = problemService.queryProjectToMe(currentProject.getId(), currentUser.getId());

        int openedProblem = 0, newProblem = 0, doingProblem = 0, resolvedProblem = 0,
                openedProblemToMe = 0, newProblemToMe = 0, doingProblemToMe = 0, resolvedProblemToMe = 0,
                openedProblemFromMe = 0, newProblemFromMe = 0, doingProblemFromMe = 0, resolvedProblemFromMe = 0;

        // 遍历所有问题，计数
        for (int i = 0; i < problemList.size(); i++) {
            // 新问题
            if (problemList.get(i).getProblemStatus() == 1) {
                openedProblem++;
                newProblem++;
            }
            // 进行中
            if (problemList.get(i).getProblemStatus() == 2) {
                doingProblem++;
                openedProblem++;
            }
            // 已解决
            if (problemList.get(i).getProblemStatus() == 3) {
                resolvedProblem++;
            }
        }

        // 遍历指派给我的问题，计数
        for (int i = 0; i < problemToMeList.size(); i++) {
            // 新问题
            if (problemToMeList.get(i).getProblemStatus() == 1) {
                openedProblemToMe++;
                newProblemToMe++;
            }
            // 进行中
            if (problemToMeList.get(i).getProblemStatus() == 2) {
                doingProblemToMe++;
                openedProblemToMe++;
            }
            // 已解决
            if (problemToMeList.get(i).getProblemStatus() == 3) {
                resolvedProblemToMe++;
            }
        }

        // 遍历我提交的问题，计数
        for (int i = 0; i < problemFromMeList.size(); i++) {
            // 新问题
            if (problemFromMeList.get(i).getProblemStatus() == 1) {
                openedProblemFromMe++;
                newProblemFromMe++;
            }
            // 进行中
            if (problemFromMeList.get(i).getProblemStatus() == 2) {
                doingProblemFromMe++;
                openedProblemFromMe++;
            }
            // 已解决
            if (problemFromMeList.get(i).getProblemStatus() == 3) {
                resolvedProblemFromMe++;
            }
        }


        // 统计数字
        model.addAttribute("openedProblem", openedProblem);
        model.addAttribute("newProblem", newProblem);
        model.addAttribute("doingProblem", doingProblem);
        model.addAttribute("resolvedProblem", resolvedProblem);

        model.addAttribute("openedProblemToMe", openedProblemToMe);
        model.addAttribute("newProblemToMe", newProblemToMe);
        model.addAttribute("doingProblemToMe", doingProblemToMe);
        model.addAttribute("resolvedProblemToMe", resolvedProblemToMe);

        model.addAttribute("openedProblemFromMe", openedProblemFromMe);
        model.addAttribute("newProblemFromMe", newProblemFromMe);
        model.addAttribute("doingProblemFromMe", doingProblemFromMe);
        model.addAttribute("resolvedProblemFromMe", resolvedProblemFromMe);

        // List
        model.addAttribute("problemFromMeList", problemFromMeList);
        model.addAttribute("problemToMeList", problemToMeList);


        // TODO 获取问题统计
        return PAGE_PROJECT_SUMMARY;
    }

    /**
     * 选择项目
     */
    @RequestMapping(value = CTRL_PROJECT_SWITCH, method = RequestMethod.GET)
    public String switchProject(@PathVariable("id") long id, HttpSession session) {
        // 获取当前用户
        User currentUser = (User) session.getAttribute("currentUser");

        // 获取当前用户加入的项目
        List<Project> projectList = projectService.queryProjectByUserId(currentUser.getId());
        session.setAttribute("projectList", projectList);

        // 获取选择的项目
        Project project = null;
        for (Project p : projectList) {
            if (p.getId() == id) {
                project = p;
                break;
            }
        }

        if (project != null) {
            session.setAttribute("currentProject", project);
        } else {
            session.setAttribute(MessageType.ERROR, "你只能选择已加入的项目");
        }

        return redirect(CTRL_PROJECT_SUMMARY);
    }

    /**
     * 创建新项目
     */
    @RequestMapping(value = CTRL_PROJECT_CREATE, method = RequestMethod.POST)
    public String createProject(Project project, HttpSession session) {
        // 获取登录的用户
        User currentUser = (User) session.getAttribute("currentUser");

        // 添加项目信息
        boolean success = projectService.addProject(project, currentUser);
        if (success) {
            session.setAttribute(MessageType.SUCCESS, "新建项目成功");
        } else {
            session.setAttribute(MessageType.ERROR, "新建项目失败，请稍后再试");
        }

        // 查询刚刚创建的项目信息
        Project newProject = projectService.findProjectByDisplayId(project.getDisplayId());
        newProject.setCreator(currentUser);
        session.setAttribute(ATTRIB_CURRENT_PROJECT, newProject);
        session.setAttribute("currentProjectCreator", currentUser);

        return redirect(CTRL_PROJECT_SUMMARY);
    }

    /**
     * 项目信息（设置） - 显示
     */
    @RequestMapping(value = CTRL_PROJECT_INFO, method = RequestMethod.GET)
    public String projectInfoGet(HttpSession session, Model model) {
        // 获取当前项目
        Project currentProject = (Project) session.getAttribute(ATTRIB_CURRENT_PROJECT);

        // 查询项目创建者
        List<Member> members = memberService.queryByProjectId(currentProject.getId());
        User projectCreator = null;
        for (Member member : members) {
            if (member.getMemberRole() == MemberRoleType.ROLE_CREATOR) {
                projectCreator = member.getUser();
                break;
            }
        }
        model.addAttribute("projectCreator", projectCreator);

        if (currentProject.getProjectDesc() == null || currentProject.getProjectDesc().equals("")) {
            session.setAttribute(MessageType.WARNING, "建议完善项目描述信息哦");
        }

        return PAGE_PROJECT_INFO;
    }

    /**
     * 项目信息(设置) - 提交
     */
    @RequestMapping(value = CTRL_PROJECT_INFO, method = RequestMethod.POST)
    public String projectInfoPost(Project project, HttpSession session) {

        if (projectService.updProject(project)) {
            Project updatedProject = projectService.findProjectById(project.getId());
            session.setAttribute(ATTRIB_CURRENT_PROJECT, updatedProject);
            session.setAttribute(MessageType.SUCCESS, "项目信息修改成功");
        } else {
            session.setAttribute(MessageType.SUCCESS, "操作失败，请稍后再试");
        }

        return redirect(CTRL_PROJECT_INFO);
    }


    /**
     * 解散项目信息 (标记为删除)
     */
    @RequestMapping(value = CTRL_PROJECT_DELETE, method = RequestMethod.GET)
    public String deleteProject(@PathVariable(value = "id") long id, HttpSession session) {
        projectService.delProjectById(id);
        session.removeAttribute(ATTRIB_CURRENT_PROJECT);
        return redirect(CTRL_ENTER);
    }


//    /**
//     * 根据项目ID查询一条记录
//     */
//    @RequestMapping(value = "/api/showProject/{projectId}", method = RequestMethod.GET)
//    public String showProject(@PathVariable(value = "projectId") long projectId, Model model) {
//        Project project = projectService.findProjectById(projectId);
//        model.addAttribute("project", project);
//
//        List<Member> listMem = memberService.queryByProjectId(projectId);
//        User projectCreator = new User();
//        for (Member member : listMem) {
//            //获取创建者
//            if (member.getMemberRole() == MemberRoleType.ROLE_CREATOR) {
//                projectCreator = member.getUser();
//            }
//        }
//        model.addAttribute("projectCreator", projectCreator);
//        return "project_info";
//    }

}
