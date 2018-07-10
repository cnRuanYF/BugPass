package com.bugpass.controller;

import com.bugpass.constant.MessageType;
import com.bugpass.entity.Discuss;
import com.bugpass.entity.Problem;
import com.bugpass.entity.User;
import com.bugpass.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.bugpass.constant.PageConst.*;

/**
 * 讨论相关操作的Controller
 * 
 * @author QiuWenYi, RuanYaofeng
 * @date 2018年7月4日 下午12:59:06
 */
@Controller
public class DiscussController {

    @Autowired
    private DiscussService discussService;

    ///////////////////////
    //    以下方法可用    //
    ///////////////////////

    /**
     * [RESTful] 获取指定问题的讨论列表
     */
    @RequestMapping(value = "api/discuss/{problemId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Discuss> showDiscuss(@PathVariable("problemId") long problemId) {
        return discussService.findByProblemId(problemId);
    }

    /**
     * 添加评论
     */
    @RequestMapping(value = "discuss/add", method = RequestMethod.POST)
    public String addDiscuss(Discuss discuss, HttpSession session) {
        // 从session中获取登录的用户作为讨论发布者
        User user = (User) session.getAttribute("currentUser");
        discuss.setPublisherUser(user);

        // （问题ID在前端放入隐藏域中）

        // 添加讨论
        if (discussService.addDiscuss(discuss)) {
            session.setAttribute(MessageType.SUCCESS, "发布讨论成功");
        } else {
            session.setAttribute(MessageType.ERROR, "发布讨论失败，请稍后再试");
        }

        return redirect(CTRL_PROBLEM_DETAIL.replace("{id}", discuss.getProblemId() + ""));
    }

    ///////////////////////////////
    //    以下方法未完成/未测试    //
    ///////////////////////////////

    /**
     * 根据传入参数problemId展示讨论信息（废弃）
     */
    /*
     * @RequestMapping(value = "api/discuss/{problemId}", method =
     * RequestMethod.GET) //@ResponseBody public String
     * showDiscuss(@PathVariable(value="problemId")long problemId, Model model)
     * { List<Discuss> discussList=discussService.findByProblemId(problemId);
     * model.addAttribute("discussList", discussList);
     * discussList.forEach(System.out::println); return DISCUSS_PAGE2; }
     */

    /**
     * 跳转到添加评论界面（废弃）
     * 
     * @return
     */
    /*
     * @RequestMapping(value = "api/toAddDiscuss") public String toAddDiscuss()
     * { return "discuss_add"; }
     */

    /**
     * 添加评论（废弃）
     */
    /*
     * @RequestMapping(value = "discuss/add", method = RequestMethod.POST)
     * public String addDiscuss(Discuss discuss,HttpSession session, Model
     * model) { //从session中获取登录的用户 User user = (User)
     * session.getAttribute("currentUser");
     * System.out.println("controllerUser:"+user.getId());
     * discuss.setPublisherUser(user);
     * 
     * // 从session中获取当前项目 // Problem currentProblem = (Problem)
     * session.getAttribute("currentProblem");//session获得当前的problem // long
     * problemId = currentProblem.getId();//获得当前的problemId
     * 
     * int problemId = (int)session.getAttribute("problemId");
     * System.out.println(problemId);// TODO 代删除，偷懒从ye'm //添加评论 boolean flag =
     * discussService.addDiscuss(discuss); if (flag) {
     * model.addAttribute("discuss", discuss); return "redirect:/discuss"; }else
     * { return ERROR_PAGE; // TODO 跳转到错误页 }
     * 
     * }
     */

    /**
     * 删除评论（废弃）
     */
    /*
     * @RequestMapping(value = "api/discuss/{discussId}", method =
     * RequestMethod.DELETE) public String
     * delDiscuss(@PathVariable("discussId")long discussId,HttpSession session)
     * { int problemId = (int)session.getAttribute("problemId");
     * System.out.println(problemId); discussService.delDiscussById(discussId);
     * return "redirect:/api/discuss/"+problemId;//重新获取讨论列表 }
     */

}
