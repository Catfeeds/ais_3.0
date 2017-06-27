package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.basedata.po.BasInstrSuitRel;
import com.digihealth.anesthesia.basedata.po.BasInstrsuit;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "手术包参数对象")
public class InstrsuitFromBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "手术包")
	private BasInstrsuit instrsuit;

	@ApiModelProperty(value = "手术包所对应的器械")
	private List<BasInstrSuitRel> instrSuitRelList;

	public BasInstrsuit getInstrsuit() {
		return instrsuit;
	}

	public void setInstrsuit(BasInstrsuit instrsuit) {
		this.instrsuit = instrsuit;
	}

	public List<BasInstrSuitRel> getInstrSuitRelList() {
		return instrSuitRelList;
	}

	public void setInstrSuitRelList(List<BasInstrSuitRel> instrSuitRelList) {
		this.instrSuitRelList = instrSuitRelList;
	}

}
