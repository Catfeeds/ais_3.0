package com.digihealth.anesthesia.operProceed.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.operProceed.po.BasMonitorFreqChange;

@Service
public class BasMonitorFreqChangeService extends BaseService{
	
	@Transactional
	public void insert(BasMonitorFreqChange entity){
	    basMonitorFreqChangeDao.insert(entity);
	}
	
	public List<BasMonitorFreqChange> getMonitorFreqChanges(String regOptId){
		return basMonitorFreqChangeDao.getMonitorFreqChanges(regOptId);
	}
	

    public BasMonitorFreqChange selectFirstChangeTime(String regOptId, String inTime)
    {
        return basMonitorFreqChangeDao.selectFirstChangeTime(regOptId, inTime);
    }
}
