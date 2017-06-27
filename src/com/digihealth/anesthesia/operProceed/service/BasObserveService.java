package com.digihealth.anesthesia.operProceed.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.Observe;

@Service
public class BasObserveService extends BaseService {
	
	// 当前手速要采集的参数
	public List<Observe> searchAnaesObserveList(String beid, String operId) {
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		return basMonitorConfigDao.searchAnaesObserveList(beid, operId);
	}
	
	public BasMonitorConfig searchMonitorConfig (String eventId,String beid){
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		return basMonitorConfigDao.selectByPrimaryKey(eventId,beid);
	}

}
