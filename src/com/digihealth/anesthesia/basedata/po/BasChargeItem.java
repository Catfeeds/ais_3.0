package com.digihealth.anesthesia.basedata.po;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


@ApiModel(value="收费项目对象")
public class BasChargeItem {
    /**
     * 收费项目id
     */
    @ApiModelProperty(value="收费项目id")
    private String chargeItemId;

    /**
     * 收费项目代码
     */
    @ApiModelProperty(value="收费项目代码")
    private String chargeItemCode;

    /**
     * 收费项目名称
     */
    @ApiModelProperty(value="收费项目名称")
    private String chargeItemName;

    /**
     * 规格
     */
    @ApiModelProperty(value="规格")
    private String spec;

    /**
     * 拼音
     */
    @ApiModelProperty(value="拼音")
    private String pinYin;

    /**
     * 单位
     */
    @ApiModelProperty(value="单位")
    private String unit;

    /**
     * 每单位对应的价格
     */
    @ApiModelProperty(value="每单位对应的价格")
    private Float price;

    /**
     * 收费项目类型
     */
    @ApiModelProperty(value="收费项目类型")
    private String type;

    /**
     * 是否可用;1-是，0-否
     */
    @ApiModelProperty(value="是否可用;1-是，0-否")
    private Integer enable;

    /**
     * 基本收费单位数量
     */
    @ApiModelProperty(value="基本收费单位数量")
    private Float basicUnitAmount;

    /**
     * 收费项目金额
     */
    @ApiModelProperty(value="收费项目金额")
    private Float chgItemAmount;
    
    /**
     * 基本收费单位数量价格
     */
    @ApiModelProperty(value="基本收费单位数量价格")
    private Float basicUnitPrice;

    /**
     * 收费类型（简单，复杂）
     */
    @ApiModelProperty(value="收费类型（简单，复杂）")
    private String chargeType;

    /**
     * 收费项目名称
     */
    @ApiModelProperty(value="收费项目名称")
    private String name;
    
    /**
     * 基线id
     */
    @ApiModelProperty(value="基线id")
    private String beid;

    public String getChargeItemId() {
        return chargeItemId;
    }

    public void setChargeItemId(String chargeItemId) {
        this.chargeItemId = chargeItemId == null ? null : chargeItemId.trim();
    }

    public String getChargeItemCode() {
        return chargeItemCode;
    }

    public void setChargeItemCode(String chargeItemCode) {
        this.chargeItemCode = chargeItemCode == null ? null : chargeItemCode.trim();
    }

    public String getChargeItemName() {
        return chargeItemName;
    }

    public void setChargeItemName(String chargeItemName) {
        this.chargeItemName = chargeItemName == null ? null : chargeItemName.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Float getBasicUnitAmount() {
        return basicUnitAmount;
    }

    public void setBasicUnitAmount(Float basicUnitAmount) {
        this.basicUnitAmount = basicUnitAmount;
    }

    public Float getChgItemAmount() {
		return chgItemAmount;
	}

	public void setChgItemAmount(Float chgItemAmount) {
		this.chgItemAmount = chgItemAmount;
	}

	public Float getBasicUnitPrice() {
        return basicUnitPrice;
    }

    public void setBasicUnitPrice(Float basicUnitPrice) {
        this.basicUnitPrice = basicUnitPrice;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeid() {
        return beid;
    }

    public void setBeid(String beid) {
        this.beid = beid == null ? null : beid.trim();
    }
}