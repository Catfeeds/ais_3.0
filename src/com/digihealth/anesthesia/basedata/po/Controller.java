package com.digihealth.anesthesia.basedata.po;
/**
 * 
     * Title: Controller.java    
     * Description: 描述
     * @author chengwang       
     * @created 2015年10月30日 上午8:59:59
 */
public class Controller {
	private String regOptId;
	private String isLocalAnaes;
	private String state;//手术状态
	private String costsettlementState;//费用状态
	private String previousState;//上一个状态，当手术状态变更的时候，这里记录上一个状态
	
	public String getIsLocalAnaes() {
		return isLocalAnaes;
	}

	public void setIsLocalAnaes(String isLocalAnaes) {
		this.isLocalAnaes = isLocalAnaes;
	}

	public String getPreviousState() {
		return previousState;
	}

	public void setPreviousState(String previousState) {
		this.previousState = previousState;
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**    
	 * @author chengwang       
	 * @created 2015-10-23 下午4:37:18 
	 * @return type 
	 */
	
	public String getCostsettlementState() {
		return costsettlementState;
	}

	/**     
	 * @author chengwang       
	 * @created 2015-10-23 下午4:37:18         
	 * @param costsettlementState   
	 */
	public void setCostsettlementState(String costsettlementState) {
		this.costsettlementState = costsettlementState;
	}

	@Override
	public String toString() {
		return "Controller [regOptId=" + regOptId + ", state=" + state
				+ ", costsettlementState=" + costsettlementState
				+ ", previousState=" + previousState + "]";
	}
	
}