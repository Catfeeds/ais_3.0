package com.digihealth.anesthesia.evt.formbean;

import java.util.List;

import com.digihealth.anesthesia.evt.po.EvtCheckEvent;
import com.digihealth.anesthesia.evt.po.EvtCheckEventItemRelation;

/**
 * 检验检测事件明细
 * 
 * @author liukui
 * 
 */
public class CheckeventItemFormBean {

	private EvtCheckEvent evtCheckEvent;

	private List<EvtCheckEventItemRelation> checkeventItemRelationList;

	public EvtCheckEvent getEvtCheckEvent() {
		return evtCheckEvent;
	}

	public void setEvtCheckEvent(EvtCheckEvent evtCheckEvent) {
		this.evtCheckEvent = evtCheckEvent;
	}

	public List<EvtCheckEventItemRelation> getCheckeventItemRelationList() {
		return checkeventItemRelationList;
	}

	public void setCheckeventItemRelationList(
			List<EvtCheckEventItemRelation> checkeventItemRelationList) {
		this.checkeventItemRelationList = checkeventItemRelationList;
	}

}
