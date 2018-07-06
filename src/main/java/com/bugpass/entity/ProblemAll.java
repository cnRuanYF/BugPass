package com.bugpass.entity;

public class ProblemAll {
	private int problem_id;
	private String problem_title;
	private String problem_desc;
	private String problemlevel_name;
	private String problemstatus_name;
	private String problemtype_name;
	private int publisher;
	public int getProblem_id() {
		return problem_id;
	}
	public String getProblem_title() {
		return problem_title;
	}
	public String getProblem_desc() {
		return problem_desc;
	}
	public String getProblemlevel_name() {
		return problemlevel_name;
	}
	public String getProblemstatus_name() {
		return problemstatus_name;
	}
	public String getProblemtype_name() {
		return problemtype_name;
	}
	public int getPublisher() {
		return publisher;
	}
	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}
	public void setProblem_title(String problem_title) {
		this.problem_title = problem_title;
	}
	public void setProblem_desc(String problem_desc) {
		this.problem_desc = problem_desc;
	}
	public void setProblemlevel_name(String problemlevel_name) {
		this.problemlevel_name = problemlevel_name;
	}
	public void setProblemstatus_name(String problemstatus_name) {
		this.problemstatus_name = problemstatus_name;
	}
	public void setProblemtype_name(String problemtype_name) {
		this.problemtype_name = problemtype_name;
	}
	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}
	
	
	
	
}
