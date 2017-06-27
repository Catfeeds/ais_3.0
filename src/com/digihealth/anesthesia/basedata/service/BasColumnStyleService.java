/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasColumnStyle;
import com.digihealth.anesthesia.common.service.BaseService;
/**
 * 
     * Title: ColumnStyleService.java    
     * Description: 日志Service
     * @author liukui       
     * @created 2016-8-7 下午6:00:54
 */
@Service
public class BasColumnStyleService extends BaseService {

	@Transactional
	public void saveColumnStyle(BasColumnStyle record){
		if(record.getId()!=null){
			basColumnStyleDao.updateByPrimaryKeySelective(record);
		}else{
			basColumnStyleDao.insertSelective(record);
		}
	}
	
	public BasColumnStyle getColumnStyle(String id){
		return basColumnStyleDao.selectByPrimaryKey(id);
	}
	
	@Transactional
	public void changeColumnSort(List<BasColumnStyle> ls){
		for (BasColumnStyle columnStyle : ls) {
			basColumnStyleDao.updateByPrimaryKeySelective(columnStyle);
		}
	}
}
