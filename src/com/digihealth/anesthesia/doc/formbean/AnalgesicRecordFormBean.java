   
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

import com.digihealth.anesthesia.doc.po.DocAnalgesicMedicalInfo;
import com.digihealth.anesthesia.doc.po.DocAnalgesicRecipe;
import com.digihealth.anesthesia.doc.po.DocAnalgesicRecord;
import com.digihealth.anesthesia.doc.po.DocAnalgesicVisitInfo;

  
    /**        
 * Title: AnalgesicRecordFormBean.java    
 * Description: 镇痛记录描述
 * @author liukui       
 * @created 2016-7-27 下午2:42:59    
 */

public class AnalgesicRecordFormBean implements Serializable{
	
	private DocAnalgesicRecord analgesicRecord;
	private List<DocAnalgesicMedicalInfo> analgesicMedicalInfo;
	private List<DocAnalgesicVisitInfo> analgesicVisitInfo;
	private List<DocAnalgesicRecipe> analgesicRecipe;
	
	public DocAnalgesicRecord getAnalgesicRecord() {
		return analgesicRecord;
	}
	public void setAnalgesicRecord(DocAnalgesicRecord analgesicRecord) {
		this.analgesicRecord = analgesicRecord;
	}

	public List<DocAnalgesicRecipe> getAnalgesicRecipe() {
		return analgesicRecipe;
	}
	public void setAnalgesicRecipe(List<DocAnalgesicRecipe> analgesicRecipe) {
		this.analgesicRecipe = analgesicRecipe;
	}
	public List<DocAnalgesicMedicalInfo> getAnalgesicMedicalInfo() {
		return analgesicMedicalInfo;
	}
	public void setAnalgesicMedicalInfo(
			List<DocAnalgesicMedicalInfo> analgesicMedicalInfo) {
		this.analgesicMedicalInfo = analgesicMedicalInfo;
	}
	public List<DocAnalgesicVisitInfo> getAnalgesicVisitInfo() {
		return analgesicVisitInfo;
	}
	public void setAnalgesicVisitInfo(List<DocAnalgesicVisitInfo> analgesicVisitInfo) {
		this.analgesicVisitInfo = analgesicVisitInfo;
	}
	
}
