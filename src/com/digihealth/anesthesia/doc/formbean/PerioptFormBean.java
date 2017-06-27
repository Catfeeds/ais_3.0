package com.digihealth.anesthesia.doc.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.doc.po.DocNursingDiagnosis;
import com.digihealth.anesthesia.doc.po.DocPeriopt;

public class PerioptFormBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private BasRegOpt regOpt;
	private DocPeriopt periopt;
	private List<DocNursingDiagnosis> nursingDiagnosisList;
	public DocPeriopt getPeriopt() {
		return periopt;
	}
	public void setPeriopt(DocPeriopt periopt) {
		this.periopt = periopt;
	}
	public List<DocNursingDiagnosis> getNursingDiagnosisList() {
		return nursingDiagnosisList;
	}
	public void setNursingDiagnosisList(List<DocNursingDiagnosis> nursingDiagnosisList) {
		this.nursingDiagnosisList = nursingDiagnosisList;
	}
	public BasRegOpt getRegOpt() {
		return regOpt;
	}
	public void setRegOpt(BasRegOpt regOpt) {
		this.regOpt = regOpt;
	}
	
	
}
