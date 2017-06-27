package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.evt.po.EvtMedicalEvent;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "采集数据表参数对象")
public class PacuObsFormbean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "麻醉事件")
	private EvtMedicalEvent medicalevent;

	@ApiModelProperty(value = "pacuObsId")
	private String pacuObsId;

	public EvtMedicalEvent getMedicalevent() {
		return medicalevent;
	}

	public void setMedicalevent(EvtMedicalEvent medicalevent) {
		this.medicalevent = medicalevent;
	}

	public String getPacuObsId() {
		return pacuObsId;
	}

	public void setPacuObsId(String pacuObsId) {
		this.pacuObsId = pacuObsId;
	}

}
