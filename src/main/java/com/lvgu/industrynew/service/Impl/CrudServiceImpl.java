package com.lvgu.industrynew.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.lvgu.industrynew.comments.PageData;
import com.lvgu.industrynew.service.CrudService;
import com.lvgu.industrynew.utils.ConvertUtils;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  CRUD基础服务类
 *
 * @author Mark sunlightcs@gmail.com
 */
public abstract class CrudServiceImpl<M extends BaseMapper<T>, T, D> extends BaseServiceImpl<M, T> implements CrudService<T, D> {

    protected Class<D> currentDtoClass() {
        return (Class<D>)ReflectionKit.getSuperClassGenericType(getClass(), 2);
    }

    @Override
    public PageData<D> page(Map<String, Object> params) {
        IPage<T> page = baseDao.selectPage(
            getPage(params, null, false),
            getWrapper(params)
        );

        return getPageData(page, currentDtoClass());
    }

    @Override
    public List<D> list(Map<String, Object> params) {
        List<T> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, currentDtoClass());
    }
    @Override
    public List<D> listMap(Map<String, Object> params) {
        List<T> entityList = baseDao.selectByMap(params);
        return ConvertUtils.sourceToTarget(entityList, currentDtoClass());
    }
    @Override
    public D getOnly(Map<String, Object> params) {
        T entity = baseDao.selectOne(getWrapper(params));
        return ConvertUtils.sourceToTarget(entity, currentDtoClass());
    }

    public abstract QueryWrapper<T> getWrapper(Map<String, Object> params);

    @Override
    public D get(String id) {
        T entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, currentDtoClass());
    }

    @Override
    public void save(D dto) {
        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        insert(entity);

        //copy主键值到dto
        BeanUtils.copyProperties(entity, dto);
    }

    @Override
    public void update(D dto) {
        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        updateById(entity);
    }

    @Override
    public void delete(String[] ids) {
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public Boolean listHaveYear(String fillingYears,String deptId,String countyCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("fillingYears",fillingYears);
        params.put("deleted",0);
        params.put("deptId",deptId);
        params.put("countyCode",countyCode);
        List<T> list = baseDao.selectList(getWrapper(params));
        if (CollectionUtils.isEmpty(list)){
            return false;
        }
        return true;
    }

    @Override
    public T oneHaveYear(Integer fillingYears,String countyCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("fillingYears",fillingYears);
        params.put("deleted",0);
        params.put("countyCode",countyCode);
        T t = baseDao.selectOne(getWrapper(params));
        return t;
    }

    @Override
    public int deleteByRelationId(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("relationId",id);
        return baseDao.delete(getWrapper(params));
    }
}