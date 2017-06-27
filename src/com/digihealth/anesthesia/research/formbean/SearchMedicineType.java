package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchMedicineType implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "药品id")
	private Integer medicineId;

	@ApiModelProperty(value = "药品名称")
	private String name;

	@ApiModelProperty(value = "剂量")
	private float dosage;

	public float getDosage() {
		return dosage;
	}

	public void setDosage(float dosage) {
		this.dosage = dosage;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
