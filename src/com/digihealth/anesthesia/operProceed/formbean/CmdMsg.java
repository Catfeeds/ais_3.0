package com.digihealth.anesthesia.operProceed.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: CmdMsg.java Description: 消息类
 * 
 * @author chenyong
 * @created 2016年7月15日 上午11:51:11
 */
@ApiModel(value="查询参数对象")
public class CmdMsg implements Serializable {

	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="消息类型")
	private String msgType;// 消息类型

    @ApiModelProperty(value="手术id")
	private String regOptId;// regOptId

    @ApiModelProperty(value="床位id")
	private String bedId;

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

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	@Override
	public String toString() {
		return "CmdMsg [msgType=" + msgType + ", regOptId=" + regOptId + ", bedId=" + bedId + "]";
	}

}
