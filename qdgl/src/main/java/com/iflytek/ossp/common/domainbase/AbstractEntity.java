package com.iflytek.ossp.common.domainbase;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * 一种抽象实体类，提供ID和版本属性，以及基本的持久化方法
 */
@MappedSuperclass
public abstract class AbstractEntity extends BaseEntity {

    private static final long serialVersionUID = 8882145540383345037L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Version
    @Column(name = "version")
    private int version;

    /**
     * 获得实体的标识
     *
     * @return 实体的标识
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * 设置实体的标识
     *
     * @param id 要设置的实体标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获得实体的版本号。持久化框架以此实现乐观锁。
     *
     * @return 实体的版本号
     */
    public int getVersion() {
        return version;
    }

    /**
     * 设置实体的版本号。持久化框架以此实现乐观锁。
     *
     * @param version 要设置的版本号
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * 将实体本身持久化到数据库
     */
    public void save() {
        getRepository().save(this);
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

}
