package com.digihealth.anesthesia.pacu.datasync;

import io.netty.channel.ChannelHandlerContext;

import org.apache.log4j.Logger;

import com.digihealth.anesthesia.operProceed.formbean.CmdMsg;
import com.digihealth.anesthesia.operProceed.formbean.ResultObj;
import com.digihealth.anesthesia.pacu.core.MyConstants;
import com.digihealth.anesthesia.common.entity.ResponseValue;

/**
 * PACU消息处理类 Title: MsgProcess.java Description:
 * 
 * @author chenyong
 * @created 2016年8月3日 下午4:37:27
 */
public class MsgProcess {

	private static Logger logger = Logger.getLogger(MsgProcess.class);

	/**
	 * 接收采集服务发过来的消息，并处理
	 * 
	 * @param msg
	 */
	public static void contextHandle(ChannelHandlerContext ctx, String msg) {
		try {
			DataCollMgr.process(ctx, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ResponseValue process(CmdMsg msg) {
		ResponseValue res = new ResponseValue();
		String msgType = msg.getMsgType();
		String operId = msg.getRegOptId();
		String bedId = msg.getBedId();
		if (MyConstants.STATUS_START.equals(msgType)) {// start
			logger.info("----------------process:进入start方法-----------------------");
			ResultObj resultObj = OperationMgr.startAnalepsia(operId, bedId);
			Integer result = resultObj.getResult();
			if (0 == result) {
				res.setResultCode("1");
				res.setResultMessage(resultObj.getMsg());
			} else {
				res.setResultCode("10000000");
				res.setResultMessage(resultObj.getMsg());
			}

		} else if (MyConstants.STATUS_END.equals(msgType)) {// end
			logger.info("----------------process:进入end方法-----------------------");
			OperationMgr.endAnalepsia(bedId, operId);
			res.setResultCode("1");
			res.setResultMessage("结束复苏（" + operId + "）成功!");

		} else if(MyConstants.UPDATE_PACU_CONFIG.equals(msgType)){
			logger.info("----------------process:进入修改采集配置（updatePacuConfig）方法-----------------------");
			OperationMgr.updatePacuConfig(bedId);
			res.setResultCode("1");
			res.setResultMessage("修改PACU采集配置（" + bedId + "）成功!");
		}else if (MyConstants.UPDATE_FREQ.equals(msgType)) {// updateFreq
			logger.info("----------------process:进入updateFreq方法-----------------------");
			OperationMgr.updateOperFreq(operId);
			res.setResultCode("1");
			res.setResultMessage("修改查看频率成功!");
		}
		return res;
	}

}
