package com.digihealth.anesthesia.basedata.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: DispatchPeopleNameFormBean.java Description: 查到排班人员的名字
 * 
 * @author chengwang
 * @created 2015年10月30日 下午2:05:05
 */
@ApiModel(value = "排班人员参数对象")
public class DispatchPeopleNameFormBean {
	
	@ApiModelProperty(value = "器械护士1")
	private String instrnurseName1;

	@ApiModelProperty(value = "器械护士2")
	private String instrnurseName2;

	@ApiModelProperty(value = "巡回护士1")
	private String circunurseName1;

	@ApiModelProperty(value = "巡回护士2")
	private String circunurseName2;

	@ApiModelProperty(value = "麻醉医生")
	private String anesthetistName;

	@ApiModelProperty(value = "上级医生")
	private String circuanesthetistName;

	@ApiModelProperty(value = "灌注医生")
	private String perfusiondoctorName;

	public String getInstrnurseName1() {
		return instrnurseName1;
	}

	public void setInstrnurseName1(String instrnurseName1) {
		this.instrnurseName1 = instrnurseName1;
	}

	public String getInstrnurseName2() {
		return instrnurseName2;
	}

	public void setInstrnurseName2(String instrnurseName2) {
		this.instrnurseName2 = instrnurseName2;
	}

	public String getCircunurseName1() {
		return circunurseName1;
	}

	public void setCircunurseName1(String circunurseName1) {
		this.circunurseName1 = circunurseName1;
	}

	public String getCircunurseName2() {
		return circunurseName2;
	}

	public void setCircunurseName2(String circunurseName2) {
		this.circunurseName2 = circunurseName2;
	}

	public String getAnesthetistName() {
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}

	public String getCircuanesthetistName() {
		return circuanesthetistName;
	}

	public void setCircuanesthetistName(String circuanesthetistName) {
		this.circuanesthetistName = circuanesthetistName;
	}

	public String getPerfusiondoctorName() {
		return perfusiondoctorName;
	}

	public void setPerfusiondoctorName(String perfusiondoctorName) {
		this.perfusiondoctorName = perfusiondoctorName;
	}

}
