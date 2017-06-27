/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasInstrSuitRel;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;

/**
 * 
     * Title: OperroomService.java    
     * Description: 手术室Service
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasInstrSuitRelService extends BaseService {
	
	
	public List<BasInstrSuitRel> findList(String instrsuitId) {
		return basInstrSuitRelDao.findList(instrsuitId);
	}
	/**
	 * 新增手术包器械耗材关联表
	 * @param operroom
	 */
	@Transactional
	public int insertInstrSuitRel(BasInstrSuitRel instrSuitRel){
	    instrSuitRel.setInstrsuitId(GenerateSequenceUtil.generateSequenceNo());
		return basInstrSuitRelDao.insert(instrSuitRel);
	}
	/**
	 * 修改手术包器械耗材关联表
	 * @param instrSuitRel
	 */
	@Transactional
	public void updateInstrSuitRel(BasInstrSuitRel instrSuitRel){
		basInstrSuitRelDao.updateInstrSuitRel(instrSuitRel);
	}
	
	
	@Transactional
	public int deleteById(String instrSuitRelId){
		return basInstrSuitRelDao.deleteById(instrSuitRelId);
	}
}
