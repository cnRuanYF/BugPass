package com.bugpass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bugpass.dao.MemberDao;
import com.bugpass.entity.Member;
import com.bugpass.service.MemberService;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;
    
    @Override
    public boolean addMember(Member member) {
        // TODO Auto-generated method stub
        return memberDao.add(member);
    }

    @Override
    public boolean deleteMember(Member member) {
        // TODO Auto-generated method stub
        return memberDao.deleteMember(member);
    }

    @Override
    public boolean updateMember(Member member) {
        // TODO Auto-generated method stub
        return memberDao.update(member);
    }

    @Override
    public List<Member> queryByProjectId(int projectId) {
        // TODO Auto-generated method stub
        return memberDao.queryByProjectId(projectId);
    }

    @Override
    public List<Member> queryByNameOrEmail(String nameorEamil) {
        // TODO Auto-generated method stub
        return memberDao.queryByNameOrEmail(nameorEamil);
    }

}
