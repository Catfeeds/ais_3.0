package com.digihealth.anesthesia.basedata.utils;

import java.util.Date;

import com.digihealth.anesthesia.common.utils.DateUtils;

/**
 * 
     * Title: Ids.java    
     * Description: ID生成类
     * @author chengwang       
     * @created 2015-10-8 下午1:50:28
 */
public class Ids {
	
	/**
	 * 
	     * @discription 日志ID生成
	     * @author chengwang       
	     * @created 2015-10-8 下午1:50:39     
	     * @param loginName
	     * @return
	 */
	public static String nextLogId(String loginName){
		return DateUtils.getDate(new Date())+"_"+loginName;
	}
	
}
