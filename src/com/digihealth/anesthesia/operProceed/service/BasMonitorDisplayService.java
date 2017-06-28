package com.digihealth.anesthesia.operProceed.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BasDeviceMonitorConfigFormBean;
import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SysCodeFormbean;
import com.digihealth.anesthesia.basedata.po.BasDeviceConfig;
import com.digihealth.anesthesia.basedata.po.BasDeviceMonitorConfig;
import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;
import com.digihealth.anesthesia.basedata.po.BasRegOpt;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.common.utils.JsonType;
import com.digihealth.anesthesia.common.utils.SysUtil;
import com.digihealth.anesthesia.doc.po.DocAnaesRecord;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;
import com.digihealth.anesthesia.evt.po.EvtCtlBreath;
import com.digihealth.anesthesia.evt.po.EvtRescueevent;
import com.digihealth.anesthesia.evt.service.EvtAnaesEventService;
import com.digihealth.anesthesia.operProceed.controller.MyObserveDataController;
import com.digihealth.anesthesia.operProceed.core.MyConstants;
import com.digihealth.anesthesia.operProceed.formbean.BasAnaesMonitorConfigFormBean;
import com.digihealth.anesthesia.operProceed.formbean.CtlBreathDateFormBean;
import com.digihealth.anesthesia.operProceed.formbean.DeviceConfigFormBean;
import com.digihealth.anesthesia.operProceed.formbean.EnterRoomFormBean;
import com.digihealth.anesthesia.operProceed.formbean.FirstSpotFormBean;
import com.digihealth.anesthesia.operProceed.formbean.IntervalDataFormBean;
import com.digihealth.anesthesia.operProceed.formbean.MonDataFormBean;
import com.digihealth.anesthesia.operProceed.formbean.MonitorData;
import com.digihealth.anesthesia.operProceed.formbean.MonitorDataFormBean;
import com.digihealth.anesthesia.operProceed.formbean.MonitorDataPage;
import com.digihealth.anesthesia.operProceed.formbean.MonitorDisplayChangeFormBean;
import com.digihealth.anesthesia.operProceed.formbean.RealTimeDataFormBean;
import com.digihealth.anesthesia.operProceed.formbean.RescueeventFormBean;
import com.digihealth.anesthesia.operProceed.formbean.SeriesData;
import com.digihealth.anesthesia.operProceed.formbean.SeriesDataObj;
import com.digihealth.anesthesia.operProceed.formbean.XAxisData1;
import com.digihealth.anesthesia.operProceed.formbean.XAxisDataBean;
import com.digihealth.anesthesia.operProceed.formbean.YAxisData;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfigDefault;
import com.digihealth.anesthesia.operProceed.po.BasMonitorDisplay;
import com.digihealth.anesthesia.operProceed.po.BasMonitorDisplayChangeHis;
import com.digihealth.anesthesia.operProceed.po.BasMonitorFreqChange;
import com.digihealth.anesthesia.operProceed.po.BasMonitorPupil;
import com.digihealth.anesthesia.operProceed.po.BasObserveData;
import com.digihealth.anesthesia.operProceed.po.Observe;
import com.digihealth.anesthesia.websocket.WebSocketHandler;

@Service
public class BasMonitorDisplayService extends BaseService{
	
	private static final int EN_ABLE = 1;
	private static final int TIMEOUT = 5;
	//private static final String[] obsLists = {"52001","52004","31006","31007"}; // 31006 NIBP_DIAS 31007 NIBP_SYS  52001 etCO2  52004 FiO2 
	
	private static Logger logger = Logger.getLogger(BasMonitorDisplayService.class);
	
	@Transactional
	public void addobsdat(BasMonitorDisplay monitorDisp) {
		String observeId = monitorDisp.getObserveId();
		Float value = monitorDisp.getValue();
		String regOptId = monitorDisp.getRegOptId();
		Date observeDate = monitorDisp.getTime();
		//String time = "";
		//if(null!=observeDate){
		//	time = SysUtil.getTimeFormat(observeDate);
		//}
		BasMonitorDisplay md = basMonitorDisplayDao.getUniqMonitorDisplay(regOptId, observeDate, observeId);
		if(null != md){ //修改b_monitor_display
			String id = md.getId();
			BaseInfoQuery baseQuery = new BaseInfoQuery();
			baseQuery.setRegOptId(regOptId);
			baseQuery.setEventId(observeId);
			baseQuery.setBeid(getBeid());
			
			//从数据库中查询最大最小值
			BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean = basAnaesMonitorConfigDao.getAnaesMonitorConfigEventId(baseQuery);
			if(null != anaesMonitorConfigFormBean){
				int state = -2;
				Float max = anaesMonitorConfigFormBean.getMax();
				Float min = anaesMonitorConfigFormBean.getMin();
				if(null != value){
					if(value.floatValue() > max.floatValue()){
						state = 1; 
					}else if(value.floatValue() < min.floatValue()){
						state = -1;
					}else{
						state = 0;
					}
					monitorDisp.setState(state);
				}
			}
			//插入修改历史表
			BasMonitorDisplayChangeHis observeHis = new BasMonitorDisplayChangeHis();
			observeHis.setObserveDataChange(md, value,"");
			observeHis.setId(GenerateSequenceUtil.generateSequenceNo());
			basMonitorDisplayChangeHisDao.insert(observeHis);
			
			BeanUtils.copyProperties(monitorDisp, md);
			md.setId(id);//防止页面传递了id
			md.setAmendFlag(3);
			basMonitorDisplayDao.updateByPrimaryKeySelective(md); //修改monitorDisplay数据
			
		}else{//新增b_monitor_display
			String newId = GenerateSequenceUtil.generateSequenceNo();
			monitorDisp.setId(newId);
			
			BaseInfoQuery baseQuery = new BaseInfoQuery();
			baseQuery.setRegOptId(regOptId);
			baseQuery.setEventId(observeId);
			baseQuery.setBeid(getBeid());
			
			BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean = basAnaesMonitorConfigDao.getAnaesMonitorConfigEventId(baseQuery);
			if(null != anaesMonitorConfigFormBean){
				int state = -2;
				Float max = anaesMonitorConfigFormBean.getMax();
				Float min = anaesMonitorConfigFormBean.getMin();
				if(null != value){
					if(value.floatValue() > max.floatValue()){
						state = 1; 
					}else if(value.floatValue() < min.floatValue()){
						state = -1;
					}else{
						state = 0;
					}
					monitorDisp.setState(state);
				}
				monitorDisp.setObserveName(anaesMonitorConfigFormBean.getEventName());
				monitorDisp.setIcon(anaesMonitorConfigFormBean.getIconId());
				monitorDisp.setColor(anaesMonitorConfigFormBean.getColor());
				monitorDisp.setPosition(anaesMonitorConfigFormBean.getPosition());
				monitorDisp.setAmendFlag(3); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
			}
			basMonitorDisplayDao.insert(monitorDisp);
		}
		
	}
	
	@Transactional
	public void changeMonitDisplay(MonitorDisplayChangeFormBean changeBean) {
		// 第一步先修改 monitorDisplay
		String id = changeBean.getId();
		//Date time = changeBean.getTime();
		String regOptId = changeBean.getDocId();
		String observeId = changeBean.getObserveId();
		Float value = changeBean.getValue();
		//String searchtime = "";
		//if (null != time) {
		//	searchtime = SysUtil.getTimeFormat(time);
		//}
		BasMonitorDisplay monitorDisplay = basMonitorDisplayDao.selectById(id);
		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(regOptId);
		baseQuery.setEventId(observeId);
		baseQuery.setBeid(getBeid());
		
		//从数据库中查询最大最小值
		BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean = basAnaesMonitorConfigDao.getAnaesMonitorConfigEventId(baseQuery);
		if(null != anaesMonitorConfigFormBean){
			int state = -2;
			Float max = anaesMonitorConfigFormBean.getMax();
			Float min = anaesMonitorConfigFormBean.getMin();
			if(null != value){
				if(value.floatValue() > max.floatValue()){
					state = 1; 
				}else if(value.floatValue() < min.floatValue()){
					state = -1;
				}else{
					state = 0;
				}
				changeBean.setState(state);
			}
		}
		if (null != monitorDisplay) {
		    //插入修改历史表
		    BasMonitorDisplayChangeHis observeHis = new BasMonitorDisplayChangeHis();
		    observeHis.setObserveDataChange(monitorDisplay, value,changeBean.getMemo());
		    observeHis.setId(GenerateSequenceUtil.generateSequenceNo());
		    basMonitorDisplayChangeHisDao.insert(observeHis);

		    BeanUtils.copyProperties(changeBean, monitorDisplay);
			monitorDisplay.setAmendFlag(2); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
			basMonitorDisplayDao.updateByPrimaryKeySelective(monitorDisplay); //修改monitorDisplay数据
			
		}

		// 第二步查看b_observe_data是否有值，如果有就修改
		/*ObserveData observeData = observeDataDao.getUniqObserveData(regOptId, searchtime, observeId);
		if (null != observeData) {
			observeData.setValue(value);
			if(null != changeBean.getState()){
				observeData.setState(changeBean.getState());
			}
			observeDataDao.updateValue(observeData);
		}*/

	}
	
	/**
	 * 查询术中实时监测项
	 */
	public List<RealTimeDataFormBean> searchObserveDataByPosition(BaseInfoQuery baseQuery) {
		// 从数据库查询最新的实时监测数据 （即position为-1的最新数据）
		List<RealTimeDataFormBean> observeList = basObserveDataDao.searchObserveDataByPosition(baseQuery);
		Date curTime = new Date();
		// 业务：如果超过5秒，则不传递给前端
		if (null != observeList && observeList.size() > 0) {
			for (RealTimeDataFormBean rtData : observeList) {
				Date time = rtData.getTime();
				long t = curTime.getTime()-time.getTime();
				if(t-TIMEOUT*1000>0){
					observeList = null;
					break;
				}
			}
		}
		return observeList;
	}
	
	/**
	 * 查询术中实时监测项 双阳改变
	 */
	public Map<String,RealTimeDataFormBean> searchObserveMapByPosition(BaseInfoQuery baseQuery) {
		// 从数据库查询最新的实时监测数据 （即position为-1的最新数据）
		List<RealTimeDataFormBean> observeList = basObserveDataDao.searchObserveDataByPosition(baseQuery);
		Map<String,RealTimeDataFormBean> resultMap = new HashMap<String,RealTimeDataFormBean>();
		Date curTime = new Date();
		// 业务：如果超过5秒，则不传递给前端
		if (null != observeList && observeList.size() > 0) {
			for (RealTimeDataFormBean rtData : observeList) {
				Date time = rtData.getTime();
				String obserName = rtData.getObserveName();
				resultMap.put(obserName, rtData);
				long t = curTime.getTime()-time.getTime();
				if(t-TIMEOUT*1000>0){
					//observeList = null;
					resultMap.clear();
					break;
				}
			}
		}
		return resultMap;
	}
	
	/**
	 * 查询手术需要打印数据
	 */
	public Map<String,Object> selectMonitorDisplayForPrint(String regOptId)
	{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		//通过regOptId查询这个患者所有的可视采集数据
		List<BasMonitorDisplay> monitorDisplayList = basMonitorDisplayDao.selectDisplayByRegOptId(regOptId);
		//通过regOptId查询这个患者所有的可视采集数据总条数
		int total = basMonitorDisplayDao.getDisplayTotalByRegOptId(regOptId);
		resultMap.put("list", monitorDisplayList);
		resultMap.put("total", total);
		return resultMap;
	}
	
