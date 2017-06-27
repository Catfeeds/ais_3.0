/*
 * DocPackagesItem.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "收费项目对象")
public class DocPackagesItem {

	@ApiModelProperty(value = "主键id")
	private String pkItId;

	@ApiModelProperty(value = "患者id")
	private String regOptId;

	/**
	 * 套餐包ID
	 */
	@ApiModelProperty(value = "套餐包ID")
	private Integer chargePkgId;

	/**
	 * 收费项目ID
	 */
	@ApiModelProperty(value = "收费项目ID")
	private Integer chargeItemId;

	/**
	 * 数量
	 */
	@ApiModelProperty(value = "数量")
	private Float chargeAmount;

	/**
	 * 是否计费
	 */
	@ApiModelProperty(value = "是否计费")
	private Boolean isCharge;

	/**
	 * 区别相同套餐
	 */
	@ApiModelProperty(value = "区别相同套餐")
	private String flag;

	/**
	 * 折扣
	 */
	@ApiModelProperty(value = "折扣")
	private Float discount;

	/**
	 * 用户类型
	 */
	@ApiModelProperty(value = "用户类型")
	private String userType;

	/**
	 * 最小包装单位价格
	 */
	@ApiModelProperty(value = "最小包装单位价格")
	private Float priceMinPackage;

	/**
	 * 单位
	 */
	@ApiModelProperty(value = "单位")
	private String unit;

	/**
	 * 计费状态
	 */
	@ApiModelProperty(value = "计费状态")
	private String state;

	/**
	 * 创建者
	 */
	@ApiModelProperty(value = "创建者")
	private String createUser;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private String createTime;

	@ApiModelProperty(value = "chargeType")
	private String chargeType;

	@ApiModelProperty(value = "shouldSum")
	private float shouldSum;

	@ApiModelProperty(value = "realSum")
	private float realSum;

	@ApiModelProperty(value = "名称")
	private String name;

	public String getPkItId() {
		return pkItId;
	}

	public void setPkItId(String pkItId) {
		this.pkItId = pkItId == null ? null : pkItId.trim();
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId == null ? null : regOptId.trim();
	}

	public Integer getChargePkgId() {
		return chargePkgId;
	}

	public void setChargePkgId(Integer chargePkgId) {
		this.chargePkgId = chargePkgId;
	}

	public Integer getChargeItemId() {
		return chargeItemId;
	}

	public void setChargeItemId(Integer chargeItemId) {
		this.chargeItemId = chargeItemId;
	}

	public Float getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(Float chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public Boolean getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(Boolean isCharge) {
		this.isCharge = isCharge;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag == null ? null : flag.trim();
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType == null ? null : userType.trim();
	}

	public Float getPriceMinPackage() {
		return priceMinPackage;
	}

	public void setPriceMinPackage(Float priceMinPackage) {
		this.priceMinPackage = priceMinPackage;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public float getShouldSum() {
		return shouldSum;
	}

	public void setShouldSum(float shouldSum) {
		this.shouldSum = shouldSum;
	}

	public float getRealSum() {
		return realSum;
	}

	public void setRealSum(float realSum) {
		this.realSum = realSum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}