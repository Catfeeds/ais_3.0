package com.digihealth.anesthesia.doc.formbean;

import java.util.List;

import com.digihealth.anesthesia.doc.po.DocInsuredChargeInform;
import com.digihealth.anesthesia.doc.po.DocInsuredChargeItem;

public class InsuredChargeInformFormbean {
	private DocInsuredChargeInform insuredChargeInform;

	private List<DocInsuredChargeItem> insuredChargeItemList;

	public DocInsuredChargeInform getInsuredChargeInform() {
		return insuredChargeInform;
	}

	public void setInsuredChargeInform(DocInsuredChargeInform insuredChargeInform) {
		this.insuredChargeInform = insuredChargeInform;
	}

	public List<DocInsuredChargeItem> getInsuredChargeItemList() {
		return insuredChargeItemList;
	}

	public void setInsuredChargeItemList(List<DocInsuredChargeItem> insuredChargeItemList) {
		this.insuredChargeItemList = insuredChargeItemList;
	}
}
