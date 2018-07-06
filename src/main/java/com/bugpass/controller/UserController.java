package com.bugpass.controller;

import com.bugpass.constant.MessageType;
import com.bugpass.entity.User;
import com.bugpass.service.UserService;
import com.bugpass.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.bugpass.constant.PageConst.*;

/**
 * 处理用户登录注册相关操作的Controller
 *
 * @author RuanYaofeng
 * @date 2018/6/29 17:38
 **/
@Controller
public class UserController {

    private static final String ATTRIB_CURRENT_USER = "currentUser";

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
    @RequestMapping(value = "api/searchUser/{key}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> searchByKeyword(@PathVariable("key") String key) {
        //TODO 模拟延时
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return userService.findByKeyword(key);
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public String userRegister(User user, HttpSession session) {

        boolean usernameExist = userService.checkUsernameExist(user.getUsername());
        if (usernameExist) {
            session.setAttribute(MessageType.ERROR, "用户名已存在，注册失败");
            return redirect(CTRL_INDEX);
        }

        boolean success = userService.register(user);
        if (success) {
            session.setAttribute(MessageType.SUCCESS, "注册成功");
            session.setAttribute(ATTRIB_CURRENT_USER, userService.findByUsername(user.getUsername()));
        } else {
            session.setAttribute(MessageType.ERROR, "注册失败，请稍后再试");
        }
        return redirect(CTRL_INDEX);
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public String userLogin(User user, HttpSession session) {
        User fullUser = userService.findByUsername(user.getUsername());

        if (fullUser == null) {
            session.setAttribute(MessageType.ERROR, "该用户不存在");
        } else if (EncryptUtil.getSHA1(user.getPassword() + fullUser.getPasswordSalt()).equals(fullUser.getPasswordHash())) {
            session.setAttribute(MessageType.SUCCESS, "登录成功");
            session.setAttribute(ATTRIB_CURRENT_USER, fullUser);
        } else {
            session.setAttribute(MessageType.ERROR, "密码不正确");
        }
        return redirect(CTRL_INDEX);
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "user/logout", method = RequestMethod.GET)
    public String userLogout(HttpSession session) {
        session.invalidate();
        session.setAttribute(MessageType.SUCCESS, "用户已退出登录");
        return redirect(CTRL_INDEX);
    }

    /**
     * 修改用户个人信息 - 界面
     */
    @RequestMapping(value = CTRL_USER_PROFILE, method = RequestMethod.GET)
    public String updateProfileGet(HttpSession session) {
        User currentUser = (User) session.getAttribute(ATTRIB_CURRENT_USER);
        if (currentUser.getRealname() == null || currentUser.getRealname().equals("")) {
            session.setAttribute(MessageType.WARNING, "建议尽快完善个人信息哦~");
        }
        return PAGE_USER_PROFILE;
    }

    /**
     * 修改用户个人信息 - 提交
     */
    @RequestMapping(value = CTRL_USER_PROFILE, method = RequestMethod.POST)
    public String updateProfilePost(User user, HttpSession session) {

        if (userService.updateUserProfile(user)) {
            User fullUser = userService.findById(user.getId());
            session.setAttribute(ATTRIB_CURRENT_USER, fullUser);
            session.setAttribute(MessageType.SUCCESS, "个人资料修改成功");
        } else {
            session.setAttribute(MessageType.SUCCESS, "操作失败，请稍后再试");
        }

        return redirect(CTRL_USER_PROFILE);
    }

    /**
     * 用户修改密码 - 界面
     */
    @RequestMapping(value = CTRL_USER_CHANGE_PASSWORD, method = RequestMethod.GET)
    public String changePasswordGet() {
        return PAGE_USER_CHANGE_PASSWORD;
    }

    /**
     * 用户修改密码 - 提交
     * TODO 流程待优化
     */
    @RequestMapping(value = CTRL_USER_CHANGE_PASSWORD, method = RequestMethod.POST)
    public String changePasswordPost(String oldPassword, String newPassword, String confirmNewPassword, HttpSession session) {

        User currentUser = (User) session.getAttribute(ATTRIB_CURRENT_USER);

        if (!newPassword.equals(confirmNewPassword)) {
            session.setAttribute(MessageType.ERROR, "两次输入不一致");
        } else if (!EncryptUtil.getSHA1(oldPassword + currentUser.getPasswordSalt()).equals(currentUser.getPasswordHash())) {
            session.setAttribute(MessageType.ERROR, "原密码不正确");
        } else {
            currentUser.setPassword(newPassword);
            boolean success = userService.updateUserPassword(currentUser);

            if (success) {
                session.setAttribute(MessageType.SUCCESS, "密码修改成功");
            } else {
                session.setAttribute(MessageType.ERROR, "操作失败，请稍后再试");
            }
        }

        session.setAttribute(ATTRIB_CURRENT_USER, userService.findById(currentUser.getId()));

        return redirect(CTRL_USER_CHANGE_PASSWORD);
    }
}
