package com.bugpass.dao.impl;

import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.bugpass.dao.MemberRelationDao;
import com.bugpass.entity.MemberRelation;
import com.bugpass.entity.User;
import com.bugpass.util.DBUtil;

/**
 * 成员DAO实现类
 * 
 * @author QiuWenYi
 * @date 2018年6月8日 上午10:39:39
 */
public class MemberRelationDAOImpl implements MemberRelationDao {

    @Override
    public List<MemberRelation> findMemberRelationByUserNameLike(String usernameLike) throws Exception {
        // TODO Auto-generated method stub
        String sql="select p.projectName,u.username,u.email,m.role FROM user u,member m,project p WHERE u.id=m.userId and p.projectId=m.projectId and username LIKE ?" ;
        List<MemberRelation> list = (List<MemberRelation>) DBUtil.execQuery(sql,MemberRelation.class, "%"+usernameLike+"%");
        return list;
    }

    @Override
    public boolean add(MemberRelation obj) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(MemberRelation obj) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(MemberRelation obj) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<MemberRelation> findAll() throws Exception {
        // TODO Auto-generated method stub
        String sql="select p.projectName,u.username,u.email,m.role FROM user u,member m,project p WHERE u.id=m.userId and p.projectId=m.projectId " ;
        List<MemberRelation> list = (List<MemberRelation>) DBUtil.execQuery(sql,MemberRelation.class);
        return list;
    }

    @Override
    public MemberRelation findById(long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}