package com.bugpass.controller;

import java.util.ArrayList;
import java.util.List;

import com.bugpass.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugpass.entity.Member;
import com.bugpass.service.MemberService;

import javax.servlet.http.HttpSession;

/**
 * TODO 处理成员相关操作的Controller
 * 
 * @author VisonSun
 * @date 2018-07-03 15:49
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * [RESTful] 添加成员信息
     */
    @RequestMapping(value = "/api/addMember", method = RequestMethod.POST)
    public String addMember(Member member, Model model) {
        if (memberService.addMember(member)) {
            return "";
        } else {
            model.addAttribute("errorMessage", "添加失败");
            return "";
        }
    }

    /**
     * [RESTful] 删除成员信息
     */
    @RequestMapping(value = "/api/deleteMember/{m}", method = RequestMethod.DELETE)
    public String deleteMember(@PathVariable(value = "m") Member member, Model model) {
        if (memberService.deleteMember(member)) {
            return "";
        } else {
            model.addAttribute("errorMessage", "删除失败");
            return "";
        }
    }

    /**
     * [RESTful] 修改成员信息
     */
    @RequestMapping(value = "/api/updateMember", method = RequestMethod.PUT)
    @ResponseBody
    public String updateMember(Member member, Model model) {
        if (memberService.updateMember(member)) {
            return "";
        } else {
            model.addAttribute("errorMessage", "修改失败");
            return "";
        }
    }

    /**
     * 查询当前项目成员
     */
    @RequestMapping(value = "project/member", method = RequestMethod.GET)
    public String queryByProjectId(HttpSession session,Model model) {
        // 从session中获取当前项目
        Project project = (Project) session.getAttribute("currentProject");


        List<Member> m = memberService.queryByProjectId(project.getId());
        // 成员列表
        List<Member> memberList = new ArrayList<>();
        // 未确认列表
        List<Member> unconfirmList = new ArrayList<>();
        // 将成员与未确认分开
        m.forEach(item->{
            if (item.getMemberRole() == 0) {
                unconfirmList.add(item);
            } else {
                memberList.add(item);
            }
        });
        model.addAttribute("memberList", memberList);
        model.addAttribute("unconfirmList", unconfirmList);

        return "project_member";
    }

    /**
     * [RESTful] 根据name或email对成员模糊查询
     */
    @RequestMapping(value = "/api/memberLike", method = RequestMethod.GET)
    @ResponseBody
    public List<Member> queryByNameOrEmail(long projectId, String nameorEamil) {
        return memberService.queryByNameOrEmail(projectId, nameorEamil);
    }

}
