package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Discuss;

/**
 * 讨论相关业务接口
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:38:47
 */
public interface DiscussService {
   
    /**
     * 新增评论
     * @param discuss
     * @return 若成功返回true
     */
    boolean addDiscuss(Discuss discuss);

    /**
     * 根据问题ID查找相应问题的评论
     * 
     * @param problemId 问题ID
     * @return 查找到的list
     */
    List<Discuss> findByProblemId(long problemId);

    /**
     * 根据discussId删除
     * 
     * @param discussId 讨论的id
     * @return 是否成功删除
     */
    boolean delDiscussById(long discussId);
    
    /**
     * 查询所有讨论
     * 
     * @param discussId 讨论的id
     * @return 是否成功删除
     */
    List<Discuss> findAllDisscuss();

}
