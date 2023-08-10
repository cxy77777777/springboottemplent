package com.lvgu.industrynew.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lvgu.industrynew.dto.SysUserRoleDTO;
import com.lvgu.industrynew.entity.SysUserRoleEntity;
import com.lvgu.industrynew.mapper.ISysUserRoleMapper;
import com.lvgu.industrynew.service.ISysUserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 用户角色表
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@Service
public class SysUserRoleServiceImpl extends CrudServiceImpl<ISysUserRoleMapper, SysUserRoleEntity, SysUserRoleDTO> implements ISysUserRoleService {

    @Override
    public QueryWrapper<SysUserRoleEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SysUserRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}