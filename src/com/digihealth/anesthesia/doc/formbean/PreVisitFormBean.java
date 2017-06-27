package com.digihealth.anesthesia.doc.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.doc.po.DocPreVisit;
import com.digihealth.anesthesia.doc.po.DocPrevisitAccessexam;
import com.digihealth.anesthesia.doc.po.DocPrevisitAnaesplan;
import com.digihealth.anesthesia.doc.po.DocPrevisitPhyexam;

public class PreVisitFormBean implements Serializable{

	private DocPreVisit preVisit;
	private DocPrevisitAccessexam previsitAccessexam;
	private DocPrevisitAnaesplan previsitAnaesplan;
	private DocPrevisitPhyexam previsitPhyexam;
	
	public DocPreVisit getPreVisit() {
		return preVisit;
	}
	public void setPreVisit(DocPreVisit preVisit) {
		this.preVisit = preVisit;
	}
	public DocPrevisitAccessexam getPrevisitAccessexam() {
		return previsitAccessexam;
	}
	public void setPrevisitAccessexam(DocPrevisitAccessexam previsitAccessexam) {
		this.previsitAccessexam = previsitAccessexam;
	}
	public DocPrevisitAnaesplan getPrevisitAnaesplan() {
		return previsitAnaesplan;
	}
	public void setPrevisitAnaesplan(DocPrevisitAnaesplan previsitAnaesplan) {
		this.previsitAnaesplan = previsitAnaesplan;
	}
	public DocPrevisitPhyexam getPrevisitPhyexam() {
		return previsitPhyexam;
	}
	public void setPrevisitPhyexam(DocPrevisitPhyexam previsitPhyexam) {
		this.previsitPhyexam = previsitPhyexam;
	}
	
	
	
}
