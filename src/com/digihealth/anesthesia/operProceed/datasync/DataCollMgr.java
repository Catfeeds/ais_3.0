package com.digihealth.anesthesia.operProceed.datasync;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.digihealth.anesthesia.basedata.po.Device;
import com.digihealth.anesthesia.basedata.service.BasDeviceService;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;
import com.digihealth.anesthesia.common.utils.SysUtil;
import com.digihealth.anesthesia.operProceed.core.MyConstants;
import com.digihealth.anesthesia.operProceed.datasync.entity.DataMonitor;
import com.digihealth.anesthesia.operProceed.datasync.entity.MonitorRecord;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.BasObserveData;
import com.digihealth.anesthesia.operProceed.po.Observe;
import com.digihealth.anesthesia.operProceed.service.BasObserveDataService;
import com.digihealth.anesthesia.operProceed.service.BasObserveService;

public class DataCollMgr {
    private final static Logger logger = Logger.getLogger(DataCollMgr.class);
    
    public static void process(String msg) {
        @SuppressWarnings("unchecked")
        Map<String, Object> obj = JSONObject.fromObject(msg);
        int msgType = Integer.parseInt(obj.get("msgType").toString());

        switch (msgType) {
        case MyConstants.DATA_COLLECTOR_HEARTBEAT:// 心跳
            checkHeartBeat();
            break;
        case MyConstants.DATA_COLLECTOR_DEVICE:// 设备状态
            checkDeviceStatus(obj);
            break;
        case MyConstants.DATA_COLLECTOR_MONITOR:// 观察点的数据
            checkMonitorData(obj);
            break;
        }
    }
    
    public static void checkHeartBeat() {
        logger.info("checkHeartBeat------不做处理"); 
    }
    
    /**
     * 检查设备状态
     * @param obj
     */
    public static void checkDeviceStatus(Map<String, Object> obj) {
        logger.info("checkDeviceStatus------检查设备状态"); 
        JSONArray deviceArray = (JSONArray) obj.get("devices");
        @SuppressWarnings("unchecked")
        List<Device> newDevices = (List<Device>) JSONArray.toCollection(
                deviceArray, Device.class);
        if (newDevices != null) {
			//            JSONObject json = new JSONObject();
			//            json.put("msgType", "deviceStatus");
			//            json.put("msgBody", deviceArray);
            // 把消息发送到客户端
            //SessionUtil.broadcast(json.toString());
            //修改设备状态，收到采集服务的状态，并修改成对应的值(-1,未连上，1连上)
        	DataCollMgr.receiveDeviceList(newDevices);
        }
    }
    
//    public static void main(String[] args) {
//    	String msg = "{\"msgType\":1,\"observes\":[{\"position\":1,\"min\":0,\"icon\":\"\",\"precision\":0,\"max\":0,\"observeId\":\"32001\",\"paraId\":\"\",\"freq\":30,\"state\":0,\"observeValue\":\"108\",\"timeSend\":\"20170206150000\",\"paraName\":\"\",\"time\":\"20170206150000\",\"color\":\"\",\"isAmend\":false,\"name\":\"SpO2\",\"docId\":\"\",\"deviceId\":\"1\"},{\"position\":-1,\"min\":0,\"icon\":\"\",\"precision\":0,\"max\":0,\"observeId\":\"30001\",\"paraId\":\"\",\"freq\":0,\"state\":0,\"observeValue\":\"108\",\"timeSend\":\"20170206150000\",\"paraName\":\"\",\"time\":\"20170206150000\",\"color\":\"\",\"isAmend\":false,\"name\":\"SpO2\",\"docId\":\"\",\"deviceId\":\"1\"}]}";
//    	Map<String, Object> obj = JSONObject.fromObject(msg);
//    	checkMonitorData(obj);
//	}
    
