package com.lvgu.industrynew.controller.sys;

import com.lvgu.industrynew.domain.Result;
import com.lvgu.industrynew.dto.SysUserDTO;
import com.lvgu.industrynew.utils.SpringSecurityUtils;
import com.lvgu.industrynew.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * @param sysUserDTO
     * @return
     */
    @PostMapping("user/login")
    public Result login(@RequestBody SysUserDTO sysUserDTO){
        return loginService.login(sysUserDTO);
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("user/loginOut")
    public Result loginOut(){
        loginService.loginOut();
        return new Result();
    }

    /**
     * 获取当前用户的权限菜单
     * @return
     */
    @GetMapping("permission/generateRoutes")
    public Result generateRoutes(){
        return new Result().ok(loginService.generateRoutes(SpringSecurityUtils.getUserInfo().getUserEntity().getId()));
    }
}
