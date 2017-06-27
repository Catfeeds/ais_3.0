/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.operProceed.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.SysUtil;
import com.digihealth.anesthesia.operProceed.datasync.DataCollMgr;
import com.digihealth.anesthesia.operProceed.formbean.ObserveDataFormBean;
import com.digihealth.anesthesia.operProceed.po.BasObserveData;

/**
 * 
     * Title: ObserveDataService.java    
     * Description: 观察点数据Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasObserveDataService extends BaseService {
	
	public JSONArray searchObserveDataList(BaseInfoQuery baseQuery) {
		List<BasObserveData>  resultList = basObserveDataDao.searchObserveDataList(baseQuery);
		JSONArray ja = new JSONArray();
        if (resultList != null) {
            JSONObject jo = new JSONObject();
            JSONArray listJson = new JSONArray();
            Timestamp time = new Timestamp(1L);
            for (int i = 0; i < resultList.size(); i ++) {
                BasObserveData data = resultList.get(i);
                
                if (!data.getTime().equals(time)) {
                    time = data.getTime();
                    jo.put("observes", listJson);
                    if (i != 0) {
                        ja.add(jo);
                    }
                    
                    jo = new JSONObject();
                    listJson = new JSONArray();
                }
                //jo.put("freq", data.getFreq());
                jo.put("time", SysUtil.getTimeFormat(data.getTime()));
                listJson.add(DataCollMgr.obserDataToJson(data));
                
                if (i == resultList.size() - 1) {
                    jo.put("observes", listJson);
                    ja.add(jo);
                }  
            }
        }
		return ja;
	}
	
	public JSONArray searchUpdateObserveDataList(BaseInfoQuery baseQuery) {
		List<BasObserveData>  resultList = basObserveDataDao.searchObserveDataList(baseQuery);
		JSONArray ja = new JSONArray();
        if (resultList != null) {
            JSONObject jo = new JSONObject();
            JSONArray listJson = new JSONArray();
            Timestamp time = new Timestamp(1L);
            for (int i = 0; i < resultList.size(); i ++) {
                BasObserveData data = resultList.get(i);
                
                if (!data.getTime().equals(time)) {
                    time = data.getTime();
                    jo.put("observes", listJson);
                    if (i != 0) {
                        ja.add(jo);
                    }
                    
                    jo = new JSONObject();
                    listJson = new JSONArray();
                }
                // 增加输出freq和intervalTime给页面
                jo.put("freq", data.getFreq());
                jo.put("time", SysUtil.getTimeFormat(data.getTime()));
                jo.put("intervalTime", data.getIntervalTime());
                listJson.add(DataCollMgr.updateObserDataJson(data));
                
                if (i == resultList.size() - 1) {
                    jo.put("observes", listJson);
                    ja.add(jo);
                }  
            }
        }
		return ja;
	}
	
	/**
	 * 
	 * @param baseQuery
	 * @return
	 */
