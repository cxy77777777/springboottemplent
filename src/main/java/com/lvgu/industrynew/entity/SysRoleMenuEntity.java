package com.lvgu.industrynew.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色菜单表
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@TableName("sys_role_menu")
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="sys_role_menu对象", description="角色菜单表")
public class SysRoleMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 菜单id
     */
	private String menuId;
    /**
     * 角色id
     */
	private String roleId;
}