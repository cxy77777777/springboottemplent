package com.lvgu.industrynew.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lvgu.industrynew.dto.SysDictDataDTO;
import com.lvgu.industrynew.entity.SysDictDataEntity;
import com.lvgu.industrynew.mapper.SysDictDataMapper;
import com.lvgu.industrynew.service.SysDictDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 字典数据
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2022-08-05
 */
@Service
public class SysDictDataServiceImpl extends CrudServiceImpl<SysDictDataMapper, SysDictDataEntity, SysDictDataDTO> implements SysDictDataService {

    @Autowired
    private SysDictDataMapper sysDictDataMapper;

    @Override
    public QueryWrapper<SysDictDataEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        String dictTypeId = null;
        if (params.get("dictTypeId")!=null && !"".equals(params.get("dictTypeId"))){
            dictTypeId = params.get("dictTypeId").toString();
        }

        String dictLabel = null;
        if (params.get("dictLabel")!=null && !"".equals(params.get("dictLabel"))){
            dictLabel = params.get("dictLabel").toString();
        }

        QueryWrapper<SysDictDataEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        wrapper.eq(StringUtils.isNotBlank(dictTypeId), "dict_type_id", dictTypeId);

        wrapper.like(StringUtils.isNotBlank(dictLabel), "dict_label", dictLabel);

        return wrapper;
    }

    /**
     * 根据字典类型+字典数据值 查询数据
     * @param dictTypeId
     * @param dictValue
     * @return
     */
    @Override
    public List<SysDictDataEntity> getListByTypeAndValue(String dictTypeId, String dictValue) {
        return sysDictDataMapper.getListByTypeAndValue(dictTypeId,dictValue);
    }

    /**
     * 保存
     * @param dictDataDTO
     * @return
     */
    @Override
    public int saveData(SysDictDataDTO dictDataDTO) {
        List<SysDictDataEntity> list = sysDictDataMapper.getListByTypeAndValue(dictDataDTO.getDictTypeId(),dictDataDTO.getDictValue());
        if (list==null || list.size()<=0){
            save(dictDataDTO);
            return 1;
        }
        throw new RuntimeException("该类型数据值已存在，请勿重复添加！");
    }

    /**
     * 修改
     * @param dictDataDTO
     * @return
     */
    @Override
    public int updateData(SysDictDataDTO dictDataDTO) {
        List<SysDictDataEntity> list = sysDictDataMapper.getListByTypeAndValue(dictDataDTO.getDictTypeId(),dictDataDTO.getDictValue());
        //根据条件过滤出id不为本数据的
        List<SysDictDataEntity> result = list.stream().filter(t -> !t.getId().equals(dictDataDTO.getId())).collect(Collectors.toList());
        if (result==null || result.size()<=0){
            update(dictDataDTO);
            return 1;
        }
        throw new RuntimeException("该类型数据值已存在！");
    }

    /**
     * 根据id删除字典类型
     * @param id
     * @return
     */
    @Override
    public int deleteByIdd(String id) {
        sysDictDataMapper.deleteByIdd(id);
        return 1;
    }

    /**
     * 根据字典类型查询数据
     * @param dictType
     * @return
     */
    @Override
    public List<SysDictDataEntity> getListByType(String dictType) {
        return sysDictDataMapper.getListByType(dictType);
    }
}