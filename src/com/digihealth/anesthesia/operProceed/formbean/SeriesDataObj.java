package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

public class SeriesDataObj {
	private String id; // 对应dat_monitor_data中的id
	private Float value; // 对应dat_monitor_data中的value
	private Date time; // 对应dat_monitor_data中的time
	private String observeId; // 对应dat_monitor_data的observeId
	private String symbol; // 呼吸事件图标
	private String symbolSvg; // 呼吸事件svg图标
	private Integer amendFlag; // 是否人为修正，显示红色

	public SeriesDataObj() {
		super();
	}

	public SeriesDataObj(String id, Float value) {
		super();
		this.id = id;
		this.value = value;
	}

	public SeriesDataObj(String id, Float value, Date time) {
		super();
		this.id = id;
		this.value = value;
		this.time = time;
	}

	public SeriesDataObj(String id, Float value, Date time, String observeId) {
		super();
		this.id = id;
		this.value = value;
		this.time = time;
		this.observeId = observeId;
	}

	public SeriesDataObj(String id, Float value, Date time, String observeId, String symbol) {
		super();
		this.id = id;
		this.value = value;
		this.time = time;
		this.observeId = observeId;
		this.symbol = symbol;
	}
	
public SeriesDataObj(String id, Float value, Date time, String observeId, String symbol, String symbolSvg) {
		super();
		this.id = id;
		this.value = value;
		this.time = time;
		this.observeId = observeId;
		this.symbol = symbol;
		this.symbolSvg = symbolSvg;
	}

	public SeriesDataObj(String id, Float value, Date time, String observeId, String symbol, Integer amendFlag) {
		super();
		this.id = id;
		this.value = value;
		this.time = time;
		this.observeId = observeId;
		this.symbol = symbol;
		this.amendFlag = amendFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getObserveId() {
		return observeId;
	}

	public void setObserveId(String observeId) {
		this.observeId = observeId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getAmendFlag() {
		return amendFlag;
	}

	public void setAmendFlag(Integer amendFlag) {
		this.amendFlag = amendFlag;
	}

	public String getSymbolSvg() {
		return symbolSvg;
	}

	public void setSymbolSvg(String symbolSvg) {
		this.symbolSvg = symbolSvg;
	}

}
