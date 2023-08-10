package com.lvgu.industrynew.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.lvgu.industrynew.comments.BaseDao;
import com.lvgu.industrynew.entity.SysRoleEntity;

/**
 * 角色
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@Mapper
public interface ISysRoleMapper extends BaseDao<SysRoleEntity> {
	
}