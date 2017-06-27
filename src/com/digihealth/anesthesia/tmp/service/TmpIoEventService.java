/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.tmp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.tmp.po.TmpIoEvent;

/**
 * 
     * Title: MedicaleventService.java    
     * Description: 用药事件Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class TmpIoEventService extends BaseService {
	
	public List<TmpIoEvent> selectIoTempEventByMedTempId(String medTempId){
		return tmpIoEventDao.selectIoTempEventByMedTempId(medTempId);
	}
	
	public TmpIoEvent queryIoTempEvemtById(String ioeventId){
		return tmpIoEventDao.queryIoTempEvemtById(ioeventId);
	}
}
