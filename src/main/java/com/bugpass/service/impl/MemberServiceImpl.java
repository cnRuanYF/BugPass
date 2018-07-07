package com.bugpass.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bugpass.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bugpass.dao.MemberDao;
import com.bugpass.entity.Member;
import com.bugpass.entity.User;
import com.bugpass.service.MemberService;

import static com.bugpass.constant.MemberRoleType.ROLE_MEMBER;
import static com.bugpass.constant.MemberRoleType.ROLE_UNCOMFIRMED;
import static com.bugpass.constant.MemberRoleType.ROLE_CREATOR;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public boolean addMember(Member member) {
        return memberDao.add(member);
    }

    @Override
    public boolean deleteMember(Member member) {
        return memberDao.deleteMember(member);
    }

    @Override
    public boolean updateMember(Member member) {
        return memberDao.update(member);
    }

    @Override
    public List<Member> queryByProjectId(long projectId) {
        return memberDao.queryByProjectId(projectId);
    }

    @Override
    public List<Member> queryByNameOrEmail(long projectId, String nameorEamil) {
        return memberDao.queryByNameOrEmail(projectId, nameorEamil);
    }

    @Override
    public boolean isProjectMember(long projectId, long userId) {
        // 查出所有该项目的成员
        List<Member> list = memberDao.queryByProjectId(projectId);
        // 遍历项目成员，若该用户已经是该项目成员，且不是创建者，则设置标记为true，可被删除
        if (list != null) {
            for (Member item : list) {
                if (item.getUserId() == userId && item.getProjectId() == projectId) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isProjectCreator(long projectId, Member member) {
        // 查出所有该项目的成员
        List<Member> list = memberDao.queryByProjectId(projectId);
        // 遍历项目成员，若该用户已经是该项目成员，且不是创建者，则设置标记为true，可被删除
        if (list != null) {
            for (Member item : list) {
                if (item.getUserId() == member.getUserId() && item.getProjectId() == member.getProjectId()) {
                    if (member.getMemberRole() == ROLE_CREATOR) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isMember(long projectId, long userId) {
        Member member = memberDao.queryByProjectIdAndUserId(projectId, userId);
        if (member != null) {
            return member.getMemberRole() == ROLE_MEMBER;
        }
        return false;
    }

    @Override
    public boolean isInvited(long projectId, long userId) {
        Member member = memberDao.queryByProjectIdAndUserId(projectId, userId);
        if (member != null) {
            return member.getMemberRole() == ROLE_UNCOMFIRMED;
        }
        return false;
    }

    @Override
    public boolean isCreator(long projectId, long userId) {
        Member member = memberDao.queryByProjectIdAndUserId(projectId, userId);
        if (member != null) {
            return member.getMemberRole() == ROLE_CREATOR;
        }
        return false;
    }

    @Override
    public List<Project> getInvitation(long userId) {
        return memberDao.getProjectByRoleIsZero(userId);
    }

    @Override
    public List<User> searchWithoutProject(List<User> userList, List<Member> memberList) {
        // 模糊查找去除成员后的集合
        List<User> list = new ArrayList<>();
        // 去除成员操作
        for (User user : userList) {
            boolean flag = true;
            for (Member member : memberList) {
                if (member.getUserId() == user.getId()) {
                    flag = false;
                }
            }
            if (flag) {
                list.add(user);
            }
        }
        // 1.8新特性的foreach不支持, flag会认为是final的, 不可赋值, 改用普通foreach
        // userList.forEach(user->{boolean flag =
        // true;memberList.forEach(member->{if(member.getUserId() ==
        // user.getId()) {flag = false;}});list.add(user);});
        return list;
    }

    @Override
    public List<Member> memberForProject(List<Member> list) {
        // 成员列表
        List<Member> memberList = new ArrayList<>();
        // 将成员与未确认分开
        list.forEach(member -> {
            if (member.getMemberRole() != ROLE_UNCOMFIRMED) {
                memberList.add(member);
            }
        });
        return memberList;
    }

    @Override
    public List<Member> unconfirmForProject(List<Member> list) {
        // 成员列表
        List<Member> unconfirmList = new ArrayList<>();
        // 将成员与未确认分开
        list.forEach(member -> {
            if (member.getMemberRole() == ROLE_UNCOMFIRMED) {
                unconfirmList.add(member);
            }
        });
        return unconfirmList;
    }

}
