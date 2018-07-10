package com.bugpass.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题相关的常量
 *
 * @author VisonSun
 * @date 2018/7/10 0:22
 */
public class ProblemConst {

    public static final Map PROBLEM_LEVEL_MAP;
    public static final Map PROBLEM_STATUS_MAP;
    public static final Map PROBLEM_TYPE_MAP;

    static {
        PROBLEM_LEVEL_MAP = new HashMap();
        PROBLEM_LEVEL_MAP.put(3,"非常重要");
        PROBLEM_LEVEL_MAP.put(2,"重要");
        PROBLEM_LEVEL_MAP.put(1,"一般");
        PROBLEM_LEVEL_MAP.put(0,"不重要");

        PROBLEM_STATUS_MAP = new HashMap();
        PROBLEM_STATUS_MAP.put(0,"已解决");
        PROBLEM_STATUS_MAP.put(1,"进行中");
        PROBLEM_STATUS_MAP.put(2,"新建");

        PROBLEM_TYPE_MAP = new HashMap();
        PROBLEM_TYPE_MAP.put(0,"其他");
        PROBLEM_TYPE_MAP.put(1,"反馈");
        PROBLEM_TYPE_MAP.put(2,"崩溃");
        PROBLEM_TYPE_MAP.put(3,"异常");
        PROBLEM_TYPE_MAP.put(4,"功能");
        PROBLEM_TYPE_MAP.put(5,"UI");
        PROBLEM_TYPE_MAP.put(6,"需求");
        PROBLEM_TYPE_MAP.put(7,"任务");
    }

    // 问题类型
    /** 任务 */
    public static final int PROBLEM_TYPE_MISSION = 7;
    /** 需求 */
    public static final int PROBLEM_TYPE_REQUIREMENT = 6;
    /** UI */
    public static final int PROBLEM_TYPE_UI = 5;
    /** 功能 */
    public static final int PROBLEM_TYPE_FUNCTION = 4;
    /** 异常 */
    public static final int PROBLEM_TYPE_EXCEPTION = 3;
    /** 崩溃 */
    public static final int PROBLEM_TYPE_CRASH = 2;
    /** 反馈 */
    public static final int PROBLEM_TYPE_FEEDBACK = 1;
    /** 其他 */
    public static final int PROBLEM_TYPE_OTHER = 0;

    // 问题状态
    /** 新建 */
    public static final int PROBLEM_STATUS_DOING = 2;
    /** 进行中 */
    public static final int PROBLEM_STATUS_NEW = 1;
    /** 已解决 */
    public static final int PROBLEM_STATUS_RESOLVED = 0;

    // 问题级别
    /** 最重要 */
    public static final int PROBLEM_LEVEL_ABOVE_ALL = 3;
    /** 重要 */
    public static final int PROBLEM_LEVEL_IMPORTANT = 2;
    /** 一般 */
    public static final int PROBLEM_LEVEL_NORMAL = 1;
    /** 不重要 */
    public static final int PROBLEM_LEVEL_UNIMPORTANCE = 0;



}
