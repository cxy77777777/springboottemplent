package com.lvgu.industrynew.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典数据
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2022-08-05
 */
@TableName("sys_dict_data")
public class SysDictDataEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 字典类型ID
     */
	private String dictTypeId;
    /**
     * 字典标签
     */
	private String dictLabel;
    /**
     * 字典值
     */
	private String dictValue;
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

	public String getDictTypeId() {
		return dictTypeId;
	}

	public void setDictTypeId(String dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	public String getDictLabel() {
		return dictLabel;
	}

	public void setDictLabel(String dictLabel) {
		this.dictLabel = dictLabel;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
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