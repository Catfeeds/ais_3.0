/*
 * BasPacuBedEventConfigDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import com.digihealth.anesthesia.basedata.formbean.PacuBedEventConfigFormBean;
import com.digihealth.anesthesia.basedata.po.BasPacuBedEventConfig;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface BasPacuBedEventConfigDao {
    int deleteByPrimaryKey(@Param("deviceId") String deviceId, @Param("eventId") String eventId, @Param("bedId") String bedId);

    int insert(BasPacuBedEventConfig record);

    int insertSelective(BasPacuBedEventConfig record);

    BasPacuBedEventConfig selectByPrimaryKey(@Param("deviceId") String deviceId, @Param("eventId") String eventId, @Param("bedId") String bedId);

    int updateByPrimaryKeySelective(BasPacuBedEventConfig record);

    int updateByPrimaryKey(BasPacuBedEventConfig record);
    
    List<PacuBedEventConfigFormBean> selectByBedId(@Param("deviceId") String deviceId, @Param("bedId") String bedId, @Param("beid") String beid);
    
    int deleteByBedId(@Param("deviceId") String deviceId, @Param("eventId") String eventId, @Param("bedId") String bedId);
}