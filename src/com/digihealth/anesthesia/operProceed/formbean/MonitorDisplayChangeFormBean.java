package com.digihealth.anesthesia.operProceed.formbean;

import java.util.Date;

public class MonitorDisplayChangeFormBean
{
	private String id;

    /**
     * 时间
     */
    private Date time;

    /**
     * reg_opt_id,患者id
     */
    private String docId;

    /**
     * 观察点ID
     */
    private String observeId;

    /**
     * 观测点的值
     */
    private Float value;

    /**
     * 是否正常值，0正常，-1过低，1过高
     */
    private Integer state;

    /**
     * 观测点的值
     */
    private String observeName;

    /**
     * 图标
     */
    private String icon;

    /**
     * 颜色
     */
    private String color;

    /**
     * 频率
     */
    private Integer freq;

    /**
     * 位置
     */
    private Integer position;

    /**
     * 间隔时间
     */
    private Integer intervalTime;
    
    /**
     * monitorDataChangeHis的备注字段 memo 
     */
    private String memo;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}

	public String getDocId()
	{
		return docId;
	}

	public void setDocId(String docId)
	{
		this.docId = docId;
	}

	public String getObserveId()
	{
		return observeId;
	}

	public void setObserveId(String observeId)
	{
		this.observeId = observeId;
	}

	public Float getValue()
	{
		return value;
	}

	public void setValue(Float value)
	{
		this.value = value;
	}

	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public String getObserveName()
	{
		return observeName;
	}

	public void setObserveName(String observeName)
	{
		this.observeName = observeName;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public Integer getFreq()
	{
		return freq;
	}

	public void setFreq(Integer freq)
	{
		this.freq = freq;
	}

	public Integer getPosition()
	{
		return position;
	}

	public void setPosition(Integer position)
	{
		this.position = position;
	}

	public Integer getIntervalTime()
	{
		return intervalTime;
	}

	public void setIntervalTime(Integer intervalTime)
	{
		this.intervalTime = intervalTime;
	}

	public String getMemo()
	{
		return memo;
	}

	public void setMemo(String memo)
	{
		this.memo = memo;
	}
    
}
