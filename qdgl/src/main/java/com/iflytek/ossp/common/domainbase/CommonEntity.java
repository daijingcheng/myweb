package com.iflytek.ossp.common.domainbase;

import java.io.Serializable;
import java.util.List;

import javax.persistence.MappedSuperclass;

/**
 * 一种抽象实体类，提供基本的持久化方法
 */
@MappedSuperclass
public abstract class CommonEntity extends BaseEntity {

    private static final long serialVersionUID = 8882145540383345037L;

    /**
     * 将实体本身持久化到数据库
     */
    public void save() {
        getRepository().save(this);
    }
    
    /**
     * 将实体本身持久化到数据库
     */
    public void update() {
        getRepository().update(this);
    }

    /**
     * 将实体本身从数据库中删除
     */
    public void remove() {
        getRepository().remove(this);
    }

    /**
     * 根据实体类型和ID从仓储中获取实体
     * @param <T> 实体类型
     * @param clazz 实体的类
     * @param id 实体的ID
     * @return 类型为T或T的子类型，ID为id的实体。
     */
    public static <T extends Entity> T get(Class<T> clazz, Serializable id) {
        return getRepository().get(clazz, id);
    }
    
    /**
     * 查找指定类型的所有实体
     * @param <T> 实体所属的类型
     * @param clazz 实体所属的类
     * @return 符合条件的实体列表
     */
    public static <T extends Entity> List<T> findAll(Class<T> clazz) {
        return getRepository().findAll(clazz);
    }

    /**
     * 查找指定类型的所有实体主键列表
     * @param <T> 实体所属的类型
     * @param clazz 实体所属的类
     * @param idName 实体主键名
     * @return 符合条件的实体列表
     */
    public static <T extends Entity> List findAllKey(Class<T> clazz, String idName) {
    	return getRepository().findAllKey(clazz, idName);
    }
}
