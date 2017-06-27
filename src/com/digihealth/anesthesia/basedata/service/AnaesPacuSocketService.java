package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.basedata.po.BasPacuMonitorConfig;
import com.digihealth.anesthesia.basedata.po.BasRegionBed;
import com.digihealth.anesthesia.common.service.BaseService;

@Service
public class AnaesPacuSocketService extends BaseService {
	// 通过床ID获取采集项
	public List<BasPacuMonitorConfig> getObserveList(String bedId,String beid) {
		//return basObserveDataDao.searchObserveListByBedId(bedId);
		return basPacuDeviceConfigDao.selectByBedIdWithOpt(bedId,beid);
	}

	// 通过床ID获取端口、IP、间隔
	public BasRegionBed getRegionBed(String bedId) {
		return basRegionBedDao.selectByPrimaryKey(bedId);
	}

}
