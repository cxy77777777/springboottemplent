package com.lvgu.industrynew.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 角色
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@ApiModel(value = "角色")
@Data
public class SysRoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private String id;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "代码")
	private String code;

	@ApiModelProperty(value = "别名")
	private String aliasName;

	@ApiModelProperty(value = "")
	private Integer isEnabled;

	@ApiModelProperty(value = "")
	private String unitid;

	@ApiModelProperty(value = "")
	private String description;

	@ApiModelProperty(value = "")
	private Long location;

	@ApiModelProperty(value = "创建人id")
	private String creator;

	@ApiModelProperty(value = "创建人name")
	private String createrName;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	@ApiModelProperty(value = "更新人id")
	private String updator;

	@ApiModelProperty(value = "更新人name")
	private String updaterName;

	@ApiModelProperty(value = "更新时间")
	private Date updateDate;

	@ApiModelProperty(value = "是否删除0否1是")
	private Integer deleted;


}