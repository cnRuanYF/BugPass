package com.bugpass.controller;

import com.bugpass.entity.Problem;
import com.bugpass.entity.ProblemAttachment;
import com.bugpass.service.ProblemAttachmentService;
import com.bugpass.service.ProblemService;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author QiuWenYi
 * @date 2018年7月7日 上午11:16:20
 */
@Controller
public class ProblemAttachmentController {

    @Resource
    private ProblemAttachmentService problemAttachmentService;

    int attachIndex = 1;// 用来索引计数用
    //上传图片
    @RequestMapping("upLoad/problemattachment")
    public String addProblemattachment(HttpServletRequest request, HttpSession session,
            ProblemAttachment problemAttachment, @RequestParam MultipartFile[] myfiles) {
        // 将request 转换为 MultipartHttpServletRequest
        // MultipartHttpServletRequest req = (MultipartHttpServletRequest)
        // request;

        for (MultipartFile file : myfiles) {

            System.out.println("自增：" + attachIndex);

            // 得到文件的contentType
            System.out.println("contentType :" + file.getContentType());
            // 得到文件域的名字file.getName() 得到文件名file.getOriginalFilename()
            System.out.println(file.getName() + "," + file.getOriginalFilename());
            // 上传的目标路径
            String path = request.getRealPath("/upLoad") + "/" + file.getOriginalFilename();
            System.out.println("path :" + path);
            // UUID attachIndex = UUID.randomUUID();//索引

            // String attachPath = "http://localhost:9090/BugPass/upLoad/" +
            // attachIndex + file.getOriginalFilename(); // TODO
            String attachPath = "http://localhost:9090/BugPass/upLoad/" + file.getOriginalFilename(); // TODO 图片应该放在那个文件夹？

            // 在session中取当前问题
            /*
             * Problem
             * currentProblem=(Problem)session.getAttribute("currentProblem");
             * long problemId =currentProblem.getId();
             * problemAttachment.setProblemId(problemId);//设置当前问题id
             */
            problemAttachment.setProblemId(4);// TODO 测试用 问题4下面的图片

            problemAttachment.setAttachIndex(attachIndex);
            problemAttachment.setAttachType(1);// TODO 设置文件类型
                                               // 先写默认值为1,这里一暂时理解为图片的状态码,考虑在静态文件中加入
            problemAttachment.setAttachPath(attachPath);// 设置文件路径

            boolean flag = problemAttachmentService.addProblemAttachment(problemAttachment);// 保存到数据库
            if (flag) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
            // 创建目标文件
            File destFile = new File(path);
            try {
                // 直接使用封装好的 copyInputStreamToFile 实现文件的上传功能
                FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            attachIndex++;// 自增

        }

        /*
         * HttpSession session = request.getSession(); //
         * session.setAttribute("imglist", imglist);// TODO 传递到视图
         */
        // problemAttachmentService.findProblemAttachmentByProblemIdId(problemId);//TODO
        // 这里的problem要从sesson中取得，先写为4
        List<ProblemAttachment> imglist = problemAttachmentService.findProblemAttachmentByProblemIdId(4);// TODO
                                                                                                         // 代传入session的problemId
        imglist.forEach(System.out::println);
        session.setAttribute("imglist", imglist);// 传递到视图
        return "showImg";

    }
    //根据问题id查询图片
    @RequestMapping("problemattachment")
    public String showProblemattachment(HttpSession session, Model model) {
       
        // problemAttachmentService.findProblemAttachmentByProblemIdId(problemId);//TODO
        // 这里的problem要从sesson中取得，先写为4
        List<ProblemAttachment> imglist = problemAttachmentService.findProblemAttachmentByProblemIdId(4);// TODO
                                                                                                         // 代传入session的problemId
        imglist.forEach(System.out::println);
        session.setAttribute("imglist", imglist);// 传递到视图
        return "showImg";

    }
}
