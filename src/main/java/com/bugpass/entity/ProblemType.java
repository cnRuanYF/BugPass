package com.bugpass.entity;


/**
 * 问题类型实体
 * @author xhh
 *
 */
public class ProblemType {
	/** 问题类型ID */
	private int problemTypeId;
	/** 问题类型名称 */
	private String problemTypeName;
	public int getProblemTypeId() {
		return problemTypeId;
	}
	public String getProblemTypeName() {
		return problemTypeName;
	}
	public void setProblemTypeId(int problemTypeId) {
		this.problemTypeId = problemTypeId;
	}
	public void setProblemTypeName(String problemTypeName) {
		this.problemTypeName = problemTypeName;
	}


}
