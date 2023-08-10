package com.lvgu.industrynew.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统用户
 *
 * @author fyh 731530116@qq.com
 * @since 1.0.0 2023-08-10
 */
@ApiModel(value = "系统用户")
@Data
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID")
	private String id;

	@ApiModelProperty(value = "姓名")
	private String userName;

	@ApiModelProperty(value = "登录名")
	private String loginName;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "加盐")
	private String salt;

	@ApiModelProperty(value = "是否在线")
	private Integer isOnline;

	@ApiModelProperty(value = "是否锁定")
	private Integer isLocked;

	@ApiModelProperty(value = "系统管理员")
	private Integer isSystem;

	@ApiModelProperty(value = "")
	private String registerIp;

	@ApiModelProperty(value = "登陆时间")
	private Date loginTime;

	@ApiModelProperty(value = "登陆IP")
	private String loginIp;

	@ApiModelProperty(value = "登陆次数")
	private Integer loginCount;

	@ApiModelProperty(value = "用户类别,0系统管理，1专家,2种植者(21种植者子账号),3消费者,4检测机构")
	private String userType;

	@ApiModelProperty(value = "头像")
	private String headPic;

	@ApiModelProperty(value = "银行卡号")
	private String cardno;

	@ApiModelProperty(value = "住址")
	private String address;

	@ApiModelProperty(value = "手机")
	private String phone;

	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "生日")
	private String birthday;

	@ApiModelProperty(value = "用户所属公司id,base_company.id")
	private String companyId;

	@ApiModelProperty(value = "人员识别卡, rfid")
	private String rfid;

	@ApiModelProperty(value = "工号")
	private String worknum;

	@ApiModelProperty(value = "岗位id")
	private String stationIds;

	@ApiModelProperty(value = "微信绑定id")
	private String wxid;

	@ApiModelProperty(value = "登录token")
	private String token;

	@ApiModelProperty(value = "用户所属团队id")
	private String teamId;

	@ApiModelProperty(value = "管辖区域")
	private String jurisdiction;

	@ApiModelProperty(value = "微信地址")
	private String email;

	@ApiModelProperty(value = "备注信息")
	private String content;

	@ApiModelProperty(value = "积分")
	private Integer integral;

	@ApiModelProperty(value = "亩数")
	private String scale;

	@ApiModelProperty(value = "身份证正面照片")
	private String idCardFront;

	@ApiModelProperty(value = "身份证背面照片")
	private String idCardBack;

	@ApiModelProperty(value = "产业")
	private String estate;

	@ApiModelProperty(value = "省")
	private String province;

	@ApiModelProperty(value = "市")
	private String city;

	@ApiModelProperty(value = "区/县")
	private String area;

	@ApiModelProperty(value = "归属地")
	private String location;

	@ApiModelProperty(value = "超管标志")
	private Integer adminLabel;

	@ApiModelProperty(value = "修改密码次数")
	private Integer modifyPasswordNum;

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

	public void setPassword(String passwd) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(passwd);
	}
}