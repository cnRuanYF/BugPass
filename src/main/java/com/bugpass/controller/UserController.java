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
import java.util.List;

/**
 * 处理用户登录注册相关操作的Controller
 *
 * @author RuanYaofeng
 * @date 2018/6/29 17:38
 **/
@Controller
public class UserController {

    private static final String LOGIN_PAGE = "index";
    private static final String ERROR_PAGE = "index";
    private static final String PAGE_USER_PROFILE = "user_profile";
    private static final String PAGE_CHANGE_PASSWORD = "user_change_password";

    @Autowired
    private UserService userService;

    /**
     * [RESTful] 检查用户名是否可用
     */
    @RequestMapping(value = "api/checkUsername", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkUsername(String username) {
        return !userService.checkUsernameExist(username);
    }

    /**
     * [RESTful] 查邮箱是否可用
     */
    @RequestMapping(value = "api/checkEmail", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkEmailExist(String email) {
        return !userService.checkEmailExist(email);
    }

    /**
     * [RESTful] 检查手机号是否可用
     */
    @RequestMapping(value = "api/checkPhone", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkPhoneExist(String phone) {
        return !userService.checkPhoneExist(phone);
    }

    /**
     * [RESTful] 关键词搜索用户
     */
    @RequestMapping(value="api/searchUser",method=RequestMethod.GET)
    @ResponseBody
    public List<User> searchByKeyword(String k){
        return userService.findByKeyword(k);
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "user/register", method = RequestMethod.POST)
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
            return ERROR_PAGE; // TODO 跳转到错误页
        }
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "user/login", method = RequestMethod.POST)
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
    @RequestMapping(value = "user/logout", method = RequestMethod.GET)
    public String userLogout(HttpSession session) {
        session.removeAttribute("user");
        return LOGIN_PAGE;
    }

    /**
     * 修改用户个人信息-界面
     */
    @RequestMapping(value = "user/updateProfile", method = RequestMethod.GET)
    public String updateProfileUI() {
        return PAGE_USER_PROFILE;
    }

    /**
     * 修改用户个人信息-提交
     */
    @RequestMapping(value = "user/updateProfile", method = RequestMethod.POST)
    public String updateProfile(User user, Model model) {

        userService.updateUserProfile(user);
        User fullUser = userService.findById(user.getId());
        model.addAttribute("user", fullUser);

        return PAGE_USER_PROFILE;
    }

    /**
     * 用户修改密码-界面
     */
    @RequestMapping(value = "user/changePassword", method = RequestMethod.GET)
    public String changePasswordUI() {
        return PAGE_CHANGE_PASSWORD;
    }

    /**
     * TODO 用户修改密码-提交
     */
    @RequestMapping(value = "user/changePassword", method = RequestMethod.POST)
    public String changePassword(User user, Model model) {

        if(userService.updateUserPassword(user)){
            User fullUser = userService.findById(user.getId());
            model.addAttribute("user",fullUser);
            model.addAttribute("successMessage", "该用户不存在");
        }else {            model.addAttribute("errorMessage", "修改失败，");
        }
        return PAGE_CHANGE_PASSWORD;
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
//        return null;
    }
}
