   
	 /**     
     * @discription 在此输入一句话描述此文件的作用
     * @author chengwang       
     * @created 2015-10-23 上午10:03:13    
     * tags     
     * see_to_target     
     */
    
package com.digihealth.anesthesia.basedata.utils;

import com.digihealth.anesthesia.common.utils.StringUtils;

  
    /**        
 * Title: TypeChange.java    
 * Description: 描述
 * @author chengwang       
 * @created 2015-10-23 上午10:03:13    
 */

public class TypeChange {
 
	public static int getPageNo(String pageNo,String pageSize){
    	return (StringUtils.toInteger(pageNo) - 1)
				* (StringUtils.toInteger(pageSize));
    }
}
