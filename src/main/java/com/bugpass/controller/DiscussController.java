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
import com.bugpass.entity.User;
import com.bugpass.service.DiscussService;

/**
 * 讨论相关操作的Controller
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:59:06
 */
@Controller
public class DiscussController {

    private static final String DISCUSS_PAGE = "showDiscuss";//展示页面
    private static final String DISCUSS_PAGE2 = "discuss_info";//展示页面
    private static final String ERROR_PAGE = "index";// TODO //错误页面
    private static final String PAGE_ADD_DISCUSS = "addDiscuss";//添加页面

    @Autowired
    private DiscussService discussService;

    /**
     * [RESTful] 根据problemId展示讨论信息
     */
    @RequestMapping(value = "api/discuss/{problemId}", method = RequestMethod.GET)
    //@ResponseBody
    public String showDiscuss(@PathVariable(value="problemId")long problemId, Model model) {
        List<Discuss> discussList=discussService.findByProblemId(problemId);
        model.addAttribute("discussList", discussList);
        discussList.forEach(System.out::println);
        return DISCUSS_PAGE2;
    }
    
    /**
     * 跳转到添加评论界面
     * 
     * @return
     */
    @RequestMapping(value = "api/toAddDiscuss")
    public String toAddDiscuss() {
        return "discuss_add";
    }
    
    /**
     * 添加评论
     */
    @RequestMapping(value = "api/discuss", method = RequestMethod.POST)
    public String addDiscuss(Discuss discuss,HttpSession session, Model model) {
        //获取登录的用户
        User user = (User) session.getAttribute("currentUser");
        System.out.println("controllerUser:"+user.getId());
        discuss.setPublisherUser(user);
        
        int problemId = (int)session.getAttribute("problemId");
        System.out.println(problemId);
        //添加评论
        boolean flag = discussService.addDiscuss(discuss);
        if (flag) {
            model.addAttribute("discuss", discuss);
            return "redirect:/api/discuss/"+problemId; 
        }else {
            return ERROR_PAGE; // TODO 跳转到错误页
        }

    }


    /**
     * 删除评论
     */
    @RequestMapping(value = "api/discuss/{discussId}", method = RequestMethod.DELETE)
    public String delDiscuss(@PathVariable("discussId")long discussId,HttpSession session) {
        int problemId = (int)session.getAttribute("problemId");
        System.out.println(problemId);
        discussService.delDiscussById(discussId);
        return "redirect:/api/discuss/"+problemId;//重新获取讨论列表
    }


}
