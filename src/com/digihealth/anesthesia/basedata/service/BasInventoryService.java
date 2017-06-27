/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasInventory;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
     * Title: InventoryService.java    
     * Description: 库存信息
     * @author chengwang       
     * @created 2015年12月15日 上午11:26:24
 */
@Service
public class BasInventoryService extends BaseService {
	
	/**
	 * 
	     * @discription 查询库存信息
	     * @author chengwang       
	     * @created 2015年12月15日 上午10:18:24     
	     * @param systemSearchFormBean
	     * @return
	 */
	public List<BasInventory> findList(BasInventory inventory){
	    if (StringUtils.isEmpty(inventory.getBeid()))
        {
	        inventory.setBeid(getBeid());
        }
		return basInventoryDao.findList(inventory);
	}
	
	
	public List<BasInventory> searchInventory(SystemSearchFormBean systemSearchFormBean ){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
	        systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("expiryDate");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					if("inventoryAmount".equals(filters.get(i).getField())) {
						filter += " AND inventoryAmount = " + filters.get(i).getValue();
					}
					filter += " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return basInventoryDao.queryInventoryList(filter, systemSearchFormBean);
	}
	
	public int searchInventoryTotal(SystemSearchFormBean systemSearchFormBean ){
	    if (StringUtils.isEmpty(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("expiryDate");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					if("inventoryAmount".equals(filters.get(i).getField())) {
						filter += " AND inventoryAmount = " + filters.get(i).getValue();
					}
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return basInventoryDao.queryInventoryListTotal(filter, systemSearchFormBean);
	}
	
	public BasInventory searchInventoryById(String invtId){
		return basInventoryDao.searchInventoryById(invtId);
	}
}
