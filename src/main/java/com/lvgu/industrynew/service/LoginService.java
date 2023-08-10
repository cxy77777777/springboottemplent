package com.lvgu.industrynew.service;

import com.lvgu.industrynew.domain.Result;
import com.lvgu.industrynew.dto.SysUserDTO;

import java.util.List;

public interface LoginService {

    /**
     * 登录
     * @param sysUserDTO
     * @return
     */
    Result login(SysUserDTO sysUserDTO);

    /**
     * 退出
     */
    void loginOut();

    /**
     *根据userid获取权限
     * @param userId
     * @return
     */
    List<String> generateRoutes(String userId);
}
