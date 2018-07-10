package com.bugpass.constant;

/**
 * 页面、控制器路径常量
 */
public class PageConst {

    /*
     * 页面地址 --------------------------------
     */

    // 首页
    public static final String PAGE_INDEX = "index";

    // 提示页
    public static final String PAGE_TIP_CHOOSE_PROJECT = "tip_choose_project";

    // 项目相关
    public static final String PAGE_PROJECT_SUMMARY = "project_summary";
    public static final String PAGE_PROJECT_INFO = "project_info";

    // 模块
    public static final String PAGE_MODULE_MANAGE = "project_module";

    // 版本
    public static final String PAGE_VERSION_MANAGE = "project_version";

    // 成员
    public static final String PAGE_MEMBER_MANAGE = "project_member";

    // 问题相关
    public static final String PAGE_PROBLEM_LIST = "problem_list";
    public static final String PAGE_PROBLEM_DETAIL = "problem_detail";
    public static final String PAGE_PROBLEM_EDIT = "problem_edit";

    // 个人中心相关
    public static final String PAGE_USER_PROFILE = "user_profile";
    public static final String PAGE_USER_CHANGE_PASSWORD = "user_change_password";

    /*
     * 控制器地址 --------------------------------
     */

    // 首页
    public static final String CTRL_INDEX = "index";

    // 进入系统
    public static final String CTRL_ENTER = "enter";

    // 项目相关
    public static final String CTRL_PROJECT_CREATE = "project/create";
    public static final String CTRL_PROJECT_SWITCH = "project/switch/{id}";
    public static final String CTRL_PROJECT_SUMMARY = "project/summary";
    public static final String CTRL_PROJECT_INFO = "project/info";
    public static final String CTRL_PROJECT_DELETE = "project/delete/{id}";

    // 模块管理
    public static final String API_MODULE = "api/module/{id}";
    public static final String CTRL_MODULE = "module";
    public static final String CTRL_MODULE_ADD = "module/add";
    public static final String CTRL_MODULE_DELETE = "module/delete/{id}";
    public static final String CTRL_MODULE_UPDATE = "module/update";

    // 版本管理
    public static final String CTRL_VERSION = "version";
    public static final String CTRL_VERSION_ADD = "version/add";
    public static final String CTRL_VERSION_DELETE = "version/delete/{id}";
    public static final String CTRL_VERSION_UPDATE = "version/update";

    // TODO 待优化: 成员管理控制器地址转常量

    // 问题相关
    public static final String CTRL_PROBLEM_LIST = "problem";
    public static final String CTRL_PROBLEM_ADD = "problem/add";
    public static final String CTRL_PROBLEM_DETAIL = "problem/{id}";
    public static final String CTRL_PROBLEM_EDIT = "problem/edit/{id}";

    // 个人中心相关
    public static final String CTRL_USER_PROFILE = "user/updateProfile";
    public static final String CTRL_USER_CHANGE_PASSWORD = "user/changePassword";


    /**
     * 返回重定向地址
     * @param url 原地址
     * @return 重定向的地址
     */
    public static String redirect(String url) {
        return "redirect:/" + url;
    }
}