	/**
	 * 查询手续持续时间点
	 */
	public List<Date> selectMonitorDisplayTime(String regOptId)
	{
		List<Date> dateList = new ArrayList<Date>();
		dateList = basMonitorDisplayDao.selectMonitorDisplayTime(regOptId);
		return dateList;
	}

	
	/**
	 * 获取最近的点的time
	 * @param regOptId
	 * @return
	 */
	public Date findLastestTime(String regOptId){
		return basMonitorDisplayDao.findLastestTime(regOptId);
	}
	
	/**
	 * 获取最近点的对象
	 * @param regOptId
	 * @return
	 */
	public BasMonitorDisplay findLastestMonitorDisplay(String regOptId){
		return basMonitorDisplayDao.findLastestMonitorDisplay(regOptId);
	}
	
	
	@Transactional
	public void batchInsertMonitorDisplays(List<BasMonitorDisplay> mds) {
		for (BasMonitorDisplay md : mds) {
			basMonitorDisplayDao.insertSelective(md);
		}
	}

	
	/**
	 * 查询moniterConfig对应的units
	 */
	public Map<String,String> selectMoniterUnits()
	{
		Map<String,String> unitsMap = new HashMap<String,String>();
		List<BasMonitorConfig> monitorList = basMonitorConfigDao.selectList(getBeid());
		if(null != monitorList && monitorList.size()>0)
		{
			for(BasMonitorConfig monitor : monitorList)
			{
				unitsMap.put(monitor.getEventId(), monitor.getUnits());
			}
		}
		return unitsMap;
	}
	
	public List<BasMonitorDisplay> findLastestedMonitors(String regOptId){
		return basMonitorDisplayDao.findLastestedMonitors(regOptId);
	}
	
	
	@Transactional
	public void batchUpdateMonitorDisplayIntervalTime(List<BasMonitorDisplay> mds) {
		for (BasMonitorDisplay md : mds) {
			basMonitorDisplayDao.updateIntevalTime(md);
		}
	}
	
	/**
	 * 获取分页的监测项数据
	 * @param bean
	 * @param observeIds
	 * @return
	 */
	public List<BasMonitorDisplay> getobsData(MonitorDataFormBean bean,List<String> observeIds){
		String regOptId = bean.getRegOptId();
		Integer no = bean.getNo();
		Integer size = bean.getSize();
		Date time = bean.getInTime();
		logger.info("getobsData---inTime-----------"+time);
		String inTime = SysUtil.getTimeFormat(time);
		Integer pageNo = 0;
		Integer pageSize = 31;
		if(null != size && 0 != size){
			pageSize = size;
		}
		Integer total = basMonitorDisplayDao.searchMonitorDisplayListTotal(regOptId, observeIds, inTime);
//		if(no != null){
//			if (0 == no) { //no为0时，指求最新页
//				if ((total % pageSize) == 0) {
//					pageNo = total / pageSize;
//				} else {
//					pageNo = total / pageSize + 1;
//				}
//				
//				if(0==pageNo){ //防止 total等于0时的情况
//					pageNo = 0;
//				}else{
//					pageNo = (pageNo - 1) * pageSize;
//				}
//			}else{
//				pageNo = (no - 1) * pageSize;
//			}
//		}
		pageNo = calcPageNo(total,no,pageSize);
		
		return basMonitorDisplayDao.searchMonitorDisplayList(regOptId, pageNo, pageSize, observeIds, inTime);
	}
	
	public int calcPageNo(int total,Integer no ,int pageSize){
		int pageNo = 0;
		if(no != null){
			if (0 == no) { //no为0时，指求最新页
				// 求页码
				if(total <= pageSize){
					pageNo = 1;
				}else{
					if (((total-pageSize) % (pageSize-1)) == 0) {
						pageNo = (total-pageSize) / (pageSize-1) + 1;
					} else {
						pageNo = ((total-pageSize) / (pageSize-1) + 1) + 1 ;
					}
				}
				
				// 求传递给sql语句的pageNo值
				if(1==pageNo){ //防止 total等于0时的情况
					pageNo = 0;
				}else{
					pageNo = (pageNo - 1) * (pageSize - 1)  ;
				}
			}else{
				if(1==no){
					pageNo = 0;
				}else{
					pageNo = (no - 1) * (pageSize - 1) ;
				}
				
			}
		}
		return pageNo;
	}
	
	/**
	 * 获取分页的监测项数据
	 * @param bean
	 * @param observeIds
	 * @return
	 */
	public List<BasMonitorDisplay> getobsDataNoPage(MonitorDataFormBean bean,List<String> observeIds){
		String regOptId = bean.getRegOptId();
		Date time = bean.getInTime();
		logger.info("inTime-----------"+time);
		String inTime = SysUtil.getTimeFormat(time);
		
		return basMonitorDisplayDao.searchMonitorDisplayList(regOptId,null,null,observeIds,inTime);
	}
	
	public Integer getobsDataTotal(MonitorDataFormBean bean,List<String> observeIds){
		String regOptId = bean.getRegOptId();
		Date time = bean.getInTime();
		String inTime = SysUtil.getTimeFormat(time);
		return basMonitorDisplayDao.searchMonitorDisplayListTotal(regOptId, observeIds, inTime);
	}

	public List<BasMonitorDisplay> getobsDatNew(MonitorDataFormBean formBean, List<String> observeIds) {
		Date inTime = formBean.getInTime();
		Date sDate = formBean.getStartTime();
		Date eDate = formBean.getEndTime();
		String regOptId = formBean.getRegOptId();
		//BaseInfo baseInfo = baseInfoDao.selectByPrimaryKey(patId);
		//Integer bedId = baseInfo.getBedId();
		logger.info("sDate: "+sDate+"---inTime: "+inTime+"---eDate: "+eDate);
		String startTime = SysUtil.getTimeFormat(sDate);
		String endTime = SysUtil.getTimeFormat(eDate);
		List<BasMonitorDisplay> list = basMonitorDisplayDao.getobsdatNew(regOptId, startTime, endTime,observeIds);
		return list;
	}
	
	/**
	 * 页面不传递结束时间，根据startTime来获取新点
	 * @param formBean
	 * @param observeIds
	 * @return
	 */
	public List<BasMonitorDisplay> getobsDataNew2(MonitorDataFormBean formBean,List<String> observeIds){
		Date inTime = formBean.getInTime();
		Date sDate = formBean.getStartTime();
		//Date eDate = formBean.getEndTime();
		String regOptId = formBean.getRegOptId();
		//BaseInfo baseInfo = baseInfoDao.selectByPrimaryKey(patId);
		//Integer bedId = baseInfo.getBedId();
		logger.info("sDate: "+sDate+"---inTime: "+inTime);
		String startTime = SysUtil.getTimeFormat(sDate);
		//String endTime = SysUtil.getTimeFormat(eDate);
		List<BasMonitorDisplay> list = basMonitorDisplayDao.getobsDataNew2(regOptId, startTime,observeIds);
		return list;
	}
	
