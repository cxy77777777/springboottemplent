package com.lvgu.industrynew.mapper;

import com.lvgu.industrynew.comments.BaseDao;
import com.lvgu.industrynew.entity.SysDictDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典数据
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2022-08-05
 */
@Mapper
public interface SysDictDataMapper extends BaseDao<SysDictDataEntity> {

    /**
     * 根据字典类型id+字典数据值 查询数据
     * @param dictTypeId
     * @param dictValue
     * @return
     */
    List<SysDictDataEntity> getListByTypeAndValue(@Param("dictTypeId") String dictTypeId, @Param("dictValue") String dictValue);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByIdd(String id);

    /**
     * 根据字典类型查询数据
     * @param dictType
     * @return
     */
    List<SysDictDataEntity> getListByType(String dictType);
}