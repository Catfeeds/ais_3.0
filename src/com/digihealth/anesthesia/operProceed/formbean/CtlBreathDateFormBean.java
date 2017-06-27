package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="查询参数对象")
public class CtlBreathDateFormBean {

    @ApiModelProperty(value="开始时间")
	private Date startTime; // 开始时间

    @ApiModelProperty(value="结束时间")
	private Date endTime; // 结束时间

    @ApiModelProperty(value="呼吸类型")
	private Integer type; // 呼吸类型

    @ApiModelProperty(value="图片路径")
	private String codeValue; // 图片路径

    @ApiModelProperty(value="codeSvg")
	private String codeSvg;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeSvg() {
		return codeSvg;
	}

	public void setCodeSvg(String codeSvg) {
		this.codeSvg = codeSvg;
	}

}
