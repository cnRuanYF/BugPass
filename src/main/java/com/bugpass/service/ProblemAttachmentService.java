package com.bugpass.service;

import java.util.List;

import com.bugpass.entity.Module;
import com.bugpass.entity.ProblemAttachment;

/**
 * 文件业务接口
 * @author QiuWenYi
 * @date 2018年7月4日 下午12:38:47
 */
public interface ProblemAttachmentService {
   
    /**
     * 新增文件
     * @param ProblemAttachment 文件
     * @return 若成功返回true
     */
    boolean addProblemAttachment(ProblemAttachment problemAttachment);

    /**
     * 根据附件索引删除附件
     * 
     * @param attachIndex 索引
     * @return 是否成功删除
     */
    boolean delProblemAttachmentByAttachIndex(long attachIndex);
    
    /**
     * 根据问题和附件索引删除附件
     * 
     * @param ProblemAttachment ProblemAttachment
     * @return 是否成功删除
     */
    boolean delProblemAttachment(ProblemAttachment ProblemAttachment);
    
    /**
     * 更新所有附件
     * 
     * @param ProblemAttachment 文件
     * @return 是否成功修改
     */
    boolean udpProblemAttachmentById(ProblemAttachment ProblemAttachment);
    
    /**
     * 按附件问题和索引查询附件
     * @param problemId 问题
     * @param attachIndex 附件索引
     */
    ProblemAttachment findProblemAttachmentByProblemIdAndAttachIndex(long problemId,long attachIndex);
    
    /**
     * 根据问题ID查找相应附件List
     * 
     * @param problemId 问题ID
     * @return 查找到的list
     */
    List<ProblemAttachment> findProblemAttachmentByProblemIdId(long problemId);
    
    /**
     * 查询所有附件（暂时没用）
     * 
     */
    List<ProblemAttachment> findAllProblemAttachment();

}
