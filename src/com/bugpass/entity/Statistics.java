package com.bugpass.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 统计表格数据实体类
 * @author YeHandsome
 * @date 2018-06-07 20:45
 */

public class Statistics {
	private String projectName;
	private String versionName;
	private String problemTitle;
	private String problemLevel;
	private String problemStatus;
	private Date createTime;
	private Date updateTime;
	private String senderName;
	private String receiverName;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public Statistics() {
		// TODO Auto-generated constructor stub
	}

	public Statistics(String projectName, String versionName, String problemTitle, String problemLevel,
			String problemStatus, Date createTime, Date updateTime, String senderName, String receiverName) {
		super();
		this.projectName = projectName;
		this.versionName = versionName;
		this.problemTitle = problemTitle;
		this.problemLevel = problemLevel;
		this.problemStatus = problemStatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.senderName = senderName;
		this.receiverName = receiverName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	public String getProblemLevel() {
		return problemLevel;
	}

	public void setProblemLevel(String problemLevel) {
		this.problemLevel = problemLevel;
	}

	public String getProblemStatus() {
		return problemStatus;
	}

	public void setProblemStatus(String problemStatus) {
		this.problemStatus = problemStatus;
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

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Override
	public String toString() {
		return "Statistics [projectName=" + projectName + ", versionName=" + versionName + ", problemTitle="
				+ problemTitle + ", problemLevel=" + problemLevel + ", problemStatus=" + problemStatus + ", createTime="
				+ sdf.format(createTime) + ", updateTime=" + sdf.format(updateTime) + ", senderName=" + senderName + ", receiverName="
				+ receiverName + "]";
	}

	
	
}
