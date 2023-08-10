package com.lvgu.industrynew.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户角色表
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@ApiModel(value = "用户角色表")
@Data
public class SysUserRoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "用户id")
	private String userId;

	@ApiModelProperty(value = "角色id")
	private String roleId;


}