/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasDeviceSpecification;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.evt.formbean.Filter;

/**
 * 
 * Title: DeviceSpecificationService.java Description: 设备规格
 * 
 * @author liukui
 * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasDeviceSpecificationService extends BaseService {

	public List<BasDeviceSpecification> getDeviceSpecificationList() {
		return basDeviceSpecificationDao.findAllList(getBeid());
	}
	
	/**
	 * 根据id查询设备规格
	 * @param defId
	 * @return
	 */
	public BasDeviceSpecification queryDeviceSpecificationById(String deviceId) {
		return basDeviceSpecificationDao.queryDeviceSpecificationById(deviceId);
	}
	
	/**
	 * 根据页面条件筛选设备规格并排序
	 * @param systemSearchFormBean
	 * @return
	 */
	public List<BasDeviceSpecification> queryDeviceSpecificationList(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("deviceId");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return basDeviceSpecificationDao.queryDeviceSpecificationList(filter, systemSearchFormBean);
	}
	/**
	 * 获取查询设备规格总数
	 * @param systemSearchFormBean
	 * @return
	 */
	public int queryDeviceSpecificationListTotal(SystemSearchFormBean systemSearchFormBean){
	    if (StringUtils.isBlank(systemSearchFormBean.getBeid()))
        {
            systemSearchFormBean.setBeid(getBeid());
        }
		if(StringUtils.isEmpty(systemSearchFormBean.getSort())){
			systemSearchFormBean.setSort("deviceId");
		}
		if(StringUtils.isEmpty(systemSearchFormBean.getOrderBy())){
			systemSearchFormBean.setOrderBy("ASC");
		}
		String filter = "";
		List<Filter> filters = systemSearchFormBean.getFilters();
		if(filters!=null&&filters.size()>0){
			for(int i = 0;i<filters.size();i++){
				if(!StringUtils.isEmpty(filters.get(i).getValue().toString())){
					filter = filter + " AND "+filters.get(i).getField() +" like '%"+filters.get(i).getValue()+"%' ";
				}
			}
		}
		return basDeviceSpecificationDao.queryDeviceSpecificationListTotal(filter, systemSearchFormBean);
	}
}
