package com.lvgu.industrynew.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@TableName("sys_user")
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="sys_user对象", description="系统用户")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 姓名
     */
	private String userName;
    /**
     * 登录名
     */
	private String loginName;
    /**
     * 密码
     */
	private String password;
    /**
     * 加盐
     */
	private String salt;
    /**
     * 是否在线
     */
	private Integer isOnline;
    /**
     * 是否锁定
     */
	private Integer isLocked;
    /**
     * 系统管理员
     */
	private Integer isSystem;
    /**
     * 
     */
	private String registerIp;
    /**
     * 登陆时间
     */
	private Date loginTime;
    /**
     * 登陆IP
     */
	private String loginIp;
    /**
     * 登陆次数
     */
	private Integer loginCount;
    /**
     * 用户类别,0系统管理，1专家,2种植者(21种植者子账号),3消费者,4检测机构
     */
	private String userType;
    /**
     * 头像
     */
	private String headPic;
    /**
     * 银行卡号
     */
	private String cardno;
    /**
     * 住址
     */
	private String address;
    /**
     * 手机
     */
	private String phone;
    /**
     * 性别
     */
	private String sex;
    /**
     * 生日
     */
	private String birthday;
    /**
     * 用户所属公司id,base_company.id
     */
	private String companyId;
    /**
     * 人员识别卡, rfid
     */
	private String rfid;
    /**
     * 工号
     */
	private String worknum;
    /**
     * 岗位id
     */
	private String stationIds;
    /**
     * 微信绑定id
     */
	private String wxid;
    /**
     * 登录token
     */
	private String token;
    /**
     * 用户所属团队id
     */
	private String teamId;
    /**
     * 管辖区域
     */
	private String jurisdiction;
    /**
     * 微信地址
     */
	private String email;
    /**
     * 备注信息
     */
	private String content;
    /**
     * 积分
     */
	private Integer integral;
    /**
     * 亩数
     */
	private String scale;
    /**
     * 身份证正面照片
     */
	private String idCardFront;
    /**
     * 身份证背面照片
     */
	private String idCardBack;
    /**
     * 产业
     */
	private String estate;
    /**
     * 省
     */
	private String province;
    /**
     * 市
     */
	private String city;
    /**
     * 区/县
     */
	private String area;
    /**
     * 归属地
     */
	private String location;
    /**
     * 超管标志
     */
	private Integer adminLabel;
    /**
     * 修改密码次数
     */
	private Integer modifyPasswordNum;
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

	public void setPassword(String passwd) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(passwd);
	}
}