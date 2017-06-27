package com.digihealth.anesthesia.basedata.formbean;

/**
 * 拟施诊断对象 
 */
public class DiagnosisCodes
{

	private String diagDefId;
	
	private String name;
	
	private String pinYin;

	public String getDiagDefId()
	{
		return diagDefId;
	}

	public void setDiagDefId(String diagDefId)
	{
		this.diagDefId = diagDefId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPinYin()
	{
		return pinYin;
	}

	public void setPinYin(String pinYin)
	{
		this.pinYin = pinYin;
	}
	
}
