package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
     * Title: AnaesMethodFormBean.java    
     * Description: 基础数据查询返回formbean
     * @author chengwang       
     * @created 2015年11月6日 上午10:41:36
 */
@ApiModel(value="收费项目结果对象")
public class BasChargeItemFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    /**
     * 收费项目id
     */
    @ApiModelProperty(value="收费项目id")
    private String chargeItemId;
    
	/**
	 * 名称
	 */
    @ApiModelProperty(value="名称")
	private String name;
    
    /**
     * 单位
     */
    @ApiModelProperty(value="单位")
    private String unit;
    
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
	
	
	public String getChargeItemId()
    {
        return chargeItemId;
    }
    public void setChargeItemId(String chargeItemId)
    {
        this.chargeItemId = chargeItemId;
    }
    public String getPinYin()
    {
        return pinYin;
    }
    public void setPinYin(String pinYin)
    {
        this.pinYin = pinYin;
    }
    public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	
	
}
