package com.digihealth.anesthesia.evt.formbean;

import java.io.Serializable;

/**
 * 
     * Title: AnaesMethodFormBean.java    
     * Description: 基础数据查询返回formbean
     * @author chengwang       
     * @created 2015年11月6日 上午10:41:36
 */
public class EvtAnaesMethodFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String anaMedId;
	private String name;
	private String pinYin;
	
	public String getPinYin() {
		return pinYin;
	}
	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}
	public String getAnaMedId() {
		return anaMedId;
	}
	public void setAnaMedId(String anaMedId) {
		this.anaMedId = anaMedId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
