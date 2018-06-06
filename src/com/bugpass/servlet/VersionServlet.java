package com.bugpass.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bugpass.entity.Version;
import com.bugpass.service.VersionService;
import com.bugpass.service.impl.VersionServiceImpl;

/**
 * Servlet implementation class VersionServlet
 */
@WebServlet("/VersionServlet")
public class VersionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       VersionService vs=new VersionServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VersionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String key=request.getParameter("key");
		if ("selectAll".equals(key)) {
			//int projectId=Integer.parseInt(request.getParameter("projectId"));
			List<Version>versions= vs.returnfindAllByProjectid(1);
			for (Version version : versions) {
				System.out.println(version);
			}
			request.setAttribute("versions", versions);
			request.getRequestDispatcher("back/showVersions.jsp").forward(request, response);
		}else if ("selectVersionName".equals(key)) {
			String versionName=request.getParameter("versionName");
			PrintWriter out=response.getWriter();
			if ("".equals(versionName)) {
				out.print("版本号不能为空");
			}else {
				System.out.println(versionName);
				boolean i=vs.returnFindByVersionName(versionName);
				if (i) {
					out.print("版本号已存在，请勿重复创建");
				} 
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
