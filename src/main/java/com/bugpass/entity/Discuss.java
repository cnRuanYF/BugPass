package com.bugpass.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 讨论实体
 * @author QiuWenYi
 * @date 2018年7月3日 上午11:19:51
 */
public class Discuss implements Serializable{

    /** 讨论ID */
    private long discussId;
    /** 问题Id */
    private int problemId;
    /** 发布者 */
    private User publisherUser;
    /** 发布时间 */
    private Date publishTime;
    /** 讨论内容 */
    private String discussContent;
    /** 发布者ID */
    private long publisherId;
    
    
    
    
    public long getPublisherId() {
        return publisherId;
    }

    
    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public long getDiscussId() {
        return discussId;
    }
    
    public void setDiscussId(long discussId) {
        this.discussId = discussId;
    }
    
    public int getProblemId() {
        return problemId;
    }
    
    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }
    
    public User getPublisherUser() {
        return publisherUser;
    }
    
    public void setPublisherUser(User publisherUser) {
        this.publisherUser = publisherUser;
    }
    
    public Date getPublishTime() {
        return publishTime;
    }
    
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    
    public String getDiscussContent() {
        return discussContent;
    }
    
    public void setDiscussContent(String discussContent) {
        this.discussContent = discussContent;
    }

    @Override
    public String toString() {
        return "Discuss [discussId=" + discussId + ", problemId=" + problemId + ", publisherUser=" + publisherUser
                + ", publishTime=" + publishTime.toLocaleString() + ", discussContent=" + discussContent +", publisherId="+publisherId+ "]";
    }
    
    
}
