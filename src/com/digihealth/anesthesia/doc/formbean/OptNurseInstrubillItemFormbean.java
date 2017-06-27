/**
 * 
 */
package com.digihealth.anesthesia.doc.formbean;

import java.io.Serializable;
import java.util.List;

import com.digihealth.anesthesia.doc.po.DocInstrubillItem;
import com.digihealth.anesthesia.doc.po.DocOptNurse;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 
     * Title: OptNurseInstrubillItemFormbean.java    
     * Description: 保存手术护理以及器械信息
     * @author chengwang       
     * @created 2015-10-22 上午9:39:31
 */
@ApiModel(value = "手术清点单参数对象")
public class OptNurseInstrubillItemFormbean implements Serializable{

	@ApiModelProperty(value = "手术清点单对象")
	private DocOptNurse optNurse;
	
	@ApiModelProperty(value = "手术所用的器械对象")
	private List<DocInstrubillItem> instrubillItems;
	/**    
	 * @author chengwang       
	 * @created 2015-10-22 上午9:40:43 
	 * @return type 
	 */
	
	public DocOptNurse getOptNurse() {
		return optNurse;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-22 上午9:40:43         
	 * @param optNurse   
	 */
	public void setOptNurse(DocOptNurse optNurse) {
		this.optNurse = optNurse;
	}
	/**    
	 * @author chengwang       
	 * @created 2015-10-22 上午9:40:43 
	 * @return type 
	 */
	
	public List<DocInstrubillItem> getInstrubillItems() {
		return instrubillItems;
	}
	/**     
	 * @author chengwang       
	 * @created 2015-10-22 上午9:40:43         
	 * @param instrubillItems   
	 */
	public void setInstrubillItems(List<DocInstrubillItem> instrubillItems) {
		this.instrubillItems = instrubillItems;
	}
	
}
