package com.bugpass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugpass.entity.Member;
import com.bugpass.service.MemberService;

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
    @RequestMapping(value = "/api/deleteMember", method = RequestMethod.DELETE)
    public String deleteMember(Member member, Model model) {
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
     * [RESTful] 根据项目ID查询成员
     */
    @RequestMapping(value = "/api/projectMember", method = RequestMethod.GET)
    @ResponseBody
    public List<Member> queryByProjectId(int projectId) {
        return memberService.queryByProjectId(projectId);
    }

    /**
     * [RESTful] 根据name或email对成员模糊查询
     */
    @RequestMapping(value = "/api/memberLike", method = RequestMethod.GET)
    @ResponseBody
    public List<Member> queryByNameOrEmail(String nameorEamil) {
        return memberService.queryByNameOrEmail(nameorEamil);
    }

}
