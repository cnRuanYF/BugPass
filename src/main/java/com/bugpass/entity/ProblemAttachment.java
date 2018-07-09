package com.bugpass.entity;

import java.io.Serializable;

/**
 * 问题附件实体
 * @author QiuWenYi
 * @date 2018年7月7日 上午11:16:20
 */
public class ProblemAttachment implements Serializable{

    /** 用于联表查询定位结果 */
    private long id;
    
    /** 问题ID*/
    private long problemId;
    /** 附件索引*/
    private long attachIndex;
    /** 附件类型*/
    private long attachType;
    /** 文件路径*/
    private String attachPath;

    public ProblemAttachment() {
        super();
    }

    public ProblemAttachment(long problemId, long attachIndex, long attachType, String attachPath) {
        super();
        this.problemId = problemId;
        this.attachIndex = attachIndex;
        this.attachType = attachType;
        this.attachPath = attachPath;
    }

    
    
    
    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

    
    public long getProblemId() {
        return problemId;
    }

    
    public void setProblemId(long problemId) {
        this.problemId = problemId;
    }

    
    public long getAttachIndex() {
        return attachIndex;
    }

    
    public void setAttachIndex(long attachIndex) {
        this.attachIndex = attachIndex;
    }

    
    public long getAttachType() {
        return attachType;
    }

    
    public void setAttachType(long attachType) {
        this.attachType = attachType;
    }

    
    public String getAttachPath() {
        return attachPath;
    }

    
    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    @Override
    public String toString() {
        return "ProblemAttachment{" +
                "problemId=" + problemId +
                ", attachIndex=" + attachIndex +
                ", attachType=" + attachType +
                ", attachPath='" + attachPath + '\'' +
                '}';
    }

}
