package com.bugpass.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录权限过滤器
 * 
 * @author RuanYaofeng
 * @date 2018-06-06 13:56
 */
@WebFilter(urlPatterns = "/*", initParams = { @WebInitParam(name = "excludedPages", value = "/index.jsp") })
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        System.out.println("LoginFilter()");
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        System.out.println("LoginFilter.destroy()");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("LoginFilter.doFilter()");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            session.setAttribute("actionErrors", "请先登录");
            resp.sendRedirect("index.jsp");
        }

        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("LoginFilter.init()");
    }

}
