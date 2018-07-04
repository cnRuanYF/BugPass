package com.bugpass.entity;

public class Version {
	/*版本ID*/
	private long versionId;
	/*版本号*/
	private String versionName;
	/*版本说明*/
	//private String versionExplanation;
	/*项目ID*/
	private long projectId;
	/*版本设置时间*/
	//private String versionSetTime;
	
	public Version() {
		super();
	}

	public Version(String versionName, int projectId) {
		super();
		this.versionName = versionName;
		this.projectId = projectId;
	}

	public long getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Version [versionId=" + versionId + ", versionName=" + versionName + ", projectId=" + projectId + "]";
	}
	
	
	
}
