package com.lvgu.industrynew.comments;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author Mark sunlightcs@gmail.com
 */
@ApiModel(value = "分页数据")
public class PageData<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "总记录数")
    private int count;

    @ApiModelProperty(value = "列表数据")
    private List<T> data;

    /**
     * 分页
     * @param data   列表数据
     * @param count  总记录数
     */
    public PageData(List<T> data, long count) {
        this.data = data;
        this.count = (int)count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}