package com.bugpass.dao;

import java.util.List;

import com.bugpass.entity.MemberRelation;

/**
 * 用户成员关系实体DAO接口
 * @author QiuWenYi
 * @date 2018年6月8日 下午1:59:17
 */
public interface MemberRelationDao extends BaseDAO<MemberRelation>{
    /**
     * 根据成名字模糊查找成员关系信息
     * 
     * @param usernameLike 成员的名字
     * @return 查找到的成员对象集合，
     * @throws Exception 处理过程中发生错误均抛出异常到业务层处理
     */
    List<MemberRelation> findMemberRelationByUserNameLike(String usernameLike) throws Exception;
}
