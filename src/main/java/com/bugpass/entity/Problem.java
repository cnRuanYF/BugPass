package com.bugpass.entity;

import java.util.Date;

/**
 * 问题实体
 *
 * @author xhh, RuanYaofeng
 */
public class Problem {
    /**
     * 问题ID
     */
    private long id;

    /**
     * 问题标题
     */
    private String problemTitle;
    /**
     * 问题描述
     */
    private String problemDesc;

    /**
     * 问题级别
     */
    private int problemLevel;
    /**
     * 问题状态
     */
    private int problemStatus;
    /**
     * 问题类型
     */
    private int problemType;

    /**
     * 问题发布者
     */
    private int publisher;
    /**
     * 被指派人
     */
    private int assignedTo;

    /**
     * 项目ID
     */
    private long projectId;
    /**
     * 模块ID
     */
    private long moduleId;
    /**
     * 版本ID
     */
    private long versionId;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public int getProblemLevel() {
        return problemLevel;
    }

    public void setProblemLevel(int problemLevel) {
        this.problemLevel = problemLevel;
    }

    public int getProblemStatus() {
        return problemStatus;
    }

    public void setProblemStatus(int problemStatus) {
        this.problemStatus = problemStatus;
    }

    public int getProblemType() {
        return problemType;
    }

    public void setProblemType(int problemType) {
        this.problemType = problemType;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public long getVersionId() {
        return versionId;
    }

    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", problemTitle='" + problemTitle + '\'' +
                ", problemDesc='" + problemDesc + '\'' +
                ", problemLevel=" + problemLevel +
                ", problemStatus=" + problemStatus +
                ", problemType=" + problemType +
                ", publisher=" + publisher +
                ", assignedTo=" + assignedTo +
                ", projectId=" + projectId +
                ", moduleId=" + moduleId +
                ", versionId=" + versionId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
