/**
 * 
 */
package com.bugpass.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bugpass.entity.Module;

/**
 * @author QiuWenYi
 * @date 2018年7月3日 下午12:57:48
 */
@Repository("moduleDao")
public interface ModuleDao extends BaseDAO<Module>{
    /**
     * 根据项目id查找对应的模块的list
     * @param problemId
     * @return
     */
    List<Module> queryByProjectId(long projectId); 
}
