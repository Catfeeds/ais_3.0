package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="手术室对象")
public class BasOperroom {
    /**
     * id
     */
    @ApiModelProperty(value="主键id")
    private String operRoomId;

    /**
     * 手术台
     */
    @ApiModelProperty(value="手术台")
    private Integer tableNum;

    /**
     * 手术室名称
     */
    @ApiModelProperty(value="手术室名称")
    private String name;

    /**
     * 有效标志;0-无效,1-有效
     */
    @ApiModelProperty(value="有效标志;0-无效,1-有效")
    private Integer enable;

    /**
     * 类型
     */
    @ApiModelProperty(value="类型")
    private String roomType;

    /**
     * 手术室等级
     */
    @ApiModelProperty(value="手术室等级")
    private String operLevel;

    /**
     * 术间分类
     */
    @ApiModelProperty(value="术间分类")
    private String roomCategory;

    /**
     *  专科ID
     */
    @ApiModelProperty(value="专科ID")
    private String deptId;

    /**
     * 专科名称
     */
    @ApiModelProperty(value="专科名称")
    private String deptName;

    /**
     * 最大连台数
     */
    @ApiModelProperty(value="最大连台数")
    private Integer maxOperNum;

    @ApiModelProperty(value="卫生护士")
    private String healthNurse;

    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getOperRoomId() {
        return operRoomId;
    }

    public void setOperRoomId(String operRoomId) {
        this.operRoomId = operRoomId == null ? null : operRoomId.trim();
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public String getOperLevel() {
        return operLevel;
    }

    public void setOperLevel(String operLevel) {
        this.operLevel = operLevel == null ? null : operLevel.trim();
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory == null ? null : roomCategory.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Integer getMaxOperNum() {
        return maxOperNum;
    }

    public void setMaxOperNum(Integer maxOperNum) {
        this.maxOperNum = maxOperNum;
    }

    public String getHealthNurse() {
        return healthNurse;
    }

    public void setHealthNurse(String healthNurse) {
        this.healthNurse = healthNurse == null ? null : healthNurse.trim();
    }

    public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}