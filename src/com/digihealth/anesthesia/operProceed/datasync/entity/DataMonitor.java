package com.digihealth.anesthesia.operProceed.datasync.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;
import com.digihealth.anesthesia.basedata.po.Device;
import com.digihealth.anesthesia.basedata.service.BasDeviceService;
import com.digihealth.anesthesia.basedata.service.BasMonitorConfigFreqService;
import com.digihealth.anesthesia.basedata.service.BasRegOptService;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;
import com.digihealth.anesthesia.common.utils.SysUtil;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.doc.service.DocAnaesRecordService;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;
import com.digihealth.anesthesia.evt.service.EvtAnaesEventService;
import com.digihealth.anesthesia.operProceed.po.BasMonitorDisplay;
import com.digihealth.anesthesia.operProceed.po.BasObserveData;
import com.digihealth.anesthesia.operProceed.po.Observe;
import com.digihealth.anesthesia.operProceed.po.ObserveDataChangeHis;
import com.digihealth.anesthesia.operProceed.service.BasMonitorDisplayService;
import com.digihealth.anesthesia.operProceed.service.BasObserveDataService;
import com.digihealth.anesthesia.operProceed.service.BasObserveService;
import com.digihealth.anesthesia.operProceed.service.ObserveDataChangeHisService;

public class DataMonitor {
    private final static Logger logger = Logger.getLogger(DataMonitor.class);
    private static Map<String, Observe> monitorItems = new ConcurrentHashMap<String, Observe>();//监测项数据
    private static List<MonitorRecord> monitorRecs = Collections.synchronizedList(new ArrayList<MonitorRecord>()); //监测数据点列表
    private static Map<String, MonitorRecord> lastMonitorRecs = new ConcurrentHashMap<String, MonitorRecord>();  //最近的监测点数据

    public static Map<String, Observe> getMonitorItems() {
        return monitorItems;
    }
    
    public static Observe getMonitorItemById(String id) {
    	Observe ob = new Observe();
    	
    	if (monitorItems != null && monitorItems.containsKey(id)) {
    		ob = monitorItems.get(id);
    	}
    	else {
            for (String key : monitorItems.keySet()) {
                if (key.contains(id)) {
                	ob = monitorItems.get(key);
                }
            }
    	}
    	
    	return ob;
    }
    
    public static  MonitorRecord getLastMonitorRec(String key) {
        MonitorRecord rec = lastMonitorRecs.get(key);
//        if (rec == null && !SysUtil.isEmptyList(monitorRecs)) {
//            logger.info("getLastMonitorRec------key未找到，返回最新的Rec：" + key);
//            rec = monitorRecs.get(monitorRecs.size() - 1);
//        }
        return rec;
    }

    public static void setLastMonitorRecs(String key, MonitorRecord monitorRec) {
        lastMonitorRecs.put(key, monitorRec);
    }

    public static List<Device> getDevicesByRoom(String roomId) {
        logger.info("getDevicesByRoom------获取房间设备信息，roomId:" + roomId);
        BasDeviceService deviceService = (BasDeviceService) SpringContextHolder
                .getBean(BasDeviceService.class);
        // 根据业务需求，不传递roomId给接口
        List<Device> devices = deviceService.searchDeviceListByRoomId(null,null);
        return devices;
    }

    public static Map<String, Observe> getObservesByRoom(String roomId, String operId) {
        logger.info("getObservesByRoom------获取监测项数据，roomId:" + roomId);
        BasObserveService observeService = (BasObserveService) SpringContextHolder
                .getBean(BasObserveService.class);
        // 根据业务需求，不传递roomId给接口
        List<Observe> listObserve = observeService
                .searchAnaesObserveList(null, operId);

        if (!SysUtil.isEmptyList(listObserve)) {
            monitorItems = new HashMap<String, Observe>();

            Iterator<Observe> iteObserve = listObserve.iterator();
            while (iteObserve.hasNext()) {
                Observe observe = iteObserve.next();
                String observeId = observe.getObserveId();
                monitorItems.put(observeId + '_' + observe.getDeviceId(),
                        observe);
            }
        }
        logger.info("getObservesByRoom------获取监测项数据，roomId:" + roomId
                + " monitorItems:" + JSONArray.fromObject(monitorItems).toString());
        return monitorItems;
    }

