package com.bugpass.entity;
/**
 * 问题信息实体
 * @author xhh
 *
 */
public class ProblemAll {
	/** 问题ID */
	private int problemId;
	/** 问题标题 */
	private String problemTitle;
	/** 问题描述 */
	private String problemDesc;
	/** 问题级别名称 */
	private String problemLevelName;
	/** 问题状态名称 */
	private String problemStatusName;
	/** 问题类型名称 */
	private String problemTypeName;
	/** 发布者 */
	private int publisher;
	public int getProblemId() {
		return problemId;
	}
	public String getProblemTitle() {
		return problemTitle;
	}
	public String getProblemDesc() {
		return problemDesc;
	}
	public String getProblemLevelName() {
		return problemLevelName;
	}
	public String getProblemStatusName() {
		return problemStatusName;
	}
	public String getProblemTypeName() {
		return problemTypeName;
	}
	public int getPublisher() {
		return publisher;
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
	public void setProblemLevelName(String problemLevelName) {
		this.problemLevelName = problemLevelName;
	}
	public void setProblemStatusName(String problemStatusName) {
		this.problemStatusName = problemStatusName;
	}
	public void setProblemTypeName(String problemTypeName) {
		this.problemTypeName = problemTypeName;
	}
	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}
	
	
}
