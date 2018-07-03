package com.bugpass.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bugpass.entity.Member;

/**
 * 成员DAO接口
 * 
 * @author VisonSun
 * @date 2018-07-03 11:19
 */
@Repository("memberDao")
public interface MemberDao extends BaseDAO<Member> {

    /**
     * 删除成员
     * 
     * @param member 成员对象（包含项目ID及用户ID）
     * @return 是否删除成功
     */
    boolean deleteMember(Member member);

    /**
     * 根据项目ID查询成员
     * 
     * @param projectId 项目ID
     * @return 查找到的成员对象的集合
     */
    List<Member> queryByProjectId(int projectId);

    /**
     * 根据name或email对成员模糊查询
     * 
     * @param NameorEamil 要查询的字符串
     * @return 查询出的成员集合
     */
    List<Member> queryByNameOrEmail(String nameorEamil);

}
