package com.digihealth.anesthesia.basedata.formbean;

import java.util.Date;

public class BasAnaesMedicineOutRecordFormBean
{
    /**
     * 毒麻药库存id
     */
    private Integer storageId;

    /**
     * 药品编号
     */
    private String medicineCode;

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
     * 有效日期
     */
    private Date effectiveTime;
    
    /**
     * 时间段内总取出数量
     */
    private Integer allOutNumber = 0;

    
    /**
     * 时间段内总退药数量
     */
    private Integer allRetreatNumber = 0;

    
    /**
     * 时间段内总报损数量
     */
    private Integer allLoseNumber = 0;

    
    /**
     * 时间段内总实际数量
     */
    private Integer allActualNumber = 0;

    /**
     * 最小包装单位
     */
    private String minPackageUnit;

    /**
     * 取药日期
     */
    private Date outTime;

    /**
     * 经办人
     */
    private String operator;

    /**
     * 领用人
     */
    private String receiveName;

    /**
     * 取药类型：1 普通取药，2 手术取药
     */
    private String outType;

    /**
     * 手术id
     */
    private String regOptId;

    /**
     * 局点id
     */
    private String beid;

	public Integer getStorageId()
	{
		return storageId;
	}

	public void setStorageId(Integer storageId)
	{
		this.storageId = storageId;
	}

	public String getMedicineCode()
	{
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode)
	{
		this.medicineCode = medicineCode;
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

	public Date getEffectiveTime()
	{
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime)
	{
		this.effectiveTime = effectiveTime;
	}

	public Integer getAllOutNumber()
	{
		return allOutNumber;
	}

	public void setAllOutNumber(Integer allOutNumber)
	{
		this.allOutNumber = allOutNumber;
	}

	public Integer getAllRetreatNumber()
	{
		return allRetreatNumber;
	}

	public void setAllRetreatNumber(Integer allRetreatNumber)
	{
		this.allRetreatNumber = allRetreatNumber;
	}

	public Integer getAllLoseNumber()
	{
		return allLoseNumber;
	}

	public void setAllLoseNumber(Integer allLoseNumber)
	{
		this.allLoseNumber = allLoseNumber;
	}

	public Integer getAllActualNumber()
	{
		return allActualNumber;
	}

	public void setAllActualNumber(Integer allActualNumber)
	{
		this.allActualNumber = allActualNumber;
	}

	public String getMinPackageUnit()
	{
		return minPackageUnit;
	}

	public void setMinPackageUnit(String minPackageUnit)
	{
		this.minPackageUnit = minPackageUnit;
	}

	public Date getOutTime()
	{
		return outTime;
	}

	public void setOutTime(Date outTime)
	{
		this.outTime = outTime;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

	public String getReceiveName()
	{
		return receiveName;
	}

	public void setReceiveName(String receiveName)
	{
		this.receiveName = receiveName;
	}

	public String getOutType()
	{
		return outType;
	}

	public void setOutType(String outType)
	{
		this.outType = outType;
	}

	public String getRegOptId()
	{
		return regOptId;
	}

	public void setRegOptId(String regOptId)
	{
		this.regOptId = regOptId;
	}

	public String getBeid()
	{
		return beid;
	}

	public void setBeid(String beid)
	{
		this.beid = beid;
	}
    
}
