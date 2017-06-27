/*
 * BasRoutingAccessControl.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "路由访问控制对象")
public class BasRoutingAccessControl {
    /**
     * 主键id
     */
	@ApiModelProperty(value = "主键id")
    private String id;

    /**
     * 基线id
     */
	@ApiModelProperty(value = "基线id")
    private String beid;

    /**
     * 访问资源URI
     */
	@ApiModelProperty(value = "访问资源URI")
    private String uri;

    /**
     * 对应的类
     */
	@ApiModelProperty(value = "对应的类")
    private String clazzUri;

    /**
     * 对应的方法
     */
	@ApiModelProperty(value = "对应的方法")
    private String method;

    /**
     * 方便扩展，唯一的别名
     */
	@ApiModelProperty(value = "方便扩展，唯一的别名")
    private String aliasName;

    /**
     * 描述
     */
	@ApiModelProperty(value = "描述")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getClazzUri() {
        return clazzUri;
    }

    public void setClazzUri(String clazzUri) {
        this.clazzUri = clazzUri == null ? null : clazzUri.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName == null ? null : aliasName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}