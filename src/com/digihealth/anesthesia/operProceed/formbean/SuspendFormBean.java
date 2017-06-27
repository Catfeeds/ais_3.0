package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

/**
 * 中止手术formbean Title: SuspendFormBean.java Description:
 * 
 * @author chenyong
 * @created 2016年7月26日 下午2:49:53
 */
public class SuspendFormBean {
	private String msgType;// 命令类型
	private String regOptId;// 病人id
	private String cause;// 中止原因
	private Date suspendTime; // 中止时间

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Date getSuspendTime() {
		return suspendTime;
	}

	public void setSuspendTime(Date suspendTime) {
		this.suspendTime = suspendTime;
	}

}
