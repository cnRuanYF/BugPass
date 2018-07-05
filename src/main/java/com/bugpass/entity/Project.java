package com.bugpass.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目实体类
 * 
 * @author QiuWenYi, ChenZhiJun
 * @date 2018-07-05 14:21
 */
public class Project implements Serializable{

    /* 项目ID */
    private long id;
    /* 项目名 */
    private String projectName;
    /* 项目日期 */
    private Date createTime;
    /* 版本描述 */
    private String projectDesc;
    /* 显示ID */
    private String displayId;
    
		@Override
		public String toString() {
			return "Project [projectId=" + id + ", projectName=" + projectName + ", projectDate=" + createTime
					+ ", projectDesc=" + projectDesc + ", displayId=" + displayId + "]";
		}

		public long getId() {
			return id;
		}
		
		public void setId(long id) {
			this.id = id;
		}
		
		public String getProjectName() {
			return projectName;
		}
		
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		
		public Date getCreateTime() {
			return createTime;
		}
		
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
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