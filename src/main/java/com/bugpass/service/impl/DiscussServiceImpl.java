package com.bugpass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bugpass.dao.DiscussDao;
import com.bugpass.entity.Discuss;
import com.bugpass.service.DiscussService;

/**
 * 讨论业务实现类
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:47:18
 */
@Service("discussService")
@Transactional
public class DiscussServiceImpl implements DiscussService {

    @Autowired
    private DiscussDao discussDao;

    @Override
    public boolean addDiscuss(Discuss discuss) {
        // TODO Auto-generated method stub
        return discussDao.add(discuss);
    }

    @Override
    public List<Discuss> findByProblemId(long problemId) {
        // TODO Auto-generated method stub
        return discussDao.queryByProblemId(problemId);
    }

    @Override
    public boolean delDiscussById(long discussId) {
        // TODO Auto-generated method stub
        return discussDao.delete(discussId);
    }

    @Override
    public List<Discuss> findAllDisscuss() {
        // TODO Auto-generated method stub
        return discussDao.queryAll();
    }

}
