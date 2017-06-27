/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasTitleStyle;
import com.digihealth.anesthesia.common.entity.ResponseValue;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
/**
 * 
     * Title: TitleStyleService.java    
     * Description: 日志Service
     * @author liukui       
     * @created 2016-8-7 下午6:00:54
 */
@Service
public class BasTitleStyleService extends BaseService {

	@Transactional
	public void saveTitleStyle(BasTitleStyle record){
	    if (StringUtils.isBlank(record.getBeid()))
        {
            record.setBeid(getBeid());
        }
		if(record.getId()!=null){
			basTitleStyleDao.updateByPrimaryKeySelective(record);
		}else{
		    record.setId(GenerateSequenceUtil.generateSequenceNo());
			basTitleStyleDao.insertSelective(record);
		}
	}
	
	public BasTitleStyle getTitleStyle(String id){
		return basTitleStyleDao.selectByPrimaryKey(id);
	}
	
	public void getStyleList(ResponseValue resp,Integer type){
		resp.put("titleStyle", basTitleStyleDao.findList(type, getBeid()));
		resp.put("columnStyle", basColumnStyleDao.findList(type, getBeid()));
		resp.put("rowStyle", basRowStyleDao.findList(type, getBeid()));
	}
}
