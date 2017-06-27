/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.operProceed.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.operProceed.po.BasObserveDataHis;

/**
 * 
     * Title: ObserveDataHisService.java    
     * Description: 观察点历史数据Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasObserveDataHisService extends BaseService {
	
	public List<BasObserveDataHis> searchObserveDataHisList(String name) {
		return basObserveDataHisDao.searchObserveDataHisListByDocId(name);
	}
	/**
	 * 新增历史记录
	 * @param BasObserveDataHis
	 */
	@Transactional
	public void insertObserveDataHis(BasObserveDataHis observeDataHis){
		basObserveDataHisDao.insert(observeDataHis);
	}
	
	@Transactional
	public int searchObserveDataHisById(String id) {
		return basObserveDataHisDao.searchObserveDataHisById(id);
	}
	
	@Transactional
	public void addBatchObserveData(List<BasObserveDataHis> list) {
		basObserveDataHisDao.addBatchObserveData(list);
	}
}
