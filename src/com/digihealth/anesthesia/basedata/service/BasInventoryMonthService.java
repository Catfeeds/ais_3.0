/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.basedata.po.BasInventoryMonth;
import com.digihealth.anesthesia.common.service.BaseService;

/**
 * 
     * Title: InventoryService.java    
     * Description: 库存信息
     * @author chengwang       
     * @created 2015年12月15日 上午11:26:24
 */
@Service
public class BasInventoryMonthService extends BaseService {
	
	/**
	 * 
	     * @discription 查询库存信息
	     * @author chengwang       
	     * @created 2015年12月15日 上午10:18:24     
	     * @param systemSearchFormBean
	     * @return
	 */
	public List<BasInventoryMonth> findList(BasInventoryMonth inventoryMonth){
	    if (StringUtils.isBlank(inventoryMonth.getBeid()))
        {
	        inventoryMonth.setBeid(getBeid());
        }
		return basInventoryMonthDao.findList(inventoryMonth);
	}
}
