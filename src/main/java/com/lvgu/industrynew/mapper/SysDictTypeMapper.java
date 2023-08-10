package com.lvgu.industrynew.mapper;

import com.lvgu.industrynew.comments.BaseDao;
import com.lvgu.industrynew.entity.SysDictTypeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典类型
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2022-08-05
 */
@Mapper
public interface SysDictTypeMapper extends BaseDao<SysDictTypeEntity> {


    /**
     * 根据id删除字典类型
     * @param id
     * @return
     */
    int deleteByIdd(String id);
}