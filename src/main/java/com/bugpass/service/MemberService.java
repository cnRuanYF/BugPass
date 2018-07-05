package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Member;

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
     *            (包含项目ID(project_id)，成员的用户ID(user_id)，成员的角色(member_role))
     * @return 是否添加成功
     */
    boolean addMember(Member member);

    /**
     * 删除成员
     * 
     * @param member 成员对象<br/>
     *            （包含项目ID及用户ID）
     * @return 是否删除成功
     */
    boolean deleteMember(Member member);

    /**
     * 修改成员信息（即修改角色状态）
     * 
     * @param member 成员对象<br/>
     *            (包含项目ID(project_id)，成员的用户ID(user_id)，成员的角色(member_role))
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
     * @param NameorEamil 要查询的字符串
     * @return 查询出的成员集合
     */
    List<Member> queryByNameOrEmail(long projectId,String nameorEamil);

}
