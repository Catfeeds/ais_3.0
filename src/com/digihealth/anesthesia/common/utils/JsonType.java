/**
 * 
 */
package com.digihealth.anesthesia.common.utils;

import java.util.Map;

import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.mapper.JsonMapper;

/**
 * @author ChengW
 *
 */
public class JsonType {

	public static String jsonType(Object object){
		if(Global.getConfig("JsonOrJsonP").equals("1")){
			return JsonMapper.getInstance().toJson(object);
		}else if(Global.getConfig("JsonOrJsonP").equals("0")){
			return JsonMapper.getInstance().toJsonP("angular.callbacks._0", object);
		}
		return "";
	}
}
