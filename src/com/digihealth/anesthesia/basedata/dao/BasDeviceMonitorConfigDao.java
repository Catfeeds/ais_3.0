/*
 * BasDeviceMonitorConfigDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import com.digihealth.anesthesia.basedata.formbean.BasDeviceMonitorConfigFormBean;
import com.digihealth.anesthesia.basedata.po.BasDeviceMonitorConfig;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface BasDeviceMonitorConfigDao {
    int deleteByPrimaryKey(@Param("beid") String beid, @Param("eventId") String eventId);

    int insert(BasDeviceMonitorConfig record);

    int insertSelective(BasDeviceMonitorConfig record);

    BasDeviceMonitorConfig selectByPrimaryKey(@Param("deviceId") String deviceId, @Param("eventId") String eventId);

    int updateByPrimaryKeySelective(BasDeviceMonitorConfig record);

    int update(BasDeviceMonitorConfig record);
    
    public List<BasDeviceMonitorConfigFormBean> getDeviceMonitorConfigList(@Param("beid") String beid,@Param("deviceId") String deviceId,@Param("optional") String optional);
    
    public List<BasDeviceMonitorConfig> getDeviceMonitorConfigByBeid(@Param("beid") String beid);
}