    /**
     * 监测点数据
     * @param obj
     */
	public static void checkMonitorData(Map<String, Object> obj) {
		
		JSONArray observeArray = (JSONArray) obj.get("observes");
		logger.info("checkMonitorData------监测数据:" + observeArray.toString());
		
		//测试value为null的时候
		/***************start********************/
		/**
		JSONObject j = (JSONObject)observeArray.get(0);
		Observe observe = (Observe)JSONObject.toBean(j,Observe.class);
		observe.setObserveValue("null");
		observeArray.set(0, observe);
		
		JSONObject j2 = (JSONObject)observeArray.get(1);
		Observe observe2 = (Observe)JSONObject.toBean(j2,Observe.class);
		observe2.setObserveValue("\"null\"");
		observeArray.set(1, observe2);
		
		logger.info("observeArray----" + observeArray.toString());
		**/
		/***************end********************/
		
		JSONArray listJson = new JSONArray();
		@SuppressWarnings("unchecked")
		List<Observe> newObserves = (List<Observe>) JSONArray.toCollection(observeArray, Observe.class);
		List<BasObserveData> listDatas = new ArrayList<BasObserveData>();
		//String timeFormat = SysUtil.getTimeFormat(currTime);
		JSONObject json = new JSONObject();
		//json.put("time", timeFormat);
		json.put("freq", "0");
		if (newObserves != null && newObserves.size() > 0) {
			String timeSend = newObserves.get(0).getTimeSend();
			Date timeSendDate = SysUtil.getDate(timeSend,"yyyyMMddHHmmss");
			Calendar ca = Calendar.getInstance();
			ca.setTime(timeSendDate);
			ca.add(Calendar.SECOND, 2);//加2s存入数据库
			Date time = ca.getTime();
			Timestamp currTime = SysUtil.getCurrentTimeStamp(time);
			String timeFormat = SysUtil.getTimeFormat(time);
			json.put("time", timeFormat);
			logger.info("checkMonitorData----time------" + time);
			Map<String, Observe> monitors = DataMonitor.getObservesByRoom(Global.getConfig("roomId").toString(), OperationMgr.getRegOptId());
			java.util.Iterator<Observe> ite = newObserves.iterator();
			
			while (ite.hasNext()) {
				logger.info("-------checkMonitorData---newObserves-------while------");
				Observe newObserve = ite.next();
				Observe monitorItem = monitors.get(newObserve.getObserveId() + '_' + newObserve.getDeviceId());

				if (json.containsKey("freq") && SysUtil.strParseToInt(json.get("freq").toString()) < newObserve.getFreq()) {
					json.put("freq", newObserve.getFreq());
				}
				BasObserveData data = new BasObserveData();
				data.setRegOptId(OperationMgr.getRegOptId());// 从OperationMgr中获取regOptId
				data.setObserveId(newObserve.getObserveId());
				data.setObserveName(newObserve.getName());
				data.setTime(currTime);
				if(newObserve.getObserveValue() == null || newObserve.getObserveValue().contains("NULL")){
					data.setValue(null);
				}else{
					data.setValue(SysUtil.strParseToFloat(newObserve.getObserveValue()));
				}
				data.setState(newObserve.getState());
				data.setColor(newObserve.getColor());
				data.setIcon(newObserve.getIcon());
				data.setFreq(newObserve.getFreq());
				data.setPosition(newObserve.getPosition());
				// 默认设置间隔时间为freq
				data.setIntervalTime(newObserve.getFreq());
				if (monitorItem != null) {
					data.setColor(monitorItem.getColor());
					data.setIcon(monitorItem.getIcon());
				}
				// 增加units
				BasObserveService observeService = SpringContextHolder.getBean(BasObserveService.class);
				BasMonitorConfig monitorConfig = observeService.searchMonitorConfig(newObserve.getObserveId(), null);
				if (null == monitorConfig || monitorConfig.getUnits() == null) {
					logger.info("monitorConfig------------is null");
				} else {
					data.setUnits(monitorConfig.getUnits());
				}

				JSONObject observJson = obserDataToJson(data);
				listDatas.add(data);
				listJson.add(observJson);
			}
		}

		json.put("observes", listJson);
		MonitorRecord rec = jsonToMontiorRec(json);
		DataMonitor.setLastMonitorRecs(json.get("freq").toString(), rec);

		// 插入采集数据
		if (rec == null) {
			logger.error("checkMonitorData----无采集数据");
		} else {
			logger.info("checkMonitorData-----获取到采集数据");

			// 判断Rec的真实采集时间与当前的时间做对比，如果超过 定义好的时间,则新增,则只推送Plot，不推送Rec
			for (BasObserveData ob : rec.getObsDatas()) {
				ob.setId(GenerateSequenceUtil.generateSequenceNo());
				// ob.setTime(currTime);
			}
			if (null != rec.getObsDatas() && rec.getObsDatas().size() > 0) {
				BasObserveDataService observeDataService = SpringContextHolder.getBean(BasObserveDataService.class);
				int count = observeDataService.searchMonitorDisplayByTime(OperationMgr.getRegOptId(), json.getString("time"));
				// logger.info("rec is not null ----- count = "+count);
				if (count == 0) {
					DataMonitor.insertObserDatas(rec.getObsDatas());// 插入b_observe_data表
				}
			}
		}

	}
    
    
    
    
    /**
     * 实时数据
     * @param obj
     */
    public static void checkPhysAlarm(Map<String, Object> obj) {
        JSONArray observeArray = (JSONArray) obj.get("observes");
        //logger.info("observes==="+JsonType.jsonType(observeArray));
        @SuppressWarnings("unchecked")
        List<Observe> newObserves = (List<Observe>) JSONArray.toCollection(
                observeArray, Observe.class);
        JSONArray phyAlarmData = new JSONArray();
        if (newObserves != null) {
            java.util.Iterator<Observe> ite = newObserves.iterator();
            while (ite.hasNext()) {
                Observe newObserve = ite.next();

                String observeName = newObserve.getName();
                String observeValue = newObserve.getObserveValue();

                JSONObject data = new JSONObject();
                data.put("name", observeName);
                data.put("value", SysUtil.strParseToFloat(observeValue));
                data.put("state", newObserve.getState());
                phyAlarmData.add(data);
            }
            //logger.info("phyAlarm==="+JsonType.jsonType(phyAlarmData));
            JSONObject json = new JSONObject();
            json.put("msgType", "phyAlarm");
            json.put("msgBody", phyAlarmData);

            // 把消息发送到客户端
            //SessionUtil.broadcast(json.toString());
        }
    }
    
