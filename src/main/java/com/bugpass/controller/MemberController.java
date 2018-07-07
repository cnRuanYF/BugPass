package com.bugpass.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import static com.bugpass.constant.PageConst.redirect;
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

    /**
     * 添加成员信息
     */
    @RequestMapping(value = "member/add", method = RequestMethod.GET)
    public String addMember(HttpSession session, Member member) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");
        // 如果是项目成员
        if (memberService.isProjectMember(project.getId(), member.getUserId())) {
            session.setAttribute(MessageType.ERROR, "添加成员失败,该成员已经是该项目的成员。");
        }
        // 非成员则执行添加
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
     * 删除成员信息
     */
    @RequestMapping(value = "member/remove/{id}", method = RequestMethod.GET)
    public String deleteMember(@PathVariable(value = "id") long userId, HttpSession session) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");
        // 成员对象
        Member member = new Member();
        member.setProjectId(project.getId());
        member.setUserId(userId);
        // 如果是项目成员
        if (!memberService.isProjectMember(project.getId(), userId)) {
            session.setAttribute(MessageType.ERROR, "删除成员失败,该成员不是该项目的成员。");
        }
        // 如果是项目组长
        else if (memberService.isProjectCreator(project.getId(), member)) {
            session.setAttribute(MessageType.ERROR, "删除成员失败,怎么能删除组长呢？");
        }
        // 非成员则执行添加
        else if (memberService.deleteMember(member)) {
            session.setAttribute(MessageType.SUCCESS, "删除成员成功。");
        }
        // 执行添加失败
        else {
            session.setAttribute(MessageType.ERROR, "删除成员失败,我也不懂,应该是DAO错了。");
        }
        return redirect("member/list");
    }

    /**
     * 修改成员信息
     */
    @RequestMapping(value = "member/update", method = RequestMethod.POST)
    public String updateMember(Member member, HttpSession session) {
        if (memberService.updateMember(member)) {
            session.setAttribute(MessageType.SUCCESS, "修改成员信息成功。");
        } else {
            session.setAttribute(MessageType.ERROR, "修改成员信息失败。");
        }
        return redirect("member/list");
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

        return "project_member";
    }

    /**
     * [RESTful] 根据name或email对成员模糊查询
     */
    @RequestMapping(value = "api/memberLike", method = RequestMethod.GET)
    @ResponseBody
    public List<Member> queryByNameOrEmail(HttpSession session, String nameorEamil) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");
        return memberService.queryByNameOrEmail(project.getId(), nameorEamil);
    }

    /**
     * [RESTful] 模糊搜索当前项目之外的用户
     */
    @RequestMapping(value = "api/userWithoutProject/{key}", method = RequestMethod.GET)
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
}
