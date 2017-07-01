package com.digihealth.anesthesia.basedata.formbean;

import java.util.Date;

public class BasAnaesMedicineLoseRecordFormBean
{
	 /**
     * id
     */
    private Integer id;

    /**
     * 报损类型：1 普通报损，2 手术报损，3清点报损
     */
    private String loseType;

    /**
     * 取药记录id
     */
    private Integer outRecordId;

    /**
     * 毒麻药库存id，专为库存清点报损用的。
     */
    private Integer storageId;

    /**
     * 报损数量
     */
    private Integer loseNumber;

    /**
     * 报损日期
     */
    private Date loseTime;

    /**
     * 经办人
     */
    private String operator;

    /**
     * 报损人
     */
    private String loseName;

    /**
     * 报损理由
     */
    private String loseReason;

    /**
     * 手术id
     */
    private String regOptId;

    /**
     * 描述
     */
    private String remark;
    
    /**
     * 是否有效： 0 逻辑删除，1正常数据  
     */
    private Integer enable;

    /**
     * 局点id
     */
    private String beid;
    
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
     * 最小包装单位
     */
    private String minPackageUnit;
    
    /**
     * 价格 
     */
    private Float price;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getLoseType()
	{
		return loseType;
	}

	public void setLoseType(String loseType)
	{
		this.loseType = loseType;
	}

	public Integer getOutRecordId()
	{
		return outRecordId;
	}

	public void setOutRecordId(Integer outRecordId)
	{
		this.outRecordId = outRecordId;
	}

	public Integer getStorageId()
	{
		return storageId;
	}

	public void setStorageId(Integer storageId)
	{
		this.storageId = storageId;
	}

	public Integer getLoseNumber()
	{
		return loseNumber;
	}

	public void setLoseNumber(Integer loseNumber)
	{
		this.loseNumber = loseNumber;
	}

	public Date getLoseTime()
	{
		return loseTime;
	}

	public void setLoseTime(Date loseTime)
	{
		this.loseTime = loseTime;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
	}

	public String getLoseName()
	{
		return loseName;
	}

	public void setLoseName(String loseName)
	{
		this.loseName = loseName;
	}

	public String getLoseReason()
	{
		return loseReason;
	}

	public void setLoseReason(String loseReason)
	{
		this.loseReason = loseReason;
	}

	public String getRegOptId()
	{
		return regOptId;
	}

	public void setRegOptId(String regOptId)
	{
		this.regOptId = regOptId;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public Integer getEnable()
	{
		return enable;
	}

	public void setEnable(Integer enable)
	{
		this.enable = enable;
	}

	public String getBeid()
	{
		return beid;
	}

	public void setBeid(String beid)
	{
		this.beid = beid;
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

	public String getMinPackageUnit()
	{
		return minPackageUnit;
	}

	public void setMinPackageUnit(String minPackageUnit)
	{
		this.minPackageUnit = minPackageUnit;
	}

	public Float getPrice()
	{
		return price;
	}

	public void setPrice(Float price)
	{
		this.price = price;
	}
    
}
