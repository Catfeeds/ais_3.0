/*
 * BasAnaesKndgbase.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="知识库对象")
public class BasAnaesKndgbase {
    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private String id;

    /**
     * 父级id
     */
    @ApiModelProperty(value="父级id")
    private String pId;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String name;

    /**
     * 是否打开;0:不打开,1:打开
     */
    @ApiModelProperty(value="是否打开;0:不打开,1:打开")
    private Integer open;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 是否为目录
     */
    @ApiModelProperty(value="是否为目录")
    private Integer folder;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private String createUser;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getFolder() {
        return folder;
    }

    public void setFolder(Integer folder) {
        this.folder = folder;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}