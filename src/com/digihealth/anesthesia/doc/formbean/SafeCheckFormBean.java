   
	 /**     
     * @discription 在此输入一句话描述此文件的作用
     * @author chengwang       
     * @created 2015-10-27 下午2:42:59    
     * tags     
     * see_to_target     
     */
    
package com.digihealth.anesthesia.doc.formbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

  
    /**        
 * Title: SafeCheckFormBean.java    
 * Description: 描述
 * @author chengwang       
 * @created 2015-10-27 下午2:42:59    
 */

public class SafeCheckFormBean implements Serializable{
	
	private String name;
	private String regOptId;
	private String hid;
	private String sex;
	private String age;
	private int ageMon;
	private int ageDay;
	private String deptName;
	private String regionName;
	private String bed;
	private String operaDate;
	private String diagnosisName;
	private String designedOptName;
	private String designedAnaesMethodName;
	private String operatorName;
	private String anesthetistName;
	private String nurseName;
	private String realDesignedAnaesMethodName;
	private String realDiagnosisName;
	private String realDesignedOptName;
	
	private List<String> circunurseList;
    private List<String> anesthetistList;
    private List<String> operatorList;
	
	

	public List<String> getCircunurseList()
    {
        return circunurseList;
    }
    public void setCircunurseList(List<String> circunurseList)
    {
        this.circunurseList = circunurseList;
    }
    public List<String> getAnesthetistList()
    {
        return anesthetistList;
    }
    public void setAnesthetistList(List<String> anesthetistList)
    {
        this.anesthetistList = anesthetistList;
    }
    public List<String> getOperatorList()
    {
        return operatorList;
    }
    public void setOperatorList(List<String> operatorList)
    {
        this.operatorList = operatorList;
    }
    public String getRealDesignedOptName() {
		return realDesignedOptName;
	}
	public void setRealDesignedOptName(String realDesignedOptName) {
		this.realDesignedOptName = realDesignedOptName;
	}
	public String getRealDesignedAnaesMethodName() {
		return realDesignedAnaesMethodName;
	}
	public void setRealDesignedAnaesMethodName(String realDesignedAnaesMethodName) {
		this.realDesignedAnaesMethodName = realDesignedAnaesMethodName;
	}
	public String getRealDiagnosisName() {
		return realDiagnosisName;
	}
	public void setRealDiagnosisName(String realDiagnosisName) {
		this.realDiagnosisName = realDiagnosisName;
	}
	
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getName() {
		return name;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param name   
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getRegOptId() {
		return regOptId;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param regOptId   
	 */
	public void setRegOptId(String regOptId) {
		this.regOptId = regOptId;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getHid() {
		return hid;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param hid   
	 */
	public void setHid(String hid) {
		this.hid = hid;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getSex() {
		return sex;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param sex   
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public int getAgeMon() {
		return ageMon;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param ageMon   
	 */
	public void setAgeMon(int ageMon) {
		this.ageMon = ageMon;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public int getAgeDay() {
		return ageDay;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param ageDay   
	 */
	public void setAgeDay(int ageDay) {
		this.ageDay = ageDay;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getDeptName() {
		return deptName;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param deptName   
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getRegionName() {
		return regionName;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param regionName   
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getBed() {
		return bed;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param bed   
	 */
	public void setBed(String bed) {
		this.bed = bed;
	}
	
	public String getOperaDate() {
		return operaDate;
	}
	public void setOperaDate(String operaDate) {
		this.operaDate = operaDate;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getDiagnosisName() {
		return diagnosisName;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param diagnosisName   
	 */
	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getDesignedOptName() {
		return designedOptName;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param designedOptName   
	 */
	public void setDesignedOptName(String designedOptName) {
		this.designedOptName = designedOptName;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getDesignedAnaesMethodName() {
		return designedAnaesMethodName;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param designedAnaesMethodName   
	 */
	public void setDesignedAnaesMethodName(String designedAnaesMethodName) {
		this.designedAnaesMethodName = designedAnaesMethodName;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getOperatorName() {
		return operatorName;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param operatorName   
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getAnesthetistName() {
		return anesthetistName;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param anesthetistName   
	 */
	public void setAnesthetistName(String anesthetistName) {
		this.anesthetistName = anesthetistName;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05 
	 * @return type 
	 */
	
	public String getNurseName() {
		return nurseName;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-27 下午3:43:05         
	 * @param nurseName   
	 */
	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}
	

}
