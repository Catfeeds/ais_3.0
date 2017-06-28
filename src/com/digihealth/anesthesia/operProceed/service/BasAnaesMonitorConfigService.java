package com.digihealth.anesthesia.operProceed.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
import com.digihealth.anesthesia.operProceed.formbean.BasAnaesMonitorConfigFormBean;
import com.digihealth.anesthesia.operProceed.po.BasAnaesMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfigDefault;

/**
 * 
 * Title: AnaesMonitorService.java Description: 监测点设置Service
 * 
 * @author liukui
 * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasAnaesMonitorConfigService extends BaseService {

	/**
	 * 进入术中麻醉记录单显示项数据的展示
	 * 
	 * @param baseQuery
	 * @return
	 */
	public List<BasAnaesMonitorConfigFormBean> getAnaesRecordShowListByRegOptId(BaseInfoQuery baseQuery) {
		baseQuery.setOperRoomId(Global.getConfig("roomId").toString());

		if (StringUtils.isBlank(baseQuery.getBeid()))
        {
		    baseQuery.setBeid(getBeid());
        }
		
		List<BasAnaesMonitorConfigFormBean> anaesMonitorList = basAnaesMonitorConfigDao.getAnaesRecordShowListByRegOptId(baseQuery);

		return anaesMonitorList;

	}

	public List<BasAnaesMonitorConfigFormBean> getAnaesMonitorRecordShowListByRegOptId(BaseInfoQuery baseQuery) {
		baseQuery.setOperRoomId(Global.getConfig("roomId").toString());

		if (null != baseQuery && StringUtils.isBlank(baseQuery.getBeid()))
        {
            baseQuery.setBeid(getBeid());
        }
		
		// 如果是查询已选展示项，直接返回b_anaes_monitor_config中数据即可
		if (null != baseQuery && "1".equals(baseQuery.getEnable())) {
			return basAnaesMonitorConfigDao.getAnaesMonitorConfigListByRegOptId(baseQuery);
		}
		// 所有的采集指标
		List<BasAnaesMonitorConfigFormBean> anaesMonitorList = basAnaesMonitorConfigDao.findAnaesMonitorRecordListByRegOptId(baseQuery);

		// 重复的采集项
		List<BasAnaesMonitorConfigFormBean> monitorList = basAnaesMonitorConfigDao.getEventNameGroupByRegOptId(baseQuery);
		// 返回的结果集
		List<BasAnaesMonitorConfigFormBean> retList = new ArrayList<BasAnaesMonitorConfigFormBean>();
		String eventStr = "";
		// 先将不重复的采集指标保存至retList
		for (BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean : anaesMonitorList) {
			Boolean flag = true;
			for (BasAnaesMonitorConfigFormBean monitorConfig : monitorList) {
				if (monitorConfig.getEventName().equals(anaesMonitorConfigFormBean.getEventName())) {
					// 这里需要判断是否在术中的时候对重复的采集指标标示为显示
					// if(!monitorConfig.getChecked().equals("1")){
					if (!eventStr.contains(anaesMonitorConfigFormBean.getEventName())) {
						eventStr += anaesMonitorConfigFormBean.getEventName() + ",";
						baseQuery.setName(anaesMonitorConfigFormBean.getEventName());
						BasAnaesMonitorConfigFormBean amcf = basAnaesMonitorConfigDao.getDefaultEventId(baseQuery);
						anaesMonitorConfigFormBean.setEventId("");
						//采集项选中时，在b_anaes_monitor_config表中存在记录，取表中配置的realEventId
						if (null != amcf) {
							anaesMonitorConfigFormBean.setEventId(amcf.getRealEventId());
							anaesMonitorConfigFormBean.setChecked("1");
						}
						//采集项未选中时，在b_anaes_monitor_config表中不存在记录，取默认配置表中的默认eventId
                        else
                        {
                            BasMonitorConfigDefault monitorConfigDefault = basMonitorConfigDefaultDao.selectByEventName(anaesMonitorConfigFormBean.getEventName(), getBeid());
                            anaesMonitorConfigFormBean.setEventId(monitorConfigDefault.getDefaultEventId());
                            //anaesMonitorConfigFormBean.setChecked("1");
                        }
						
						anaesMonitorConfigFormBean.setDeviceId("");
						retList.add(anaesMonitorConfigFormBean);
					}
					// }

					flag = false;
				}
			}
			if (flag == false && !eventStr.contains(anaesMonitorConfigFormBean.getEventName()) && "1".equals(anaesMonitorConfigFormBean.getChecked())) {
				retList.add(anaesMonitorConfigFormBean);
				eventStr += anaesMonitorConfigFormBean.getEventName() + ",";
			}

			if (flag) {
				retList.add(anaesMonitorConfigFormBean);
			}
		}

		for (BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean : retList) {
			baseQuery.setName(anaesMonitorConfigFormBean.getEventName());
			anaesMonitorConfigFormBean.setDevEventIdList(basAnaesMonitorConfigDao.getDeviceMonitorListByEventName(baseQuery));
		}

		return retList;
	}

	/**
	 * 保存麻醉记录单配置监测显示项
	 * 
	 * @param anaesMonitorConfigList
	 * @throws Exception
	 */
	@Transactional
	public void saveAnaesMonitorConfig(List<BasAnaesMonitorConfig> anaesMonitorConfigList) {

		if (anaesMonitorConfigList.size() > 0) {
			BasAnaesMonitorConfig queryObj = anaesMonitorConfigList.get(0);
			basAnaesMonitorConfigDao.delete(queryObj);

			for (BasAnaesMonitorConfig anaesMonitorConfig : anaesMonitorConfigList) { 
				// if(logger.isDebugEnabled()){
				logger.debug("url:saveAnaesMonitorConfig data:" + anaesMonitorConfig.toString());
				// }
				String beid = anaesMonitorConfig.getBeid();
				if(StringUtils.isBlank(beid)){//beid判空
					anaesMonitorConfig.setBeid(getBeid());
					beid = getBeid();
				}
				anaesMonitorConfig.setRealEventId(anaesMonitorConfig.getEventId());
				BasMonitorConfigDefault monitorConfigDefault = basMonitorConfigDefaultDao.selectByEventName(anaesMonitorConfig.getEventName(),beid);
				if (null != monitorConfigDefault) {
					// 重复监测项都设置为统一的eventId
					anaesMonitorConfig.setEventId(monitorConfigDefault.getEventId());
					// 如果监测项没有对应的eventId则将默认eventId设置为realEventId
					if (null == anaesMonitorConfig.getRealEventId() || "".equals(anaesMonitorConfig.getRealEventId())) {
						anaesMonitorConfig.setRealEventId(monitorConfigDefault.getDefaultEventId());
					}
				}

				if (StringUtils.isEmpty(anaesMonitorConfig.getId()))
				{
				    anaesMonitorConfig.setId(GenerateSequenceUtil.generateSequenceNo()); 
				}
				basAnaesMonitorConfigDao.insert(anaesMonitorConfig);

			}
		}
	}

	/**
	 * 修改麻醉记录单配置监测显示项
	 * 
	 * @param anaesMonitorConfigList
	 */
	@Transactional
	public void updateAnaesMonitorConfig(List<BasAnaesMonitorConfig> anaesMonitorConfigList) {

		if (anaesMonitorConfigList.size() > 0) {
			for (BasAnaesMonitorConfig anaesMonitorConfig : anaesMonitorConfigList) {
				String deviceId = anaesMonitorConfig.getDeviceId();
				String regOptId = anaesMonitorConfig.getRegOptId();
				
				if (StringUtils.isBlank(anaesMonitorConfig.getBeid()))
		        {
				    anaesMonitorConfig.setBeid(getBeid());
		        }
				
				BasAnaesMonitorConfig tempConfig = basAnaesMonitorConfigDao.getAnaesMonitorListByRegOptId(deviceId, regOptId);
				if (null != tempConfig) {
					basAnaesMonitorConfigDao.updateAnaesMonitorConfig(anaesMonitorConfig);
				} else {
				    anaesMonitorConfig.setId(GenerateSequenceUtil.generateSequenceNo());
					basAnaesMonitorConfigDao.insert(anaesMonitorConfig);
				}
			}
		}
	}

	public List<BasAnaesMonitorConfigFormBean> finaAnaesList(BaseInfoQuery baseQuery) {
		if (StringUtils.isBlank(baseQuery.getBeid())) {
			baseQuery.setBeid(getBeid());
		}
		List<BasAnaesMonitorConfigFormBean> anaesMonitorList = basAnaesMonitorConfigDao.getAnaesMonitorConfigListByRegOptId(baseQuery);
		return anaesMonitorList;
	}

	public List<BasAnaesMonitorConfigFormBean> finaAnaesListWithoutO2(BaseInfoQuery baseQuery) {
		if (StringUtils.isBlank(baseQuery.getBeid())) {
			baseQuery.setBeid(getBeid());
		}
		List<BasAnaesMonitorConfigFormBean> anaesMonitorList = basAnaesMonitorConfigDao.getAnaesMonitorConfigListByRegOptId(baseQuery);
		for (BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean : anaesMonitorList) {
			if ("91001".equals(anaesMonitorConfigFormBean.getEventId())) {
				anaesMonitorList.remove(anaesMonitorConfigFormBean);
				break;
			}
		}
		return anaesMonitorList;
	}

	@Transactional
	public void updateByEventId(BasAnaesMonitorConfig anaesMonitorConfig) {
		if (StringUtils.isBlank(anaesMonitorConfig.getBeid())) {
			anaesMonitorConfig.setBeid(getBeid());
		}
		basAnaesMonitorConfigDao.updateByEventId(anaesMonitorConfig);
	}
}
