package com.digihealth.anesthesia.basedata.formbean;

import java.math.BigDecimal;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "his药品对应的价格参数对象")
public class HisPrice {

	@ApiModelProperty(value = "主键id")
	private Integer priceId;

	@JsonProperty(value = "Code")
	@ApiModelProperty(value = "编码")
	private String code;

	@ApiModelProperty(value = "his药品编码")
	private String hismedicineCode;

	@JsonProperty(value = "Spec")
	@ApiModelProperty(value = "规格")
	private String spec;

	@JsonProperty(value = "Firm")
	@ApiModelProperty(value = "厂家")
	private String firm;

	@JsonProperty(value = "Batch")
	@ApiModelProperty(value = "批次")
	private String batch;

	@JsonProperty(value = "MinPackageUnit")
	@ApiModelProperty(value = "最小计价 (包装)单位")
	private String minPackageUnit;

	@JsonProperty(value = "PriceMinPackage")
	@ApiModelProperty(value = "最小计价单位对应价格")
	private BigDecimal priceMinPackage;

	@JsonProperty(value = "Enable")
	@ApiModelProperty(value = "是否可用;1-是，0-无")
	private String enable;

	@ApiModelProperty(value = "药房代码")
	private String pharmaciesCode;

	@ApiModelProperty(value = "药房名称")
	private String pharmaciesName;

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午4:43:36
	 * @return type
	 */

	public Integer getPriceId() {
		return priceId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午4:43:36
	 * @param priceId
	 */
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHismedicineCode() {
		return hismedicineCode;
	}

	public void setHismedicineCode(String hismedicineCode) {
		this.hismedicineCode = hismedicineCode;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = StringUtils.isEmpty(spec) ? spec : spec.trim();
	}

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = StringUtils.isEmpty(firm) ? firm : firm.trim();
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getMinPackageUnit() {
		return minPackageUnit;
	}

	public void setMinPackageUnit(String minPackageUnit) {
		this.minPackageUnit = minPackageUnit;
	}

	public BigDecimal getPriceMinPackage() {
		return priceMinPackage;
	}

	public void setPriceMinPackage(BigDecimal priceMinPackage) {
		this.priceMinPackage = priceMinPackage;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getPharmaciesCode() {
		return pharmaciesCode;
	}

	public void setPharmaciesCode(String pharmaciesCode) {
		this.pharmaciesCode = pharmaciesCode;
	}

	public String getPharmaciesName() {
		return pharmaciesName;
	}

	public void setPharmaciesName(String pharmaciesName) {
		this.pharmaciesName = pharmaciesName;
	}
}