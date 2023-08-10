package com.lvgu.industrynew.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.lvgu.industrynew.comments.BaseDao;
import com.lvgu.industrynew.entity.SysUserRoleEntity;

/**
 * 用户角色表
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@Mapper
public interface ISysUserRoleMapper extends BaseDao<SysUserRoleEntity> {
	
}