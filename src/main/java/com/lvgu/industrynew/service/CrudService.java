package com.lvgu.industrynew.service;

import com.lvgu.industrynew.comments.PageData;

import java.util.List;
import java.util.Map;

/**
 *  CRUD基础服务接口
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface CrudService<T, D> extends BaseService<T> {

    PageData<D> page(Map<String, Object> params);

    List<D> list(Map<String, Object> params);

    List<D> listMap(Map<String, Object> params);

    D getOnly(Map<String, Object> params);

    D get(String id);

    void save(D dto);

    void update(D dto);

    void delete(String[] ids);

    Boolean listHaveYear(String fillingYears, String deptId, String countyCode);

    T oneHaveYear(Integer fillingYears, String countyCode);

    int deleteByRelationId(String id);

}