/*
 * EvtShiftChange.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "交接班对象")
public class EvtShiftChange {
	
	@ApiModelProperty(value = "id")
	private Integer id;

    /**
     * 文书Id
     */
    @ApiModelProperty(value = "文书ID")
    private String docId;

    /**
     * 交班人员
     */
    @ApiModelProperty(value = "交班人员")
    private String shiftChangedPeople;

    /**
     * 交班人员
     */
    @ApiModelProperty(value = "交班人员")
    private String shiftChangedPeopleId;

    @ApiModelProperty(value = "被交班人员角色")
    private String shiftChangedPeopleRole;

    /**
     * 接班时间
     */
    @ApiModelProperty(value = "接班时间")
    private Date shiftChangeTime;

    /**
     * 接班人员
     */
    @ApiModelProperty(value = "接班人员")
    private String shiftChangePeople;

    /**
     * 接班人员
     */
    @ApiModelProperty(value = "接班人员")
    private String shiftChangePeopleId;

    @ApiModelProperty(value = "交接班人员角色")
    private String shiftChangePeopleRole;

    /**
     * 注意事项
     */
    @ApiModelProperty(value = "注意事项")
    private String notes;

    /**
     * 交班人工作时长（分钟）
     */
    @ApiModelProperty(value = "交班人工作时长（分钟）")
    private String times;
    
    /**
     * 接班人员密码
     */
    @ApiModelProperty(value = "接班人员密码")
    private String shiftChangePeoplePwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getShiftChangedPeople() {
        return shiftChangedPeople;
    }

    public void setShiftChangedPeople(String shiftChangedPeople) {
        this.shiftChangedPeople = shiftChangedPeople == null ? null : shiftChangedPeople.trim();
    }

    public String getShiftChangedPeopleId() {
        return shiftChangedPeopleId;
    }

    public void setShiftChangedPeopleId(String shiftChangedPeopleId) {
        this.shiftChangedPeopleId = shiftChangedPeopleId == null ? null : shiftChangedPeopleId.trim();
    }

    public String getShiftChangedPeopleRole() {
        return shiftChangedPeopleRole;
    }

    public void setShiftChangedPeopleRole(String shiftChangedPeopleRole) {
        this.shiftChangedPeopleRole = shiftChangedPeopleRole == null ? null : shiftChangedPeopleRole.trim();
    }

    public Date getShiftChangeTime() {
        return shiftChangeTime;
    }

    public void setShiftChangeTime(Date shiftChangeTime) {
        this.shiftChangeTime = shiftChangeTime;
    }

    public String getShiftChangePeople() {
        return shiftChangePeople;
    }

    public void setShiftChangePeople(String shiftChangePeople) {
        this.shiftChangePeople = shiftChangePeople == null ? null : shiftChangePeople.trim();
    }

    public String getShiftChangePeopleId() {
        return shiftChangePeopleId;
    }

    public void setShiftChangePeopleId(String shiftChangePeopleId) {
        this.shiftChangePeopleId = shiftChangePeopleId == null ? null : shiftChangePeopleId.trim();
    }

    public String getShiftChangePeopleRole() {
        return shiftChangePeopleRole;
    }

    public void setShiftChangePeopleRole(String shiftChangePeopleRole) {
        this.shiftChangePeopleRole = shiftChangePeopleRole == null ? null : shiftChangePeopleRole.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times == null ? null : times.trim();
    }

	public String getShiftChangePeoplePwd()
	{
		return shiftChangePeoplePwd;
	}

	public void setShiftChangePeoplePwd(String shiftChangePeoplePwd)
	{
		this.shiftChangePeoplePwd = shiftChangePeoplePwd;
	}
    
}