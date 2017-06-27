package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.doc.po.DocEventBilling;
import com.digihealth.anesthesia.doc.po.DocPackagesItem;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: MedIoChargeFormBean.java Description: 修改费用统计
 * 
 * @author chengwang
 * @created 2015年12月17日 下午3:23:51
 */
@ApiModel(value = "查询参数对象")
public class MedIoChargeFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "medList")
	private List<DocEventBilling> medList;

	@ApiModelProperty(value = "费用统计单")
	private List<DocEventBilling> ioList;

	@ApiModelProperty(value = "收费项目")
	private List<DocPackagesItem> packagesCharge;

	@ApiModelProperty(value = "收费项目")
	private List<DocPackagesItem> charge;

	public List<DocEventBilling> getMedList() {
		return medList;
	}

	public void setMedList(List<DocEventBilling> medList) {
		this.medList = medList;
	}

	public List<DocEventBilling> getIoList() {
		return ioList;
	}

	public void setIoList(List<DocEventBilling> ioList) {
		this.ioList = ioList;
	}

	public List<DocPackagesItem> getPackagesCharge() {
		return packagesCharge;
	}

	public void setPackagesCharge(List<DocPackagesItem> packagesCharge) {
		this.packagesCharge = packagesCharge;
	}

	public List<DocPackagesItem> getCharge() {
		return charge;
	}

	public void setCharge(List<DocPackagesItem> charge) {
		this.charge = charge;
	}

}
