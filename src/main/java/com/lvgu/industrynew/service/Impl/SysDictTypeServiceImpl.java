package com.lvgu.industrynew.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lvgu.industrynew.dto.SysDictDataDTO;
import com.lvgu.industrynew.dto.SysDictTypeDTO;
import com.lvgu.industrynew.entity.SysDictTypeEntity;
import com.lvgu.industrynew.mapper.SysDictTypeMapper;
import com.lvgu.industrynew.service.SysDictDataService;
import com.lvgu.industrynew.service.SysDictTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 字典类型
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2022-08-05
 */
@Service
public class SysDictTypeServiceImpl extends CrudServiceImpl<SysDictTypeMapper, SysDictTypeEntity, SysDictTypeDTO> implements SysDictTypeService {

    @Autowired
    private SysDictDataService sysDictDataService;

    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;

    @Override
    public QueryWrapper<SysDictTypeEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        String dictType = null;
        if (params.get("dictType")!=null && !"".equals(params.get("dictType"))){
            dictType = params.get("dictType").toString();
        }

        QueryWrapper<SysDictTypeEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.like(StringUtils.isNotBlank(dictType), "dict_type", dictType);

        return wrapper;
    }

    /**
     * 根据id删除字典类型
     * @param id
     * @return
     */
    @Override
    public int deleteByIdd(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("dictTypeId",id);
        List<SysDictDataDTO> list = sysDictDataService.list(params);
        if (list!=null && list.size()>0){
            throw new RuntimeException("该类型下存在数据，无法删除！");
        }
        sysDictTypeMapper.deleteByIdd(id);
        return 1;
    }

    /**
     * 修改
     * @param dictTypeDTO
     * @return
     */
    @Override
    public int updateData(SysDictTypeDTO dictTypeDTO) {
        Map<String, Object> params = new HashMap<>();
        params.put("dictType",dictTypeDTO.getDictType());
        List<SysDictTypeDTO> list = list(params);
        //根据条件过滤出id不为本数据的
        List<SysDictTypeDTO> result = list.stream().filter(t -> !t.getId().equals(dictTypeDTO.getId())).collect(Collectors.toList());
        if (result==null || result.size()<=0){
            update(dictTypeDTO);
            return 1;
        }
        throw new RuntimeException("该类型数据值已存在！");
    }
}