    public static void addMonitorRec(MonitorRecord rec) {
        logger.info("addMonitorRec------新增监测项数据，rec:" + rec.toString());
        if (monitorRecs == null || monitorRecs.isEmpty()) {
            monitorRecs = new ArrayList<MonitorRecord>();
        }

        monitorRecs.add(rec);
    }

    public static void updateMonitorData(String msg) {
        logger.info("updateMonitorData------更新监测项数据:" + msg);
        JSONObject json = JSONObject.fromObject(msg);
        BasObserveDataService observeDataService = (BasObserveDataService) SpringContextHolder
                .getBean(BasObserveDataService.class);
        BasObserveData data = observeDataService.searchObserveDataByObserveId(json.getString("id"));
        
        if (data != null) {
        	 logger.info("updateMonitorData------更新数据开始");
             ObserveDataChangeHis changeData = new ObserveDataChangeHis();
             changeData.setObserveDataChange(data, Float.parseFloat(json
                     .getString("value")));
             
             data.setValue(Float.parseFloat(json
                     .getString("value")));

             observeDataService.updateObserveData(data);
             logger.info("updateMonitorData------更新数据成功");
             
             ObserveDataChangeHisService changeService = (ObserveDataChangeHisService) SpringContextHolder
                     .getBean(ObserveDataChangeHisService.class);
             changeService.insertObserveDataChanges(changeData);
             logger.info("updateMonitorData------insertObserveDataChanges更新数据成功");
        }
    }

    public static void updateMonitors(String msg) {
    	logger.info("updateMonitors------更新监测项图标、颜色:" + msg);
        JSONObject json = JSONObject.fromObject(msg);
        String regOptId = json.getString("regOptId");
        JSONArray observeArray = (JSONArray) json.get("observes");
        @SuppressWarnings("unchecked")
        List<Observe> observeList = (List<Observe>) JSONArray.toCollection(
                observeArray, Observe.class);
        
        if (SysUtil.isEmptyList(observeList)) {
            logger.info("updateMonitors------无监测项数据，不需要更新");
            return;
        }
        
        if (monitorItems != null && monitorItems.size() > 0) {
            for (Observe ob : monitorItems.values()) {
                for (int i = 0; i < observeList.size(); i ++) {
                    Observe observe = observeList.get(i);
                    if (ob.getName().equals(observe.getName())) {
                        logger.info("updateMonitors------更新监测项数据开始, name:" + ob.getName());
                        ob.setColor(observe.getColor());
                        ob.setIcon(observe.getIcon());
                        logger.info("updateMonitors------更新监测项数据成功, color:" + observe.getColor() + " icon:" + observe.getIcon());
                    }
                }
            }
        }
        
        BasObserveDataService observeDataService = (BasObserveDataService) SpringContextHolder
                .getBean(BasObserveDataService.class);
        for (int i = 0; i < observeList.size(); i ++) {
            Observe observe = observeList.get(i);
            observeDataService.updateIconAndColor(regOptId, observe.getObserveId(), 
            		observe.getIcon(), observe.getColor());
        }
    }

    public static void clearMonitorRec() {
        logger.info("clearMonitorRec------清理监测项数据");
        if (monitorRecs != null && !monitorRecs.isEmpty()) {
            monitorRecs.clear();
        }
    }

    public static void clearMonitorItems() {
        logger.info("clearMonitorItems------清理监测项");
        if (monitorItems != null && monitorItems.size() != 0) {
            monitorItems.clear();
        }
    }
    
    public static void clearMonitorRecord(){
    	 logger.info("clearMonitorRecord------清理监测项record");
    	 if(null != lastMonitorRecs && lastMonitorRecs.size()!=0){
    		 lastMonitorRecs.clear();
    	 }
    }

