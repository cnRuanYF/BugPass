package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.MemberRelation;
import com.bugpass.entity.User;

/**
 * 成员关系相关业务接口
 * 
 * @author QiuWenYi
 * @date 2018年6月8日 下午2:49:46
 */
public interface MemberRelationService {
   

    /**
     * 根据姓名查找成员关系
     * 
     * @param usernameLike 姓名
     * @return 查找到的对象
     */
    List<MemberRelation> findMemberRelationByUserNameLike(String usernameLike);
    
    /**
    * 查询所有成员关系
    * 
    * @return 查找到的对象
    */
   List<MemberRelation> findAllMemberRelation();
    
}
