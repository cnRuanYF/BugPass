package com.bugpass.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import static com.bugpass.constant.MemberRoleType.ROLE_MEMBER;
import static com.bugpass.constant.PageConst.CTRL_ENTER;
import static com.bugpass.constant.PageConst.redirect;
import static com.bugpass.constant.MemberRoleType.ROLE_UNCOMFIRMED;

import com.bugpass.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugpass.constant.MessageType;
import com.bugpass.entity.Member;
import com.bugpass.entity.Project;
import com.bugpass.entity.User;
import com.bugpass.service.MemberService;
import com.bugpass.service.UserService;

import static com.bugpass.constant.PageConst.*;

/**
 * 处理成员相关操作的Controller
 *
 * @author VisonSun
 * @date 2018-07-03 15:49
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    /**
     * 添加成员信息
     */
    @RequestMapping(value = "member/add/{id}", method = RequestMethod.GET)
    public String addMember(@PathVariable(value = "id") long userId, HttpSession session) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");
        // 成员对象
        Member member = new Member();
        member.setProjectId(project.getId());
        member.setUserId(userId);
        // 如果是项目成员
        if (memberService.isProjectMember(project.getId(), userId)) {
            session.setAttribute(MessageType.ERROR, "添加成员失败,该成员已经是该项目的成员。");
        }
        // 执行添加
        else if (memberService.addMember(member)) {
            session.setAttribute(MessageType.SUCCESS, "添加成员成功。");
        }
        // 执行添加失败
        else {
            session.setAttribute(MessageType.ERROR, "添加成员失败,我也不懂,应该是DAO错了。");
        }
        return redirect("member/list");
    }


    /**
     * 接受成员邀请
     */
    @RequestMapping(value = "member/acceptInvitation/{projectId}", method = RequestMethod.GET)
    public String updateMember(HttpSession session, @PathVariable(value = "projectId") long projectId) {
        // 获取当前用户
        User user = (User) session.getAttribute("currentUser");
        // 设置用户
        Member member = new Member(projectId, user.getId(), ROLE_MEMBER);

        // 如果是项目成员
        if (memberService.isMember(projectId, user.getId())) {
            session.setAttribute(MessageType.ERROR, "接受邀请失败，你是项目组成员，不可以再接受了哦。");
        }
        // 如果是项目组长
        else if (memberService.isCreator(projectId, user.getId())) {
            session.setAttribute(MessageType.ERROR, "接受邀请失败，你是创建者欸接个pi啦。");
        }
        // 如果是还没邀请
        else if (!memberService.isInvited(projectId, user.getId())) {
            session.setAttribute(MessageType.ERROR, "接受邀请失败，好像没有接到邀请欸？");
        }
        // 非成员则执行移除操作
        else if (memberService.updateMember(member)) {
            session.setAttribute("currentProject", projectService.findProjectById(projectId));
            session.setAttribute(MessageType.SUCCESS, "接受邀请成功啦，欢迎加入。");
        }
        // 执行添加失败
        else {
            session.setAttribute(MessageType.ERROR, "接受邀请失败，我也不懂，应该是你把库误删了，快跑路吧。");
        }

        return redirect(CTRL_ENTER);
    }

    /**
     * 查询当前项目成员
     */
    @RequestMapping(value = "member/list", method = RequestMethod.GET)
    public String queryByProjectId(HttpSession session, Model model) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");

        List<Member> list = memberService.queryByProjectId(project.getId());

        model.addAttribute("memberList", memberService.memberForProject(list));
        model.addAttribute("unconfirmList", memberService.unconfirmForProject(list));

        return PAGE_MEMBER_MANAGE;
    }

    /**
     * [RESTful] 根据name或email对成员模糊查询
     */
    @RequestMapping(value = "api/memberLike", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public List<Member> queryByNameOrEmail(HttpSession session, String nameorEamil) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");
        return memberService.queryByNameOrEmail(project.getId(), nameorEamil);
    }

    /**
     * [RESTful] 模糊搜索当前项目之外的用户
     */
    @RequestMapping(value = "api/member/searchUserWithoutProjectMemberByKeyword/{key}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> searchByKeyword(HttpSession session, @PathVariable("key") String key) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");
        // 模糊查找所有用户
        List<User> userList = userService.findByKeyword(key);
        // 该项目的成员
        List<Member> memberList = memberService.queryByProjectId(project.getId());

        return memberService.searchWithoutProject(userList, memberList);
    }

    /**
     * [RESTful] 邀请成员
     */
    @RequestMapping(value = "api/member/invite/{id}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public String inviteMember(HttpSession session, @PathVariable(value = "id") long userId) {

        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");

        // 成员对象，执行添加时候用
        Member member = new Member();
        member.setProjectId(project.getId());
        member.setUserId(userId);
        member.setMemberRole(ROLE_UNCOMFIRMED);

        // 如果是项目成员
        if (memberService.isMember(project.getId(), userId)) {
            return "邀请成员失败，该成员已经是该项目的成员。";
        }
        // 如果是项目成员
        if (memberService.isInvited(project.getId(), userId)) {
            return "邀请成员失败，该成员已经被邀请了，请稍等。";
        }
        // 非成员则执行添加
        else if (memberService.addMember(member)) {
            return "success";
        }
        // 执行添加失败
        else {
            return "邀请成员失败，我也不懂，应该是你把库误删了，快跑路吧。";
        }
    }

    /**
     * [RESTful] 移除邀请
     */
    @RequestMapping(value = "api/member/cancelInvitation/{id}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public String removeMember(@PathVariable(value = "id") long userId, HttpSession session) {

        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");

        // 成员对象, 删除操作用
        Member member = new Member();
        member.setProjectId(project.getId());
        member.setUserId(userId);

        // 如果是项目成员
        if (memberService.isMember(project.getId(), userId)) {
            return "移除邀请失败，该用户是项目组成员，不可以哦。";
        }
        // 如果是项目组长
        else if (memberService.isCreator(project.getId(), userId)) {
            return "移除邀请失败，该用户是组长啊大哥。";
        }
        // 如果是还没邀请
        else if (!memberService.isInvited(project.getId(), userId)) {
            return "移除邀请失败，您还没邀请他就想踢他了吗？";
        }
        // 非成员则执行移除操作
        else if (memberService.deleteMember(member)) {
            return "success";
        }
        // 执行添加失败
        else {
            return "移除邀请失败，我也不懂，应该是你把库误删了，快跑路吧。";
        }
    }

    /**
     * [RESTful] 删除成员
     */
    @RequestMapping(value = "api/member/remove/{id}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public String deleteMember(@PathVariable(value = "id") long userId, HttpSession session) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");

        // 成员对象
        Member member = new Member();
        member.setProjectId(project.getId());
        member.setUserId(userId);

        // 如果是项目成员
        if (!memberService.isMember(project.getId(), userId)) {
            return "删除成员失败,该成员不是该项目的成员。";
        }
        // 如果是项目组长
        else if (memberService.isCreator(project.getId(), userId)) {
            return "删除成员失败,怎么能删除组长呢？";
        }
        // 非成员则执行添加
        else if (memberService.deleteMember(member)) {
            return "success";
        }
        // 执行添加失败
        else {
            return "删除成员失败，我也不懂，应该是你把库误删了，快跑路吧。";
        }
    }

    /**
     * [RESTful] 获取被邀请的项目列表
     */
    @RequestMapping(value = "api/member/getInvitationList", method = RequestMethod.GET)
    @ResponseBody
    public List<Project> invitationProject(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        return memberService.getInvitation(user.getId());
    }
}
