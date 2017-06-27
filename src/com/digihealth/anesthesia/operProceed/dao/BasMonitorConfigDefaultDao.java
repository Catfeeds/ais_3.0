/*
 * BasMonitorConfigDefaultDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-11 Created
 */
package com.digihealth.anesthesia.operProceed.dao;

import java.util.List;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.po.BasMonitorConfigDefault;

import org.apache.ibatis.annotations.Param;
@MyBatisDao
public interface BasMonitorConfigDefaultDao {
    int deleteByPrimaryKey(@Param("eventId") String eventId, @Param("beid") String beid);

    int insert(BasMonitorConfigDefault record);

    int insertSelective(BasMonitorConfigDefault record);

    BasMonitorConfigDefault selectByPrimaryKey(@Param("eventId") String eventId, @Param("beid") String beid);

    int updateByPrimaryKeySelective(BasMonitorConfigDefault record);

    int updateByPrimaryKey(BasMonitorConfigDefault record);
    
    BasMonitorConfigDefault selectByEventName(@Param("eventName") String eventName, @Param("beid") String beid);
    
    List<BasMonitorConfigDefault> selectAll(@Param("beid") String beid);
}