	/**
	 * 插入新点，并传递给前端
	 * @param formBean
	 * @param observeIds
	 * @return
	 */
	@Transactional
	public List<BasMonitorDisplay> getobsDataNew3(MonitorDataFormBean formBean,List<String> observeIds){
		Date inTime = formBean.getInTime();
		Date sDate = formBean.getStartTime();
		String regOptId = formBean.getRegOptId();
		logger.info("sDate: "+sDate+"---inTime: "+inTime);
		String startTime = SysUtil.getTimeFormat(sDate);
		
		List<BasMonitorDisplay> newMds = null;
		List<BasMonitorDisplay> mds = null;
		BasMonitorDisplay md = null;
		// 取beid
		String beid = formBean.getBeid();
		if(StringUtils.isBlank(beid)){
		    formBean.setBeid(getBeid());
			beid = getBeid();
		}
		String operModel = MyConstants.OPERATION_MODEL_NORMAL;
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
    	String anaRecordId = "";
    	if(null!=anaesRecord){
    		anaRecordId = anaesRecord.getAnaRecordId();
        	SearchFormBean searchBean = new SearchFormBean();
        	searchBean.setDocId(anaRecordId);
        	searchBean.setCurrentState("1");
    		List<EvtRescueevent> list = evtRescueeventDao.searchRescueeventList(searchBean);
    		if(list.size()>0){
    			operModel = list.get(0).getModel();
    			logger.info("getCurrentModel---当前的手术模式==="+operModel);
    		}
    		logger.info("getCurrentModel--- 返回当前的手术模式operModel==="+operModel+",list的size==="+list.size());
    	}else{
    		logger.error("getCurrentModel-------根据regOptId返回的doc_id为空，请检查！");
    	}
    	
		int collTime = 0;
		if(operModel.equals(MyConstants.OPERATION_MODEL_NORMAL)){
			collTime = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_NORMAL, beid).getValue());
		}else if (MyConstants.OPERATION_MODEL_SAVE.equals(operModel)) {
			collTime = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_SAVE, beid).getValue());
		}
		
		List<BasObserveData> observeDatas = basObserveDataDao.findObserveDataListByTime(regOptId,startTime,null); //获取新点 把所有b_observe_data都拿到
		logger.info("getobsDataNew3----observeDatas=="+JsonType.jsonType(observeDatas));
		List<Observe> observes = basMonitorConfigDao.searchAllAnaesObserveList(beid);
		
		if(null != observeDatas && observeDatas.size()>0){
			mds = new ArrayList<BasMonitorDisplay>();
			newMds = new ArrayList<BasMonitorDisplay>();
			Timestamp tt = SysUtil.getTimestamp(startTime);
			for (BasObserveData observeData : observeDatas) {
				md = new BasMonitorDisplay();
				BeanUtils.copyProperties(observeData, md);
				md.setFreq(collTime); //修改为系统获取的freq值，而不是b_observe_data的freq
				md.setIntervalTime(collTime); //修改为系统获取的freq值，而不是b_observe_data的freq
				md.setAmendFlag(0); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
				String observeId = md.getObserveId();
				if(null != observeIds && observeIds.size()>0){
					for (String oIds : observeIds) {
						if(observeId.equals(oIds)){
							newMds.add(md);
							break;
						}
					}
				}
				mds.add(md);
			}
			if(null != observes && observes.size()>0){
				for (Observe observe : observes) {
					md = new BasMonitorDisplay();
					BeanUtils.copyProperties(observe, md);
					md.setFreq(collTime);
					md.setValue(null); // 设值为0.0f
					md.setId(GenerateSequenceUtil.generateSequenceNo());
					md.setObserveName(observe.getName());
					// 设置新增时间
					md.setTime(tt);
					md.setRegOptId(regOptId);// 设置regOptId
					md.setIntervalTime(collTime); // 设置间隔时间
					md.setAmendFlag(0); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
					String observeId = md.getObserveId();
					if(null != mds && mds.size()>0){
						int flag = 0;
						for (int i = 0; i < mds.size(); i++) {
							BasMonitorDisplay monitorDisplay = mds.get(i);
							if(observeId.equals(monitorDisplay.getObserveId())){
								flag = -1;
							}
						}
						if(flag == 0){
							mds.add(md);
						}
					}
					
					if(null != observeIds && observeIds.size()>0){
						for (String oIds : observeIds) {
							if(observeId.equals(oIds)){
								if(null != newMds && newMds.size()>0){
									int flag = 0;
									for (int i = 0; i < newMds.size(); i++) {
										BasMonitorDisplay monitorDisplay = newMds.get(i);
										if(observeId.equals(monitorDisplay.getObserveId())){
											flag = -1;
										}
									}
									if(flag == 0){
										newMds.add(md);
										break;
									}
								}
							}
						}
					}
				}
			}
		}else{//对应时间点查询不到数据，则存入null值到b_monitor_display表
			mds = new ArrayList<BasMonitorDisplay>();
			newMds = new ArrayList<BasMonitorDisplay>();
			//List<Observe> observes = observeDao.searchAnaesObserveList(null, regOptId);
			Timestamp tt = SysUtil.getTimestamp(startTime);
			if(null != observes && observes.size()>0){
				for (Observe observe : observes) {
					md = new BasMonitorDisplay();
					BeanUtils.copyProperties(observe, md);
					md.setFreq(collTime);
					md.setValue(null); // 设值为0.0f
					md.setId(GenerateSequenceUtil.generateSequenceNo());
					md.setObserveName(observe.getName());
					// 设置新增时间
					md.setTime(tt);
					md.setRegOptId(regOptId);// 设置regOptId
					md.setIntervalTime(collTime); // 设置间隔时间
					md.setAmendFlag(0); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
					mds.add(md);
					String observeId = md.getObserveId();
					if(null != observeIds && observeIds.size()>0){
						for (String oIds : observeIds) {
							if(observeId.equals(oIds)){
								newMds.add(md);
								break;
							}
						}
					}
				}
			}
		}
		if (null != mds && mds.size()>0) {
			logger.info("getobsDataNew3----mds="+JsonType.jsonType(mds));
			int count = basMonitorDisplayDao.searchMonitorDisplayByTime(regOptId,startTime);
			if(count==0){
				for (BasMonitorDisplay monitorDisplay : mds) {
					basMonitorDisplayDao.insertSelective(monitorDisplay);
				}
			}
		}
		return newMds;
	}
	
	/**
	 * 相比于getobsDataNew3，增加了obsLists数据项的特殊处理(去除obsLists的处理)
	 * obsLists的特殊处理原因是：血压、etCo2、fio2由于采集设备的原因，不能保证每秒都有数据，就有断点的情况，需要额外去最大时间的点，填充到数据库中，但需额外控制下，间隔时间超过20s，则直接存null值
	 * 目前的解决方案:根据传递的采集指标，如果该秒无记录，采集服务会自动补上记录，但value值为null 
	 * @param formBean
	 * @param observeIds
	 * @return
	 */
	@Transactional
	public List<BasMonitorDisplay> getobsDataNew4(MonitorDataFormBean formBean,List<String> observeIds){
		Date inTime = formBean.getInTime();
		Date sDate = formBean.getStartTime();
		String regOptId = formBean.getRegOptId();
		logger.info("sDate: "+sDate+"---inTime: "+inTime);
		String startTime = SysUtil.getTimeFormat(sDate);
		
		List<BasMonitorDisplay> newMds = null;
		List<BasMonitorDisplay> mds = null;
		BasMonitorDisplay md = null;
		
		// 取beid
		String beid = formBean.getBeid();
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
			formBean.setBeid(beid);
		}
		
		String operModel = MyConstants.OPERATION_MODEL_NORMAL;
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
    	String anaRecordId = "";
    	if(null!=anaesRecord){
    		anaRecordId = anaesRecord.getAnaRecordId();
        	SearchFormBean searchBean = new SearchFormBean();
        	searchBean.setDocId(anaRecordId);
        	searchBean.setCurrentState("1");
    		List<EvtRescueevent> list = evtRescueeventDao.searchRescueeventList(searchBean);
    		if(list.size()>0){
    			operModel = list.get(0).getModel();
    			logger.info("getCurrentModel---当前的手术模式==="+operModel);
    		}
    		logger.info("getCurrentModel--- 返回当前的手术模式operModel==="+operModel+",list的size==="+list.size());
    	}else{
    		logger.error("getCurrentModel-------根据regOptId返回的doc_id为空，请检查！");
    	}
    	
		int collTime = 0;
		if(operModel.equals(MyConstants.OPERATION_MODEL_NORMAL)){
			collTime = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_NORMAL, beid).getValue());
		}else if (MyConstants.OPERATION_MODEL_SAVE.equals(operModel)) {
			collTime = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_SAVE, beid).getValue());
		}
		
		List<BasObserveData> observeDatas = basObserveDataDao.findObserveDataListByTime(regOptId,startTime,null); //获取新点 把所有b_observe_data都拿到
		logger.info("getobsDataNew4----observeDatas=="+JsonType.jsonType(observeDatas));
		List<Observe> observes = basMonitorConfigDao.searchAllAnaesObserveList(beid);  //获取数据库配置监测项
		observes = removeSameObserve(observes);
		
		//List<String> observeLists = Arrays.asList(obsLists); //数组转换为ArrayList
		//List<String> eventLists = new ArrayList<String>();
		// 判断是否需要麻醉的两项  一般都会有监护仪，所以血压应该肯定是会有的 ，只需要判断麻醉机是否需要存52001 52004
		/*if(null != observes && observes.size()>0){
			for (int i = 0; i < observes.size(); i++) {
				Observe observe = observes.get(i);
				for (int j = 0; j < observeLists.size(); j++) {
					String observeId = observeLists.get(j);
					if(observe.getObserveId().equals(observeId)){
						eventLists.add(observeId); //添加到新的eventLists对象中
						break;
					}
				}
			}
		}*/
		
		
		if(null != observeDatas && observeDatas.size()>0){ //查询出来有数据
			mds = new ArrayList<BasMonitorDisplay>();
			newMds = new ArrayList<BasMonitorDisplay>();
			Timestamp tt = SysUtil.getTimestamp(startTime);
			for (BasObserveData observeData : observeDatas) {
				md = new BasMonitorDisplay();
				BeanUtils.copyProperties(observeData, md);
				
				//将重复监测项的eventId设置为统一的eventId
				BasMonitorConfigDefault mcd = basMonitorConfigDefaultDao.selectByEventName(md.getObserveName(), beid);
				if (null != mcd && 0 == md.getPosition())
				{
				    BaseInfoQuery baseQuery = new BaseInfoQuery();
				    baseQuery.setRegOptId(regOptId);
				    baseQuery.setEventId(mcd.getEventId());
				    baseQuery.setBeid(getBeid());
				    BasAnaesMonitorConfigFormBean amc = basAnaesMonitorConfigDao.getAnaesMonitorConfigByEventId(baseQuery);
				    if (null != amc && md.getObserveId().equals(amc.getRealEventId()))
				    {
				        md.setObserveId(mcd.getEventId());
				    }
				}
				
				md.setFreq(collTime); //修改为系统获取的freq值，而不是b_observe_data的freq
				md.setIntervalTime(collTime); //修改为系统获取的freq值，而不是b_observe_data的freq
				md.setAmendFlag(0); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
				String observeId = md.getObserveId();
				if(null != observeIds && observeIds.size()>0){
					for (String oIds : observeIds) {
						if(observeId.equals(oIds)){
							newMds.add(md);//只有属于页面需要的observeIds,才放入到list对象中
							break;
						}
					}
				}
				mds.add(md);//全部存入list中，并存入到数据库
			}
			if(null != observes && observes.size()>0){ //如果mds不全，则从数据库中获取监测项，并将对应需要补齐的，返回给前端
				for (Observe observe : observes) {
					md = new BasMonitorDisplay();
					BeanUtils.copyProperties(observe, md);
					md.setFreq(collTime);
					md.setValue(null); // 设值为0.0f
					md.setId(GenerateSequenceUtil.generateSequenceNo());
					md.setObserveName(observe.getName());
					// 设置新增时间
					md.setTime(tt);
					md.setRegOptId(regOptId);// 设置regOptId
					md.setIntervalTime(collTime); // 设置间隔时间
					md.setAmendFlag(0); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
					String observeId = md.getObserveId();
					if(null != mds && mds.size()>0){ 
						int flag = 0;
						for (int i = 0; i < mds.size(); i++) {
							BasMonitorDisplay monitorDisplay = mds.get(i);
							if(observeId.equals(monitorDisplay.getObserveId())){ //已经存在mds中，则不继续存入，将flag置为-1
								flag = -1;
								break; //有相同的，则直接break
							}
						}
						if(flag == 0){ //当flag为0，则说明mds中没有当前observeId的数据，则需要添加到mds中
							mds.add(md);
						}
					}
					
					if(null != observeIds && observeIds.size()>0){ // 页面需要observeIds,传递回去的也是observeIds对应的数据，不够的，则补齐到前端
						for (String oIds : observeIds) {
							if(observeId.equals(oIds)){ //是需要传递给前端的observeId 
								if(null != newMds && newMds.size()>0){ //size大于0，则需要比较 
									int flag = 0;
									for (int i = 0; i < newMds.size(); i++) {
										BasMonitorDisplay monitorDisplay = newMds.get(i);
										if(observeId.equals(monitorDisplay.getObserveId())){
											flag = -1;
											break;
										}
									}
									if(flag == 0){ // 说明newMds中没有当前observeId的数据，需要增加到newMds
										newMds.add(md);
										break; //添加一项后，break当前for
									}else{
										break;  //等于-1，则直接break当前for 
									}
								}else{ //size 为0，则需要添加，并发送给前端数据
									newMds.add(md);
									break;  //添加一项后，break当前for
								}
							}
						}
					}
				}
			}
			
			// 增加处理，如果eventLists中的observeId的数据value值为null的时候，需要再去数据库中查询最近的点的value值，并替换mds和newMds中的数据
			/*if(null != eventLists && eventLists.size()>0){ 
				for (int i = 0; i < eventLists.size(); i++) {
					
					String eventId = eventLists.get(i);
					
					if(null != mds && mds.size()>0){ //mds处理 
						for (int j = 0; j < mds.size(); j++) {
							MonitorDisplay mDisplay = mds.get(j);
							if(eventId.equals(mDisplay.getObserveId())){
								if(null == mDisplay.getValue()){ //如果value为null，则从数据库中查询最近点的value值
									MonitorDisplay m = monitorDisplayDao.findLastestedDataByObserveId(mDisplay.getDocId(),eventId);
									if(null != m){
										if(null != m.getValue()){
											mDisplay.setValue(m.getValue());
											if(null != m.getState()){
												mDisplay.setState(m.getState());
											}
											break;
										}
									}
								}
							}
						}
					}
					
					// newMds 处理，只有当newMds中的对应observeId的value值为null的时候，才去查询数据库中最近的点的value值，并替换
					if(null != newMds && newMds.size()>0){
						for (int j = 0; j < newMds.size(); j++) {
							MonitorDisplay mDisplay = newMds.get(j);
							if(eventId.equals(mDisplay.getObserveId())){ //从newMds中获取，不从数据库中获取
								if(null == mDisplay.getValue()){ //如果value为null，则从数据库中查询最近点的value值
									if(null != mds && mds.size()>0){
										for (int k = 0; k < mds.size(); k++) {
											MonitorDisplay m = mds.get(k);
											if(m.getObserveId().equals(mDisplay.getObserveId())){
												if(null != m.getValue()){
													mDisplay.setValue(m.getValue());
													if(null != m.getState()){
														mDisplay.setState(m.getState());
													}
													break; //当进入相等逻辑，处理完成即退出，跳出mds的循环
												}
											}
										}
									}
									break;//跳出newMds的循环，当进入相等逻辑，处理完成即退出
								}
							}
						}
					}
					
					
				}
			}*/
			
		}else{//对应时间点查询不到数据，则存入null值到b_monitor_display表，eventLists中的数据的value值也应该为null，不处理eventLists数据
			mds = new ArrayList<BasMonitorDisplay>();
			newMds = new ArrayList<BasMonitorDisplay>();
			Timestamp tt = SysUtil.getTimestamp(startTime);
			if(null != observes && observes.size()>0){
				for (Observe observe : observes) {
					md = new BasMonitorDisplay();
					BeanUtils.copyProperties(observe, md);
					md.setFreq(collTime);
					md.setValue(null); // 设值为0.0f
					md.setId(GenerateSequenceUtil.generateSequenceNo());
					md.setObserveName(observe.getName());
					// 设置新增时间
					md.setTime(tt);
					md.setRegOptId(regOptId);// 设置regOptId
					md.setIntervalTime(collTime); // 设置间隔时间
					md.setAmendFlag(0); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
					mds.add(md);
					String observeId = md.getObserveId();
					if(null != observeIds && observeIds.size()>0){
						for (String oIds : observeIds) {
							if(observeId.equals(oIds)){
								newMds.add(md);
								break;
							}
						}
					}
				}
			}
		}
		
		if (null != mds && mds.size()>0) { //存入数据库
			logger.info("getobsDataNew4----mds="+JsonType.jsonType(mds));
			int count = basMonitorDisplayDao.searchMonitorDisplayByTime(regOptId,startTime);
			if(count==0){
				for (BasMonitorDisplay monitorDisplay : mds) {
					basMonitorDisplayDao.insertSelective(monitorDisplay);
				}
			}
		}
		return newMds;
	}
	
	
	public List<BasMonitorDisplay> getMonDataNew(MonitorDataFormBean formBean ,List<String> observeIds){
		Date inTime = formBean.getInTime();
		Date sDate = formBean.getStartTime();
		//Date eDate = formBean.getEndTime();
		String regOptId = formBean.getRegOptId();
		//BaseInfo baseInfo = baseInfoDao.selectByPrimaryKey(patId);
		//Integer bedId = baseInfo.getBedId();
		logger.info("sDate: "+sDate+"---inTime: "+inTime);
		String startTime = SysUtil.getTimeFormat(sDate);
		//String endTime = SysUtil.getTimeFormat(eDate);
		List<BasMonitorDisplay> list = basMonitorDisplayDao.getMonDataNew(regOptId, startTime,observeIds);
		return list;
	}
	
	/**
	 * 术中修改设备配置
	 * @param deviceConfigFormBean
	 */
	@Transactional
	public void updDeviceConfig(DeviceConfigFormBean deviceConfigFormBean) {
		if(deviceConfigFormBean !=null){
			
			String roomId = Global.getConfig("roomId").toString();
			//只有当传入的deviceConfig及子集不为空才保存当下数据
			if(deviceConfigFormBean.getDeviceConfig()!=null && deviceConfigFormBean.getDeviceMonitorConfigList()!=null){
			
				BasDeviceConfig deviceConfig = deviceConfigFormBean.getDeviceConfig();
				//deviceConfig.setRoomId(roomId);
				deviceConfig.setRoomId(null);
				
				//先删除床旁设备配置表的数据，再做新增处理
				basDeviceConfigDao.delete(deviceConfig);
				if(null == deviceConfig.getEnable()){
					deviceConfig.setEnable(EN_ABLE);
				}
				basDeviceConfigDao.insert(deviceConfig);
				
				
				//获取之前设置的设备监测项勾选配置信息，设置监测项为空。注：必选项不做修改
				List<BasDeviceMonitorConfigFormBean> isChecklist = basDeviceMonitorConfigDao.getDeviceMonitorConfigList(getBeid(), deviceConfig.getDeviceId(), "O");
				for (BasDeviceMonitorConfigFormBean checkPo : isChecklist) {
					BasDeviceMonitorConfig deviceMonitorConfig = new BasDeviceMonitorConfig();
					deviceMonitorConfig.setOptional(null);
					deviceMonitorConfig.setRoomId(roomId);
					deviceMonitorConfig.setDeviceId(deviceConfig.getDeviceId());
					deviceMonitorConfig.setEventId(checkPo.getEventId());
					basDeviceMonitorConfigDao.update(deviceMonitorConfig);
				}
				//将页面传入的监测项设置为勾选
				List<BasDeviceMonitorConfig> list = deviceConfigFormBean.getDeviceMonitorConfigList();
				for (BasDeviceMonitorConfig deviceMonitorConfig : list) {
					deviceMonitorConfig.setRoomId(roomId);
					deviceMonitorConfig.setDeviceId(deviceConfig.getDeviceId());
					deviceMonitorConfig.setOptional("O");
					basDeviceMonitorConfigDao.update(deviceMonitorConfig);
				}
			}
			
		}
	}
	
	@Transactional
	public void updateEnterRoomTimegt(EnterRoomFormBean formBean,ResponseValue res) {
		//ResultObj result = new ResultObj();
		
		String docId = formBean.getDocId();
		String regOptId = formBean.getRegOptId();
		Date inTime = formBean.getInTime();
		Date operTime = formBean.getOperTime();
		String time = SysUtil.getTimeFormat(operTime);
		String in_time = SysUtil.getTimeFormat(inTime);
		Integer code = formBean.getCode();
		String anaEventId = formBean.getAnaEventId();
		
		// 1、删除原有无用数据
		basMonitorDisplayDao.deleteByOperTime(time,regOptId);
		// 2、记录事件，并修改入室时间
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(docId);
		
		EvtAnaesEvent anaesevent = new EvtAnaesEvent();
		
		//anaesevent.setState(anaesRecord.getState());
		anaesevent.setDocId(docId);
		anaesevent.setCode(code);
		anaesevent.setOccurTime(inTime);
		
		List<EvtAnaesEvent> anaeseventList =  evtAnaesEventDao.selectByCodeAndDocId(anaesevent.getDocId(), anaesevent.getCode());
		
		if(StringUtils.isEmpty(anaEventId)){
			if(anaeseventList!=null && anaeseventList.size()>0){
				res.setResultCode("-1");
				res.setResultMessage("入室事件已存在，不能重复添加！");
				//res.setMsg("该事件已存在，不能重复添加！anaEventId="+anaEventId);
				throw new RuntimeException();
			}else{
				List<EvtAnaesEvent> sAnaesEventList = evtAnaesEventDao.selectCodeByDESC(anaesevent.getDocId(), anaesevent.getCode());
				if(sAnaesEventList!=null&&sAnaesEventList.size()>0){
					//Date d = DateUtils.getParseTime(sAnaesEventList.get(0).getOccurtime());
					if((sAnaesEventList.get(0).getOccurTime().getTime())>(anaesevent.getOccurTime().getTime())){
						List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", anaesevent.getCode()+"", getBeid());
						List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList.get(0).getCode()+"", getBeid());
						//return s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间";
						//result.setResult(-2);
						//result.setMsg(s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间");
						res.setResultCode("-2");
						res.setResultMessage(s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间");
						throw new RuntimeException();
						//return result;
					}
				}
				List<EvtAnaesEvent> sAnaesEventList1 = evtAnaesEventDao.selectCodeByASC(anaesevent.getDocId(), anaesevent.getCode());
				if(sAnaesEventList1!=null&&sAnaesEventList1.size()>0){
					
					if((sAnaesEventList1.get(0).getOccurTime().getTime())<(anaesevent.getOccurTime()).getTime()){
						List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", anaesevent.getCode()+"", getBeid());
						List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList1.get(0).getCode()+"", getBeid());
						//return s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间";
						//result.setResult(-3);
						//result.setMsg(s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间");
						//return result;
						res.setResultCode("-3");
						res.setResultMessage(s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间");
						throw new RuntimeException();
					}
				}
				anaesevent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				anaesevent.setOccurTime(inTime);
				evtAnaesEventDao.insert(anaesevent);
			}
		}else{
			
			List<EvtAnaesEvent> sAnaesEventList = evtAnaesEventDao.selectCodeByDESC(anaesevent.getDocId(), anaesevent.getCode());
			if(sAnaesEventList!=null&&sAnaesEventList.size()>0){
				
				if((sAnaesEventList.get(0).getOccurTime().getTime())>(anaesevent.getOccurTime()).getTime()){
					List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", anaesevent.getCode()+"", getBeid());
					List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList.get(0).getCode()+"", getBeid());
					//return s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间";
					//result.setResult(-2);
					//result.setMsg(s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间");
					//return result;
					res.setResultCode("-2");
					res.setResultMessage(s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间");
					throw new RuntimeException();
					
				}
			}
			List<EvtAnaesEvent> sAnaesEventList1 = evtAnaesEventDao.selectCodeByASC(anaesevent.getDocId(), anaesevent.getCode());
			if(sAnaesEventList1!=null&&sAnaesEventList1.size()>0){
				
				
				if((sAnaesEventList1.get(0).getOccurTime().getTime())<(anaesevent.getOccurTime()).getTime()){
					List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", anaesevent.getCode()+"", getBeid());
					List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList1.get(0).getCode()+"", getBeid());
					//return s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间";
					//result.setResult(-3);
					//result.setMsg(s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间");
					//return result;
					res.setResultCode("-3");
					res.setResultMessage(s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间");
					throw new RuntimeException();
				}
			}
			anaesevent.setAnaEventId(anaEventId);
			anaesevent.setOccurTime(inTime);
			evtAnaesEventDao.updateByPrimaryKeySelective(anaesevent);
		}
		
		anaesRecord.setInOperRoomTime(in_time);
		docAnaesRecordDao.updateByPrimaryKey(anaesRecord);
		//result.setResult(0);
		//result.setMsg("修改入室时间成功！");
		res.setResultCode("1");
		res.setResultMessage("修改入室时间成功！");
		//return result;
	}
	
	public BasMonitorDisplay findMonitorDisplayByInTimeLimit1(String regOptId,Date time){
		return basMonitorDisplayDao.findMonitorDisplayByInTimeLimit1(regOptId, time);
	}
	
	public BasMonitorDisplay findMonitorDisplaybyTime(String regOptId, String time){
		return basMonitorDisplayDao.findMonitorDisplaybyTime(regOptId, time);
	}
	
	@Transactional
	public void updEnterRoomTimelt(EnterRoomFormBean formBean,ResponseValue res) {
		//ResultObj result = new ResultObj();
		String docId = formBean.getDocId();
		String regOptId = formBean.getRegOptId();
		Date inTime = formBean.getInTime();
		Date operTime = formBean.getOperTime();
		String time = SysUtil.getTimeFormat(operTime);
		String in_time = SysUtil.getTimeFormat(inTime);
		Integer code = formBean.getCode();
		String anaEventId = formBean.getAnaEventId();
		
		// 取beid
		String beid = formBean.getBeid();
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
			formBean.setBeid(beid);
		}
		// 1、删除原有无用数据
		basMonitorDisplayDao.deleteByOperTime(time,regOptId);
		
		//2、根据当前手术时间往前推freq的值，存入b_monitor_display表中
		long inTimeLong = inTime.getTime();
		long operTimeLong = operTime.getTime();
		BasMonitorDisplay mDisplay = basMonitorDisplayDao.findMonitorDisplaybyTime(regOptId, time);
		
		if(null != mDisplay){
			Integer freq = mDisplay.getFreq();
			logger.info("inTimeLong=="+inTimeLong+",operTimeLong=="+operTimeLong+",freq=="+freq);
			operTimeLong -= freq*1000; //防止operTime的数据再次插入
			List<BasMonitorDisplay> mds = null;
			BasMonitorDisplay md = null;
			List<Observe> observes = basMonitorConfigDao.searchAllAnaesObserveList(beid);
			observes = removeSameObserve(observes);
			for(;operTimeLong>=inTimeLong;){
				
				mds = new ArrayList<BasMonitorDisplay>();
				Timestamp tt = SysUtil.getCurrentTimeStamp(new Date(operTimeLong));
				for (Observe observe : observes) {
					md = new BasMonitorDisplay();
					BeanUtils.copyProperties(observe, md);
					md.setFreq(freq);
					md.setValue(null); // 设值为0.0f
					md.setId(GenerateSequenceUtil.generateSequenceNo());
					md.setObserveName(observe.getName());
					// 设置新增时间
					md.setTime(tt);
					md.setRegOptId(regOptId);// 设置regOptId
					md.setIntervalTime(freq); //设置间隔时间
					mds.add(md);
				}
				
				if (null != mds && mds.size() > 0) {
					for (BasMonitorDisplay monitorDisplay : mds) {
						basMonitorDisplayDao.insertSelective(monitorDisplay);
					}
				}
				
				operTimeLong -= freq*1000;
			}
		}
		
		//3、记录事件，并修改入室时间
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(docId);
		
		EvtAnaesEvent anaesevent = new EvtAnaesEvent();
		
		//anaesevent.setState(anaesRecord.getState());
		anaesevent.setDocId(docId);
		anaesevent.setCode(code);
		anaesevent.setOccurTime(inTime);
		
		List<EvtAnaesEvent> anaeseventList =  evtAnaesEventDao.selectByCodeAndDocId(anaesevent.getDocId(), anaesevent.getCode());
		
		if(StringUtils.isEmpty(anaEventId)){
			if(anaeseventList!=null && anaeseventList.size()>0){
				//result.setResult(-1);
				//result.setMsg("该事件已存在，不能重复添加！anaEventId="+anaEventId);
				//return "该事件已存在，不能重复添加！anaEventId="+anaEventId;
				//return result;
				res.setResultCode("-1");
				res.setResultMessage("入室事件已存在，不能重复添加！");
				return;
			}else{
				List<EvtAnaesEvent> sAnaesEventList = evtAnaesEventDao.selectCodeByDESC(anaesevent.getDocId(), anaesevent.getCode());
				if(sAnaesEventList!=null&&sAnaesEventList.size()>0){
					//Date d = DateUtils.getParseTime(sAnaesEventList.get(0).getOccurtime());
					if((sAnaesEventList.get(0).getOccurTime().getTime())>(anaesevent.getOccurTime().getTime())){
						List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", anaesevent.getCode()+"", getBeid());
						List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList.get(0).getCode()+"", getBeid());
						//return s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间";
						//result.setResult(-2);
						//result.setMsg(s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间");
						//return result;
						res.setResultCode("-2");
						res.setResultMessage(s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间");
						return;
					}
				}
				List<EvtAnaesEvent> sAnaesEventList1 = evtAnaesEventDao.selectCodeByASC(anaesevent.getDocId(), anaesevent.getCode());
				if(sAnaesEventList1!=null&&sAnaesEventList1.size()>0){
					
					if((sAnaesEventList1.get(0).getOccurTime().getTime())<(anaesevent.getOccurTime()).getTime()){
						List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", anaesevent.getCode()+"", getBeid());
						List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList1.get(0).getCode()+"", getBeid());
						//return s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间";
						//result.setResult(-3);
						//result.setMsg(s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间");
						//return result;
						res.setResultCode("-3");
						res.setResultMessage(s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间");
						return ;
					}
				}
				anaesevent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
				anaesevent.setOccurTime(inTime);
				evtAnaesEventDao.insert(anaesevent);
			}
		}else{
			
			List<EvtAnaesEvent> sAnaesEventList = evtAnaesEventDao.selectCodeByDESC(anaesevent.getDocId(), anaesevent.getCode());
			if(sAnaesEventList!=null&&sAnaesEventList.size()>0){
				
				if((sAnaesEventList.get(0).getOccurTime().getTime())>(anaesevent.getOccurTime()).getTime()){
					List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", anaesevent.getCode()+"", getBeid());
					List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList.get(0).getCode()+"", getBeid());
					//return s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间";
					//result.setResult(-2);
					//result.setMsg(s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间");
					//return result;
					res.setResultCode("-2");
					res.setResultMessage(s1.get(0).getCodeName()+"时间不能小于"+s2.get(0).getCodeName()+"时间");
					return ;
				}
			}
			List<EvtAnaesEvent> sAnaesEventList1 = evtAnaesEventDao.selectCodeByASC(anaesevent.getDocId(), anaesevent.getCode());
			if(sAnaesEventList1!=null&&sAnaesEventList1.size()>0){
				
				
				if((sAnaesEventList1.get(0).getOccurTime().getTime())<(anaesevent.getOccurTime()).getTime()){
					List<SysCodeFormbean> s1 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", anaesevent.getCode()+"", getBeid());
					List<SysCodeFormbean> s2 = basSysCodeDao.searchSysCodeByGroupIdAndCodeValue("anaes_event_type", sAnaesEventList1.get(0).getCode()+"", getBeid());
					//return s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间";
					//result.setResult(-3);
					//result.setMsg(s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间");
					//return result;
					res.setResultCode("-3");
					res.setResultMessage(s1.get(0).getCodeName()+"时间不能大于"+s2.get(0).getCodeName()+"时间");
					return;
				}
			}
			anaesevent.setAnaEventId(anaEventId);
			anaesevent.setOccurTime(inTime);
			evtAnaesEventDao.updateByPrimaryKeySelective(anaesevent);
		}
		
		anaesRecord.setInOperRoomTime(in_time);
		docAnaesRecordDao.updateByPrimaryKey(anaesRecord);
		//result.setResult(0);
		//result.setMsg("修改入室时间成功！");
		//return result;
		res.setResultCode("1");
		res.setResultMessage("修改入室时间成功！");
	}
	
	@Transactional
	public void batchHandleObsDat(List<MonitorDisplayChangeFormBean> monitors) {
		if(null != monitors && monitors.size()>0){
			for (MonitorDisplayChangeFormBean changeBean : monitors) {
				String id = changeBean.getId();
				Date time = changeBean.getTime();
				String regOptId = changeBean.getDocId();
				String observeId = changeBean.getObserveId();
				Float value = changeBean.getValue();
				//String searchtime = "";
				//if (null != time) {
				//	searchtime = SysUtil.getTimeFormat(time);
				//}
				//判断id是否有值
				if(StringUtils.isNotBlank(id)){//不是null,或者不是空字符串，则为修改
					BasMonitorDisplay monitorDisplay = basMonitorDisplayDao.selectById(id);
					BaseInfoQuery baseQuery = new BaseInfoQuery();
					baseQuery.setRegOptId(regOptId);
					baseQuery.setEventId(observeId);
					baseQuery.setBeid(getBeid());
					
					//从数据库中查询最大最小值
					BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean = basAnaesMonitorConfigDao.getAnaesMonitorConfigEventId(baseQuery);
					if(null != anaesMonitorConfigFormBean){
						int state = -2;
						Float max = anaesMonitorConfigFormBean.getMax();
						Float min = anaesMonitorConfigFormBean.getMin();
						if(null != value){
							if(value.floatValue() > max.floatValue()){
								state = 1; 
							}else if(value.floatValue() < min.floatValue()){
								state = -1;
							}else{
								state = 0;
							}
							changeBean.setState(state);
						}
					}
					if (null != monitorDisplay) {
					    //插入修改历史表
					    BasMonitorDisplayChangeHis observeHis = new BasMonitorDisplayChangeHis();
					    observeHis.setObserveDataChange(monitorDisplay, value,changeBean.getMemo());
					    observeHis.setId(GenerateSequenceUtil.generateSequenceNo());
					    basMonitorDisplayChangeHisDao.insert(observeHis);
					    
						BeanUtils.copyProperties(changeBean, monitorDisplay);
						monitorDisplay.setAmendFlag(2); //数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
						basMonitorDisplayDao.updateByPrimaryKeySelective(monitorDisplay); //修改monitorDisplay数据
					}

					// 第二步查看b_observe_data是否有值，如果有就修改
					/*ObserveData observeData = observeDataDao.getUniqObserveData(regOptId, searchtime, observeId);
					if (null != observeData) {
						observeData.setValue(value);
						if(null != changeBean.getState()){
							observeData.setState(changeBean.getState());
						}
						observeDataDao.updateValue(observeData);
					}*/
					
				}else{//可能为新增，也可能为修改，查询b_monitor_display是否有对应记录，如果有，则修改，如果无，则修改；
					BasMonitorDisplay md = basMonitorDisplayDao.getUniqMonitorDisplay(regOptId, time, observeId);
					if(null != md){ //修改b_monitor_display
						
						BaseInfoQuery baseQuery = new BaseInfoQuery();
						baseQuery.setRegOptId(regOptId);
						baseQuery.setEventId(observeId);
						baseQuery.setBeid(getBeid());
						
						//从数据库中查询最大最小值
						BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean = basAnaesMonitorConfigDao.getAnaesMonitorConfigEventId(baseQuery);
						if(null != anaesMonitorConfigFormBean){
							int state = -2;
							Float max = anaesMonitorConfigFormBean.getMax();
							Float min = anaesMonitorConfigFormBean.getMin();
							if(null != value){
								if(value.floatValue() > max.floatValue()){
									state = 1; 
								}else if(value.floatValue() < min.floatValue()){
									state = -1;
								}else{
									state = 0;
								}
								changeBean.setState(state);
							}
						}
						//插入修改历史表
						BasMonitorDisplayChangeHis observeHis = new BasMonitorDisplayChangeHis();
						observeHis.setObserveDataChange(md, value,changeBean.getMemo());
						observeHis.setId(GenerateSequenceUtil.generateSequenceNo());
						basMonitorDisplayChangeHisDao.insert(observeHis);
						
						BeanUtils.copyProperties(changeBean, md);
						md.setAmendFlag(2); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
						basMonitorDisplayDao.updateByPrimaryKeySelective(md); //修改monitorDisplay数据
						
						
						/*ObserveData observeData = observeDataDao.getUniqObserveData(regOptId, searchtime, observeId);
						if (null != observeData) {
							observeData.setValue(value);
							if(null != changeBean.getState()){
								observeData.setState(changeBean.getState());
							}
							observeDataDao.updateValue(observeData);
						}*/
					}else{//新增b_monitor_display
						String newId = GenerateSequenceUtil.generateSequenceNo();
						changeBean.setId(newId);
						
						BaseInfoQuery baseQuery = new BaseInfoQuery();
						baseQuery.setRegOptId(regOptId);
						baseQuery.setEventId(observeId);
						baseQuery.setBeid(getBeid());
						
						BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean = basAnaesMonitorConfigDao.getAnaesMonitorConfigEventId(baseQuery);
						if(null != anaesMonitorConfigFormBean){
							int state = -2;
							Float max = anaesMonitorConfigFormBean.getMax();
							Float min = anaesMonitorConfigFormBean.getMin();
							if(null != value){
								if(value.floatValue() > max.floatValue()){
									state = 1; 
								}else if(value.floatValue() < min.floatValue()){
									state = -1;
								}else{
									state = 0;
								}
								changeBean.setState(state);
							}
							changeBean.setObserveName(anaesMonitorConfigFormBean.getEventName());
							changeBean.setIcon(anaesMonitorConfigFormBean.getIconId());
							changeBean.setColor(anaesMonitorConfigFormBean.getColor());
							changeBean.setPosition(anaesMonitorConfigFormBean.getPosition());
						}
						
						//根据observeId+docId+time来查询b_observe_data表中是否有记录
						/*ObserveData observeData = observeDataDao.getUniqObserveData(regOptId,searchtime,observeId);
						if(null != observeData){ // 修改
							observeData.setValue(changeBean.getValue());
							observeData.setState(changeBean.getState());
							observeDataDao.updateValue(observeData);
						}else{//新增
							observeData = new ObserveData();
							BeanUtils.copyProperties(changeBean, observeData);
							observeData.setTime(new Timestamp(time.getTime()));//设置时间
							observeDataDao.insert(observeData);
						}*/
						BasMonitorDisplay monitorDisplay = new BasMonitorDisplay();
						BeanUtils.copyProperties(changeBean, monitorDisplay);
						monitorDisplay.setAmendFlag(3); // 数据状态，0：正常；1：程序修正；2：人为修正；3：人为添加
						basMonitorDisplayDao.insert(monitorDisplay);
					}
				}
			}
		}
	}
	
	@Transactional
	public void getIntervalObsData(IntervalDataFormBean bean) {
		List<Date> times = bean.getTimes();
		String regOptId = bean.getRegOptId();
		Integer freq = bean.getFreq();
		// 取beid
		String beid = bean.getBeid();
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
			bean.setBeid(beid);
		}
		logger.info("------getIntervalObsData-------regOptId="+regOptId+",freq="+freq);
		if(null != times && times.size()>0){
			List<Observe> observes = basMonitorConfigDao.searchAllAnaesObserveList(beid);
			observes = removeSameObserve(observes);
			List<BasMonitorDisplay> mds = null;
			BasMonitorDisplay md = null;
			for (int i = 0; i < times.size(); i++) {
				//Timestamp tt = SysUtil.getTimestamp(times.get(i));
				Date t = times.get(i);
				String timeFormat = SysUtil.getTimeFormat(t);
				Date tt = SysUtil.getDate(timeFormat);
				mds = new ArrayList<BasMonitorDisplay>();
				for (Observe observe : observes) {
					md = new BasMonitorDisplay();
					BeanUtils.copyProperties(observe, md);
					md.setFreq(freq);
					md.setValue(null); // 设值为0.0f
					md.setId(GenerateSequenceUtil.generateSequenceNo());
					md.setObserveName(observe.getName());
					// 设置新增时间
					md.setTime(tt);
					md.setRegOptId(regOptId);// 设置regOptId
					md.setIntervalTime(freq); // 设置间隔时间
					md.setAmendFlag(1); //程序修正 
					mds.add(md);
				}

				if (null != mds && mds.size() > 0) {
					int count = basMonitorDisplayDao.searchMonitorDisplayByTime(regOptId, timeFormat);
					logger.info("getIntervalObsData-----count=="+count+",timeFormat="+timeFormat);
					if(count==0){
						for (BasMonitorDisplay mDisplay : mds) {
							basMonitorDisplayDao.insertSelective(mDisplay);
						}
					}
				}
			}
		}
		
	}
	
	@Transactional
	public void firstSpot(FirstSpotFormBean formBean) {
		Date inTime = formBean.getInTime();
		String operTime = SysUtil.getTimeFormat(inTime);
		String regOptId = formBean.getRegOptId();
		basRegOptDao.updateOperTime(operTime,regOptId);
		docAnaesRecordDao.updateAnaesInRoomTime(operTime, regOptId);
		// 取beid
		String beid = formBean.getBeid();
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
			formBean.setBeid(beid);
		}
		//将消息推送到手术室大屏
		BasRegOpt regOpt = basRegOptDao.searchRegOptById(regOptId);
		String bedStr = StringUtils.isNotBlank(regOpt.getBed())==true?regOpt.getBed()+"床的":"";
		WebSocketHandler.sentMessageToAllUser(regOpt.getDeptName()+regOpt.getRegionName()+bedStr+regOpt.getName()+"开始手术");
		
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
		EvtAnaesEvent anaesevent = new EvtAnaesEvent();
		anaesevent.setCode(EvtAnaesEventService.IN_ROOM);
		Date date = SysUtil.getDate(operTime);
		anaesevent.setOccurTime(date);
		//anaesevent.setState("04");//必须是术中
		if(null != anaesRecord){
			anaesevent.setDocId(anaesRecord.getAnaRecordId());
		}
		anaesevent.setAnaEventId(GenerateSequenceUtil.generateSequenceNo());
		evtAnaesEventDao.insertSelective(anaesevent);
		
		//存入新点
		List<BasMonitorDisplay> mds = new ArrayList<BasMonitorDisplay>();
		logger.error("----firstSpot---inTime="+inTime+",regOptId="+regOptId);
		// 直接存入b_monitor_display中
		List<Observe> observes = basMonitorConfigDao.searchAllAnaesObserveList(beid);
		observes = removeSameObserve(observes);
		
		Timestamp tt = SysUtil.getTimestamp(operTime);
		String operModel = MyConstants.OPERATION_MODEL_NORMAL;
    	String anaRecordId = "";
    	if(null!=anaesRecord){
    		anaRecordId = anaesRecord.getAnaRecordId();
        	SearchFormBean searchBean = new SearchFormBean();
        	searchBean.setDocId(anaRecordId);
        	searchBean.setCurrentState("1");
    		List<EvtRescueevent> list = evtRescueeventDao.searchRescueeventList(searchBean);
    		if(list.size()>0){
    			operModel = list.get(0).getModel();
    			logger.info("firstSpot---getCurrentModel---当前的手术模式==="+operModel);
    		}
    		logger.info("firstSpot---getCurrentModel--返回当前的手术模式operModel==="+operModel+",list的size==="+list.size());
    	}else{
    		logger.error("firstSpot---getCurrentModel----根据regOptId返回的doc_id为空，请检查！");
    	}
    	
    	int collTime = 0;
		if(operModel.equals(MyConstants.OPERATION_MODEL_NORMAL)){
			collTime = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_NORMAL, beid).getValue());
		}else if (MyConstants.OPERATION_MODEL_SAVE.equals(operModel)) {
			collTime = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_SAVE, beid).getValue());
		}
		
		for (Observe observe : observes) {
			BasMonitorDisplay md = new BasMonitorDisplay();
			BeanUtils.copyProperties(observe, md);
			md.setFreq(collTime);
			md.setValue(null); // 设值为0.0f
			// md.setValue(0.0f);
			md.setId(GenerateSequenceUtil.generateSequenceNo());
			md.setObserveName(observe.getName());
			// 设置新增时间
			md.setTime(tt);
			md.setRegOptId(regOptId);// 设置regOptId
			md.setIntervalTime(collTime); // 设置间隔时间
			md.setAmendFlag(1); // 程序修正 
			mds.add(md);
		}

		if (null != mds && mds.size() > 0) {
			for (BasMonitorDisplay md : mds) {
				basMonitorDisplayDao.insertSelective(md);
			}
		}
	}

    private List<Observe> removeSameObserve(List<Observe> observes)
    {
        List<Observe> observeList = new ArrayList<Observe>();
        String eventStr = "";
        for (Observe observe : observes)
        {
            BasMonitorConfigDefault monitorConfigDefault = basMonitorConfigDefaultDao.selectByEventName(observe.getName(), getBeid());
            if (null == monitorConfigDefault)
            {
                observeList.add(observe);
            }
            else if (!eventStr.contains(observe.getName()))
            {
                // 如果监测项有重复，则将监测项的id设置为统一的eventid，并且将其他重复的observe移除
                observe.setObserveId(monitorConfigDefault.getEventId());
                eventStr += observe.getName();
                observeList.add(observe);
            }
        }
        return observeList;
    }
	
	@Transactional
	public void changeModel(RescueeventFormBean rescueeventFormBean) {
		//1、修改间隔时间
		EvtRescueevent rescueevent = rescueeventFormBean.getRescueevent();
		
		Date time = rescueeventFormBean.getTime();
		//String timeFormat = SysUtil.getTimeFormat(time);
		String regOptId = rescueeventFormBean.getRegOptId();
		String beid = rescueeventFormBean.getBeid();
		if (StringUtils.isBlank(beid))
		{
		    beid = getBeid();
		    rescueeventFormBean.setBeid(beid);
		}
		
		String model = rescueevent.getModel();
		int curFreq = 0;
		int freq = 0;
		if(model.equals(MyConstants.OPERATION_MODEL_NORMAL)){
			curFreq = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_NORMAL, beid).getValue());
			freq = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_SAVE, beid).getValue());
		}else if (MyConstants.OPERATION_MODEL_SAVE.equals(model)) {
			curFreq = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_SAVE, beid).getValue());
			freq = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_NORMAL, beid).getValue());
		}
		List<BasMonitorDisplay> mds = basMonitorDisplayDao.findLastestedMonitors(regOptId);
		if(null != mds && mds.size()>0){
			BasMonitorDisplay monitorDisplay = mds.get(0);
			Date d = monitorDisplay.getTime();
			long t1 = time.getTime();
			long t2 = d.getTime();
			int t =  (int)(t1 - t2)/1000;
			logger.info("time="+time+",d="+d+",t1="+t1+",t2="+t2+",t="+t+",curFreq="+curFreq);
			int interval_time = curFreq + t ;
			for (BasMonitorDisplay md : mds) {
				md.setIntervalTime(interval_time);
				basMonitorDisplayDao.updateIntevalTime(md);
			}
		}
		
		BasMonitorFreqChange entity = new BasMonitorFreqChange();
        entity.setId(GenerateSequenceUtil.generateSequenceNo());
        entity.setRegOptId(regOptId);
        entity.setFreq(curFreq);
        entity.setOldFreq(freq);
        entity.setTime(time);
        basMonitorFreqChangeDao.insert(entity);
		
		//2、存入抢救事件
        //DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordById(rescueevent.getDocId());
