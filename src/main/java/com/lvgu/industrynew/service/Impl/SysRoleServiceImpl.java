package com.lvgu.industrynew.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lvgu.industrynew.dto.SysRoleDTO;
import com.lvgu.industrynew.entity.SysRoleEntity;
import com.lvgu.industrynew.mapper.ISysRoleMapper;
import com.lvgu.industrynew.service.ISysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 角色
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@Service
public class SysRoleServiceImpl extends CrudServiceImpl<ISysRoleMapper, SysRoleEntity, SysRoleDTO> implements ISysRoleService {

    @Override
    public QueryWrapper<SysRoleEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SysRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}