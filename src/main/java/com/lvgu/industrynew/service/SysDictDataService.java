package com.lvgu.industrynew.service;


import com.lvgu.industrynew.dto.SysDictDataDTO;
import com.lvgu.industrynew.entity.SysDictDataEntity;

import java.util.List;

/**
 * 字典数据
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2022-08-05
 */
public interface SysDictDataService extends CrudService<SysDictDataEntity, SysDictDataDTO> {

    /**
     * 根据字典类型+字典数据值 查询数据
     * @param dictTypeId
     * @param dictValue
     * @return
     */
    List<SysDictDataEntity>getListByTypeAndValue(String dictTypeId, String dictValue);

    /**
     * 保存
     * @param dictDataDTO
     * @return
     */
    int saveData(SysDictDataDTO dictDataDTO);

    /**
     * 修改
     * @param dictDataDTO
     * @return
     */
    int updateData(SysDictDataDTO dictDataDTO);

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