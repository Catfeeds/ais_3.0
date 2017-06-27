package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

public class MonitorPupilFormBean {

	private String id;

	/**
	 * reg_opt_id,患者id
	 */
	private String regOptId;

	/**
	 * 时间
	 */
	private Date time;

	/**
	 * 左
	 */
	private String left;

	/**
	 * 右
	 */
	private String right;

	/**
	 * 对光反射
	 */
	private String lightReaction;

	private Integer index;// 序号

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRegOptId() {
		return regOptId;
	}

	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public String getLightReaction() {
		return lightReaction;
	}

	public void setLightReaction(String lightReaction) {
		this.lightReaction = lightReaction;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
