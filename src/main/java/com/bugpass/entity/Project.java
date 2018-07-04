package com.bugpass.entity;

import java.util.Date;

/**
 * 项目实体类
 * 
 * @author QiuWenYi
 * @date 2018年6月10日 下午2:03:44
 */
public class Project {

    /**
     * projectId projectName projectDate projectDesc
     * 
     */
    /* 项目ID */
    private long projectId;
    /* 项目名 */
    private String projectName;
    /* 项目日期 */
    private Date projectDate;
    /* 版本描述 */
    private String projectDesc;
    /* 显示ID */
    private String displayId;
    
		public Project() {
			super();
		}

		public Project(String projectName, Date projectDate, String projectDesc, String displayId) {
			super();
			this.projectName = projectName;
			this.projectDate = projectDate;
			this.projectDesc = projectDesc;
			this.displayId = displayId;
		}

		public Project(long projectId, String projectName, Date projectDate, String projectDesc, String displayId) {
			super();
			this.projectId = projectId;
			this.projectName = projectName;
			this.projectDate = projectDate;
			this.projectDesc = projectDesc;
			this.displayId = displayId;
		}

		@Override
		public String toString() {
			return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDate=" + projectDate
					+ ", projectDesc=" + projectDesc + ", displayId=" + displayId + "]";
		}

		public long getProjectId() {
			return projectId;
		}
		
		public void setProjectId(long projectId) {
			this.projectId = projectId;
		}
		
		public String getProjectName() {
			return projectName;
		}
		
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		
		public Date getProjectDate() {
			return projectDate;
		}
		
		public void setProjectDate(Date projectDate) {
			this.projectDate = projectDate;
		}
		
		public String getProjectDesc() {
			return projectDesc;
		}
		
		public void setProjectDesc(String projectDesc) {
			this.projectDesc = projectDesc;
		}
		
		public String getDisplayId() {
			return displayId;
		}
		
		public void setDisplayId(String displayId) {
			this.displayId = displayId;
		}
    
}