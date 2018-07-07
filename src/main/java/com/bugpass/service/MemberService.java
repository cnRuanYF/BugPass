package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Member;
import com.bugpass.entity.Project;
import com.bugpass.entity.User;

/**
 * 成员相关业务接口
 *
 * @author VisonSun
 * @date 2018-07-03 15:27
 */
public interface MemberService {

    /**
     * 添加成员
     *
     * @param member 成员对象<br/>
     *               (包含项目ID(project_id)，成员的用户ID(user_id)，成员的角色(member_role))
     * @return 是否添加成功
     */
    boolean addMember(Member member);

    /**
     * 删除成员
     *
     * @param member 成员对象<br/>
     *               （包含项目ID及用户ID）
     * @return 删除返回的信息
     */
    boolean deleteMember(Member member);

    /**
     * 修改成员信息（即修改角色状态）
     *
     * @param member 成员对象<br/>
     *               (包含项目ID(project_id)，成员的用户ID(user_id)，成员的角色(member_role))
     * @return 是否修改成功
     */
    boolean updateMember(Member member);

    /**
     * 根据项目ID查询成员
     *
     * @param projectId 项目ID
     * @return 查找到的成员对象的集合
     */
    List<Member> queryByProjectId(long projectId);

    /**
     * 根据name或email对成员模糊查询
     *
     * @param nameorEamil 要查询的字符串
     * @return 查询出的成员集合
     */
    List<Member> queryByNameOrEmail(long projectId, String nameorEamil);

    /**
     * 模糊搜索当前项目之外的用户
     *
     * @param userList   模糊搜索出的用户集合
     * @param memberList 该项目的成员集合
     * @return 筛选掉已经是成员的用户集合
     */
    List<User> searchWithoutProject(List<User> userList, List<Member> memberList);

    /**
     * 当前项目的成员和创建者
     *
     * @param list 所有状态的成员
     * @return 成员集合
     */
    List<Member> memberForProject(List<Member> list);

    /**
     * 当前项目的未确定者
     *
     * @param list 所有状态的成员
     * @return 成员集合
     */
    List<Member> unconfirmForProject(List<Member> list);

    /**
     * 判断是否为项目成员或被邀请
     *
     * @param projectId 项目ID
     * @param userId    成员ID
     * @return 是否为项目成员
     */
    boolean isProjectMember(long projectId, long userId);

    /**
     * 判断是否为项目组长
     *
     * @param projectId 项目ID
     * @param member    成员对象
     * @return 是否为项目组长
     */
    @Deprecated
    boolean isProjectCreator(long projectId, Member member);

    /**
     * 是否是项目成员
     *
     * @param id     项目id
     * @param userId 用户id
     * @return 是否為項目成員
     */
    boolean isMember(long id, long userId);

    /**
     * 是否被邀请了
     *
     * @param id     项目id
     * @param userId 用户id
     * @return 是否已被邀请
     */
    boolean isInvited(long id, long userId);

    /**
     * 是否为创建者
     *
     * @param projectId 项目ID
     * @param userId    用户ID
     * @return 是否为创建者
     */
    boolean isCreator(long projectId, long userId);

    /**
     * 获取用户的被邀请项目列表
     *
     * @param userId 用户ID
     * @return 项目列表
     */
    List<Project> getInvitation(long userId);
}
