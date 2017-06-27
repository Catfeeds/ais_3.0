package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class IntervalDataFormBean {
	
	@ApiModelProperty(value = "间隔时间数组")
	private List<Date> times;
	@ApiModelProperty(value = "手术id")
	private String regOptId;
	@ApiModelProperty(value = "频率")
	private Integer freq;
	@ApiModelProperty(value = "入室时间")
	private Date inTime;
	@ApiModelProperty(value = "页码")
	private Integer no;
	@ApiModelProperty(value = "每页数量")
	private Integer size;
	@ApiModelProperty(value = "局点id")
	private String beid;

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	public List<Date> getTimes() {
		return times;
	}

	public void setTimes(List<Date> times) {
		this.times = times;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
