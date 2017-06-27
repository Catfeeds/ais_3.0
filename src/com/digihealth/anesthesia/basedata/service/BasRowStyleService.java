/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.BasRowStyle;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;
/**
 * 
     * Title: RowStyleService.java    
     * Description: 日志Service
     * @author liukui       
     * @created 2016-8-7 下午6:00:54
 */
@Service
public class BasRowStyleService extends BaseService {

	@Transactional
	public void saveRowStyle(BasRowStyle record){
	    if (StringUtils.isBlank(record.getBeid()))
        {
	        record.setBeid(getBeid());
        }
		if(basRowStyleDao.getRowStyleByRowNum(record)!=null){
			basRowStyleDao.updateByPrimaryKeySelective(record);
		}else{
		    record.setId(GenerateSequenceUtil.generateSequenceNo());
			basRowStyleDao.insertSelective(record);
		}
	}
	
	public BasRowStyle getRowStyle(String id){
		return basRowStyleDao.selectByPrimaryKey(id);
	}
}
