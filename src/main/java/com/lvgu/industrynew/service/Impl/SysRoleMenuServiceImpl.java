package com.lvgu.industrynew.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lvgu.industrynew.dto.SysRoleMenuDTO;
import com.lvgu.industrynew.entity.SysRoleMenuEntity;
import com.lvgu.industrynew.mapper.ISysRoleMenuMapper;
import com.lvgu.industrynew.service.ISysRoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 角色菜单表
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@Service
public class SysRoleMenuServiceImpl extends CrudServiceImpl<ISysRoleMenuMapper, SysRoleMenuEntity, SysRoleMenuDTO> implements ISysRoleMenuService {

    @Override
    public QueryWrapper<SysRoleMenuEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SysRoleMenuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}