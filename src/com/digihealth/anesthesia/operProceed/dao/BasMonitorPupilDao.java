/*
 * BasMonitorPupilDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.operProceed.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.po.BasMonitorPupil;

@MyBatisDao
public interface BasMonitorPupilDao {
    int deleteByPrimaryKey(String id);

    int insert(BasMonitorPupil record);

    int insertSelective(BasMonitorPupil record);

    BasMonitorPupil selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasMonitorPupil record);

    int updateByPrimaryKey(BasMonitorPupil record);
    
    public List<BasMonitorPupil> getPupilList(@Param("regOptId")String regOptId, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
}