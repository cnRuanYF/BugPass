package com.bugpass.dao;

import java.util.List;

import com.bugpass.entity.Project;
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
    List<Member> queryByProjectId(long projectId);

    /**
     * 根据name或email模糊查询指定项目的成员
     *
     * @param projectId   项目ID
     * @param nameorEamil 要查询的字符串
     * @return 查询出的成员集合
     */
    List<Member> queryByNameOrEmail(long projectId, String nameorEamil);

    /**
     * 根据项目ID+用户ID查询成员
     *
     * @param userId    用户ID
     * @param projectId 项目ID
     * @return 成员对象
     */
    Member queryByProjectIdAndUserId(long userId, long projectId);

    /**
     * 获取项目列表
     *
     * @param userId 用户ID
     * @return 项目列表
     */
    List<Project> getProjectByRoleIsZero(long userId);
}
