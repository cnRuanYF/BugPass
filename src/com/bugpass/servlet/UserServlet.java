package com.bugpass.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bugpass.entity.User;
import com.bugpass.service.UserService;
import com.bugpass.service.impl.UserServiceImpl;
import com.bugpass.util.EncryptionUtils;

/**
 * 处理用户登录注册相关操作的Servlet
 * 
 * @author RuanYaofeng
 * @date 2018-06-05 22:37
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/register.checkUsernameExist", "/register.checkPhoneExist", "/register.checkEmailExist","/register.do",
        "/login.do", "/logout.do","/editPersonalInfo.do","/changePassword.do" })
public class UserServlet extends HttpServlet {

    private static final String REGISTER_PAGE = "index.jsp";
    private static final String LOGIN_PAGE = "index.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        switch (request.getServletPath()) {
        case "/logout.do":
            userLogout(request, response);
            break;
        case "/register.checkUsernameExist":
            checkUsernameExist(request, response);
            break;
        case "/register.checkPhoneExist":
            checkPhoneExist(request, response);
            break;
        case "/register.checkEmailExist":
            checkEmailExist(request, response);
            break;
        default:
            break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        switch (request.getServletPath()) {
        case "/register.do":
            userRegister(request, response);
            break;
        case "/login.do":
            userLogin(request, response);
            break;
        case "/editPersonalInfo.do":
      		userEditPersonalInfo(request,response);
      		break;
        case "/changePassword.do":
      		userChangePassword(request,response);
      		break;
        default:
            break;
        }
    }

    /**
     * (Ajax)检查用户名是否存在<br>
     * 返回0：已被占用；1：可用
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void checkUsernameExist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getParameter("username");

        UserService userService = new UserServiceImpl();
        boolean isExist = userService.checkUsernameExist(username);

        PrintWriter writer = response.getWriter();
        writer.print(isExist ? 0 : 1);
        writer.flush();
        writer.close();
    }

    /**
     * (Ajax)检查邮箱是否存在<br>
     * 返回0：已被占用；1：可用
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void checkEmailExist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = (String) request.getParameter("email");

        UserService userService = new UserServiceImpl();
        boolean isExist = userService.checkEmailExist(email);

        PrintWriter writer = response.getWriter();
        writer.print(isExist ? 0 : 1);
        writer.flush();
        writer.close();
    }

    /**
     * (Ajax)检查手机号是否存在<br>
     * 返回0：已被占用；1：可用
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void checkPhoneExist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = (String) request.getParameter("phone");

        UserService userService = new UserServiceImpl();
        boolean isExist = userService.checkPhoneExist(phone);

        PrintWriter writer = response.getWriter();
        writer.print(isExist ? 0 : 1);
        writer.flush();
        writer.close();
    }

    /**
     * 用户注册
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void userRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        // XXX 表单验证
        User user = new User(username, EncryptionUtils.getSHA1(password));

        UserService userService = new UserServiceImpl();
        boolean success = userService.register(user);

        if (success) {
            request.getSession().setAttribute("actionMessages", "注册成功");
        } else {
            request.getSession().setAttribute("actionErrors", "注册失败");
        }

        response.sendRedirect(REGISTER_PAGE);
    }

    /**
     * 用户登录
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        // XXX 表单验证
        UserService userService = new UserServiceImpl();
        User user = userService.findByUsername(username);
        
        if (user == null) {
            request.getSession().setAttribute("actionErrors", "该用户不存在");
        } else if (!user.getPassword().equals(EncryptionUtils.getSHA1(password))) {
            request.getSession().setAttribute("actionErrors", "密码不正确");
        } else {
            request.getSession().setAttribute("actionMessages", "登录成功");
            request.getSession().setAttribute("user", user);
        }

        response.sendRedirect(LOGIN_PAGE);
    }

    /**
     * 退出登录
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect(LOGIN_PAGE);
    }

		/**
     * 修改用户个人信息
		 * @param request
		 * @param response
		 * @throws Exception 
		 */
		private void userEditPersonalInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
			request.setCharacterEncoding("utf-8");
			
			UserService userService = new UserServiceImpl();
			int id = Integer.parseInt(request.getParameter("id"));
			String realname = request.getParameter("realname");
			String phone = request.getParameter("phone");
			String qq = request.getParameter("qq");
			//创建一个用户对象
			User user = new User(id, phone, qq, realname);
			boolean flag = false;
				//调用方法
				try {
					flag = userService.updatePartUser(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			//简单处理提示
			if (flag) {
				response.sendRedirect("project.jsp");
			}
			
		}
		
		/**
		 * 用户修改密码
		 * @param request
		 * @param response
		 */
		private void userChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			UserService userService = new UserServiceImpl();
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			String confirmNewPassword = request.getParameter("confirmNewPassword");
			//获取用户对象
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			
			//测试代码
			/*User user = null;
			try {
				user = ud.findById(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			//判断原密码是否一致
			if (oldPassword.equals(user.getPassword())) {
				//判断两次新密码是否一致
				if (newPassword.equals(confirmNewPassword)) {
					//设置新密码
					user.setPassword(newPassword);
				}
			}
			response.sendRedirect("index.jsp");
		}
}
