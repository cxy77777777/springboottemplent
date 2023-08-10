package com.lvgu.industrynew.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典类型
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2022-08-05
 */
@TableName("sys_dict_type")
public class SysDictTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 字典类型
     */
	private String dictType;
    /**
     * 字典名称
     */
	private String dictName;
    /**
     * 备注
     */
	private String remark;
    /**
     * 排序
     */
	private Integer sort;
    /**
     * 创建者
     */
	private String creator;
    /**
     * 创建时间
     */
	private Date createDate;
    /**
     * 更新者
     */
	private String updater;
    /**
     * 更新时间
     */
	private Date updateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}