package com.iflytek.ossp.common.domainbase;

import java.io.Serializable;
import java.util.List;

/**
 * 仓储访问接口。用于存取和查询数据库中的各种类型的实体。
 */
public interface EntityRepository {

    /**
     * 将新实体保存到仓储中。
     *
     * @param <T> 实体的类型
     * @param entity 要存储的实体实例。
     * @return 持久化后的当前实体
     */
    <T extends Entity> T save(T entity);
    
    /**
     * 将修改的实体保存到仓储中。
     *
     * @param <T> 实体的类型
     * @param entity 要存储的实体实例。
     * @return 持久化后的当前实体
     */
    <T extends Entity> T update(T entity);

    /**
     * 将实体从仓储中删除。如果仓储中不存在此实例将抛出EntityNotExistedException异常。
     *
     * @param entity 要删除的实体实例。
     */
    void remove(Entity entity);

    /**
     * 判断仓储中是否存在指定ID的实体实例。
     *
     * @param <T> 实体类型
     * @param clazz 实体的类
     * @param id 实体标识
     * @return 如果实体实例存在，返回true，否则返回false
     */
    <T extends Entity> boolean exists(Class<T> clazz, Serializable id);

    /**
     * 从仓储中获取指定类型、指定ID的实体
     *
     * @param <T> 实体类型
     * @param clazz 实体的类
     * @param id 实体标识
     * @return 一个实体实例。
     */
    <T extends Entity> T get(Class<T> clazz, Serializable id);

    /**
     * 查找指定类型的所有实体
     *
     * @param <T> 实体类型
     * @param clazz 实体的类
     * @return 符合条件的实体集合
     */
    <T extends Entity> List<T> findAll(Class<T> clazz);
    
    /**
     * 查找指定类型的所有实体主键列表
     * @param idName 实体主键属性名（默认为id）
     * @return 主键列表
     */
    <T extends Entity> List findAllKey(Class<T> clazz, String idName);
}
