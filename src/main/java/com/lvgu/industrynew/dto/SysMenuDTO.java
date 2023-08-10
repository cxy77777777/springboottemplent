package com.lvgu.industrynew.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 菜单
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@ApiModel(value = "菜单")
@Data
public class SysMenuDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private String id;

	@ApiModelProperty(value = "父级ID")
	private String parentId;

	@ApiModelProperty(value = "树路径")
	private String path;

	@ApiModelProperty(value = "菜单名称")
	private String name;

	@ApiModelProperty(value = "菜单别名")
	private String aliasName;

	@ApiModelProperty(value = "资源类型")
	private String type;

	@ApiModelProperty(value = "菜单链接")
	private String href;

	@ApiModelProperty(value = "打开方式")
	private String target;

	@ApiModelProperty(value = "菜单图标")
	private String micon;

	@ApiModelProperty(value = "是否显示")
	private Integer isShow;

	@ApiModelProperty(value = "是否启用")
	private Integer isEnabled;

	@ApiModelProperty(value = "权限标识")
	private String permission;

	@ApiModelProperty(value = "菜单介绍")
	private String description;

	@ApiModelProperty(value = "排序字段")
	private Long location;

	@ApiModelProperty(value = "有子节点")
	private Integer hasChildren;

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