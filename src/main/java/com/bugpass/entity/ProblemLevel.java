package com.bugpass.entity;


/**
 * 问题级别实体
 * @author xhh
 *
 */
public class ProblemLevel {
	/** 问题级别ID */
	private int problemLevelId;
	/** 问题级别名称 */
	private String problemLevelName;
	public int getProblemLevelId() {
		return problemLevelId;
	}
	public String getProblemLevelName() {
		return problemLevelName;
	}
	public void setProblemLevelId(int problemLevelId) {
		this.problemLevelId = problemLevelId;
	}
	public void setProblemLevelName(String problemLevelName) {
		this.problemLevelName = problemLevelName;
	}




}
