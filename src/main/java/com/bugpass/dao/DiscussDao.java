/**
 * 
 */
package com.bugpass.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bugpass.entity.Discuss;

/**
 * @author QiuWenYi
 * @date 2018年7月3日 下午12:57:48
 */
@Repository("discussDao")
public interface DiscussDao extends BaseDAO<Discuss>{
    /**
     * 根据问题id查找对应的讨论返回list
     * @param problemId
     * @return
     */
    List<Discuss> queryByProblemId(long problemId); 
}
