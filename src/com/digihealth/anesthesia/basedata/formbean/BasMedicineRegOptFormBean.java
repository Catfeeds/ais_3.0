package com.digihealth.anesthesia.basedata.formbean;

public class BasMedicineRegOptFormBean
{
	 /**
     * 手术ID
     */
    private String regOptId;
    
	 /**
     * 姓名
     */
    private String name;
    
	 /**
     * 科室
     */
    private String deptName;
    
    /**
     * 手续名称
     */
    private String designedOptName;
    
    /**
     * 住院号
     */
    private String hid;
    
    /**
     * 手术日期
     */
    private String operaDate;
    
    /**
     * 麻醉医生
     */
    private String anesthetistName;
    
    /**
     * 巡回护士
     */
    private String circunurseName;

	public String getRegOptId()
	{
		return regOptId;
	}

	public void setRegOptId(String regOptId)
	{
		this.regOptId = regOptId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDeptName()
	{
		return deptName;
	}

	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}

	public String getDesignedOptName()
	{
		return designedOptName;
	}

	public void setDesignedOptName(String designedOptName)
	{
		this.designedOptName = designedOptName;
	}

	public String getHid()
	{
		return hid;
	}

	public void setHid(String hid)
	{
		this.hid = hid;
	}

	public String getOperaDate()
	{
		return operaDate;
	}

	public void setOperaDate(String operaDate)
	{
		this.operaDate = operaDate;
	}

	public String getAnesthetistName()
	{
		return anesthetistName;
	}

	public void setAnesthetistName(String anesthetistName)
	{
		this.anesthetistName = anesthetistName;
	}

	public String getCircunurseName()
	{
		return circunurseName;
	}

	public void setCircunurseName(String circunurseName)
	{
		this.circunurseName = circunurseName;
	}

}
