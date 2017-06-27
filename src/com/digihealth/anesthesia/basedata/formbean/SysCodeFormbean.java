package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: SysCodeFormbean.java Description:
 * 
 * @author chengwang
 * @created 2015年11月12日 下午6:14:51
 */
@ApiModel(value = "码表查询参数对象")
public class SysCodeFormbean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "码值")
	private String codeValue;

	@ApiModelProperty(value = "码值名称")
	private String codeName;

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

}
