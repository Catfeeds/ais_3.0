package com.digihealth.anesthesia.basedata.formbean;

import java.io.Serializable;

import com.digihealth.anesthesia.basedata.po.BasAnnouncement;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "公告查询参数对象")
public class BasAnnouncementFormBean extends BasAnnouncement implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "开始时间")
	private String beginTime;

	@ApiModelProperty(value = "结束时间")
	private String endTime;

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
