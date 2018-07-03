package com.bugpass.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bugpass.dao.MemberDao;
import com.bugpass.entity.Member;

/**
 * TestMemberDao
 * 
 * @author VisonSun
 * @date 2018-07-03 16:31
 */
@RunWith(SpringJUnit4ClassRunner.class) // 配置单元测试的Runner
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
// 配置Spring配置文件路径
public class TestMemberDao {

    @Autowired
    private MemberDao memberDao;

    /* 测试用Member对象 */
    private Member member = new Member(2, 1, 1);

    /**
     * 测试添加成员信息<br/>
     * result - success
     */
    @Test
    public void testAdd() {
        System.out.println(memberDao.add(member));
    }

    /**
     * 测试修改成员信息<br/>
     * result - success
     */
    @Test
    public void testUpdate() {
        System.out.println(memberDao.update(member));
    }

    /**
     * 测试删除成员信息<br/>
     * result - success
     */
    @Test
    public void testDelete() {
        System.out.println(memberDao.deleteMember(member));
    }

    /**
     * 测试按项目ID查询该项目的成员<br/>
     * result - success
     */
    @Test
    public void testProjectMember() {
        List<Member> list = memberDao.queryByProjectId(1);
        list.forEach(System.out::println);
    }

    /**
     * 测试模糊查询(用户真名/用户邮箱)<br/>
     * result - success
     */
    @Test
    public void testQueryLike() {
        List<Member> list = memberDao.queryByNameOrEmail("ad");
        list.forEach(System.out::println);
    }

}
