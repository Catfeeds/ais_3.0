/*
 * BasUserRole.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.sysMng.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "系统用户权限对象")
public class BasUserRole {
    /**
     * 用户ID
     */
	@ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 角色ID
     */
	@ApiModelProperty(value = "角色ID")
    private String roleId;

    /**
     * 局点id
     */
	@ApiModelProperty(value = "局点ID")
    private String beid;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}