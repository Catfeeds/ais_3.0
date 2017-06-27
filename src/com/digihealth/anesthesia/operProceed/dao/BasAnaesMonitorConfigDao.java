/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.operProceed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.DeviceMonitorFormbean;
import com.digihealth.anesthesia.basedata.po.BasDeviceSpecification;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.formbean.BasAnaesMonitorConfigFormBean;
import com.digihealth.anesthesia.operProceed.po.BasAnaesMonitorConfig;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfig;


/**
 * 
     * Title: AnaesMonitorConfigDao.java    
     * Description: 监测点标记设置DAO接口
     * @author liukui       
     * @created 2015-10-7 下午5:54:49
 */
@MyBatisDao
public interface BasAnaesMonitorConfigDao extends CrudDao<BasAnaesMonitorConfig> {
	
	public List<BasAnaesMonitorConfigFormBean> getAnaesRecordShowListByRegOptId(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public List<BasDeviceSpecification> getDeviceSpecificationListByEventId(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public BasAnaesMonitorConfigFormBean getAnaesMonitorConfigEventId(@Param("baseQuery")BaseInfoQuery baseQuery);
	
	public BasAnaesMonitorConfigFormBean getAnaesMonitorConfigByEventId(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public BasMonitorConfig getMonitorConfig(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public BasAnaesMonitorConfigFormBean getAnaesMonitorConfig(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public BasAnaesMonitorConfig getAnaesMonitorListByRegOptId(@Param("deviceId") String deviceId,@Param("regOptId") String regOptId);
	
	public void updateAnaesMonitorConfig(BasAnaesMonitorConfig BasAnaesMonitorConfig);
	
	public List<BasAnaesMonitorConfigFormBean> findAnaesMonitorRecordListByRegOptId(@Param("baseQuery")BaseInfoQuery baseQuery);
	
	public List<BasAnaesMonitorConfigFormBean> getAnaesMonitorConfigListByRegOptId(@Param("baseQuery")BaseInfoQuery baseQuery);
	
	public List<BasAnaesMonitorConfigFormBean> getEventNameGroupByRegOptId(@Param("baseQuery")BaseInfoQuery baseQuery);
	
	public List<DeviceMonitorFormbean> getDeviceMonitorListByEventName(@Param("baseQuery") BaseInfoQuery baseQuery);
	
	public void updateByEventId(BasAnaesMonitorConfig BasAnaesMonitorConfig);
	
	public BasAnaesMonitorConfigFormBean getDefaultEventId(@Param("baseQuery") BaseInfoQuery baseQuery);
}
