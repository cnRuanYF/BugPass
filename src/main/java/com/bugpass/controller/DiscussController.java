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
import com.bugpass.entity.Problem;
import com.bugpass.entity.User;
import com.bugpass.service.DiscussService;

/**
 * 讨论相关操作的Controller
 * 
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:59:06
 */
@Controller
public class DiscussController {

    private static final String DISCUSS_PAGE = "showDiscuss";// 展示页面
    private static final String DISCUSS_PAGE2 = "discuss_info";// 展示页面
    private static final String ERROR_PAGE = "index";// TODO //错误页面
    private static final String PAGE_ADD_DISCUSS = "addDiscuss";// 添加页面

    @Autowired
    private DiscussService discussService;

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
     * 根据session中的problemId展示讨论信息
     */
    @RequestMapping(value = "discuss", method = RequestMethod.GET)
    // @ResponseBody
    public String showDiscuss(HttpSession session, Model model) {
        /*
         * 用来测试用session中放入当前问题 TODO 整进去就删除这个   测试用
         */
        Problem currentProblem = new Problem();
        currentProblem.setId(1);
        session.setAttribute("currentProblem", currentProblem);
        /*************************
         * currentProblem的测试代码到这里结束，删到这里
         **********************************/
        // 从session中获取当前项目
        currentProblem = (Problem) session.getAttribute("currentProblem");// session获得当前的problem
        List<Discuss> discussList = discussService.findByProblemId(currentProblem.getId());// 得到当前问题id对应的所有讨论信息

        // List<Discuss> discussList=discussService.findByProblemId(1);// TODO
        // 带整合，先用problemId=1做测试，后面删除
        model.addAttribute("discussList", discussList);
        // discussList.forEach(System.out::println);//测试用
        return DISCUSS_PAGE2;
    }

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
     * 添加评论
     */
    @RequestMapping(value = "discuss/add", method = RequestMethod.POST)
    public String addDiscuss(Discuss discuss, HttpSession session, Model model) {
        // 从session中获取登录的用户
        User user = (User) session.getAttribute("currentUser");
        System.out.println("controllerUser:" + user.getId());
        System.out.println(user);
        discuss.setPublisherUser(user);// 添加进讨论的时候，需要得到user对象作为参数

        // 从session中获取当前项目
        Problem currentProblem = (Problem) session.getAttribute("currentProblem");// session获得当前的problem
        long problemId = currentProblem.getId();// 获得当前的problemId
        discuss.setProblemId(problemId);

        /*
         * int problemId = (int)session.getAttribute("problemId");
         * System.out.println(problemId);
         */// TODO 代删除，偷懒从页面直接传入session->problemId到控制器，接收，传入disscuss对象中

        // discuss.setProblemId(1);// TODO 测试用来构建对象
        // 添加评论
        boolean flag = discussService.addDiscuss(discuss);
        if (flag) {
            model.addAttribute("discuss", discuss);
            return "redirect:/discuss";
        } else {
            return ERROR_PAGE; // TODO 跳转到错误页
        }

    }

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