    public static MonitorRecord jsonToMontiorRec(JSONObject json) {
        logger.info("jsonToMontiorRec------JSON数据转换：" + json); 
        MonitorRecord rec = new MonitorRecord();
        rec.setTime(json.get("time").toString());
        rec.setFreq(json.get("freq").toString());
        JSONArray jsonArr = (JSONArray) json.get("observes");
        List<BasObserveData> obserDatas = new ArrayList<BasObserveData>();
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jo = (JSONObject) jsonArr.get(i);
            obserDatas.add(jsonToObserData(jo));
        }
        rec.setObsDatas(obserDatas);
        
        return rec;
    }
    
    public static BasObserveData jsonToObserData(JSONObject jo) {
        logger.info("jsonToObserData------JSON数据转换：" + jo); 
        BasObserveData data = new BasObserveData();
        if (jo.containsKey("id")) {
            data.setId(jo.get("id").toString());
        }
        data.setRegOptId(jo.get("regOptId").toString());
        data.setObserveId(jo.get("observeId").toString());
        data.setObserveName(jo.get("observeName").toString());
        if (jo.containsKey("time")) {
            data.setTime(SysUtil.getTimestamp(jo.get("time").toString()));
        }
        
        // value处理
        if(!jo.containsKey("value")){
        	data.setValue(null);
        }else{
            String value = jo.get("value").toString();
            if(value.contains("NULL")){
            	data.setValue(null);
            }else{
            	data.setValue(SysUtil.strParseToFloat(value));
            }
        }
       
        data.setState(Integer.parseInt(jo.get("state").toString()));
        data.setColor(jo.get("color").toString());
        data.setIcon(jo.get("icon").toString());
        data.setFreq(SysUtil.strParseToInt(jo.get("freq").toString()));
        data.setPosition(SysUtil.strParseToInt(jo.get("position").toString()));
        data.setIntervalTime(SysUtil.strParseToInt(jo.get("intervalTime").toString()));
        /*ObserveService observeService = (ObserveService)SpringContextHolder.getBean("observeService");
        // 获取Observe,增加units
        MonitorConfig monitorConfig = observeService.searchMonitorConfig(data.getObserveId());
        data.setUnits(monitorConfig.getUnits());*/
        if(jo.containsKey("units")){
        	data.setUnits(jo.get("units").toString());
        }
        
        return data;
    }
    
    public static JSONObject obserDataToJson(BasObserveData data) {
        //logger.info("obserDataToJson------ObserveData数据转换：" + JsonType.jsonType(data)+"---" + SysUtil.getTimeFormat(data.getTime())); 
        JSONObject observJson = new JSONObject();
        observJson.put("id", data.getId());
        observJson.put("regOptId", data.getRegOptId());
        observJson.put("color", data.getColor());
        observJson.put("icon", data.getIcon());
        observJson.put("state", data.getState());
        observJson.put("value", data.getValue());
        observJson.put("time", SysUtil.getTimeFormat(data.getTime()));
        observJson.put("observeId", data.getObserveId());
        observJson.put("observeName", data.getObserveName());
        observJson.put("freq", data.getFreq());
        observJson.put("position", data.getPosition());
        observJson.put("intervalTime", data.getIntervalTime());
        observJson.put("units", data.getUnits());
        return observJson;
    }
    
    public static JSONObject updateObserDataJson(BasObserveData data) {
        Observe monitorItem = DataMonitor.getMonitorItemById(data.getObserveId() + '_');
        
        JSONObject observJson = new JSONObject();
        observJson.put("id", data.getId());
        observJson.put("regOptId", data.getRegOptId());
        observJson.put("color", data.getColor());
        observJson.put("icon", data.getIcon());
        if (monitorItem != null) {
            observJson.put("color", monitorItem.getColor());
            observJson.put("icon", monitorItem.getIcon());
        }
        observJson.put("state", data.getState());
        observJson.put("value", data.getValue());
        observJson.put("time", SysUtil.getTimeFormat(data.getTime()));
        observJson.put("observeId", data.getObserveId());
        observJson.put("observeName", data.getObserveName());
        observJson.put("freq", data.getFreq());
        observJson.put("position", data.getPosition());
        // 增加intervalTime的传入
        observJson.put("intervalTime", data.getIntervalTime());
        
        BasObserveService observeService = (BasObserveService)SpringContextHolder.getBean(BasObserveService.class);
        // 获取Observe,增加units
        BasMonitorConfig monitorConfig = observeService.searchMonitorConfig(data.getObserveId(),null);
        data.setUnits(monitorConfig.getUnits());
        
        // 增加units的传入 
        observJson.put("units", data.getUnits());
        
        return observJson;
    }

    public static JSONObject monitorRecToJson(MonitorRecord rec) {
        //logger.info("monitorRecToJson------MonitorRecord转为Json" + rec.getTime());
        JSONObject json = new JSONObject();
        json.put("freq", rec.getFreq());
        json.put("time", rec.getTime());
        JSONArray listJson = new JSONArray();
        for (BasObserveData data : rec.getObsDatas()) {
            listJson.add(obserDataToJson(data));
        }
        json.put("observes", listJson);
        return json;
    }
    
    /**
     * 修改设备的状态 0 为正在检查中
     * @param devices
     */
    public static void updateDeviceList(List<Device> devices){
    	BasDeviceService deviceService = (BasDeviceService) SpringContextHolder
                .getBean(BasDeviceService.class);
    	int size = devices.size();
    	if(size>0){ 
    		for (Device device : devices) {
				device.setStatus(0);
			}
    	}
        deviceService.updateDeviceList(devices);
    }
    
    /**
     * 接收采集服务的设备状态，并修改b_device_config的status状态
     * @param devices
     */
    public static void receiveDeviceList(List<Device> devices){
    	BasDeviceService deviceService = (BasDeviceService) SpringContextHolder
                .getBean(BasDeviceService.class);
    	int size = devices.size();
    	if(size>0){
    		for (Device device : devices) {
				if(device.isConnected()){
					device.setStatus(1);
				}else{
					device.setStatus(-1);
				}
			}
    	}
        deviceService.updateDeviceList(devices);
    }
}
