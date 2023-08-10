package com.lvgu.industrynew.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lvgu.industrynew.dto.SysUserDTO;
import com.lvgu.industrynew.entity.SysUserEntity;
import com.lvgu.industrynew.mapper.ISysMenuMapper;
import com.lvgu.industrynew.mapper.ISysUserMapper;
import com.lvgu.industrynew.service.SysUserService;
import com.lvgu.industrynew.dto.LoginUser;
import com.lvgu.industrynew.utils.CollectionTools;
import com.lvgu.industrynew.utils.RedisCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl  extends CrudServiceImpl<ISysUserMapper, SysUserEntity, SysUserDTO> implements SysUserService {
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private ISysMenuMapper sysMenuMapper;


    @Override
    public QueryWrapper<SysUserEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        String loginname = null;
        if (params.get("loginname")!=null && !"".equals(params.get("loginname"))){
            loginname = params.get("loginname").toString();
        }

        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq( "isdeteled", 0);
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.like(StringUtils.isNotBlank(loginname), "loginname", loginname);

        return wrapper;
    }

    /**
     * 根据用户id获取权限菜单及用户相关信息
     * @return
     */
    @Override
    public Map<String,Object> getInfo(String id) {
        LoginUser loginUser = redisCache.getCacheObject("login:" + id);

        //查询对应的权限信息
        List<String> listPermis = sysMenuMapper.getPermsByUserId(id);
        if (!CollectionUtils.isEmpty(listPermis)){
            listPermis = CollectionTools.removeEmptyString(listPermis);
        }
        Map<String,Object> map = new HashMap<>();
        //添加权限菜单
        map.put("roles",listPermis);
        //添加名称
        map.put("name",loginUser.getUserEntity().getUserName());
        //添加头像
        map.put("avatar","https://shujutong.oss-cn-north-2.unicloudsrv.com/zhaijidi/877515c2c1bd41d4bd07064dbcfd2659/1.jpg");
        return map;
    }

    /**
     * 新增
     * @param dto
     * @return
     */
    @Override
    public int addData(SysUserDTO dto) {
        save(dto);
        return 1;
    }
}
