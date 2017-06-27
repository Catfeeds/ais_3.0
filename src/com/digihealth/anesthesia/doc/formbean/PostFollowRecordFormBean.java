/**     
 * @discription 在此输入一句话描述此文件的作用
 * @author chengwang       
 * @created 2015-10-27 下午2:42:59    
 * tags     
 * see_to_target     
 */

package com.digihealth.anesthesia.doc.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.digihealth.anesthesia.doc.po.DocPostFollowAnalgesic;
import com.digihealth.anesthesia.doc.po.DocPostFollowGeneral;
import com.digihealth.anesthesia.doc.po.DocPostFollowRecord;
import com.digihealth.anesthesia.doc.po.DocPostFollowSpinal;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Title: AnalgesicRecordFormBean.java Description: 镇痛记录描述
 * 
 * @author liukui
 * @created 2016-7-27 下午2:42:59
 */
@ApiModel(value = "麻醉术后随访记录单参数对象")
public class PostFollowRecordFormBean implements Serializable {

	@ApiModelProperty(value = "麻醉术后随访记录单对象")
	private DocPostFollowRecord postFollowRecord;

	@ApiModelProperty(value = "麻醉术后镇痛记录对象")
	private List<DocPostFollowAnalgesic> postFollowAnalgesicInfo;

	@ApiModelProperty(value = "全麻术后观察记录对象")
	private List<DocPostFollowGeneral> postFollowGeneralInfo;

	@ApiModelProperty(value = "椎管内麻醉观察记录对象")
	private List<DocPostFollowSpinal> postFollowSpinalInfo;
	
	public DocPostFollowRecord getPostFollowRecord() {
		return postFollowRecord;
	}

	public void setPostFollowRecord(DocPostFollowRecord postFollowRecord) {
		this.postFollowRecord = postFollowRecord;
	}

	public List<DocPostFollowAnalgesic> getPostFollowAnalgesicInfo() {
		return postFollowAnalgesicInfo;
	}

	public void setPostFollowAnalgesicInfo(
			List<DocPostFollowAnalgesic> postFollowAnalgesicInfo) {
		this.postFollowAnalgesicInfo = postFollowAnalgesicInfo;
	}

	public List<DocPostFollowGeneral> getPostFollowGeneralInfo() {
		return postFollowGeneralInfo;
	}

	public void setPostFollowGeneralInfo(
			List<DocPostFollowGeneral> postFollowGeneralInfo) {
		this.postFollowGeneralInfo = postFollowGeneralInfo;
	}

	public List<DocPostFollowSpinal> getPostFollowSpinalInfo() {
		return postFollowSpinalInfo;
	}

	public void setPostFollowSpinalInfo(
			List<DocPostFollowSpinal> postFollowSpinalInfo) {
		this.postFollowSpinalInfo = postFollowSpinalInfo;
	}

}
