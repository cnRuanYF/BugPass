package com.bugpass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 处理用户登录注册相关操作的Controller
 */
@Controller
public class IndexController {

    private static final String INDEX_PAGE = "index";

    /**
     * 跳转到首页
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndex() {
        return INDEX_PAGE;
    }

}
