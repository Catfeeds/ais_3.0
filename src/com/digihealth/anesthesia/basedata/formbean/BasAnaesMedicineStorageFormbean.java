package com.digihealth.anesthesia.basedata.formbean;

import java.util.Date;

public class BasAnaesMedicineStorageFormbean
{
	/**
	 * 药品code
	 */
	private String medicineCode;

	/**
	 * 药品名字
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
	 * 数量
	 */
	private Integer number = 0;

	/**
	 * 最小包装单位
	 */
	private String minPackageUnit;

	/**
	 * 生产日期
	 */
	private Date productionTime;

	/**
	 * 有效期
	 */
	private Date effectiveTime;

	/**
	 * 局点编号
	 */
	private String beid;

	/**
	 * 上月总结存
	 */
	private Integer lastMonthAllNum;

	/**
	 * 本月总入库数
	 */
	private Integer monthAllInNum;

	/**
	 * 本月总取药
	 */
	private Integer monthAllOutNum;

	/**
	 * 本月总退药
	 */
	private Integer monthAllRetreatNum;

	/**
	 * 本月总报损
	 */
	private Integer monthAllLoseNum;

	/**
	 * 本月总结存
	 */
	private Integer monthAllNum;


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

	public Integer getNumber()
	{
		return number;
	}

	public void setNumber(Integer number)
	{
		this.number = number;
	}

	public String getMinPackageUnit()
	{
		return minPackageUnit;
	}

	public void setMinPackageUnit(String minPackageUnit)
	{
		this.minPackageUnit = minPackageUnit;
	}

	public Date getProductionTime()
	{
		return productionTime;
	}

	public void setProductionTime(Date productionTime)
	{
		this.productionTime = productionTime;
	}

	public Date getEffectiveTime()
	{
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime)
	{
		this.effectiveTime = effectiveTime;
	}

	public String getBeid()
	{
		return beid;
	}

	public void setBeid(String beid)
	{
		this.beid = beid;
	}

	public Integer getLastMonthAllNum()
	{
		return lastMonthAllNum;
	}

	public void setLastMonthAllNum(Integer lastMonthAllNum)
	{
		this.lastMonthAllNum = lastMonthAllNum;
	}

	public Integer getMonthAllInNum()
	{
		return monthAllInNum;
	}

	public void setMonthAllInNum(Integer monthAllInNum)
	{
		this.monthAllInNum = monthAllInNum;
	}

	public Integer getMonthAllOutNum()
	{
		return monthAllOutNum;
	}

	public void setMonthAllOutNum(Integer monthAllOutNum)
	{
		this.monthAllOutNum = monthAllOutNum;
	}

	public Integer getMonthAllRetreatNum()
	{
		return monthAllRetreatNum;
	}

	public void setMonthAllRetreatNum(Integer monthAllRetreatNum)
	{
		this.monthAllRetreatNum = monthAllRetreatNum;
	}

	public Integer getMonthAllLoseNum()
	{
		return monthAllLoseNum;
	}

	public void setMonthAllLoseNum(Integer monthAllLoseNum)
	{
		this.monthAllLoseNum = monthAllLoseNum;
	}

	public Integer getMonthAllNum()
	{
		return monthAllNum;
	}

	public void setMonthAllNum(Integer monthAllNum)
	{
		this.monthAllNum = monthAllNum;
	}

}
