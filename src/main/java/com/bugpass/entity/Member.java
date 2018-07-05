package com.bugpass.entity;

import java.io.Serializable;

/**
 * 成员实体类
 * 
 * @author VisonSun
 * @date 2018-07-03 11:16
 */
public class Member implements Serializable {

    private static final long serialVersionUID = -2627788005217266716L;

    /**
     * 用于联表查询定位结果
     */
    private int id;
    
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

    private int userId;
    
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

    public Member(long projectId, int userId, int memberRole) {
        super();
        this.projectId = projectId;
        this.memberRole = memberRole;
        this.userId = userId;
    }

    public Member() {
        super();
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Member [projectId=" + projectId + ", user=" + user + ", memberRole=" + memberRole + "]";
    }

}
