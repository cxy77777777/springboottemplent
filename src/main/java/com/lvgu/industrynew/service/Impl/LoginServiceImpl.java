package com.lvgu.industrynew.service.Impl;

import com.lvgu.industrynew.domain.Result;
import com.lvgu.industrynew.dto.SysUserDTO;
import com.lvgu.industrynew.entity.SysUserEntity;
import com.lvgu.industrynew.mapper.ISysMenuMapper;
import com.lvgu.industrynew.utils.JwtUtil;
import com.lvgu.industrynew.utils.RedisCache;
import com.lvgu.industrynew.dto.LoginUser;
import com.lvgu.industrynew.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysMenuMapper sysMenuMapper;

    /**
     * 登录
     * @param sysUserDTO
     * @return
     */
    @Override
    public Result login(SysUserDTO sysUserDTO) {
        //1.AuthenticationManager authenticate进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(sysUserDTO.getLoginName(),sysUserDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //2.如果认证没通过给出对应的提示
        if (Objects.isNull(authentication)){
            throw new RuntimeException("登陆失败!");
        }
        //3.如果认证通过了，使用userid生成jwt，jwt存入Result返回
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        SysUserEntity userEntity = loginUser.getUserEntity();
        String jwt = JwtUtil.createJWT(userEntity.getId(), 60*60*60*1000L);
        Map<String,Object> map = new HashMap<>();
        map.put("token",jwt);
        map.put("user",userEntity);
        //4.把完整的用户信息存入redis，userid作为key
        redisCache.setCacheObject("login:" + userEntity.getId(),loginUser,60*60, TimeUnit.SECONDS);
        return new Result().ok(map);
    }

    /**
     * 退出
     */
    @Override
    public void loginOut() {
        //1.从SecurityContextHolder中获取用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        //2.根据登录用户的userid删除redis中的用户信息
        redisCache.deleteObject("login:" + loginUser.getUserEntity().getId());
    }

    /**
     *根据userid获取权限
     * @param userId
     * @return
     */
    @Override
    public List<String> generateRoutes(String userId) {
        return sysMenuMapper.getPermsByUserId(userId);
    }
}
