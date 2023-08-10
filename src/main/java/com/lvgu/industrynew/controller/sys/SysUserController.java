package com.lvgu.industrynew.controller.sys;

import com.lvgu.industrynew.domain.Result;
import com.lvgu.industrynew.dto.SysUserDTO;
import com.lvgu.industrynew.service.SysUserService;
import com.lvgu.industrynew.utils.SpringSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据用户token获取权限菜单及用户相关信息
     * @param token
     * @return
     */
    @GetMapping("getInfo")
    public Result getInfo(String token){
        return new Result().ok(sysUserService.getInfo(SpringSecurityUtils.getUserIdByToken(token)));
    }

    @PostMapping("addData")
    public Result addData(@RequestBody SysUserDTO dto){
        dto.setPassword(dto.getPassword());
        return new Result().ok(sysUserService.addData(dto));
    }
}
