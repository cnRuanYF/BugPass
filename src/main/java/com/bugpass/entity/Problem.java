package com.bugpass.entity;
/**
 * 问题实体
 * @author xhh
 *
 */
public class Problem {
	 /** 问题ID */
	private int problemId;
	 /** 问题标题 */
	private String problemTitle;
	 /** 问题描述 */
	private String problemDesc;
	 /** 问题级别 */
	private int problemLevel;
	 /** 问题状态 */
	private int problemStatus;
	 /** 问题类型 */
	private int problemType;
	 /** 问题发布者 */
	private int publisher;
	 /** 被指派人 */
	private int assignedTo;
	 /** 模块ID */
	private int moduleId;
	 /** 版本ID */
	private int versionId;

	public int getProblemId() {
		return problemId;
	}
	public String getProblemTitle() {
		return problemTitle;
	}
	public String getProblemDesc() {
		return problemDesc;
	}
	public int getProblemLevel() {
		return problemLevel;
	}
	public int getProblemStatus() {
		return problemStatus;
	}
	public int getProblemType() {
		return problemType;
	}
	public int getPublisher() {
		return publisher;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public int getModuleId() {
		return moduleId;
	}
	public int getVersionId() {
		return versionId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}
	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	public void setProblemLevel(int problemLevel) {
		this.problemLevel = problemLevel;
	}
	public void setProblemStatus(int problemStatus) {
		this.problemStatus = problemStatus;
	}
	public void setProblemType(int problemType) {
		this.problemType = problemType;
	}
	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}


}
