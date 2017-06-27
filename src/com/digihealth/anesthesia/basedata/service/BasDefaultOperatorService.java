/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SearchDefaultOperatorFormBean;
import com.digihealth.anesthesia.basedata.po.BasDefaultOperator;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;

/**
 * 
     * Title: DefaultOperatorService.java    
     * Description: 手术室人员默认配置表
     * @author liukui       
     * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasDefaultOperatorService extends BaseService {
	
	/**
	 * 当传入的查询条件为空时，需要构建一个查询对象
	 * @param baseQuery
	 * @return
	 */
	public List<SearchDefaultOperatorFormBean> findList(BaseInfoQuery baseQuery) {
		return basDefaultOperatorDao.findList(baseQuery);
	}
	
	@Transactional
	public void saveDefaultOperator(BasDefaultOperator defaultOperator){
		if(logger.isDebugEnabled()){
			logger.debug("url:saveDefaultOperator data:"+defaultOperator.toString());
		}
		BaseInfoQuery baseQuery = new BaseInfoQuery();
		baseQuery.setOperRoomId(defaultOperator.getOperRoomId());
		List<BasDefaultOperator> list = basDefaultOperatorDao.getDefaultOperatorById(baseQuery);
		if(list.size()>0){
			basDefaultOperatorDao.update(defaultOperator);
		}else{
		    defaultOperator.setId(GenerateSequenceUtil.generateSequenceNo());
		    defaultOperator.setBeid(getBeid());
			basDefaultOperatorDao.insert(defaultOperator);
		}
	}
	
	/**
	 * 手术室人员默认配置表修改
	 */
	
	@Transactional
	public void deleteDefaultOperator(BasDefaultOperator defaultOperator){
		basDefaultOperatorDao.deleteDefaultOperator(defaultOperator.getOperRoomId(), defaultOperator.getBeid());
	}
	
}
