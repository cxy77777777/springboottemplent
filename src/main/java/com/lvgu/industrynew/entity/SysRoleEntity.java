package com.lvgu.industrynew.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@TableName("sys_role")
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="sys_role对象", description="角色")
public class SysRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * 
     */
	private String id;
    /**
     * 名称
     */
	private String name;
    /**
     * 代码
     */
	private String code;
    /**
     * 别名
     */
	private String aliasName;
    /**
     * 
     */
	private Integer isEnabled;
    /**
     * 
     */
	private String unitid;
    /**
     * 
     */
	private String description;
    /**
     * 
     */
	private Long location;
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