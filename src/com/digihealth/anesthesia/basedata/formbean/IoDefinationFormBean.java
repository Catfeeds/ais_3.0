package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 药品出入量
 * 
 * @author liukui
 * 
 */
@ApiModel(value = "药品出入量参数对象")
public class IoDefinationFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "编码")
	private String code;

	@ApiModelProperty(value = "类型")
	private String type;

	@ApiModelProperty(value = "子类型")
	private String subType;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "简称")
	private String briefName;

	@ApiModelProperty(value = "单位")
	private String unit;

	@ApiModelProperty(value = "是否有效;1-有效，0-无效")
	private String enable;

	@ApiModelProperty(value = "规格")
	private String spec;

	@ApiModelProperty(value = "拼音")
	private String pinYin;

	@ApiModelProperty(value = "剂量单位")
	private String dosageUnit;

	@ApiModelProperty(value = "主键id")
	private String ioDefId;

	@ApiModelProperty(value = "每最小包装单位中所含有的总剂量")
	private float packageDosageAmount;

	@ApiModelProperty(value = "firm")
	private String firm;

	@ApiModelProperty(value = "价格id")
	private String priceId;

	@ApiModelProperty(value = "血型")
	private String blood;

	@ApiModelProperty(value = "子类型名称")
	private String subTypeName;

	@ApiModelProperty(value = "是否为自体血 0否，1是")
	private Integer autoBlood;

	public Integer getAutoBlood() {
		return autoBlood;
	}

	public void setAutoBlood(Integer autoBlood) {
		this.autoBlood = autoBlood;
	}

	public String getSubTypeName() {
		return subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

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

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBriefName() {
		return briefName;
	}

	public void setBriefName(String briefName) {
		this.briefName = briefName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getPinYin() {
		return pinYin;
	}

	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}

	public String getDosageUnit() {
		return dosageUnit;
	}

	public void setDosageUnit(String dosageUnit) {
		this.dosageUnit = dosageUnit;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午4:40:26
	 * @return type
	 */

	public String getIoDefId() {
		return ioDefId;
	}

	/**
	 * @author chengwang
	 * @created 2015-10-23 下午4:40:26
	 * @param ioDefId
	 */
	public void setIoDefId(String ioDefId) {
		this.ioDefId = ioDefId;
	}

	public float getPackageDosageAmount() {
		return packageDosageAmount;
	}

	public void setPackageDosageAmount(float packageDosageAmount) {
		this.packageDosageAmount = packageDosageAmount;
	}
}