/*	public JSONArray searchPrintObserveData(BaseInfoQuery baseQuery) {
		JSONArray ja = new JSONArray();
		List<BasObserveData> observeTimes = basObserveDataDao.searchObserveTimeById(baseQuery.getRegOptId());
		int total = observeTimes.size();
		if (observeTimes != null & total > 0) {
			BaseInfoQuery infoQry = new BaseInfoQuery();
			infoQry.setRegOptId(baseQuery.getRegOptId());
			List<BasObserveData>  resultList = basObserveDataDao.searchObserveDataList(infoQry);
			
			if (observeTimes.size() <= baseQuery.getPageSize()) {
                JSONObject jo = new JSONObject();
                JSONArray listJson = new JSONArray();
                Timestamp time = new Timestamp(1L);
                for (int i = 0; i < resultList.size(); i ++) {
                    BasObserveData data = resultList.get(i);
                    
                    if (!data.getTime().equals(time)) {
                        time = data.getTime();
                        jo.put("observes", listJson);
                        if (i != 0) {
                            ja.add(jo);
                        }
                        
                        jo = new JSONObject();
                        listJson = new JSONArray();
                    }
                    //jo.put("freq", data.getFreq());
                    jo.put("time", SysUtil.getTimeFormat(data.getTime()));
                    listJson.add(DataCollMgr.obserDataToJson(data));
                    
                    if (i == resultList.size() - 1) {
                        jo.put("observes", listJson);
                        ja.add(jo);
                    }  
                }
			} else {
				float sp = (float)total / (baseQuery.getPageSize() - 1);
				List<Timestamp> times = new ArrayList<Timestamp>();
				for (int cnt = 0; cnt < baseQuery.getPageSize() - 1; cnt ++) {
					times.add(observeTimes.get((int)(cnt * sp)).getTime());
				}
				times.add(observeTimes.get(observeTimes.size() - 1).getTime());
				
                JSONObject jo = new JSONObject();
                JSONArray listJson = new JSONArray();
                Timestamp time = new Timestamp(1L);
                
                for (int i = 0; i < resultList.size(); i ++) {
                    BasObserveData data = resultList.get(i);
                    if (times.contains(data.getTime())) {
                        if (!data.getTime().equals(time)) {
                            time = data.getTime();
                            jo.put("observes", listJson);
                            if (i != 0) {
                                ja.add(jo);
                            }
                            
                            jo = new JSONObject();
                            listJson = new JSONArray();
                        }
                        //jo.put("freq", data.getFreq());
                        jo.put("time", SysUtil.getTimeFormat(data.getTime()));
                        listJson.add(DataCollMgr.obserDataToJson(data));
                    } else {
                    	if (i == resultList.size() - 1 || times.indexOf(data.getTime()) == times.size()-1) {
                    		jo.put("observes", listJson);
                    		ja.add(jo);
                    	}
                    }
                }
			}
		}

		return ja;
	}*/
	
	/**
	 * 
	 * @param baseQuery
	 * @return
	 */
	public JSONArray searchPrintObserveData(BaseInfoQuery baseQuery) {
		JSONArray ja = new JSONArray();
		List<BasObserveData> observeTimes = basObserveDataDao.searchObserveTimeById(baseQuery.getRegOptId());
		int total = observeTimes.size();
		if (observeTimes != null & total > 0) {
			BaseInfoQuery infoQry = new BaseInfoQuery();
			infoQry.setRegOptId(baseQuery.getRegOptId());
			List<BasObserveData> resultList = basObserveDataDao.searchObserveDataList(infoQry);
			Map<Timestamp, List<BasObserveData>> map = new HashMap<Timestamp, List<BasObserveData>>();
			List<BasObserveData> datList = null;
			Timestamp t = new Timestamp(1L);
			List<ObserveDataFormBean> jsonList = new ArrayList<ObserveDataFormBean>();
			ObserveDataFormBean bean = null;
			if (observeTimes.size() <= baseQuery.getPageSize()) {

				for (int i = 0; i < resultList.size(); i++) {
					BasObserveData d = resultList.get(i);
					if (t != d.getTime()) {
						t = d.getTime();
					}
					if (d.getTime().equals(t)) {
						if (!map.containsKey(t)) {
							datList = new ArrayList<BasObserveData>();
							datList.add(d);
							map.put(t, datList);
						} else {
							List<BasObserveData> list = map.get(t);
							list.add(d);
							map.put(t, list);
						}
					}
				}

				if (!map.isEmpty()) {
					for (Timestamp key : map.keySet()) {
						List<BasObserveData> series = map.get(key);
						String curTime = SysUtil.getTimeFormat(key);
						bean = new ObserveDataFormBean();
						bean.setTime(curTime);
						bean.setObserves(series);
						jsonList.add(bean);
					}
					ja = JSONArray.fromObject(jsonList);
				}
			} else {
				float sp = (float) total / (baseQuery.getPageSize() - 1);
				List<Timestamp> times = new ArrayList<Timestamp>();
				for (int cnt = 0; cnt < baseQuery.getPageSize() - 1; cnt++) {
					times.add(observeTimes.get((int) (cnt * sp)).getTime());
				}
				times.add(observeTimes.get(observeTimes.size() - 1).getTime());

				for (int i = 0; i < resultList.size(); i++) {
					BasObserveData d = resultList.get(i);
					if (times.contains(d.getTime())) {
						if (t != d.getTime()) {
							t = d.getTime();
						}
						if (d.getTime().equals(t)) {
							if (!map.containsKey(t)) {
								datList = new ArrayList<BasObserveData>();
								datList.add(d);
								map.put(t, datList);
							} else {
								List<BasObserveData> list = map.get(t);
								list.add(d);
								map.put(t, list);
							}
						}
					}
				}
				if (!map.isEmpty()) {
					for (Timestamp key : map.keySet()) {
						List<BasObserveData> series = map.get(key);
						String curTime = SysUtil.getTimeFormat(key);
						bean = new ObserveDataFormBean();
						bean.setTime(curTime);
						bean.setObserves(series);
						jsonList.add(bean);
					}
					ja = JSONArray.fromObject(jsonList);
				}

			}
		}

		return ja;
	}
	
	/**
	 * 获取汇总记录条数
	 * @param baseQuery
	 * @return
	 */
	public Integer searchObserveDataListTotal(BaseInfoQuery baseQuery) {
		return basObserveDataDao.searchObserveDataListTotal(baseQuery);
	}
	
	/**
	 * 新增观察点数据
	 * @param BasObserveData
	 */
	@Transactional
	public void insertObserveData(BasObserveData observeData){
		basObserveDataDao.insert(observeData);
	}
	
	@Transactional
	public void batchInsertObserveData(List<BasObserveData> obsDateList){
		for (BasObserveData observeData : obsDateList) {
			basObserveDataDao.insert(observeData);
		}
	}
	
	@Transactional
	public void batchUpdateObserveData(List<BasObserveData> obsDataList){
		for (BasObserveData observeData : obsDataList) {
			basObserveDataDao.updateIntervalTime(observeData);
		}
	}
	
	/**
	 * 修改观察点数据
	 * @param BasObserveData
	 */
	@Transactional
	public void updateObserveData(BasObserveData observeData){
		basObserveDataDao.update(observeData);
	}
	
	
	//获取手术时间轴信息
	public List<BasObserveData> searchObserveTimeById(String regOptId){
		return basObserveDataDao.searchObserveTimeById(regOptId);
	}
	//获取单个手术设备采集项信息
	public List<BasObserveData> searchObserveIdById(String regOptId){
		return basObserveDataDao.searchObserveIdById(regOptId);
	}
	//获取采集设备对应时间轴信息
	public List<BasObserveData> searchObserveDataById(String regOptId,List<String> obserIdItems,String items){
		return basObserveDataDao.searchObserveDataById(regOptId,obserIdItems,items);
	}
	//观察点数据
	public BasObserveData searchObserveDataByObserveId(String id) {
		return basObserveDataDao.searchObserveDataByObserveId(id);
	}
	
	@Transactional
	public void updateIconAndColor(String docId, String observeId,
			 String icon, String color) {
		basObserveDataDao.updateIconAndColor(docId, observeId, icon, color);
	}
	
	public Timestamp queryDbTime(){
		 return basObserveDataDao.queryDbTime();
	}
	
	@Transactional
	public List<BasObserveData> searchObserveDataBytime(String time){
		return basObserveDataDao.searchObserveDataBytime(time);
	}
	
	@Transactional
	public void deleteObserveDataById(String id) {
		basObserveDataDao.deleteObserveDataById(id);
	}

	public int searchMonitorDisplayByTime(String regOptId, String time) {
		return basObserveDataDao.searchMonitorDisplayByTime(regOptId, time);
	}
	
}
