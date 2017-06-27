package com.digihealth.anesthesia.research.formbean;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SciTempFormBean {
	/**
	 * 科研模板id
	 */
	@ApiModelProperty(value = "科研模板id")
	private String id;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 创建人id
	 */
	@ApiModelProperty(value = "创建人id")
	private String createUser;

	/**
	 * 创建人名称
	 */
	@ApiModelProperty(value = "创建人名称")
	private String createUsername;

	/**
	 * 模板名称
	 */
	@ApiModelProperty(value = "模板名称")
	private String tmpName;

	/**
	 * 模板级别：1，个人；2，科室
	 */
	@ApiModelProperty(value = "模板级别：1，个人；2，科室")
	private Integer type;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 模板json
	 */
	@ApiModelProperty(value = "模板json")
	private String tmpJson;

	/**
	 * 模板sql
	 */
	@ApiModelProperty(value = "模板sql")
	private String tmpSql;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	public String getTmpName() {
		return tmpName;
	}

	public void setTmpName(String tmpName) {
		this.tmpName = tmpName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTmpJson() {
		return tmpJson;
	}

	public void setTmpJson(String tmpJson) {
		this.tmpJson = tmpJson;
	}

	public String getTmpSql() {
		return tmpSql;
	}

	public void setTmpSql(String tmpSql) {
		this.tmpSql = tmpSql;
	}

}