    public static void insertObserDatas(List<BasObserveData> obserDatas) {
        logger.info("insertObserDatas------插入监测项数据");
        try {
            BasObserveDataService observeDataService = (BasObserveDataService) SpringContextHolder
                    .getBean(BasObserveDataService.class);
            observeDataService.batchInsertObserveData(obserDatas);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }
    
    public static void updateObserDatas(List<BasObserveData> obserDatas){
    	logger.info("updateObserDatas--------修改监测项数据,在更改模式的时候，会修改intervalTime时间"+JsonType.jsonType(obserDatas));
    	try {
			BasObserveDataService observeDataService = (BasObserveDataService)SpringContextHolder.getBean(BasObserveDataService.class);
			observeDataService.batchUpdateObserveData(obserDatas);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
    }

    public static String getMonitorFreq(String type) {
        logger.info("getMonitorFreq------获取项:" + type);
        BasMonitorConfigFreqService freqSer = SpringContextHolder.getBean(BasMonitorConfigFreqService.class);
        BasMonitorConfigFreq monFreq = freqSer.searchMonitorFreqByType(type);
        String freq = "";
        if (monFreq != null) {
            freq = monFreq.getValue();
        }
        logger.info("getMonitorFreq------获取值，value:" + freq);
        return freq;
    }

    public static List<Integer> getMonitorItemFreqs() {
        logger.info("getMonitorItemFreqs------获取监测项频率基数");
        if (monitorItems == null || monitorItems.size() == 0) {
        	Integer[] data = new Integer[] {1, 3}; 
			return Arrays.asList(data);
        }

        List<Integer> list = new ArrayList<Integer>();
        for (Observe ob : monitorItems.values()) {
            if (SysUtil.isEmptyList(list) && ob.getFreq() > 0) {
                list.add(ob.getFreq());
                continue;
            }
            if (!list.contains(ob.getFreq()) && ob.getFreq() > 0) {
                list.add(ob.getFreq());
            }
        }
        logger.info("getMonitorItemFreqs------监测项频率基数：" + list.toString());
        return list;
    }
    
    /**
     * 获取所有的监测项
     * @param regOptId
     * @return
     */
    public static List<Observe> getObserves(String regOptId){
    	BasObserveService observeService = (BasObserveService) SpringContextHolder
                .getBean(BasObserveService.class);
        // 根据业务需求，不传递roomId给接口
        List<Observe> listObserve = observeService
                .searchAnaesObserveList(null, regOptId);
        return listObserve;
    }
    
    public static void insertMonitorDisplays(List<BasMonitorDisplay> mds) {
        logger.info("insertMonitorDisplays------插入监测项数据");
        try {
        	BasMonitorDisplayService monitorDisplayService = (BasMonitorDisplayService) SpringContextHolder
                    .getBean(BasMonitorDisplayService.class);
        	monitorDisplayService.batchInsertMonitorDisplays(mds);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertMonitorDisplays==="+e);
        }
    }
    
    public static void updateOperTime(String operTime,String regOptId){
    	logger.info("updateOperTime----修改 患者id为 "+regOptId+" 的手术开始命令时间为 " + operTime );
    	try {
    		BasRegOptService regOptService = SpringContextHolder.getBean(BasRegOptService.class);
        	regOptService.updateOperTime(operTime, regOptId);
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("updateOperTime---> "+e);
		}
    }
    
    public static void updateAnaesInRoomTime(String inTime,String regOptId){
    	logger.info("updateAnaesInRoomTime----修改 患者id为 "+regOptId+" 的手术入室时间为 " + inTime );
    	try {
    		DocAnaesRecordService anaesRecordService = SpringContextHolder.getBean(DocAnaesRecordService.class);
    		anaesRecordService.updateAnaesInRoomTime(inTime, regOptId);
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("updateAnaesInRoomTime---> "+e);
		}
    }
    
    public static void insertAnaesEvent(String regOptId,String  timeFormat){
    	logger.info("insertAnaesEvent----初始进入手术室，新增手术入室事件");
    	try {
    		EvtAnaesEventService anaeseventService = SpringContextHolder.getBean(EvtAnaesEventService.class);
    		DocAnaesRecordService anaesRecordService = SpringContextHolder.getBean(DocAnaesRecordService.class);
    		DocAnaesRecord anaesRecord = anaesRecordService.searchAnaesRecordByRegOptId(regOptId);
    		EvtAnaesEvent anaesevent = new EvtAnaesEvent();
    		//anaesevent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
    		anaesevent.setCode(EvtAnaesEventService.IN_ROOM);
    		//String timeFormat = SysUtil.getTimeFormat(occurtime);
    		Date date = SysUtil.getDate(timeFormat);
    		anaesevent.setOccurTime(date);
    		//anaesevent.setState("04");//必须是术中
    		if(null != anaesRecord){
    			anaesevent.setDocId(anaesRecord.getAnaRecordId());
    		}
    		anaesevent.setDocType(EvtAnaesEventService.DOC_ANAES_RECORD); //设置为麻醉记录单
    		anaeseventService.insertAnaesevent(anaesevent);
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("updateAnaesInRoomTime---> "+e);
		}
    }
}
