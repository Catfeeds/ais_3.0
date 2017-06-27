package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.basedata.po.BasChargeItemPackagesRel;
import com.digihealth.anesthesia.basedata.po.BasChargePackages;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="收费项目包参数对象")
public class BasChargePackagesFromBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @ApiModelProperty(value="收费项目包")
	private BasChargePackages chargePackages;

    @ApiModelProperty(value="收费项目关联表集合")
	private List<BasChargeItemPackagesRel> chargeItemPackagesRelList;

	public BasChargePackages getChargePackages() {
		return chargePackages;
	}

	public void setChargePackages(BasChargePackages chargePackages) {
		this.chargePackages = chargePackages;
	}

	public List<BasChargeItemPackagesRel> getChargeItemPackagesRelList() {
		return chargeItemPackagesRelList;
	}

	public void setChargeItemPackagesRelList(
			List<BasChargeItemPackagesRel> chargeItemPackagesRelList) {
		this.chargeItemPackagesRelList = chargeItemPackagesRelList;
	}

}
