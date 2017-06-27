/*
 * BasPacuDeviceMonitorConfigDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import com.digihealth.anesthesia.basedata.po.BasPacuDeviceMonitorConfig;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface BasPacuDeviceMonitorConfigDao {
    int deleteByPrimaryKey(@Param("deviceId") String deviceId, @Param("eventId") String eventId);

    int insert(BasPacuDeviceMonitorConfig record);

    int insertSelective(BasPacuDeviceMonitorConfig record);

    BasPacuDeviceMonitorConfig selectByPrimaryKey(@Param("deviceId") String deviceId, @Param("eventId") String eventId);

    int updateByPrimaryKeySelective(BasPacuDeviceMonitorConfig record);

    int updateByPrimaryKey(BasPacuDeviceMonitorConfig record);
}