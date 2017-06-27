/*
 * BasMonitorFreqChangeDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.operProceed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.po.BasMonitorFreqChange;

@MyBatisDao
public interface BasMonitorFreqChangeDao {
    int deleteByPrimaryKey(String id);

    int insert(BasMonitorFreqChange record);

    int insertSelective(BasMonitorFreqChange record);

    BasMonitorFreqChange selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasMonitorFreqChange record);

    int updateByPrimaryKey(BasMonitorFreqChange record);
    
    public List<BasMonitorFreqChange> getMonitorFreqChanges(@Param("regOptId")String regOptId);
    
    BasMonitorFreqChange selectFirstChangeTime(@Param("regOptId")String regOptId, @Param("inTime")String inTime);
}