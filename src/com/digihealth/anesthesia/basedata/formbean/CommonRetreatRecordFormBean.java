package com.digihealth.anesthesia.basedata.formbean;

import java.util.Date;

/**
 * 普通退药视图 
 */
public class CommonRetreatRecordFormBean
{
	 /**
     * id
     */
    private Integer id;
    
    /**
     * 退药日期
     */
    private Date retreatTime;
    
    /**
     * 药品名称
     */
    private String medicineName;

    /**
     * 厂家
     */
    private String firm;

    /**
     * 规格
     */
    private String spec;

    /**
     * 批次
     */
    private String batch;
    
    /**
     * 退药数量
     */
    private Integer retreatNumber = 0;
    
    /**
     * 最小包装单位
     */
    private String minPackageUnit;

    /**
     * 经办人
     */
    private String operator;

    /**
     * 退药人
     */
    private String retreatName;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Date getRetreatTime()
	{
		return retreatTime;
	}

	public void setRetreatTime(Date retreatTime)
	{
		this.retreatTime = retreatTime;
	}

	public String getMedicineName()
	{
		return medicineName;
	}

	public void setMedicineName(String medicineName)
	{
		this.medicineName = medicineName;
	}

	public String getFirm()
	{
		return firm;
	}

	public void setFirm(String firm)
	{
		this.firm = firm;
	}

	public String getSpec()
	{
		return spec;
	}

	public void setSpec(String spec)
	{
		this.spec = spec;
	}

	public String getBatch()
	{
		return batch;
	}

	public void setBatch(String batch)
	{
		this.batch = batch;
	}

	public Integer getRetreatNumber()
	{
		return retreatNumber;
	}

	public void setRetreatNumber(Integer retreatNumber)
	{
		this.retreatNumber = retreatNumber;
	}

	public String getMinPackageUnit()
	{
		return minPackageUnit;
	}

	public void setMinPackageUnit(String minPackageUnit)
	{
		this.minPackageUnit = minPackageUnit;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

	public String getRetreatName()
	{
		return retreatName;
	}

	public void setRetreatName(String retreatName)
	{
		this.retreatName = retreatName;
	}
    
}
