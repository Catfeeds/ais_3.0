package com.digihealth.anesthesia.doc.formbean;

import java.util.List;
import com.digihealth.anesthesia.doc.po.DocAccede;
import com.digihealth.anesthesia.doc.po.DocAccedeInformed;

public class AccedeFormBean {

	private DocAccede accede;
	private List<DocAccedeInformed> accedeInformedList;

	public DocAccede getAccede() {
		return accede;
	}

	public void setAccede(DocAccede accede) {
		this.accede = accede;
	}

	public List<DocAccedeInformed> getAccedeInformedList() {
		return accedeInformedList;
	}

	public void setAccedeInformedList(List<DocAccedeInformed> accedeInformedList) {
		this.accedeInformedList = accedeInformedList;
	}

}
