package com.lvgu.industrynew.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lvgu.industrynew.dto.SysMenuDTO;
import com.lvgu.industrynew.entity.SysMenuEntity;
import com.lvgu.industrynew.mapper.ISysMenuMapper;
import com.lvgu.industrynew.service.ISysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 菜单
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@Service
public class SysMenuServiceImpl extends CrudServiceImpl<ISysMenuMapper, SysMenuEntity, SysMenuDTO> implements ISysMenuService {

    @Override
    public QueryWrapper<SysMenuEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SysMenuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq( "deleted", 0);
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}