package com.digihealth.anesthesia.research.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "查询参数对象")
public class SearchRegionOperatCountByOptlev implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "病区id")
	private String regionId;

	@ApiModelProperty(value = "病区名称")
	private String regionName;

	@ApiModelProperty(value = "fst")
	private Long fst;

	@ApiModelProperty(value = "sec")
	private Long sec;

	@ApiModelProperty(value = "thd")
	private Long thd;

	@ApiModelProperty(value = "fou")
	private Long fou;

	@ApiModelProperty(value = "总计")
	private Long total;

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Long getFst() {
		return fst;
	}

	public void setFst(Long fst) {
		this.fst = fst;
	}

	public Long getSec() {
		return sec;
	}

	public void setSec(Long sec) {
		this.sec = sec;
	}

	public Long getThd() {
		return thd;
	}

	public void setThd(Long thd) {
		this.thd = thd;
	}

	public Long getFou() {
		return fou;
	}

	public void setFou(Long fou) {
		this.fou = fou;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
