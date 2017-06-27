package com.digihealth.anesthesia.pacu.datasync;

import io.netty.channel.ChannelHandlerContext;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.digihealth.anesthesia.basedata.dao.BasBusEntityDao;
import com.digihealth.anesthesia.basedata.po.BasCollectPacuData;
import com.digihealth.anesthesia.basedata.po.BasPacuMonitorConfig;
import com.digihealth.anesthesia.basedata.po.BasRegionBed;
import com.digihealth.anesthesia.basedata.service.BasCollectPacuDataService;
import com.digihealth.anesthesia.basedata.service.BasRegionBedService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;
import com.digihealth.anesthesia.operProceed.po.Observe;
import com.digihealth.anesthesia.pacu.core.MyConstants;
import com.digihealth.anesthesia.common.utils.SysUtil;

public class DataCollMgr {
    private final static Logger logger = Logger.getLogger(DataCollMgr.class);
    
    public static void process(ChannelHandlerContext ctx,String msg) {
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
            checkMonitorData(ctx,obj);
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
        /*JSONArray deviceArray = (JSONArray) obj.get("devices");
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
        }*/
    }
   
    public static void checkMonitorData(ChannelHandlerContext ctx,Map<String, Object> obj) {
    	//Timestamp currTime = SysUtil.getCurrentTimeStamp();
        JSONArray observeArray = (JSONArray) obj.get("observes");
        logger.info("checkMonitorData------监测数据:" + observeArray.toString()); 
        
        @SuppressWarnings("unchecked")
        List<Observe> newObserves = (List<Observe>) JSONArray.toCollection(
                observeArray, Observe.class);
        List<BasCollectPacuData> listDatas = new ArrayList<BasCollectPacuData>();
        
        //JSONObject json = new JSONObject();
        //json.put("time", SysUtil.getTimeFormat(currTime));
        //json.put("freq", "0");
        if (newObserves != null) {
        	InetSocketAddress address=(InetSocketAddress)(ctx.channel().remoteAddress());
        	String ip=address.getHostString();
        	int port = address.getPort();
        	BasRegionBed regionBed = null;
        	BasRegionBedService regionBedService = SpringContextHolder.getBean(BasRegionBedService.class);
        	String regOptId = null ;
        	String bedId = null;
        	BasBusEntityDao busEntityDao = SpringContextHolder.getBean(BasBusEntityDao.class);
        	String beid = busEntityDao.getBeid(); //获取当前局点
        	regionBed = regionBedService.selectByIpAddrPort(ip, port,beid);
        	if(regionBed != null){
        		regOptId = regionBed.getRegOptId();
        		bedId = regionBed.getId();
        		java.util.Iterator<Observe> ite = newObserves.iterator();
        		Map<String, List<BasPacuMonitorConfig>> bedMap = OperationMgr.getBedMap();
        		List<BasPacuMonitorConfig> pacuMonitorList = null;
        		if(bedMap.containsKey(bedId)){
        			pacuMonitorList = bedMap.get(bedId);
        		}
        		if(null != pacuMonitorList && pacuMonitorList.size()>0){
        			logger.info("pacuMonitorList.size-----"+pacuMonitorList.size()+",pacuMonitorList:"+JsonType.jsonType(pacuMonitorList));
        		}else{
        			//logger.info("bedMap==="+JsonType.jsonType(bedMap)+",bedId="+bedId);
        			logger.info("---------pacuMonitorList.size===0-------------");
        		}
                while (ite.hasNext()) {
                    Observe newObserve = ite.next();
                    
//                    if (json.containsKey("freq") && SysUtil.strParseToInt(json.get("freq").toString()) < newObserve.getFreq()) {
//                        json.put("freq", newObserve.getFreq());   
//                    }
                    if(null != pacuMonitorList && pacuMonitorList.size()>0){
                    	for (int i = 0; i < pacuMonitorList.size(); i++) {
                    		BasPacuMonitorConfig pmc = pacuMonitorList.get(i);
							if(newObserve.getObserveId().equals(pmc.getEventId())){
								logger.info("checkMonitorData---while---pmc---"+pmc.getEventId());
								BasCollectPacuData data = new BasCollectPacuData();
								data.setId(GenerateSequenceUtil.generateSequenceNo());
			                    data.setRegOptId(regOptId);
			                    data.setObserveId(newObserve.getObserveId());
			                    data.setObserveName(newObserve.getName());
			                    data.setTime(SysUtil.getDate(newObserve.getTimeSend(),"yyyyMMddHHmmss"));
			                    data.setValue(SysUtil.strParseToFloat(newObserve.getObserveValue()));
			                    //data.setState(newObserve.getState());
			                    data.setColor(pmc.getColor());
			                    data.setIcon(pmc.getIconId());
			                    //data.setFreq(newObserve.getFreq());
			                    data.setPosition(pmc.getPosition());
			                    // 默认设置间隔时间为freq
			                    //data.setIntervalTime(newObserve.getFreq());
			                    // 增加units 
			                    //data.setUnits(pmc.getUnits());
			                    listDatas.add(data);
			                    break;
							}
						}
                    }
                }
                if(null != listDatas && listDatas.size()>0){
                	logger.info("pacu---listDatas===checkMonitorData:"+JsonType.jsonType(listDatas));
                	BasCollectPacuDataService collectPacuDataService = SpringContextHolder.getBean(BasCollectPacuDataService.class);
                	collectPacuDataService.insertPacuObserveData(listDatas);
                	listDatas.clear();
                }
                
        	}else{
        		logger.error("There is no bed info with current ip:"+ip+" and port:"+port+"-------------");
        	}
            
        }
    }
    
    /**
     * 修改设备的状态 0 为正在检查中
     * @param devices
     */
//    public static void updateDeviceList(List<Device> devices){
//    	DeviceService deviceService = (DeviceService) SpringContextHolder
//                .getBean("deviceService");
//    	int size = devices.size();
//    	if(size>0){ 
//    		for (Device device : devices) {
//				device.setStatus(0);
//			}
//    	}
//        deviceService.updateDeviceList(devices);
//    }
    
    /**
     * 接收采集服务的设备状态，并修改b_device_config的status状态
     * @param devices
     */
//    public static void receiveDeviceList(List<Device> devices){
//    	DeviceService deviceService = (DeviceService) SpringContextHolder
//                .getBean("deviceService");
//    	int size = devices.size();
//    	if(size>0){ 
//    		for (Device device : devices) {
//				if(device.isConnected()){
//					device.setStatus(1);
//				}else{
//					device.setStatus(-1);
//				}
//			}
//    	}
//        deviceService.updateDeviceList(devices);
//    }
}
