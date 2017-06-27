package com.digihealth.anesthesia.operProceed.formbean;

public class ResultObj {

	private Boolean bool;
	private Integer result;
	private String msg;

	public ResultObj() {
		super();
	}

	public ResultObj(Boolean bool, Integer result) {
		super();
		this.bool = bool;
		this.result = result;
	}

	public ResultObj(Boolean bool, Integer result, String msg) {
		super();
		this.bool = bool;
		this.result = result;
		this.msg = msg;
	}

	public Boolean getBool() {
		return bool;
	}

	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
