package com.bugpass.test;

import java.util.List;

import com.bugpass.dao.MemberRelationDao;
import com.bugpass.dao.impl.MemberRelationDAOImpl;
import com.bugpass.entity.MemberRelation;
import com.bugpass.service.MemberRelationService;
/**
 * 成员关系测试
 * @author QiuWenYi
 * @date 2018年6月8日 下午2:40:46
 */
import com.bugpass.service.impl.MemberRelationServiceImpl;
public class MemberDaoTest {

    static MemberRelationDao mrd=new MemberRelationDAOImpl();

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//        testFindAll();
//        testFindMemberRelationByUserNameLike();
        testMemberRelationServiceImpl();
        
//        testfindAllMemberRelation();
    }

    // 测试查询所有成员
    /*public static void testFindAll() {
        try {
            List<Member> list = md.findAll();
            for (Member member : list) {
                System.out.println(member);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/

    // 测试根据成名字模糊查找成员
   /* public static void testFindMemberByUserNameLike() {
        try {
            List<Member> findMemberByUserNameLike = md.findMemberByUserNameLike("");
            for (Member member : findMemberByUserNameLike) {
                System.out.println(member);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
    
    // 测试根据成名字模糊查找成员
    /*public static void testFindMemberByUserNameLike() {
        try {
            List<UserMemberRelation> findMemberByUserNameLike = umrd.findMemberByUserNameLike("");
            for (UserMemberRelation info : findMemberByUserNameLike) {
                System.out.println(info);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
    
    // 测试根据成名字模糊查找成员dao
    public static void testFindMemberRelationByUserNameLike() {
        try {
            List<MemberRelation> list = mrd.findMemberRelationByUserNameLike("");
            for (MemberRelation info : list) {
                System.out.println(info);
                
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    static MemberRelationService mrs=new MemberRelationServiceImpl();
    // 测试根据成名字模糊查找成员service
    public static void testMemberRelationServiceImpl() {
        List<MemberRelation> list = mrs.findMemberRelationByUserNameLike("w");
        for (MemberRelation info : list) {
            System.out.println(info);
        }
        
    }
 // 测试根据成名字模糊查找成员service
    public static void testfindAllMemberRelation() {
        List<MemberRelation> list = mrs.findAllMemberRelation();
        for (MemberRelation info : list) {
            System.out.println(info);
        }
        
    }
}
