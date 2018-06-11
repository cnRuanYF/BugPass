package com.bugpass.service.impl;

import java.util.List;

import com.bugpass.dao.MemberRelationDao;
import com.bugpass.dao.impl.MemberRelationDAOImpl;
import com.bugpass.entity.MemberRelation;
import com.bugpass.service.MemberRelationService;

/**
 * 成员关系相关业务实现类
 * 
 * @author QiuWenYi
 * @date 2018年6月8日 下午2:51:22
 */
public class MemberRelationServiceImpl implements MemberRelationService {
    
    MemberRelationDao mrd=new MemberRelationDAOImpl();

    @Override
    public List<MemberRelation> findMemberRelationByUserNameLike(String usernameLike) {
        // TODO Auto-generated method stub
        List<MemberRelation> list=null;
        try {
            list = mrd.findMemberRelationByUserNameLike(usernameLike);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<MemberRelation> findAllMemberRelation() {
        // TODO Auto-generated method stub
        List<MemberRelation> list=null;
        try {
            list = mrd.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

   

}
