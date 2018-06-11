package com.bugpass.entity;

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
    private int projectId;
    /* 项目名 */
    private String projectName;
    /* 项目日期 */
    private String projectDate;
    /* 版本描述 */
    private String projectDesc;
    @Override
    public String toString() {
        return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDate=" + projectDate
                + ", projectDesc=" + projectDesc + "]";
    }
    public Project(int projectId, String projectName, String projectDate, String projectDesc) {
        super();
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDate = projectDate;
        this.projectDesc = projectDesc;
    }
    public Project(String projectName, String projectDate, String projectDesc) {
        super();
        this.projectName = projectName;
        this.projectDate = projectDate;
        this.projectDesc = projectDesc;
    }
    public Project(String projectName, String projectDesc) {
        super();
        this.projectName = projectName;
        this.projectDesc = projectDesc;
    }
    
    public Project() {
        super();
    }
    
    public int getProjectId() {
        return projectId;
    }
    
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getProjectDate() {
        return projectDate;
    }
    
    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate;
    }
    
    public String getProjectDesc() {
        return projectDesc;
    }
    
    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    

}