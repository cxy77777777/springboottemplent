package com.lvgu.industrynew.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色表
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@TableName("sys_user_role")
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="sys_user_role对象", description="用户角色表")
public class SysUserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 用户id
     */
	private String userId;
    /**
     * 角色id
     */
	private String roleId;
}