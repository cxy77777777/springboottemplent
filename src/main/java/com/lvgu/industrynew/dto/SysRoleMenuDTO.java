package com.lvgu.industrynew.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 角色菜单表
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@ApiModel(value = "角色菜单表")
@Data
public class SysRoleMenuDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "菜单id")
	private String menuId;

	@ApiModelProperty(value = "角色id")
	private String roleId;


}