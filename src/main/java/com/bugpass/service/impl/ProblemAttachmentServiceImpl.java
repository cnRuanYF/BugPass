package com.bugpass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bugpass.dao.ModuleDao;
import com.bugpass.dao.ProblemAttachmentDao;
import com.bugpass.entity.Module;
import com.bugpass.entity.ProblemAttachment;
import com.bugpass.service.ModuleService;
import com.bugpass.service.ProblemAttachmentService;

/**
 * 文件业务实现类
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:47:18
 */
@Service("problemAttachmentService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
public class ProblemAttachmentServiceImpl implements ProblemAttachmentService {

    @Autowired
    private ProblemAttachmentDao problemAttachmentDao;

    @Override
    public boolean addProblemAttachment(ProblemAttachment problemAttachment) {
        // TODO Auto-generated method stub
        return problemAttachmentDao.addProblemAttachment(problemAttachment);
    }

    @Override
    public boolean delProblemAttachmentByAttachIndex(long attachIndex) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean udpProblemAttachmentById(ProblemAttachment ProblemAttachment) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ProblemAttachment findProblemAttachmentByProblemIdAndAttachIndex(long problemId,long attachIndex) {
        // TODO Auto-generated method stub
        return problemAttachmentDao.queryProblemAttachmentByProblemIdAndAttachIndex(problemId, attachIndex);
    }

    @Override
    public List<ProblemAttachment> findProblemAttachmentByProblemIdId(long problemId) {
        // TODO Auto-generated method stub
        return problemAttachmentDao.queryAllProblemAttachmentByProblemId(problemId);
    }

    @Override
    public List<ProblemAttachment> findAllProblemAttachment() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delProblemAttachment(ProblemAttachment ProblemAttachment) {
        // TODO Auto-generated method stub
        return false;
    }

   





}
