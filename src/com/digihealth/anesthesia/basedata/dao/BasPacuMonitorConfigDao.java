/*
 * BasPacuMonitorConfigDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasPacuMonitorConfig;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasPacuMonitorConfigDao {
    int deleteByPrimaryKey(@Param("eventId")String eventId,@Param("beid")String beid);

    int insert(BasPacuMonitorConfig record);

    int insertSelective(BasPacuMonitorConfig record);

    BasPacuMonitorConfig selectByPrimaryKey(String eventId);

    int updateByPrimaryKeySelective(BasPacuMonitorConfig record);

    int updateByPrimaryKey(BasPacuMonitorConfig record);
    
    List<BasPacuMonitorConfig> getPacuMonitorConfigCheck(@Param("deviceType") Integer deviceType,@Param("deviceId")String deviceId,@Param("beid")String beid);
    
    List<BasPacuMonitorConfig> getPacuMonitorConfigByBeid(@Param("beid")String beid);
}