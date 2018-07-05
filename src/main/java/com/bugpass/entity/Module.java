package com.bugpass.entity;

import java.io.Serializable;

/**
 * 模块实体
 * @author QiuWenYi
 * @date 2018年7月5日 下午2:09:13
 */
public class Module implements Serializable {
    /** 模块ID */
    private long moduleId;
    /** 模块名 */
    private String moduleName;
    /** 项目ID */
    private long projectId;
    
    
    
    public long getModuleId() {
        return moduleId;
    }
    
    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }
    
    public String getModuleName() {
        return moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public long getProjectId() {
        return projectId;
    }
    
    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + ", projectId=" + projectId + "]";
    }
    
    
}
