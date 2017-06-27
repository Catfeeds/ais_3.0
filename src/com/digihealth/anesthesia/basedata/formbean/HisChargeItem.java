package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HisChargeItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer chargeItemId;
	
	@JsonProperty(value = "ItemCode")
	private String itemCode;
	
	@JsonProperty(value = "ItemName")
	private String itemName;
	
	@JsonProperty(value = "Spec")
	private String spec;
	
	@JsonProperty(value = "Pinyin")
	private String pinyin;
	
	@JsonProperty(value = "Unit")
	private String unit;
	
	@JsonProperty(value = "Price")
	private float price;
	
	@JsonProperty(value = "Type")
	private String type;
	
	@JsonProperty(value = "Enable")
	private String enable;
	
	private float basicUnitAmount;
	
	private float basicUnitPrice;
	
	private String chargeType;
	
	private Integer chargeItemAmount;
	
	private Integer chItPkgId;

	public Integer getChargeItemAmount() {
		return chargeItemAmount;
	}

	public void setChargeItemAmount(Integer chargeItemAmount) {
		this.chargeItemAmount = chargeItemAmount;
	}

	public Integer getChItPkgId() {
		return chItPkgId;
	}

	public void setChItPkgId(Integer chItPkgId) {
		this.chItPkgId = chItPkgId;
	}

	public Integer getChargeItemId() {
		return chargeItemId;
	}

	public void setChargeItemId(Integer chargeItemId) {
		this.chargeItemId = chargeItemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = StringUtils.isEmpty(spec) ? spec : spec.trim();
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = StringUtils.isEmpty(pinyin) ? pinyin : pinyin.trim();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = StringUtils.isEmpty(unit) ? unit : unit.trim();
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public float getBasicUnitAmount() {
		return basicUnitAmount;
	}

	public void setBasicUnitAmount(float basicUnitAmount) {
		this.basicUnitAmount = basicUnitAmount;
	}

	public float getBasicUnitPrice() {
		return basicUnitPrice;
	}

	public void setBasicUnitPrice(float basicUnitPrice) {
		this.basicUnitPrice = basicUnitPrice;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
}