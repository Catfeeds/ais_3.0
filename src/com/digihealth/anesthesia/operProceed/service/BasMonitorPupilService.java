package com.digihealth.anesthesia.operProceed.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.operProceed.po.BasMonitorPupil;

@Service
public class BasMonitorPupilService extends BaseService{
	
	public List<BasMonitorPupil> getPupilList(String regOptId,Date startTime,Date endTime){
		return basMonitorPupilDao.getPupilList(regOptId,startTime,endTime);
	}
	
}
