/*
 * DocEventBilling.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "费用统计单对象")
public class DocEventBilling {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键id")
     private String ebId;

    /**
     * 手术申请ID
     */
    @ApiModelProperty(value = "手术申请ID")
     private String regOptId;

    /**
     * 药品或者入量事件的ID
     */
    @ApiModelProperty(value = "药品或者入量事件的ID")
     private String objectId;

    /**
     * 药品或者入量的ID
     */
    @ApiModelProperty(value = "药品或者入量的ID")
     private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
     private String name;

    /**
     * 简称
     */
    @ApiModelProperty(value = "简称")
     private String otherName;

    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
     private String spec;

    /**
     * 厂家
     */
    @ApiModelProperty(value = "厂家")
     private String firm;

    /**
     * 药房代码
     */
    @ApiModelProperty(value = "药房代码")
     private String pharmaciesCode;

    /**
     * 药房名称
     */
    @ApiModelProperty(value = "药房名称")
     private String pharmaciesName;

    /**
     * 最小包装单位中所含有的总剂量
     */
    @ApiModelProperty(value = "最小包装单位中所含有的总剂量")
     private Float packageDosageAmount;

    /**
     * 使用总剂量
     */
    @ApiModelProperty(value = "使用总剂量")
     private Float dosageTotalAmount;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位")
     private String dosageUnit;

    /**
     * 使用总计价用量
     */
    @ApiModelProperty(value = "使用总计价用量")
     private Float packageTotalAmount;

    /**
     * 最小包装单位
     */
    @ApiModelProperty(value = "最小包装单位")
     private String minPackageUnit;

    /**
     * 最小包装单位对应的单价
     */
    @ApiModelProperty(value = "最小包装单位对应的单价")
     private Float priceMinPackage;

    /**
     * 折扣率
     */
    @ApiModelProperty(value = "折扣率")
     private Float discount;

    /**
     * 应收
     */
    @ApiModelProperty(value = "应收")
     private Float shouldCost;

    /**
     * 实收
     */
    @ApiModelProperty(value = "实收")
     private Float realCost;

    /**
     * 是否计费;0-否，1-是
     */
    @ApiModelProperty(value = "是否计费;0-否，1-是")
     private Integer isCharged;

    /**
     * 计费类型（入量或者药品）
     */
    @ApiModelProperty(value = "计费类型（入量或者药品）")
     private String chargedType;

    @ApiModelProperty(value = "创建人")
     private String createUser;

    /**
     * 计费是否上传
     */
    @ApiModelProperty(value = "计费是否上传")
     private String state;

    /**
     * 用户类型  麻醉医生/护士
     */
    @ApiModelProperty(value = "用户类型  麻醉医生/护士")
     private String userType;

    /**
     * 数据来源 1表示术中导入，2表示手动添加
     */
    @ApiModelProperty(value = "数据来源 1表示术中导入，2表示手动添加")
     private Integer source;

    @ApiModelProperty(value = "创建时间")
     private Date createTime;

    public String getEbId() {
        return ebId;
    }

    public void setEbId(String ebId) {
        this.ebId = ebId == null ? null : ebId.trim();
    }

    public String getRegOptId() {
        return regOptId;
    }

    public void setRegOptId(String regOptId) {
        this.regOptId = regOptId == null ? null : regOptId.trim();
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName == null ? null : otherName.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm == null ? null : firm.trim();
    }

    public String getPharmaciesCode() {
        return pharmaciesCode;
    }

    public void setPharmaciesCode(String pharmaciesCode) {
        this.pharmaciesCode = pharmaciesCode == null ? null : pharmaciesCode.trim();
    }

    public String getPharmaciesName() {
        return pharmaciesName;
    }

    public void setPharmaciesName(String pharmaciesName) {
        this.pharmaciesName = pharmaciesName == null ? null : pharmaciesName.trim();
    }

    public Float getPackageDosageAmount() {
        return packageDosageAmount;
    }

    public void setPackageDosageAmount(Float packageDosageAmount) {
        this.packageDosageAmount = packageDosageAmount;
    }

    public Float getDosageTotalAmount() {
        return dosageTotalAmount;
    }

    public void setDosageTotalAmount(Float dosageTotalAmount) {
        this.dosageTotalAmount = dosageTotalAmount;
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit == null ? null : dosageUnit.trim();
    }

    public Float getPackageTotalAmount() {
        return packageTotalAmount;
    }

    public void setPackageTotalAmount(Float packageTotalAmount) {
        this.packageTotalAmount = packageTotalAmount;
    }

    public String getMinPackageUnit() {
        return minPackageUnit;
    }

    public void setMinPackageUnit(String minPackageUnit) {
        this.minPackageUnit = minPackageUnit == null ? null : minPackageUnit.trim();
    }

    public Float getPriceMinPackage() {
        return priceMinPackage;
    }

    public void setPriceMinPackage(Float priceMinPackage) {
        this.priceMinPackage = priceMinPackage;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getShouldCost() {
        return shouldCost;
    }

    public void setShouldCost(Float shouldCost) {
        this.shouldCost = shouldCost;
    }

    public Float getRealCost() {
        return realCost;
    }

    public void setRealCost(Float realCost) {
        this.realCost = realCost;
    }

    public Integer getIsCharged() {
        return isCharged;
    }

    public void setIsCharged(Integer isCharged) {
        this.isCharged = isCharged;
    }

    public String getChargedType() {
        return chargedType;
    }

    public void setChargedType(String chargedType) {
        this.chargedType = chargedType == null ? null : chargedType.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
}