package com.bugpass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugpass.dao.ModuleDao;
import com.bugpass.entity.Module;
import com.bugpass.service.ModuleService;

/**
 * 模块业务实现类
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:47:18
 */
@Service("moduleService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Override
    public boolean addModule(Module module) {
        // TODO Auto-generated method stub
        return moduleDao.add(module);
    }

    @Override
    public boolean delModuleById(long moduleId) {
        // TODO Auto-generated method stub
        return moduleDao.delete(moduleId);
    }

    @Override
    public boolean udpModuleById(Module module) {
        // TODO Auto-generated method stub
        return moduleDao.update(module);
    }

    @Override
    public Module findByModuleId(long moduleId) {
        // TODO Auto-generated method stub
        return moduleDao.queryById(moduleId);
    }

    @Override
    public List<Module> findByProjectId(long projectId) {
        // TODO Auto-generated method stub
        return moduleDao.queryByProjectId(projectId);
    }

    @Override
    public List<Module> findAllModule() {
        // TODO Auto-generated method stub
        return moduleDao.queryAll();
    }



}
