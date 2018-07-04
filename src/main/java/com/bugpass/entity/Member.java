package com.bugpass.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 成员实体类
 * 
 * @author VisonSun
 * @date 2018-07-03 11:16
 */
public class Member implements Serializable {

    private static final long serialVersionUID = -2627788005217266716L;
    /**
     * 创建者
     */
    public static final int ROLE_CREATOR = 1;
    /**
     * 成员
     */
    public static final int ROLE_MEMBER = 2;
    /**
     * 未确认
     */
    public static final int ROLE_UNCOMFIRMED = 0;

    /****************************************************************************/

    /**
     * 项目ID
     */
    private long projectId;

    /**
     * 本用户的实体
     */
    private User user;

    /**
     * 角色
     */
    private int memberRole;

    /**
     * 成员类的构造
     * 
     * @param projectId 项目ID
     * @param userId 成员用户ID
     * @param memberRole 成员角色
     */
    public Member(long projectId, long userId, int memberRole) {
        super();
        this.projectId = projectId;
        this.memberRole = memberRole;
        User u = null;
        u.setId(userId);
    }

    public Member() {
        super();
    }

    /**
     * @return the projectId
     */
    public long getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the memberRole
     */
    public int getMemberRole() {
        return memberRole;
    }

    /**
     * @param memberRole the memberRole to set
     */
    public void setMemberRole(int memberRole) {
        this.memberRole = memberRole;
    }

}
