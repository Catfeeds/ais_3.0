/**
 * 
 */
package com.digihealth.anesthesia.doc.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
 * Title: AnaesSummaryItemFormbean.java Description: 麻醉总结单附属记录创建
 * 
 * @author liuikui
 * @created 2015-10-22 上午9:39:31
 */
@ApiModel(value = "手术患者接送交接单对象")
public class PatShuttleTransferFormbean implements Serializable {

	@ApiModelProperty(value = "手术患者接送交接单参数对象")
	private PatShuttleFormbean patShuttleTransfer;

	@ApiModelProperty(value = "手术患者接送交接单内容参数对象")
	private PatShuttleTransferContentFormbean content1;

	@ApiModelProperty(value = "手术患者接送交接单内容参数对象")
	private PatShuttleTransferContentFormbean content2;

	public PatShuttleFormbean getPatShuttleTransfer() {
		return patShuttleTransfer;
	}

	public void setPatShuttleTransfer(PatShuttleFormbean patShuttleTransfer) {
		this.patShuttleTransfer = patShuttleTransfer;
	}

	public PatShuttleTransferContentFormbean getContent1() {
		return content1;
	}

	public void setContent1(PatShuttleTransferContentFormbean content1) {
		this.content1 = content1;
	}

	public PatShuttleTransferContentFormbean getContent2() {
		return content2;
	}

	public void setContent2(PatShuttleTransferContentFormbean content2) {
		this.content2 = content2;
	}

}
