package com.bugpass.entity;

public class Problem {
private int problem_id;
private String problem_title;
private String problem_desc;
private int problem_level;
private int problem_status;
private int problem_type;
private int publisher;
private int assigned_to;
private int module_id;
private int version_id;
public int getProblem_id() {
	return problem_id;
}
public String getProblem_title() {
	return problem_title;
}
public String getProblem_desc() {
	return problem_desc;
}
public int getProblem_level() {
	return problem_level;
}
public int getProblem_status() {
	return problem_status;
}
public int getProblem_type() {
	return problem_type;
}
public int getPublisher() {
	return publisher;
}
public int getAssigned_to() {
	return assigned_to;
}
public int getModule_id() {
	return module_id;
}
public int getVersion_id() {
	return version_id;
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
public void setProblem_level(int problem_level) {
	this.problem_level = problem_level;
}
public void setProblem_status(int problem_status) {
	this.problem_status = problem_status;
}
public void setProblem_type(int problem_type) {
	this.problem_type = problem_type;
}
public void setPublisher(int publisher) {
	this.publisher = publisher;
}
public void setAssigned_to(int assigned_to) {
	this.assigned_to = assigned_to;
}
public void setModule_id(int module_id) {
	this.module_id = module_id;
}
public void setVersion_id(int version_id) {
	this.version_id = version_id;
}


}
