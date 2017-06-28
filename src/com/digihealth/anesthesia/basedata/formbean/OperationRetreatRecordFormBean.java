package com.digihealth.anesthesia.basedata.formbean;

import java.util.Date;

/**
 * 手术退药视图信息 
 */
public class OperationRetreatRecordFormBean
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
     * 手续名称
     */
    private String designedOptName;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 性别
     */
    private String sex;
    
    /**
     * 年龄
     */
    private int age;
    
    /**
     * 住院号
     */
    private String hid;
    
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

	public String getDesignedOptName()
	{
		return designedOptName;
	}

	public void setDesignedOptName(String designedOptName)
	{
		this.designedOptName = designedOptName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getHid()
	{
		return hid;
	}

	public void setHid(String hid)
	{
		this.hid = hid;
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
