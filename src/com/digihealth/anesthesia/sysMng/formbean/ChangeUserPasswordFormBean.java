package com.digihealth.anesthesia.sysMng.formbean;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "密码修改对象")
public class ChangeUserPasswordFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "帐号不能为空！")
	@Length(min = 1, max = 40, message = "帐号长度必须在1至40之间")
	@ApiModelProperty(value = "帐号")
	private String loginName;

	@NotEmpty(message = "旧密码不能为空！")
	@ApiModelProperty(value = "旧密码")
	private String password;

	@NotEmpty(message = "新密码不能为空！")
	@ApiModelProperty(value = "新密码")
	private String newPassword;

	@ApiModelProperty(value = "基线id")
	private String beid;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

}
