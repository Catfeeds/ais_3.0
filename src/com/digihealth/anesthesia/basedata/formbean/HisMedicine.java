package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "his药品参数对象")
public class HisMedicine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "Code")
	@ApiModelProperty(value = "药品编码")
	private String code;

	@JsonProperty(value = "Type")
	@ApiModelProperty(value = "类型")
	private String type;

	@JsonProperty(value = "Enable")
	@ApiModelProperty(value = "是否可用;1-是，0-否")
	private String enable;

	@JsonProperty(value = "Pinyin")
	@ApiModelProperty(value = "拼音")
	private String pinyin;

	@JsonProperty(value = "Name")
	@ApiModelProperty(value = "名称")
	private String name;

	@JsonProperty(value = "Spec")
	@ApiModelProperty(value = "规格")
	private String spec;

	@ApiModelProperty(value = "his药品编号")
	private String hismedicineCode;

	@JsonProperty(value = "BriefName")
	@ApiModelProperty(value = "简称")
	private String briefName;

	@JsonProperty(value = "DosageUnit")
	@ApiModelProperty(value = "剂量单位")
	private String dosageUnit;

	@ApiModelProperty(value = "主键id")
	private Integer medicineId;

	@ApiModelProperty(value = "药品分类")
	private String roughType;

	@ApiModelProperty(value = "每最小包装单位中所含有的总剂量")
	private BigDecimal packageDosageAmount;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = StringUtils.isEmpty(pinyin) ? pinyin : pinyin.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = StringUtils.isEmpty(name) ? name : name.trim();
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = StringUtils.isEmpty(spec) ? spec : spec.trim();
	}

	public String getHismedicineCode() {
		return hismedicineCode;
	}

	public void setHismedicineCode(String hismedicineCode) {
		this.hismedicineCode = hismedicineCode;
	}

	public String getBriefName() {
		return briefName;
	}

	public void setBriefName(String briefName) {
		this.briefName = StringUtils.isEmpty(briefName) ? briefName : briefName
				.trim();
	}

	public String getDosageUnit() {
		return dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = StringUtils.isEmpty(dosageUnit) ? dosageUnit
				: dosageUnit.trim();
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午4:42:17
	 * @return type
	 */

	public Integer getMedicineId() {
		return medicineId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午4:42:17
	 * @param medicineId
	 */
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getRoughType() {
		return roughType;
	}

	public void setRoughType(String roughType) {
		this.roughType = roughType;
	}

	public BigDecimal getPackageDosageAmount() {
		return packageDosageAmount;
	}

	public void setPackageDosageAmount(BigDecimal packageDosageAmount) {
		this.packageDosageAmount = packageDosageAmount;
	}
}