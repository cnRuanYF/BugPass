package com.bugpass.dao;

import java.util.List;

/**
 * 基础的数据访问类接口
 *
 * @author RuanYaofeng
 * @date 2018/6/29 18:09
 **/
public interface BaseDAO<T> {

    /**
     * 添加该对象
     *
     * @param obj 要添加的对象
     * @return 操作是否成功
     */
    boolean add(T obj);

    /**
     * 删除该对象
     *
     * @param id 对象的ID
     * @return 操作是否成功
     */
    boolean delete(long id);

    /**
     * 更新该对象
     *
     * @param obj 要修改的对象
     * @return 操作是否成功
     */
    boolean update(T obj);

    /**
     * 查找所有该对象的数据
     *
     * @return 该对象的所有数据的集合
     */
    List<T> queryAll();

    /**
     * 根据ID查找对象
     *
     * @param id 对象的ID
     * @return 查找到的对象
     */
    T queryById(long id);
}
