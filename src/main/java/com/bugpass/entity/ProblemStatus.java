package com.bugpass.entity;


/**
 * 问题状态实体
 * @author xhh
 *
 */
public class ProblemStatus {
	/** 问题状态ID */
	private int problemStatusId;
	/** 问题状态名称 */
	private String problemStatusName;
	public int getProblemStatusId() {
		return problemStatusId;
	}
	public String getProblemStatusName() {
		return problemStatusName;
	}
	public void setProblemStatusId(int problemStatusId) {
		this.problemStatusId = problemStatusId;
	}
	public void setProblemStatusName(String problemStatusName) {
		this.problemStatusName = problemStatusName;
	}



}