//		rescueevent.setState(anaesRecord.getState());
		evtRescueeventDao.updateCurrentState(rescueevent.getDocId(), "0");
		rescueevent.setCurrentState(1);
		rescueevent.setRescueEventId(GenerateSequenceUtil.generateSequenceNo());
		rescueevent.setStartTime(time);
		evtRescueeventDao.insert(rescueevent);
	}
	
	@Transactional
	public void updateFreq(List<BasMonitorConfigFreq> freqList, String model,Date time,String regOptId) {
		String curBeid = getBeid();
		if(null != freqList && freqList.size()>0){
			//logger.info("-----------updateFreq-------model="+model+",time="+time+",regOptId="+regOptId+",size="+freqList.size());
			for (BasMonitorConfigFreq monitorConfigFreq : freqList) {
				String type = monitorConfigFreq.getType();
				String beid = monitorConfigFreq.getBeid();
				if(StringUtils.isBlank(beid)){
					beid = curBeid;
				}
				logger.info("-----------updateFreq-------model="+model+",time="+time+",regOptId="+regOptId+",size="+freqList.size()+",type="+type);
				if(type.equals(model)){//传递过来的数据有当前模式下的频率
					String value = monitorConfigFreq.getValue();
					Integer curFreq = Integer.valueOf(value); //页面传过来的freq
					
					int freq = 0;
					if(model.equals(MyConstants.OPERATION_MODEL_NORMAL)){
						freq = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_NORMAL, beid).getValue());
					}else if (MyConstants.OPERATION_MODEL_SAVE.equals(model)) {
						freq = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_SAVE, beid).getValue());
					}
					if(curFreq != freq){ //频率不相等，则发送修改频率的命令到数据处理模块
						logger.info("updateFreq-----curFreq="+curFreq+",数据库freq="+freq);
						
						BasMonitorFreqChange entity = new BasMonitorFreqChange();
                        entity.setId(GenerateSequenceUtil.generateSequenceNo());
                        entity.setRegOptId(regOptId);
                        entity.setFreq(curFreq);
                        entity.setOldFreq(freq);
                        entity.setTime(time);
                        basMonitorFreqChangeDao.insert(entity);
						
						List<BasMonitorDisplay> mds = basMonitorDisplayDao.findLastestedMonitors(regOptId);
						if(null != mds && mds.size()>0){
							BasMonitorDisplay monitorDisplay = mds.get(0);
							Date d = monitorDisplay.getTime();
							long t1 = time.getTime();
							long t2 = d.getTime();
							int t =  (int)(t1 - t2)/1000;
							int interval_time = curFreq + t ;
							logger.info("updateFreq-----time="+time+",d="+d+",t1="+t1+",t2="+t2+",t="+t+",interval_time="+interval_time+",freq="+freq);
							for (BasMonitorDisplay md : mds) {
								md.setIntervalTime(interval_time);
								basMonitorDisplayDao.updateIntevalTime(md);
							}
							basMonitorConfigFreqDao.update(monitorConfigFreq); //只有是普通模式的时候，频率值变化了，才会去修改对应freq
							break;
						}
					}
				}else if(model.equals(MyConstants.OPERATION_MODEL_SAVE)&& !type.equals(model)){  //传递过来的模式与当前模式不相等    场景：在抢救模式，修改普通模式的频率值
					logger.info("updateFreq-----type="+type+",当前模式model="+model);
					String value = monitorConfigFreq.getValue();
					Integer curFreq = Integer.valueOf(value); //页面传过来的freq
					
					int freq = SysUtil.strParseToInt(basMonitorConfigFreqDao.searchMonitorFreqByType(MyConstants.OPERATION_MODEL_NORMAL, beid).getValue());//取普通模式的freq
					logger.info("updateFreq-----curFreq="+curFreq+",数据库freq="+freq);
					
					if(curFreq != freq){ //频率不相等，则发送修改频率的命令到数据处理模块  ，即页面传递过来的freq值 != 普通模式现有的freq值
						logger.info("updateFreq-----curFreq="+curFreq+",数据库freq="+freq+",updateFreq值");
						basMonitorConfigFreqDao.update(monitorConfigFreq);
						break;
					}
				}
			}
		}
	}
	
	public int searchMonitorDisplayByTime(String regOptId,String time){
		return basMonitorDisplayDao.searchMonitorDisplayByTime(regOptId, time);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void printObserveData(MonitorDataFormBean formBean, Map map) {
		logger.info("----------------start printObserveData------------------------");
		List<MonitorDataPage> mdPageList = new ArrayList<MonitorDataPage>();
		// 获取需要显示的数据
		String regOptId = formBean.getRegOptId();
		if(StringUtils.isBlank(regOptId)){
			map.put("resultCode", "70000000");
			map.put("resultMessage", Global.getRetMsg(map.get("resultCode").toString()));
			logger.info("----------------end printObserveData------------------------");
		}
		
		int size = 31;
		int pageSize = formBean.getSize();
		if(pageSize == 0){
			pageSize = size;
		}
		
		//查询入室时间
		DocAnaesRecord anaesRecord = docAnaesRecordDao.searchAnaesRecordByRegOptId(regOptId);
		if(null != anaesRecord){
			String inTime = anaesRecord.getInOperRoomTime();
			Date inTimeDate = null;
			if(StringUtils.isNotBlank(inTime)){
				inTimeDate = SysUtil.getDate(inTime);
				formBean.setInTime(inTimeDate);
			}else{
				map.put("resultCode", "70000000");
				map.put("resultMessage", "入室时间不能为空！");
				logger.info("----------------end printObserveData------------------------");
			}
			
		}else{
			map.put("resultCode", "70000000");
			map.put("resultMessage", "麻醉记录单没有查询到记录！");
			logger.info("----------------end printObserveData------------------------");
		}
		
		Integer position = 0;
		
		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setRegOptId(regOptId);
		baseQuery.setPosition(position+"");
		baseQuery.setEnable("1");
		baseQuery.setBeid(getBeid());
		List<BasAnaesMonitorConfigFormBean> anaesLists = basAnaesMonitorConfigDao.findAnaesMonitorRecordListByRegOptId(baseQuery);
		List<String> observeIds = new ArrayList<String>();
		
		if (null != anaesLists && anaesLists.size() > 0) {
			for (BasAnaesMonitorConfigFormBean bean : anaesLists) {
				String observeId = bean.getEventId();
				// 获取显示项需要的observeIds
				observeIds.add(observeId);
			}
		}
		
		//数字部分的obsIds
		List<BasMonitorConfig> monitorConfigList = basMonitorConfigDao.selectMustShowList(baseQuery.getBeid());
		
		// 获取当前频率
		//String currentModel = regOptService.getCurrentModel(formBean.getRegOptId());
		/*String currentModel = MyConstants.OPERATION_MODEL_NORMAL;
    	String anaRecordId = "";
    	if(null!=anaesRecord){
    		anaRecordId = anaesRecord.getAnaRecordId();
        	SearchFormBean searchBean = new SearchFormBean();
        	searchBean.setDocId(anaRecordId);
        	searchBean.setCurrentState("1");
    		List<Rescueevent> list = rescueeventDao.searchRescueeventList(searchBean);
    		if(list.size()>0){
    			currentModel = list.get(0).getModel();
    			logger.info("printObserveData---getCurrentModel---当前的手术模式==="+currentModel);
    		}
    		logger.info("printObserveData---getCurrentModel--- 返回当前的手术模式operModel==="+currentModel+",list的size==="+list.size());
    	}else{
    		logger.error("printObserveData---getCurrentModel-------根据regOptId返回的doc_id为空，请检查！");
    	}
		MonitorFreq monitorFreq = basMonitorConfigFreqDao.searchMonitorFreqByType(currentModel);
		String f = "";
		Integer curfreq = 0;
		if (monitorFreq != null) {
			f = monitorFreq.getValue();
			curfreq = Integer.valueOf(f);
		}*/
		
		//获取呼吸事件列表
		List<EvtCtlBreath> ctlBreathList = evtCtlBreathDao.searchBreathListOrder(regOptId);
		CtlBreathDateFormBean cbFormBean = null;
		List<CtlBreathDateFormBean> cbList = new ArrayList<CtlBreathDateFormBean>();
		
		if(null != ctlBreathList && ctlBreathList.size()>0){
			for (int i = 0; i < ctlBreathList.size(); i++) {
				EvtCtlBreath ctlBreath = ctlBreathList.get(i);
				int curState = ctlBreath.getCurrentState();
				int type = ctlBreath.getType();
				if(1 == curState){
					cbFormBean = new CtlBreathDateFormBean();
					cbFormBean.setStartTime(ctlBreath.getStartTime());
					cbFormBean.setType(type);
					List<SysCodeFormbean> scList = basSysCodeDao.searchSysCodeByGroupIdAndCodeName("breath_event", type+"", getBeid());
					if(null != scList && scList.size()>0){
						String codeValue = scList.get(0).getCodeValue();
						cbFormBean.setCodeValue(codeValue);
					}
					cbList.add(cbFormBean);
				}else{
					cbFormBean = new CtlBreathDateFormBean();
					cbFormBean.setStartTime(ctlBreath.getStartTime());
					cbFormBean.setEndTime(cbList.get(cbList.size()-1).getStartTime());
					cbFormBean.setType(type);
					List<SysCodeFormbean> scList = basSysCodeDao.searchSysCodeByGroupIdAndCodeName("breath_event", type+"", getBeid());
					if(null != scList && scList.size()>0){
						String codeValue = scList.get(0).getCodeValue();
						cbFormBean.setCodeValue(codeValue);
					}
					cbList.add(cbFormBean);
				}
			}
		}
		
		// 获取总数
		int total = this.getobsDataTotal(formBean, observeIds);
		
		if(total==0){
			map.put("resultCode", "1");
			map.put("resultMessage", "当前患者采集点数据暂无！");
			map.put("mdPageList", mdPageList);
		}else{
			int no = total/pageSize; //页码
			int mod = total % pageSize ;
			if(no==0){
				if(0!=mod){
					no = no + 1 ;
				}
				// 只有1页的数据
				formBean.setNo(no);
				formBean.setSize(pageSize);
				

				List<XAxisData1> xAxis = new ArrayList<XAxisData1>();
				XAxisData1 xaisData = null;
				List<XAxisDataBean> data = new ArrayList<XAxisDataBean>();

				// 建造yAxis数据
				List<YAxisData> yAxis = new ArrayList<YAxisData>();
				YAxisData yd = null;
				yd = new YAxisData();
				yd.setType("value");
				yd.setMax(180);
				yd.setMin(0);
				yd.setOrder(1);
				yAxis.add(yd);
				yd = new YAxisData();
				yd.setType("value");
				yd.setMax(60);
				yd.setMin(30);
				yd.setOrder(2);
				yAxis.add(yd);
				Collections.sort(yAxis);

				List<SeriesData> series = new ArrayList<SeriesData>();
				SeriesData seriesdata = null;
				List<SeriesDataObj> da = null;
				SeriesDataObj obj = null;
				Map<String, SeriesData> seriesMap = new HashMap<String, SeriesData>();
				
				if (null != anaesLists && anaesLists.size() > 0) {
					for (BasAnaesMonitorConfigFormBean bean : anaesLists) {
						String observeId = bean.getEventId();
						// 获取显示项需要的observeIds
						observeIds.add(observeId);
						String observeName = bean.getEventName();
						String color = bean.getColor();// 对应图标
						String icon = bean.getIconId();// 对应颜色
						String units = bean.getUnits(); // 默认单位
						if (observeId.equals("30008") || observeId.equals("30010") || observeId.equals("31008") || observeId.equals("31010")) { // 如果是温度，则y轴为1
							seriesMap.put(observeId, new SeriesData(observeName, "line", new ArrayList<SeriesDataObj>(), icon, 1, 
									MyObserveDataController.SYMBOL_PRINTDATA, color, units));
						} else {
							seriesMap.put(observeId, new SeriesData(observeName, "line", new ArrayList<SeriesDataObj>(), icon, 0, 
									MyObserveDataController.SYMBOL_PRINTDATA, color, units));
						}
					}
				}
				
				//数字部分的obsIds
				List<String> obsIds = new ArrayList<String>();
				if(null != monitorConfigList && monitorConfigList.size()>0){
					for (BasMonitorConfig mc : monitorConfigList) {
						if(!obsIds.contains(mc.getEventId()+"")){
							obsIds.add(mc.getEventId()+"");
						}
					}
				}
				
				List<BasMonitorDisplay> monitorList = this.getobsData(formBean, observeIds);
				
				Date t = new Date(1L);
				if (null != monitorList && monitorList.size() > 0) {
					for (int i = 0; i < monitorList.size(); i++) {
						BasMonitorDisplay md = monitorList.get(i);
						String key = md.getObserveId();
						Date time = md.getTime();
						
						if (t.getTime() != time.getTime()) {
							t = time;
							XAxisDataBean bean = new XAxisDataBean();
							bean.setValue(t);
							Integer freq = md.getIntervalTime();
							bean.setFreq(freq);
							data.add(bean);
						}

						// series
						if (!seriesMap.containsKey(key)) {
							logger.info("------------------没有当前key" + key + "------------------------");
						} else {
							seriesdata = seriesMap.get(key);
							da = seriesdata.getData();
							seriesdata.setType("line");
							seriesdata.setName(md.getObserveName());
							// 设置指定对应的y轴
							if ("31008".equals(md.getObserveId())) {
								seriesdata.setyAxisIndex(1);
							} else if ("31010".equals(md.getObserveId())) {
								seriesdata.setyAxisIndex(1);
							}else if("30008".equals(md.getObserveId())){
								seriesdata.setyAxisIndex(1);
							}else if("30010".equals(md.getObserveId())){
								seriesdata.setyAxisIndex(1);
							} else {
								seriesdata.setyAxisIndex(0);
							}
							//seriesdata.setSymbolSize(8);
							//增加呼吸事件图标的判断
							if("31009".equals(md.getObserveId())){
								if(null != cbList && cbList.size()>0){
									int flag = -1;
									for (CtlBreathDateFormBean cb : cbList) {
										Date st = cb.getStartTime();
										Date et = cb.getEndTime();
										//logger.info("getobsData----st="+st+",et="+et+",time="+time);
										if(null != et){
											if(time.getTime()>=st.getTime() && time.getTime()<et.getTime()){
												obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(),cb.getCodeValue());
												flag = 0;
												break;
											}
										}else{
											if(time.getTime()>=st.getTime()){
												obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(),cb.getCodeValue());
												flag = 0 ;
												break;
											}
										}
									}
									if(flag == -1){
										obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
									}
								}else{
									obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
								}
							}else{
								obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
							}
							
							da.add(obj);
							seriesdata.setData(da);
							seriesMap.put(key, seriesdata);
						}

					}

				} else {
					// 无采集数据
					logger.info("----------无采集数据----------------");
				}

				// 循环seriesMap中的数据
				for (String key : seriesMap.keySet()) {
					SeriesData sd = seriesMap.get(key);
					series.add(sd);
				}

				// 添加times到x轴
				xaisData = new XAxisData1();
				xaisData.setData(data);
				xAxis.add(xaisData);

				//获取数字部分
				List<BasMonitorDisplay> monitorDisplayList = this.getobsData(formBean, obsIds);
				Map<Date,List<BasMonitorDisplay>> tableMap = new TreeMap<Date, List<BasMonitorDisplay>>();
				List<BasMonitorDisplay> mds = null;
				if(null != monitorDisplayList && monitorDisplayList.size()>0){
					for (BasMonitorDisplay md : monitorDisplayList) {
						Date time = md.getTime();
						if(!tableMap.containsKey(time)){
							mds = new ArrayList<BasMonitorDisplay>();
							mds.add(md);
							tableMap.put(time, mds);
						}else{
							mds = tableMap.get(time);
							mds.add(md);
							tableMap.put(time, mds);
						}
					}
				}else {
					// 无采集数据
					logger.info("----------无采集数据----------------");
				}
				
				List<MonDataFormBean> monDataList = new ArrayList<MonDataFormBean>();
				MonDataFormBean monData = null ;
				MonitorData monitorData = null ;
				
				if(!tableMap.isEmpty() && tableMap.size()>0){
					//int i = 0;
					int index = 0;
					// 循环seriesMap中的数据
					for (Date key : tableMap.keySet()) {
						//if(i%3==0){
							monData = new MonDataFormBean();
							List<MonitorData> monitorDataList = new ArrayList<MonitorData>();
							List<BasMonitorDisplay> list = tableMap.get(key);
							monData.setTime(key);
							monData.setIndex(index++);
							if(null != list && list.size()>0){
								for (BasMonitorDisplay md : list) {
									Integer fre = md.getFreq();
									if(null != fre){
										monData.setFreq(fre);
									}
									monitorData = new MonitorData();
									BeanUtils.copyProperties(md, monitorData);
									monitorDataList.add(monitorData);
								}
							}
							monData.setMonitorDataList(monitorDataList);
							monDataList.add(monData);
						//}
						//i++;
					}
				}
				
				MonitorDataPage page = new MonitorDataPage();
				page.setxAxis(xAxis);
				page.setyAxis(yAxis);
				page.setSeries(series);
				page.setMonDataList(monDataList);
				//page.setFreq(curfreq); //发送当前频率
				mdPageList.add(page);
				map.put("resultCode", "1");
				map.put("resultMessage", "操作成功！");
				map.put("mdPageList", mdPageList);
				logger.info("------------------end printObserveData------------------------");
				
			}else if (no>0){ //多页分组 
				if(0!=mod){
					no = no+1;
				}
				for(int j=0;j<no;j++){
					int pageNo = j+1;
					formBean.setNo(pageNo);
					formBean.setSize(pageSize);
					
					List<XAxisData1> xAxis = new ArrayList<XAxisData1>();
					XAxisData1 xaisData = null;
					List<XAxisDataBean> data = new ArrayList<XAxisDataBean>();

					// 建造yAxis数据
					List<YAxisData> yAxis = new ArrayList<YAxisData>();
					YAxisData yd = null;
					yd = new YAxisData();
					yd.setType("value");
					yd.setMax(180);
					yd.setMin(0);
					yd.setOrder(1);
					yAxis.add(yd);
					yd = new YAxisData();
					yd.setType("value");
					yd.setMax(60);
					yd.setMin(30);
					yd.setOrder(2);
					yAxis.add(yd);
					Collections.sort(yAxis);

					List<SeriesData> series = new ArrayList<SeriesData>();
					SeriesData seriesdata = null;
					List<SeriesDataObj> da = null;
					SeriesDataObj obj = null;
					Map<String, SeriesData> seriesMap = new HashMap<String, SeriesData>();
					
					if (null != anaesLists && anaesLists.size() > 0) {
						for (BasAnaesMonitorConfigFormBean bean : anaesLists) {
							String observeId = bean.getEventId();
							// 获取显示项需要的observeIds
							observeIds.add(observeId);
							String observeName = bean.getEventName();
							String color = bean.getColor();// 对应图标
							String icon = bean.getIconId();// 对应颜色
							String units = bean.getUnits(); // 默认单位
							if (observeId.equals("30008") || observeId.equals("30010") || observeId.equals("31008") || observeId.equals("31010")) { // 如果是温度，则y轴为1
								seriesMap.put(observeId, new SeriesData(observeName, "line", new ArrayList<SeriesDataObj>(), icon, 1,
										MyObserveDataController.SYMBOL_PRINTDATA, color, units));
							} else {
								seriesMap.put(observeId, new SeriesData(observeName, "line", new ArrayList<SeriesDataObj>(), icon, 0, 
										MyObserveDataController.SYMBOL_PRINTDATA, color, units));
							}
						}
					}
					
					//数字部分的obsIds
					List<String> obsIds = new ArrayList<String>();
					if(null != monitorConfigList && monitorConfigList.size()>0){
						for (BasMonitorConfig mc : monitorConfigList) {
							if(!obsIds.contains(mc.getEventId()+"")){
								obsIds.add(mc.getEventId()+"");
							}
						}
					}
					
					//获取当页的数据集合
					List<BasMonitorDisplay> monitorList = this.getobsData(formBean, observeIds);
					
					Date t = new Date(1L);
					if (null != monitorList && monitorList.size() > 0) {
						for (int i = 0; i < monitorList.size(); i++) {
							BasMonitorDisplay md = monitorList.get(i);
							String key = md.getObserveId();
							Date time = md.getTime();
							
							if (t.getTime() != time.getTime()) {
								t = time;
								XAxisDataBean bean = new XAxisDataBean();
								bean.setValue(t);
								Integer freq = md.getIntervalTime();
								bean.setFreq(freq);
								data.add(bean);
							}
							
							// series
							if (!seriesMap.containsKey(key)) {
								logger.info("------------------没有当前key" + key + "------------------------");
							} else {
								seriesdata = seriesMap.get(key);
								da = seriesdata.getData();
								seriesdata.setType("line");
								seriesdata.setName(md.getObserveName());
								// 设置指定对应的y轴
								if ("31008".equals(md.getObserveId())) {
									seriesdata.setyAxisIndex(1);
								} else if ("31010".equals(md.getObserveId())) {
									seriesdata.setyAxisIndex(1);
								}else if("30008".equals(md.getObserveId())){
									seriesdata.setyAxisIndex(1);
								}else if("30010".equals(md.getObserveId())){
									seriesdata.setyAxisIndex(1);
								} else {
									seriesdata.setyAxisIndex(0);
								}
								
								//增加呼吸事件图标的判断
								if("31009".equals(md.getObserveId())){
									if(null != cbList && cbList.size()>0){
										int flag = -1;
										for (CtlBreathDateFormBean cb : cbList) {
											Date st = cb.getStartTime();
											Date et = cb.getEndTime();
											//logger.info("getobsData----st="+st+",et="+et+",time="+time);
											if(null != et){
												if(time.getTime()>=st.getTime() && time.getTime()<et.getTime()){
													obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(),cb.getCodeValue());
													flag = 0;
													break;
												}
											}else{
												if(time.getTime()>=st.getTime()){
													obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId(),cb.getCodeValue());
													flag = 0 ;
													break;
												}
											}
										}
										if(flag == -1){
											obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
										}
									}else{
										obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
									}
								}else{
									obj = new SeriesDataObj(md.getId(), md.getValue(), md.getTime(), md.getObserveId());
								}

								da.add(obj);
								seriesdata.setData(da);
								seriesMap.put(key, seriesdata);
							}

						}

					} else {
						// 无采集数据
						logger.info("----------无采集数据----------------");
					}

					// 循环seriesMap中的数据
					for (String key : seriesMap.keySet()) {
						SeriesData sd = seriesMap.get(key);
						series.add(sd);
					}

					// 添加times到x轴
					xaisData = new XAxisData1();
					xaisData.setData(data);
					xAxis.add(xaisData);

					//获取数字部分
					List<BasMonitorDisplay> monitorDisplayList = this.getobsData(formBean, obsIds);
					Map<Date,List<BasMonitorDisplay>> tableMap = new TreeMap<Date, List<BasMonitorDisplay>>();
					List<BasMonitorDisplay> mds = null;
					if(null != monitorDisplayList && monitorDisplayList.size()>0){
						for (BasMonitorDisplay md : monitorDisplayList) {
							Date time = md.getTime();
							if(!tableMap.containsKey(time)){
								mds = new ArrayList<BasMonitorDisplay>();
								mds.add(md);
								tableMap.put(time, mds);
							}else{
								mds = tableMap.get(time);
								mds.add(md);
								tableMap.put(time, mds);
							}
						}
					}else {
						// 无采集数据
						logger.info("----------无采集数据----------------");
					}
					
					List<MonDataFormBean> monDataList = new ArrayList<MonDataFormBean>();
					MonDataFormBean monData = null ;
					MonitorData monitorData = null ;
					
					if(!tableMap.isEmpty() && tableMap.size()>0){
						//int i = 0;
						int index = 0;
						// 循环seriesMap中的数据
						for (Date key : tableMap.keySet()) {
							//if(i%3==0){
								monData = new MonDataFormBean();
								List<MonitorData> monitorDataList = new ArrayList<MonitorData>();
								List<BasMonitorDisplay> list = tableMap.get(key);
								monData.setTime(key);
								monData.setIndex(index++);
								if(null != list && list.size()>0){
									for (BasMonitorDisplay md : list) {
										Integer fre = md.getFreq();
										if(null != fre){
											monData.setFreq(fre);
										}
										monitorData = new MonitorData();
										BeanUtils.copyProperties(md, monitorData);
										monitorDataList.add(monitorData);
									}
								}
								monData.setMonitorDataList(monitorDataList);
								monDataList.add(monData);
							//}
							//i++;
						}
					}
					
					MonitorDataPage page = new MonitorDataPage();
					page.setxAxis(xAxis);
					page.setyAxis(yAxis);
					page.setSeries(series);
					page.setMonDataList(monDataList);
					//page.setFreq(curfreq);
					mdPageList.add(page);
					
				}
				map.put("resultCode", "1");
				map.put("resultMessage", "操作成功！");
				map.put("mdPageList", mdPageList);
				logger.info("------------------end printObserveData------------------------");
			}
		}
	}
	
	@Transactional
    public String saveMonitorPupil(BasMonitorPupil mp) {
        if(null != mp.getId() && StringUtils.isNotBlank(mp.getId())){
            mp.setAmendFlag(2); //人为修正
            basMonitorPupilDao.updateByPrimaryKeySelective(mp);
            return mp.getId();
        }else{
            String id = GenerateSequenceUtil.generateSequenceNo();
            mp.setId(id);
            mp.setAmendFlag(3);//人为添加
            mp.setBeid(getBeid());
            basMonitorPupilDao.insertSelective(mp);
            return id;
        }
    }
}
