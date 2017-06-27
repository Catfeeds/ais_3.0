package com.digihealth.anesthesia.pacu.datasync;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.digihealth.anesthesia.basedata.po.BasPacuMonitorConfig;
import com.digihealth.anesthesia.basedata.po.BasRegionBed;
import com.digihealth.anesthesia.basedata.service.AnaesPacuSocketService;
import com.digihealth.anesthesia.basedata.service.BasCollectPacuDataHisService;
import com.digihealth.anesthesia.common.listener.ConstantHolder;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;
import com.digihealth.anesthesia.operProceed.formbean.ResultObj;
import com.digihealth.anesthesia.operProceed.po.Observe;
import com.digihealth.anesthesia.pacu.core.MyConstants;
import com.digihealth.anesthesia.pacu.core.SocketClient;

public class OperationMgr {
	private final static Logger logger = Logger.getLogger(OperationMgr.class);
	private static Map<String, SocketClient> socketMap = new HashMap<String, SocketClient>();
	private static Map<String, List<BasPacuMonitorConfig>> bedMap = new HashMap<String, List<BasPacuMonitorConfig>>();

	public static Map<String, List<BasPacuMonitorConfig>> getBedMap() {
		return bedMap;
	}

	public static void setBedMap(Map<String, List<BasPacuMonitorConfig>> bedMap) {
		OperationMgr.bedMap = bedMap;
	}

	public OperationMgr(String remoteHost, int remotePort) {

	}

	public static String getKey(String bedId, String beid) {
		return bedId + ConstantHolder.ROUTING_ACCESS_LINK + beid;
	}

	public static boolean init(String operId, String bedId) {
		logger.info("init------初始化开始");
		boolean rst = true;

		AnaesPacuSocketService anaesPacuSocketService = SpringContextHolder.getBean(AnaesPacuSocketService.class);
		// 通过bedID 获取端口和IP
		BasRegionBed regionBed = anaesPacuSocketService.getRegionBed(bedId);
		// 校验床和人的是否对应的上
		if (!operId.equals(regionBed.getRegOptId())) {
			return rst = false;
		}

		String ip = regionBed.getIpAddr();
		int port = regionBed.getPort();
		String beid = regionBed.getBeid();
		// String key = getKey(bedId,beid);
		SocketClient socket = socketMap.get(bedId);
		if (socket == null) {
			logger.info("init------初始化Socket连接");
			socket = new SocketClient(ip, port);
			socketMap.put(bedId, socket);
		}

		List<BasPacuMonitorConfig> list = bedMap.get(bedId);
		if (list == null) {
			logger.info("init---------初始化bedMap！");
			list = anaesPacuSocketService.getObserveList(bedId, beid);
			bedMap.put(bedId, list);
			logger.info("bedMap===" + JsonType.jsonType(bedMap));
		}

		if (socket.getConnected() == -1) {
			rst = socket.init();
		}

		return rst;
	}

	public static ResultObj startAnalepsia(String operId, String bedId) {
		ResultObj resultObj = new ResultObj();
		logger.info("startAnalepsia------复苏开始， operId:" + operId + ",bedId:" + bedId);

		// 获取床旁设备
		// AnaesPacuSocketService anaesPacuSocketService =
		// SpringContextHolder .getBean("anaesPacuSocketService");
		// List<Observe> observeList = anaesPacuSocketService
		// .getObserveList(bedId);
		// //如果床盘没有设备就无需建立连接 if(null == observeList || observeList.size()<=0) {
		// resultObj.setBool(false); resultObj.setResult(-1);
		// resultObj.setMsg("床旁没有设备，请检查！"); return resultObj;
		// }

		boolean init = init(operId, bedId);

		if (!init) {
			resultObj.setBool(false);
			resultObj.setResult(-1);
			resultObj.setMsg("初始化失败，请检查！床位和患者（region_bed）是否配置正确。");
			return resultObj;
		}

		// 发送采集项
		// JSONObject json = new JSONObject();
		// json.put("msgType", MyConstants.COMMAND_OPERATION_MONITOR);
		// json.put("observes", observeList);
		// SocketClient socket = socketMap.get(String.valueOf(bedId));
		// socket.sendMsg(json.toString());

		// 发送开始指令
		setCommand(bedId, MyConstants.COMMAND_OPERATION_START);

		resultObj.setBool(true);
		resultObj.setResult(0);
		resultObj.setMsg("开启复苏监测" + operId + "成功!");
		return resultObj;

	}

	public static void endAnalepsia(String bedId, String operId) {
		logger.info("endOperation------发送手术结束指令， operId:" + operId);
		SocketClient socket = socketMap.get(bedId);
		if (null != socket) {
			setCommand(bedId, MyConstants.COMMAND_OPERATION_END);
			socket.close();
			if (socketMap.containsKey(bedId)) {
				socketMap.remove(bedId);
			}
			BasCollectPacuDataHisService collectPacuDataHisService = SpringContextHolder.getBean(BasCollectPacuDataHisService.class);
			collectPacuDataHisService.movePacuObserveDataToHis(operId);
		}
	}

	public static boolean setOperMonitor(int bedId, Map<String, Observe> observes) {
		logger.info("setOperMonitor------设置并发送监测项指令");
		JSONObject json = new JSONObject();
		json.put("msgType", MyConstants.COMMAND_OPERATION_MONITOR);
		json.put("observes", observes.values());
		SocketClient socket = socketMap.get(bedId);
		return socket.sendMsg(json.toString());
	}

	// 修改频率
	public static void updateOperFreq(String operId) {
		logger.info("updateOperFreq---修改当前模式下的频率，regOptId: " + operId);

	}

	public static boolean setCommand(String bedId, String msgType) {
		JSONObject json = new JSONObject();
		json.put("msgType", msgType);
		SocketClient socket = socketMap.get(bedId);
		return socket.sendMsg(json.toString());
	}

	public static boolean setCommand(String bedId, String msgType, int freq) {
		JSONObject json = new JSONObject();
		json.put("msgType", msgType);
		json.put("freq", freq);
		SocketClient socket = socketMap.get(bedId);
		return socket.sendMsg(json.toString());
	}

	public static String getErrorDesc(String msg) {
		JSONObject jsonInit = new JSONObject();
		jsonInit.put("msgType", "warn");
		jsonInit.put("msgBody", msg);
		return jsonInit.toString();
	}

	public static void updatePacuConfig(String bedId) {
		logger.info("updatePacuConfig---------修改bedMap采集配置！");
		List<BasPacuMonitorConfig> list = bedMap.get(bedId);
		// if (list == null) {
		// logger.info("updatePacuConfig---------修改bedMap采集配置！");
		AnaesPacuSocketService anaesPacuSocketService = SpringContextHolder.getBean(AnaesPacuSocketService.class);
		BasRegionBed regionBed = anaesPacuSocketService.getRegionBed(bedId);
		list = anaesPacuSocketService.getObserveList(bedId, regionBed.getBeid());
		bedMap.put(bedId, list);
		// }
	}
}
