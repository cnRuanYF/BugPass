package com.bugpass.test;

import java.util.List;

import com.bugpass.dao.ProjectDAO;
import com.bugpass.dao.impl.ProjectDAOImpl;
import com.bugpass.entity.Project;
import com.bugpass.service.ProjectService;
import com.bugpass.service.impl.ProjectServiceImpl;
/**
 * 项目测试类
 * 
 * @author QiuWenYi
 * @date 2018年6月10日 下午9:45:34
 */
public class ProrjectTest {

    static Project p = new Project();
    static ProjectDAO pd = new ProjectDAOImpl();
    static ProjectService ps = new ProjectServiceImpl();

    public static void main(String[] args) {
        /*
         * List<Project>Projects= vs.returnfindAllByProjectid(1); for (Project
         * Project : Projects) { System.out.println(Project); }
         */
        testDelDao();
    }

    public static void testFindDao() {
        try {
            // List<Project> lst = pd.findByLikename("");
            List<Project> lst = pd.findAll();
            for (Project project : lst) {
                System.out.println(project);

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void testUpdateDao() {
        Project obj=new Project("project3", "project3");
        boolean flag=false;
        try {
            flag = pd.update(obj);
            if(flag) {
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void testDelDao() {
        try {
            boolean flag = pd.deleteByProjectId(4);
            if(flag) {
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void testAddDao() {
        Project obj=new Project("23", "23");
        try {
            boolean flag = pd.add(obj);
            if(flag) {
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
