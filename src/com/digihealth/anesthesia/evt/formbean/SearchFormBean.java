package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Title: SearchFormBean.java Description: 业务层查询formBean
 * 
 * @author liukui
 * @created 2015-10-23 上午9:48:27
 */

@ApiModel(value = "统计查询参数对象")
public class SearchFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "文书ID")
	private String docId;
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	@ApiModelProperty(value = "状态")
	private String state;
	@ApiModelProperty(value = "ID")
	private String id;
	@ApiModelProperty(value = "第几页")
	private String pageNo;
	@ApiModelProperty(value = "每页显示多少行")
	private String pageSize;
	@ApiModelProperty(value = "")
	private String cheEventId;
	@ApiModelProperty(value = "手术ID")
	private String regOptId;
	@ApiModelProperty(value = "权限")
	private String role;
	@ApiModelProperty(value = "")
	private String anaSumId;
	@ApiModelProperty(value = "编码")
	private String code;
	@ApiModelProperty(value = "类型")
	private String type;
	@ApiModelProperty(value = "")
	private String currentState;
	@ApiModelProperty(value = "")
	private String accessSource;
	@ApiModelProperty(value = "")
	private String pacuObsId;
	@ApiModelProperty(value = "科室ID")
	private String deptId;
	@ApiModelProperty(value = "")
	private String subType;
	@ApiModelProperty(value = "")
	private String operatorId;
	@ApiModelProperty(value = "")
	private String nurseId;
	@ApiModelProperty(value = "")
	private String leaveTo;
	@ApiModelProperty(value = "手术室ID")
	private String operRoomId;
	@ApiModelProperty(value = "")
	private String anesthetistId;
	@ApiModelProperty(value = "")
	private String operSource;
	@ApiModelProperty(value = "")
	private Integer emergency;
	@ApiModelProperty(value = "")
	private String asaLevel;
	@ApiModelProperty(value = "")
	private String isLocalAnaes;
	@ApiModelProperty(value = "")
	private Integer ioEventNum;
	@ApiModelProperty(value = "")
	private Integer medEventNum;
	@ApiModelProperty(value = "")
	private Integer egressNum;
	@ApiModelProperty(value = "")
	private Integer anaesMedNum;
	@ApiModelProperty(value = "")
	private String anesDocId;
	@ApiModelProperty(value = "")
	private Integer bloodNum;
	@ApiModelProperty(value = "")
	private Integer infusionNum;
	@ApiModelProperty(value = "")
	private Integer isSuccess;
	@ApiModelProperty(value = "是否是持续性 1持续,0不持续,2:TCI")
	private String durable; // 是否是持续性 1持续,0不持续,2:TCI
	private String beid;
	@ApiModelProperty(value = "文书类型：1-麻醉记录单，2-pacu观察记录单")
	private Integer docType; // 文书类型：1-麻醉记录单，2-pacu观察记录单

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

	public Integer getBloodNum() {
		return bloodNum;
	}

	public void setBloodNum(Integer bloodNum) {
		this.bloodNum = bloodNum;
	}

	public Integer getInfusionNum() {
		return infusionNum;
	}

	public void setInfusionNum(Integer infusionNum) {
		this.infusionNum = infusionNum;
	}

	public Integer getIoEventNum() {
		return ioEventNum;
	}

	public void setIoEventNum(Integer ioEventNum) {
		this.ioEventNum = ioEventNum;
	}

	public Integer getMedEventNum() {
		return medEventNum;
	}

	public void setMedEventNum(Integer medEventNum) {
		this.medEventNum = medEventNum;
	}

	public Integer getEgressNum() {
		return egressNum;
	}

	public void setEgressNum(Integer egressNum) {
		this.egressNum = egressNum;
	}

	public String getIsLocalAnaes() {
		return isLocalAnaes;
	}

	public void setIsLocalAnaes(String isLocalAnaes) {
		this.isLocalAnaes = isLocalAnaes;
	}

	public String getAsaLevel() {
		return asaLevel;
	}

	public void setAsaLevel(String asaLevel) {
		this.asaLevel = asaLevel;
	}

	public Integer getEmergency() {
		return emergency;
	}

	public void setEmergency(Integer emergency) {
		this.emergency = emergency;
	}

	public String getOperSource() {
		return operSource;
	}

	public void setOperSource(String operSource) {
		this.operSource = operSource;
	}

	public String getAnesthetistId() {
		return anesthetistId;
	}

	public void setAnesthetistId(String anesthetistId) {
		this.anesthetistId = anesthetistId;
	}

	public String getOperRoomId() {
		return operRoomId;
	}

	public void setOperRoomId(String operRoomId) {
		this.operRoomId = operRoomId;
	}

	public String getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo;
	}

	public String getNurseId() {
		return nurseId;
	}

	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPacuObsId() {
		return pacuObsId;
	}

	public void setPacuObsId(String pacuObsId) {
		this.pacuObsId = pacuObsId;
	}

	public String getAccessSource() {
		return accessSource;
	}

	public void setAccessSource(String accessSource) {
		this.accessSource = accessSource;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAnaSumId() {
		return anaSumId;
	}

	public void setAnaSumId(String anaSumId) {
		this.anaSumId = anaSumId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getCheEventId() {
		return cheEventId;
	}

	public void setCheEventId(String cheEventId) {
		this.cheEventId = cheEventId;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getAnaesMedNum() {
		return anaesMedNum;
	}

	public void setAnaesMedNum(Integer anaesMedNum) {
		this.anaesMedNum = anaesMedNum;
	}

	public String getAnesDocId() {
		return anesDocId;
	}

	public void setAnesDocId(String anesDocId) {
		this.anesDocId = anesDocId;
	}

	public String getDurable() {
		return durable;
	}

	public void setDurable(String durable) {
		this.durable = durable;
	}

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	}

}
