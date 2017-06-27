/*
 * TmpSciTemp.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.tmp.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="科研模板对象")
public class TmpSciTemp {
    /**
     * 科研模板id
     */
    @ApiModelProperty(value="科研模板id")
    private String id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String createUser;

    /**
     * 模板名称
     */
    @ApiModelProperty(value="模板名称")
    private String tmpName;

    /**
     * 模板级别：1，个人；2，科室
     */
    @ApiModelProperty(value="模板级别")
    private Integer type;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
     * 模板json
     */
    @ApiModelProperty(value="模板json")
    private String tmpJson;

    /**
     * 模板sql
     */
    @ApiModelProperty(value="模板sql")
    private String tmpSql;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        this.createUser = createUser == null ? null : createUser.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTmpJson() {
        return tmpJson;
    }

    public void setTmpJson(String tmpJson) {
        this.tmpJson = tmpJson == null ? null : tmpJson.trim();
    }

    public String getTmpSql() {
        return tmpSql;
    }

    public void setTmpSql(String tmpSql) {
        this.tmpSql = tmpSql == null ? null : tmpSql.trim();
    }
}