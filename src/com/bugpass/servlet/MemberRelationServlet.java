package com.bugpass.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bugpass.entity.MemberRelation;
import com.bugpass.service.MemberRelationService;
import com.bugpass.service.impl.MemberRelationServiceImpl;

/**
 * 处理成员关系操作的Servlet
 * 
 * @author QiuWenYi
 * @date 2018年6月8日 下午3:07:19
 */
@WebServlet("/MemberRelationServlet")
public class MemberRelationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    MemberRelationService mrs = new MemberRelationServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRelationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String key = request.getParameter("key");
        String usernameLike = request.getParameter("usernameLike");
        System.out.println(key);
        if ("queryUsernameLike".equals(key)) {
            // int
            // projectId=Integer.parseInt(request.getParameter("projectId"));
            System.out.println("key:" + key + "usernameLike:" + usernameLike);
            List<MemberRelation> memberlist = mrs.findMemberRelationByUserNameLike(usernameLike);
            for (MemberRelation info : memberlist) {
                System.out.println(info);

            }
            request.setAttribute("memberlist", memberlist);
//            request.getRequestDispatcher("back/showMember.jsp").forward(request, response);
            request.getRequestDispatcher("showMember.jsp").forward(request, response);
        }
        if ("queryAll".equals(key)) {
            // int
            // projectId=Integer.parseInt(request.getParameter("projectId"));
            System.out.println("key:" + key);
            List<MemberRelation> memberlist = mrs.findAllMemberRelation();
            for (MemberRelation info : memberlist) {
                System.out.println(info);

            }
            request.setAttribute("memberlist", memberlist);
            //测试界面
//            request.getRequestDispatcher("back/showMember.jsp").forward(request, response);
            request.getRequestDispatcher("showMember.jsp").forward(request, response);
//            request.getRequestDispatcher("back/showMember.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
