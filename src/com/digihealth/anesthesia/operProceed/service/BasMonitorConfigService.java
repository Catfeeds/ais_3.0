package com.digihealth.anesthesia.operProceed.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.operProceed.formbean.BasAnaesMonitorConfigFormBean;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfigDefault;

@Service
public class BasMonitorConfigService extends BaseService{
	
	public List<BasMonitorConfig> selectMustShowList(){
		return basMonitorConfigDao.selectMustShowList(getBeid());
	}
	
	public List<BasMonitorConfig> selectWithoutMustShowList(){
		return basMonitorConfigDao.selectWithoutMustShowList(getBeid());
	}
	
	public List<BasMonitorConfig> queryAllMonitorConfig(){
		List<BasMonitorConfig> list = basMonitorConfigDao.queryAllMonitorConfig(getBeid());
		// 去除O2的监测项
		if(null != list && list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				BasMonitorConfig mc = list.get(i);
				if("91001".equals(mc.getEventId())){
					list.remove(mc);
				}
			}
		}
		return list;
	}
	
	@Transactional
	public void updMonitorConfig(List<BasMonitorConfig> monitorConfigList) {
		for (BasMonitorConfig monitorConfig : monitorConfigList) {
			basMonitorConfigDao.updateByPrimaryKeySelective(monitorConfig);
		}
	}

	public List<BasMonitorConfig> selectMustShowListWithoutO2() {
		List<BasMonitorConfig> list = basMonitorConfigDao.selectMustShowList(getBeid());
		// 去除O2的监测项
		if(null != list && list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				BasMonitorConfig mc = list.get(i);
				if("91001".equals(mc.getEventId())){
					list.remove(mc);
				}
			}
		}
		return list;
	}
	
	
	public BasMonitorConfig selectByEventId(String eventId){
		return basMonitorConfigDao.selectByPrimaryKey(eventId, getBeid());
	}
	
	public String selectEventIdByEventName(BasAnaesMonitorConfigFormBean anaesMonitorConfigFormBean,String regOptId)
	{
	    List<String> strList = basMonitorConfigDao.selectEventIdByEventName(anaesMonitorConfigFormBean.getEventName(), getBeid());
	    BasMonitorConfigDefault monitorConfigDefault = basMonitorConfigDefaultDao.selectByEventName(anaesMonitorConfigFormBean.getEventName(), getBeid());

	    //如果b_anaes_monitor_config中配置的realEventId为已启用设备，则直接返回即可
	    //如果b_anaes_monitor_config中配置的realEventId为未启用设备，则返回启用设备中的第一个即可
	    //如果没有设备启用，返回默认eventId
        if (null != strList && strList.size() > 0)
        {
            for (String str : strList)
            {
                if (str.equals(anaesMonitorConfigFormBean.getRealEventId()))
                {
                    return str;
                }
            }
            if (strList.size() > 1 && strList.contains(monitorConfigDefault.getDefaultEventId()))
            {
                return monitorConfigDefault.getDefaultEventId();
            }
            else
            {
                return strList.get(0);
            }
            
        }
	    return monitorConfigDefault.getDefaultEventId();
	}
}
