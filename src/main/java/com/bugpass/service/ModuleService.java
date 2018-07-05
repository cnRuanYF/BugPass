package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Module;

/**
 * 模块相关业务接口
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:38:47
 */
public interface ModuleService {
   
    /**
     * 新增模块
     * @param module
     * @return 若成功返回true
     */
    boolean addModule(Module module);

    /**
     * 根据moduleId删除
     * 
     * @param moduleId 模块的id
     * @return 是否成功删除
     */
    boolean delModuleById(long moduleId);
    
    /**
     * 更新所有模块
     * 
     * @param moduleId 模块的id
     * @return 是否成功删除
     */
    boolean udpModuleById(Module module);
    
    /**
     * 按模块Id查询模块
     * 
     */
    Module findByModuleId(long moduleId);
    
    /**
     * 根据项目ID查找相应模块List
     * 
     * @param projectId 项目ID
     * @return 查找到的list
     */
    List<Module> findByProjectId(long projectId);
    
    /**
     * 查询所有模块
     * 
     */
    List<Module> findAllModule();

}
