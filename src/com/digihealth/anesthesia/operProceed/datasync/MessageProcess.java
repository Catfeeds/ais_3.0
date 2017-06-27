package com.digihealth.anesthesia.operProceed.datasync;

import org.apache.log4j.Logger;

import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.utils.Exceptions;
import com.digihealth.anesthesia.operProceed.core.MyConstants;
import com.digihealth.anesthesia.operProceed.formbean.CmdMsg;
import com.digihealth.anesthesia.operProceed.formbean.ResultObj;

/**
 * 消息处理类
     * Title: MessageProcess.java    
     * Description: 
     * @author chenyong       
     * @created 2016年7月15日 下午2:49:56
 */
public class MessageProcess {
	
	private static Logger logger = Logger.getLogger(MessageProcess.class);
	
	/**
	 * 接收采集服务发过来的消息，并处理
	 * @param msg
	 */
	public static void contextHandle(String msg) {
		try {
			DataCollMgr.process(msg);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("contextHandle-----"+Exceptions.getStackTraceAsString(e));
		}
	}
	
	/**
	 * 接收http请求，并处理对应参数，返回对应数据
	 * 1、start 判断手术是否开启，未开启，则检查设备开启
	 * 2、ONMESSAGE 结束手术
	 * 
	 * @param json
	 */
	/*public static void process(JSONObject json) {
		try {
			String msgType = json.getString("msgType");
			if (Constants.WEBSOCKET_ONOPEN.equals(msgType)) {
				String operId = json.getString("regOptId");
				if (OperationMgr.init(operId)) {
					OperationMgr.initialize(json);
				}
			} else if (Constants.WEBSOCKET_CLOSE.equals(msgType)) {

			} else if (Constants.OPERATION_STATUS_INIT.equals(msgType)) {
				String operId = JSONObject.fromObject(json.get("msg")).getString("regOptId");
				if (OperationMgr.init(operId)) {
					OperationMgr.initialize(json);
				}
			} else if (Constants.WEBSOCKET_ONMESSAGE.equals(msgType)) {
				OperationMgr.process(json.getString("msg"));
			}
		} catch (Exception e) {
			logger.error("MessageProcess.process=="+e.getMessage());
		}
		
	}*/
	
	public static ResponseValue process(CmdMsg msg) {
		ResponseValue res = new ResponseValue();
		String msgType = msg.getMsgType();
		String operId = msg.getRegOptId();
		if (MyConstants.OPERATION_STATUS_INIT.equals(msgType)) {//init
			logger.info("----------------process:进入init方法-----------------------");
			if (OperationMgr.init(operId)) {
				ResultObj resultObj = OperationMgr.initialize(msg);
				if(0==resultObj.getResult()){
					res.setResultCode("1");
					res.setResultMessage("手术初始化，请等待20s！");
				}else if(-1==resultObj.getResult()){
					res.setResultCode("70000002");
					res.setResultMessage(Global.getRetMsg(res.getResultCode()));
				}
			}else{
				res.setResultCode("70000001");
				res.setResultMessage(Global.getRetMsg(res.getResultCode()));
			}
			
		} else if (MyConstants.OPERATION_STATUS_START.equals(msgType)) {//start
			logger.info("----------------process:进入start方法-----------------------");
			ResultObj resultObj = OperationMgr.startOperation(operId);
			Integer result = resultObj.getResult();
			if(0==result){
				res.setResultCode("1");
				res.setResultMessage(resultObj.getMsg());
			}else{
				res.setResultCode("10000000");
				res.setResultMessage(resultObj.getMsg());
			}
		}else if (MyConstants.OPERATION_STATUS_CHECK.equals(msgType)) {//check
			logger.info("----------------process:进入check方法-----------------------");
			ResultObj resultObj = OperationMgr.updateDeviceMonitorItems(operId);
			Integer result = resultObj.getResult();
			if(0==result){
				res.setResultCode("1");
				res.setResultMessage(resultObj.getMsg());
			}else{
				res.setResultCode("10000000");
				res.setResultMessage(resultObj.getMsg());
			}
			
		}else if (MyConstants.OPERATION_STATUS_END.equals(msgType)) {//end
			logger.info("----------------process:进入end方法-----------------------");
			OperationMgr.endOperation(operId);
			res.setResultCode("1");
			res.setResultMessage("结束手术（"+operId+"）成功!");
			
		}else if (MyConstants.OPERATION_MODEL_NORMAL.equals(msgType)) {//normal
			logger.info("----------------process:进入normal方法-----------------------");
			OperationMgr.setCurOperModel(operId, MyConstants.OPERATION_MODEL_NORMAL);
			res.setResultCode("1");
			res.setResultMessage("切换手术模式为："+msgType+" 成功!");
			
		}else if (MyConstants.OPERATION_MODEL_SAVE.equals(msgType)) {//save
			logger.info("----------------process:进入save方法-----------------------");
			OperationMgr.setCurOperModel(operId, MyConstants.OPERATION_MODEL_SAVE);
			res.setResultCode("1");
			res.setResultMessage("切换手术模式为："+msgType+" 成功!");
			
		}else if (MyConstants.OPERATION_UPDATE_FREQ.equals(msgType)) {//updateFreq
			logger.info("----------------process:进入updateFreq方法-----------------------");
			OperationMgr.updateOperFreq(operId);
			res.setResultCode("1");
			res.setResultMessage("修改采集频率成功!");
		}else if(MyConstants.OPERATION_STATUS_FORCEEND.equals(msgType)){
			logger.info("----------------process:进入forceEnd方法-----------------------");
			OperationMgr.forceEndOperation(operId);
			res.setResultCode("1");
			res.setResultMessage("强制结束成功!");
		}
		return res;
	}

}
