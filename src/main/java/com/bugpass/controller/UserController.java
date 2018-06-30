package com.bugpass.controller;

import com.bugpass.entity.User;
import com.bugpass.service.UserService;
import com.bugpass.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 处理用户登录注册相关操作的Controller
 */
@Controller
public class UserController {

    private static final String LOGIN_PAGE = "index";
    private static final String ERROR_PAGE = "index";

    @Autowired
    private UserService userService;


    /**
     * [RESTful] 检查用户名是否可用
     */
    @RequestMapping(value = "/api/checkUsername", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkUsername(String username) {
        return !userService.checkUsernameExist(username);
    }

    /**
     * [RESTful] 查邮箱是否可用
     */
    @RequestMapping(value = "/api/checkEmail", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkEmailExist(String email) {
        return !userService.checkEmailExist(email);
    }

    /**
     * [RESTful] 检查手机号是否可用
     */
    @RequestMapping(value = "/api/checkPhone", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkPhoneExist(String phone) {
        return !userService.checkPhoneExist(phone);
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/user/register.do", method = RequestMethod.POST)
    public String userRegister(User user, Model model) {

        boolean usernameExist = userService.checkUsernameExist(user.getUsername());
        if (usernameExist) {
            model.addAttribute("errorMessage", "用户名已存在");
            return ERROR_PAGE; // TODO 跳转到错误页
        }

        boolean success = userService.register(user);
        if (success) {
            return LOGIN_PAGE;
        } else {
            model.addAttribute("errorMessage", "注册失败，请稍后再试");
            return "ERROR_PAGE"; // TODO 跳转到错误页
        }
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
    public String userLogin(User user, Model model) {
        User fullUser = userService.findByUsername(user.getUsername());

        if (fullUser == null) {
            model.addAttribute("errorMessage", "该用户不存在");
        } else if (EncryptUtil.getSHA1(user.getPassword() + fullUser.getPasswordSalt()).equals(fullUser.getPasswordHash())) {
            model.addAttribute("successMessage", "登录成功");
            model.addAttribute("user", fullUser);
        } else {
            model.addAttribute("errorMessage", "密码不正确");
        }
        return LOGIN_PAGE;
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/user/logout.do", method = RequestMethod.GET)
    public String userLogout(HttpSession session) {
        session.removeAttribute("user");
        return LOGIN_PAGE;
    }

    /**
     * TODO 修改用户个人信息
     */
    public String updateUserProfile(User user, Model model) {

//        UserService userService = new UserServiceImpl();
//        long id = Long.parseLong(request.getParameter("id"));
//        String realname = request.getParameter("realname");
//        String phone = request.getParameter("phone");
//        String qq = request.getParameter("qq");
//
//        User user = new User(id, phone, qq, realname);
//
//        if (userService.updatePartUser(user)) {
//            user = userService.findById(user.getId());
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect("user_profile.jsp");
        //     }
        return null;
    }

    /**
     * TODO 用户修改密码
     */
    public String updateUserPassword(User user, Model model) {
//        UserService userService;
//        HttpSession session = request.getSession();
//
//        String oldPassword = EncryptUtil.getSHA1(request.getParameter("oldPassword"));
//        String newPassword = EncryptUtil.getSHA1(request.getParameter("newPassword"));
//        String confirmNewPassword = EncryptUtil.getSHA1(request.getParameter("confirmNewPassword"));
//
//        User user = (User) session.getAttribute("user");
//
//        if (!newPassword.equals(confirmNewPassword)) {
//            session.setAttribute("actionErrors", "两次输入不一致");
//        } else if (!oldPassword.equals(user.getPassword())) {
//            session.setAttribute("actionErrors", "原密码不正确");
//        } else {
//            userService = new UserServiceImpl();
//            user.setPassword(newPassword);
//            boolean success = userService.updateUserProfile(user);
//
//            if (success) {
//                session.setAttribute("actionMessages", "修改成功");
//            } else {
//                session.setAttribute("actionErrors", "操作失败");
//            }
//        }
//
//        response.sendRedirect("user_change_password.jsp");
        return null;
    }
}
