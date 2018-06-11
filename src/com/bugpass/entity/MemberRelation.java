package com.bugpass.entity;

/**
 * 成员关系实体
 * 
 * @author QiuWenYi
 * @date 2018年6月8日 下午2:25:14
 */
public class MemberRelation {

    /** 项目名 */
    private String projectName;
    /** 用户名 */
    private String username;
    /** 邮箱 */
    private String email;
    /** 角色 */
    private String role;
    
    
    public MemberRelation() {
        super();
    }

    public MemberRelation(String projectName, String username, String email, String role) {
        super();
        this.projectName = projectName;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    
    public String getProjectName() {
        return projectName;
    }

    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getRole() {
        return role;
    }

    
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "成员管理 [projectName=" + projectName + ", username=" + username + ", email=" + email + ", role="
                + role + "]";
    }
    
    
}
