package com.bugpass.dao;

import com.bugpass.entity.Member;
import com.bugpass.entity.ProblemAttachment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 文件接口
 * @author QiuWenYi
 * @date 2018年7月7日 上午11:16:20
 */
@Repository("problemAttachmentDao")
public interface ProblemAttachmentDao extends BaseDAO<ProblemAttachment>{
    
    /**
     * 根据问题id查找对应的文件返回list ProblemAttachment
     * @param problemId
     * @return
     */
   List<ProblemAttachment> queryAllProblemAttachmentByProblemId(long problemId);

   /**
    * 删除文件
    * @param ProblemAttachment 项目ID及索引ID
    * @return 是否删除成功
    */
//   boolean deleteAttachmentByProblemIdAndAttachIndex(long problemId, long attachIndex);
   boolean deleteAttachmentByProblemIdAndAttachIndex(@Param("problemId")long problemId, @Param("attachIndex")long attachIndex);
   
   /**
    * 删除文件
    * @param ProblemAttachment 文件对象（包含项目ID及索引ID）
    * @return 是否删除成功
    */
   boolean deleteProblemAttachment(@Param("problemAttachment")ProblemAttachment problemAttachment);
   
   /**
    * 根据问题ID+索引查询文件
    *
    * @param problemId    问题ID
    * @param attachIndex  索引
    * @return 文件
    */
   ProblemAttachment queryProblemAttachmentByProblemIdAndAttachIndex(@Param("problemId")long problemId, @Param("attachIndex")long attachIndex);
   
   /**
    * 添加文件
    */
//   boolean addProblemAttachment(@Param("problemAttachment") ProblemAttachment problemAttachment);
   boolean addProblemAttachment2(Map map);
   /**
    * 添加文件
    */
//   boolean addProblemAttachment(@Param("problemAttachment") ProblemAttachment problemAttachment);
   boolean addProblemAttachment(ProblemAttachment problemAttachment);

}
