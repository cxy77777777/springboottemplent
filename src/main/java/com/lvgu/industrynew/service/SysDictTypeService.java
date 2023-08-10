package com.lvgu.industrynew.service;


import com.lvgu.industrynew.dto.SysDictTypeDTO;
import com.lvgu.industrynew.entity.SysDictTypeEntity;

/**
 * 字典类型
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2022-08-05
 */
public interface SysDictTypeService extends CrudService<SysDictTypeEntity, SysDictTypeDTO> {

    /**
     * 根据id删除字典类型
     * @param id
     * @return
     */
    int deleteByIdd(String id);

    /**
     * 修改
     * @param dictTypeDTO
     * @return
     */
    int updateData(SysDictTypeDTO dictTypeDTO);
}