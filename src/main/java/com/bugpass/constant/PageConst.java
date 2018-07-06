package com.bugpass.constant;

/**
 * 页面、控制器路径常量
 */
public class PageConst {

    /* ****************
     * 页面地址
     * **************** */
    public static final String PAGE_INDEX = "index";

    public static final String PAGE_TIP_CHOOSE_PROJECT = "tip_choose_project";

    public static final String PAGE_USER_PROFILE = "user_profile";
    public static final String PAGE_USER_CHANGE_PASSWORD = "user_change_password";

    public static final String PAGE_PROJECT_SUMMARY = "project_summary";
    public static final String PAGE_PROJECT_INFO = "project_info";

    /* ****************
     * 控制器地址
     * **************** */
    public static final String CTRL_INDEX = "index";
    public static final String CTRL_ENTER = "enter";

    public static final String CTRL_PROJECT_CREATE = "project/create";
    public static final String CTRL_PROJECT_SWITCH = "project/switch/{id}";
    public static final String CTRL_PROJECT_SUMMARY = "project/summary";
    public static final String CTRL_PROJECT_INFO = "project/info";

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
