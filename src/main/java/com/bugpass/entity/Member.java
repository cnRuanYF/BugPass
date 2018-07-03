package com.bugpass.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 成员实体类
 * 
 * @author VisonSun
 * @date 2018-07-03 11:16
 */
public class Member implements Serializable{

    private static final long serialVersionUID = -2627788005217266716L;
    
    /**
     * 项目ID
     */
    private int projectId;
    /**
     * 成员的集合
     */
    private List<User> users;
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 角色
     */
    private int memberRole;

    
    public Member(int projectId, int userId, int memberRole) {
        super();
        this.projectId = projectId;
        this.userId = userId;
        this.memberRole = memberRole;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Member [projectId=" + projectId + ", users=" + users + ", userId=" + userId + ", memberRole="
                + memberRole + "]";
    }

    public Member() {
        super();
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @param projectId the projectId to set
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
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
