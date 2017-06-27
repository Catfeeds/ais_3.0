/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.operProceed.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.operProceed.po.ObserveDataChangeHis;

/**
 * 
 * @author huchao
 *
 */
@Service
@Transactional(readOnly = true)
public class ObserveDataChangeHisService extends BaseService {

	/**
	 * 新增观察点数据
	 * @param ObserveData
	 */
	@Transactional(readOnly = false)
	public void insertObserveDataChanges(ObserveDataChangeHis observeData){
		observeDataChangeDao.insert(observeData);
	}
	
	@Transactional(readOnly = false)
	public void batchInsertObserveData(List<ObserveDataChangeHis> obsDateList){
		for (ObserveDataChangeHis observeData : obsDateList) {
			observeDataChangeDao.insert(observeData);
		}
	}
}
