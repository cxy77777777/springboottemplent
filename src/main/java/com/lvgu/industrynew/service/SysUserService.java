package com.lvgu.industrynew.service;

import com.lvgu.industrynew.dto.SysUserDTO;

import java.util.Map;

public interface SysUserService {

    /**
     * 根据用户id获取权限菜单及用户相关信息
     * @return
     */
    Map<String,Object> getInfo(String id);

    /**
     * 新增
     * @param dto
     * @return
     */
    int addData(SysUserDTO dto);
}
