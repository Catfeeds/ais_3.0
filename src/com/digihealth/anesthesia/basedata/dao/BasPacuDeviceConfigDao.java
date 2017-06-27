/*
 * BasPacuDeviceConfigDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.PacuDeviceConfigFormBean;
import com.digihealth.anesthesia.basedata.po.BasPacuDeviceConfig;
import com.digihealth.anesthesia.basedata.po.BasPacuMonitorConfig;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasPacuDeviceConfigDao {
    int deleteByPrimaryKey(@Param("deviceId") String deviceId, @Param("bedId") String bedId);

    int insert(BasPacuDeviceConfig record);

    int insertSelective(BasPacuDeviceConfig record);

    BasPacuDeviceConfig selectByPrimaryKey(@Param("deviceId") String deviceId, @Param("bedId") String bedId);

    int updateByPrimaryKeySelective(BasPacuDeviceConfig record);

    int updateByPrimaryKey(BasPacuDeviceConfig record);
    
    List<PacuDeviceConfigFormBean> selectByBedId(@Param("bedId") String bedId, @Param("beid") String beid);
    
    List<BasPacuMonitorConfig> selectByBedIdWithOpt(@Param("bedId") String bedId, @Param("beid") String beid);
}