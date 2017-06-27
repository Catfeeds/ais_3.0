/*
 * BasHealthNurse.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.po;

import com.digihealth.anesthesia.sysMng.po.BasUser;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="卫生护士对象")
public class BasHealthNurse {
    
    @ApiModelProperty(value="主键id")
    private String id;

    @ApiModelProperty(value="手术室id")
    private String operRoomId;

    @ApiModelProperty(value="手术日期")
    private String operaDate;

    @ApiModelProperty(value="卫生护士")
    private String healthnurse;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;
    
    @ApiModelProperty(value="手术室名称")
    private String operRoomName;
    
    @ApiModelProperty(value="卫生护士名字")
    private String healthnurseName;
    
    @ApiModelProperty(value="用户对象")
    private BasUser hnUser;


    public String getOperRoomName()
    {
        return operRoomName;
    }

    public void setOperRoomName(String operRoomName)
    {
        this.operRoomName = operRoomName;
    }

    public String getHealthnurseName()
    {
        return healthnurseName;
    }

    public void setHealthnurseName(String healthnurseName)
    {
        this.healthnurseName = healthnurseName;
    }

    public BasUser getHnUser()
    {
        return hnUser;
    }

    public void setHnUser(BasUser hnUser)
    {
        this.hnUser = hnUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOperRoomId()
    {
        return operRoomId;
    }

    public void setOperRoomId(String operRoomId)
    {
        this.operRoomId = operRoomId;
    }

    public String getOperaDate() {
        return operaDate;
    }

    public void setOperaDate(String operaDate) {
        this.operaDate = operaDate == null ? null : operaDate.trim();
    }

    public String getHealthnurse() {
        return healthnurse;
    }

    public void setHealthnurse(String healthnurse) {
        this.healthnurse = healthnurse == null ? null : healthnurse.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}