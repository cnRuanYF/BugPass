package com.bugpass.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理用户登录注册相关操作的Servlet
 * 
 * @author RuanYaofeng
 * @date 2018-06-05 22:37
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "register.do", "login.do", "logout.do" })
public class UserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 退出登录使用get方式
        switch (request.getServletPath()) {
        case "logout.do":
            userLogout(request, response);
            break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 其余操作使用post方式
        switch (request.getServletPath()) {
        case "register.do":
            userRegister(request, response);
            break;
        case "login.do":
            userLogin(request, response);
            break;
        default:
            break;
        }
    }

    /**
     * TODO 用户注册
     */
    private void userRegister(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * TODO 用户登录
     */
    private void userLogin(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * TODO 退出登录
     */
    private void userLogout(HttpServletRequest request, HttpServletResponse response) {

    }

}
