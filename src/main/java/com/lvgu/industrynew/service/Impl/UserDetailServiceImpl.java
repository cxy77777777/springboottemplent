package com.lvgu.industrynew.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lvgu.industrynew.dto.LoginUser;
import com.lvgu.industrynew.entity.SysUserEntity;
import com.lvgu.industrynew.mapper.ISysMenuMapper;
import com.lvgu.industrynew.mapper.ISysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private ISysUserMapper sysUserMapper;
    @Autowired
    private ISysMenuMapper sysMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        //查询用户信息
        SysUserEntity userEntity = null;
        try {
            List<SysUserEntity> list = sysUserMapper.selectListByQure(loginName);
            if (list!=null && list.size()>0){
                userEntity = list.get(0);
            }
        }catch (Exception e){
            e.getMessage();
        }
        //如果没有查询到用户就抛出异常----spring-security-存在异常捕获过滤器
        if(Objects.isNull(userEntity)){
            throw new RuntimeException("用户名或密码错误!");
        }
        //查询对应的权限信息
//        List<String> listPermis = sysMenuMapper.getPermsByUserId(userEntity.getId());
        //去掉list中的null
//        List<String> newList = listPermis.stream().filter(Objects::nonNull)
//                .collect(Collectors.toList());
        //去掉list空字符串
//        List<String> filtered=newList.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        List<String> list = new ArrayList<>(Arrays.asList("test","admin"));
        //把数据封装成UserDetails返回
        return new LoginUser(userEntity,list);
    }
}
