package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

public class FirstSpotFormBean {
	private Date inTime;
	private String regOptId;
	private String docId;// 文书id
	private String beid;

	public String getBeid()
    {
        return beid;
    }

    public void setBeid(String beid)
    {
        this.beid = beid;
    }

    public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

}
