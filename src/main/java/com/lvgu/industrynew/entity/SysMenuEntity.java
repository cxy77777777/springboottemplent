package com.lvgu.industrynew.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@TableName("sys_menu")
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="sys_menu对象", description="菜单")
public class SysMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 父级ID
     */
	private String parentId;
    /**
     * 树路径
     */
	private String path;
    /**
     * 菜单名称
     */
	private String name;
    /**
     * 菜单别名
     */
	private String aliasName;
    /**
     * 资源类型
     */
	private String type;
    /**
     * 菜单链接
     */
	private String href;
    /**
     * 打开方式
     */
	private String target;
    /**
     * 菜单图标
     */
	private String micon;
    /**
     * 是否显示
     */
	private Integer isShow;
    /**
     * 是否启用
     */
	private Integer isEnabled;
    /**
     * 权限标识
     */
	private String permission;
    /**
     * 菜单介绍
     */
	private String description;
    /**
     * 排序字段
     */
	private Long location;
    /**
     * 有子节点
     */
	private Integer hasChildren;
    /**
     * 创建人id
     */
	private String creator;
    /**
     * 创建人name
     */
	private String createrName;
    /**
     * 创建时间
     */
	private Date createDate;
    /**
     * 更新人id
     */
	private String updator;
    /**
     * 更新人name
     */
	private String updaterName;
    /**
     * 更新时间
     */
	private Date updateDate;
    /**
     * 是否删除0否1是
     */
	private Integer deleted;
}