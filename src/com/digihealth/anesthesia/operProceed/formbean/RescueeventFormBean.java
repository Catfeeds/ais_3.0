package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

import com.digihealth.anesthesia.evt.po.EvtRescueevent;

/**
 * 修改模式的bean Title: RescueeventFormBean.java Description:
 * 
 * @author chenyong
 * @created 2016年7月23日 下午4:28:29
 */
public class RescueeventFormBean {

	private EvtRescueevent rescueevent;// 抢救事件

	private String model;// 模式 save | normal

	private String regOptId; // regOptId

	private Date time; //切换频率时间
	
	private String beid;

	public String getBeid()
    {
        return beid;
    }

    public void setBeid(String beid)
    {
        this.beid = beid;
    }

    public EvtRescueevent getRescueevent() {
		return rescueevent;
	}

	public void setRescueevent(EvtRescueevent rescueevent) {
		this.rescueevent = rescueevent;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
