package com.digihealth.anesthesia.basedata.formbean;

import java.util.List;

import com.digihealth.anesthesia.tmp.po.TmpIoEvent;
import com.digihealth.anesthesia.tmp.po.TmpMedicine;
import com.digihealth.anesthesia.tmp.po.TmpMedicineEvent;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用药模版参数对象")
public class MedTempFormBean {

	@ApiModelProperty(value = "用药模版")
	private TmpMedicine medTemp;

	@ApiModelProperty(value = "麻醉事件模版对应的药品表")
	private List<TmpMedicineEvent> medTempEventList;

	@ApiModelProperty(value = "麻醉事件模版对应的药品表")
	private List<TmpMedicineEvent> zhlTempEventList;

	@ApiModelProperty(value = "入量模版")
	private List<TmpIoEvent> ioTempEventList;

	public List<TmpIoEvent> getIoTempEventList() {
		return ioTempEventList;
	}

	public void setIoTempEventList(List<TmpIoEvent> ioTempEventList) {
		this.ioTempEventList = ioTempEventList;
	}

	public List<TmpMedicineEvent> getZhlTempEventList() {
		return zhlTempEventList;
	}

	public void setZhlTempEventList(List<TmpMedicineEvent> zhlTempEventList) {
		this.zhlTempEventList = zhlTempEventList;
	}

	public TmpMedicine getMedTemp() {
		return medTemp;
	}

	public void setMedTemp(TmpMedicine medTemp) {
		this.medTemp = medTemp;
	}

	public List<TmpMedicineEvent> getMedTempEventList() {
		return medTempEventList;
	}

	public void setMedTempEventList(List<TmpMedicineEvent> medTempEventList) {
		this.medTempEventList = medTempEventList;
	}

}
