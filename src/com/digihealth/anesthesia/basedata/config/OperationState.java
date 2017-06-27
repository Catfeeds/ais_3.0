   
	 /**     
     * @discription 在此输入一句话描述此文件的作用
     * @author chengwang       
     * @created 2015-10-20 上午9:44:31    
     * tags     
     * see_to_target     
     */
    
package com.digihealth.anesthesia.basedata.config;

  
    /**        
 * Title: OperationState.java    
 * Description: 描述
 * @author chengwang       
 * @created 2015-10-20 上午9:44:31    
 */

public interface OperationState {
	String NOT_REVIEWED = "01";//未审核
	String NO_SCHEDULING = "02";//未排班
	String PREOPERATIVE = "03";//术前
	String SURGERY = "04";//术中
	String RESUSCITATION = "05";//复苏前
	String POSTOPERATIVE = "06";//术后
	String STOP = "07";//中止
	String CANCEL = "08";//取消
}
