package com.bugpass.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bugpass.entity.Project;
import com.bugpass.service.ProjectService;
import com.bugpass.service.impl.ProjectServiceImpl;

/**
 * 项目控制类
 * 
 * @author QiuWenYi
 * @date 2018年6月10日 下午9:44:35
 */
@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {

    private static final long serialProjectUID = 1L;
    ProjectService ps = new ProjectServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * 查询所有
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doFindAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Project> projects = ps.returnfindAll();
        for (Project project : projects) {
            System.out.println(project);// 暂且输出该项目的信息
        }
        request.setAttribute("projects", projects);// 把项目的信息设置到request中
        request.getRequestDispatcher("back/showProject.jsp").forward(request, response);
    }

    /**
     * 查询，暂时不用
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doSelectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 查询项目的id
        // int projectId=Integer.parseInt(request.getParameter("projectId"));
        List<Project> projects = ps.returnfindAllByProjectid(1);// 先写死，获取第一个项目的id
        for (Project project : projects) {
            System.out.println(project);// 暂且输出该项目的信息
        }
        request.setAttribute("projects", projects);// 把项目的信息设置到request中
        request.getRequestDispatcher("back/showProject.jsp").forward(request, response);
    }

    /**
     * 根据名字查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doSelectProjectName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String projectName = request.getParameter("projectName");

        System.out.println("projectName：" + projectName);
        PrintWriter out = response.getWriter();
        if ("".equals(projectName)) {
            out.print("项目名不能为空");
        } else {
            System.out.println("projectName：" + projectName);
            boolean i = ps.returnFindByProjectName(projectName);
            if (i) {
                out.print("项目名已存在，请勿重复创建");
            }
        }
    }

    /**
     * 添加项目
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String projectName = request.getParameter("projectName");
        String projectDesc = request.getParameter("projectDesc");
        System.out.println(projectName + "," + projectDesc);
        Project p = new Project();
        p.setProjectName(projectName);
        p.setProjectDesc(projectDesc);
        boolean flag = ps.returnAdd(p);

        out.print(flag);
    }

    /**
     * 删除
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doDele(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        System.out.println("*****************");
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        System.out.println(projectId);
        boolean flag = ps.returndeleteByProjectId(projectId);
        out.print(flag);
    }

    /**
     * 根据projectId查询
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doSelectOne(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("projectId"));
        PrintWriter out = response.getWriter();
        out.print(ps.returnFindById(id).getProjectName());
    }

    /**
     * 更新
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("进入到update");
        Project p = new Project();
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String projectName = request.getParameter("projectNewName");
        String projectNewDesc = request.getParameter("projectNewDesc");
        p.setProjectId(projectId);
        p.setProjectName(projectName);
        p.setProjectDesc(projectNewDesc);
        //System.out.println("输出一下，" + projectId + "," + projectName + "," + projectNewDesc);
        System.out.println(p);
        PrintWriter out = response.getWriter();
        boolean flag = ps.returnUpdate(p);
        out.print(flag);
    }

    /**
     * 模糊查询
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doSelectByLike(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String projectName = request.getParameter("projectLike");
        if (projectName.equals("")) {
            // List<Project> projects = ps.returnfindAllByProjectid(1);
            List<Project> projects = ps.returnfindAll();
            for (Project project : projects) {
                System.out.println(projects);
            }
            request.setAttribute("projects", projects);
            request.getRequestDispatcher("back/showProject.jsp").forward(request, response);
        } else {
            List<Project> projects = ps.returnListFindByProjectName(projectName);
            for (Project Project : projects) {
                System.out.println(projects);
            }
            request.setAttribute("projects", projects);
            request.setAttribute("ProjectLike", projectName);
            request.getRequestDispatcher("back/showProject.jsp").forward(request, response);
        }
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
        System.out.println(key);
        if ("selectAll".equals(key)) {
            doSelectAll(request, response);
        } else if ("selectProjectName".equals(key)) {
            doSelectProjectName(request, response);
        } else if ("add".equals(key)) {
            doAdd(request, response);
        } else if ("dele".equals(key)) {
            doDele(request, response);
        } else if ("findAll".equals(key)) {
            doFindAll(request, response);
        } else if ("selectOne".equals(key)) {
            doSelectOne(request, response);
        } else if ("update".equals(key)) {
            doUpdate(request, response);
        } else if ("selectByLike".equals(key)) {
            doSelectByLike(request, response);
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
