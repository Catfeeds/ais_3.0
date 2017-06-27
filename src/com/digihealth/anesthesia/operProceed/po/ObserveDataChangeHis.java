package com.digihealth.anesthesia.operProceed.po;

import java.io.Serializable;
import java.sql.Timestamp;

import com.digihealth.anesthesia.common.utils.SysUtil;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 监测数据修改历史
 * 
 * @author huchao
 * 
 */
@ApiModel(value = "监测数据修改历史对象")
public class ObserveDataChangeHis implements Serializable, Cloneable {
	private static final long serialVersionUID = 1002L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "患者ID")
	private String regOptId;

	@ApiModelProperty(value = "时间")
	private Timestamp time;

	@ApiModelProperty(value = "观测点ID")
	private String observeId;

	@ApiModelProperty(value = "值")
	private Float value;

	@ApiModelProperty(value = "旧值")
	private Float oldValue;

	@ApiModelProperty(value = "创建人")
	private String userId;

	@ApiModelProperty(value = "memo")
	private String memo;

	@ApiModelProperty(value = "修改时间")
	private Timestamp modifyTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getObserveId() {
		return observeId;
	}

	public void setObserveId(String observeId) {
		this.observeId = observeId;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Float getOldValue() {
		return oldValue;
	}

	public void setOldValue(Float oldValue) {
		this.oldValue = oldValue;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public void setObserveDataChange(BasObserveData data, Float newValue) {
		this.regOptId = data.getRegOptId();
		this.id = data.getId();
		this.memo = "";
		this.modifyTime = SysUtil.getCurrentTimeStamp();
		this.observeId = data.getObserveId();
		this.oldValue = data.getValue();
		this.time = data.getTime();
		this.userId = "";
		this.value = newValue;
	}

	public void setObserveDataChange(BasMonitorDisplay md, Float newValue,
			String memo) {
		this.regOptId = md.getRegOptId();
		this.id = md.getId();
		this.modifyTime = SysUtil.getCurrentTimeStamp();
		this.observeId = md.getObserveId();
		this.oldValue = md.getValue();
		this.time = new Timestamp(md.getTime().getTime());
		this.userId = "";
		this.value = newValue;
		this.memo = memo;
	}
}