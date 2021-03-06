package com.bugpass.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 项目实体类
 * 
 * @author QiuWenYi, ChenZhiJun
 * @date 2018-07-05 14:21
 */
public class Project implements Serializable {

    /** 项目ID */
    private long id;
    /** 项目名  */
    private String projectName;
    /** 项目日期  */
    private Date createTime;
    /** 版本描述  */
    private String projectDesc;
    /** 显示ID */
    private String displayId;
    /** 成员列表 */
    private List<Member> memberList;
    /** 创建者 */
    private User creator;
    /** 模块列表 */
    private List<Module> meduleList;
    /** 版本列表 */
    private List<Version> versionList;
    
    
    
    @Override
    public String toString() {
        return "Project [id=" + id + ", projectName=" + projectName + ", createTime=" + createTime + ", projectDesc="
                + projectDesc + ", displayId=" + displayId + ", memberList=" + memberList + ", creator=" + creator
                + ", meduleList=" + meduleList + ", versionList=" + versionList + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    
    public List<Member> getMemberList() {
        return memberList;
    }

    
    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    
    public User getCreator() {
        return creator;
    }

    
    public void setCreator(User creator) {
        this.creator = creator;
    }

    
    public List<Module> getMeduleList() {
        return meduleList;
    }

    
    public void setMeduleList(List<Module> meduleList) {
        this.meduleList = meduleList;
    }

    
    public List<Version> getVersionList() {
        return versionList;
    }

    
    public void setVersionList(List<Version> versionList) {
        this.versionList = versionList;
    }
    
    
}