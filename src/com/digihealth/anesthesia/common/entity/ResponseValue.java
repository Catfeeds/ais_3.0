package com.digihealth.anesthesia.common.entity;

import java.util.HashMap;
import java.util.Map;

import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.utils.JsonType;

/**
 * 统一返回消息
 * @author huchao
 *
 */
public class ResponseValue {
    //返回结果码
    private String resultCode;

    //返回结果描述信息
    private String resultMessage;
    
    private Map<String, Object> resultObj = new HashMap<String, Object>();
    

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	public Map<String, Object> getResultObj() {
		return resultObj;
	}

	public void setResultObj(Map<String, Object> resultObj) {
		this.resultObj = resultObj;
	}

    public ResponseValue() {
    	setResultCode("1");
    	setResultMessage(Global.getRetMsg(getResultCode()));
    }
    
    public ResponseValue(String retCode) {
    	setResultCode(retCode);
    	setResultMessage(Global.getRetMsg(retCode));
    }
    
    public ResponseValue(String retCode, String retMsg) {
    	setResultCode(retCode);
    	setResultMessage(retMsg);
    }
    
    public void put(String key, Object value) {
    	resultObj.put(key, value);
    }

    public String getJsonStr() {
    	resultObj.put("resultCode", getResultCode());
    	resultObj.put("resultMessage", getResultMessage());
    	return JsonType.jsonType(resultObj);
    }
    
}
