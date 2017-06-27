/*
 * EvtParticipant.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术人员对象")
public class EvtParticipant {
    /**
     * 手术人员主键
     */
	@ApiModelProperty(value = "手术人员主键")
    private String partpId;

    /**
     * 文书主键ID
     */
	@ApiModelProperty(value = "文书ID")
    private String docId;

    /**
     * 姓名
     */
	@ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 职位
     */
	@ApiModelProperty(value = "职位")
    private String role;

    /**
     * 创建人
     */
	@ApiModelProperty(value = "创建人")
    private String createUser;

    /**
     * 人员类型
     */
	@ApiModelProperty(value = "人员类型")
    private String operatorType;

    /**
     * 人员工号
     */
	@ApiModelProperty(value = "人员工号")
    private String userLoginName;

    /**
     * 是否为交接班数据;0-否,1-是
     */
	@ApiModelProperty(value = "是否为交接班数据;0-否,1-是")
    private Integer isShiftChange;

    /**
     * 文书类型：1-麻醉记录单，2-pacu观察记录单
     */
	@ApiModelProperty(value = "文书类型：1-麻醉记录单，2-pacu观察记录单")
    private Integer docType;

    public String getPartpId() {
        return partpId;
    }

    public void setPartpId(String partpId) {
        this.partpId = partpId == null ? null : partpId.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType == null ? null : operatorType.trim();
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName == null ? null : userLoginName.trim();
    }

    public Integer getIsShiftChange() {
        return isShiftChange;
    }

    public void setIsShiftChange(Integer isShiftChange) {
        this.isShiftChange = isShiftChange;
    }

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }
}