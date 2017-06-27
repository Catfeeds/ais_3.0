/*
 * BasCollectPacuDataDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasCollectPacuData;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasCollectPacuDataDao {
    int deleteByPrimaryKey(@Param("id") String id, @Param("time") Date time);

    int insert(BasCollectPacuData record);

    int insertSelective(BasCollectPacuData record);

    BasCollectPacuData selectByPrimaryKey(@Param("id") String id, @Param("time") Date time);

    int updateByPrimaryKeySelective(BasCollectPacuData record);

    int updateByPrimaryKey(BasCollectPacuData record);
    
    int deleteByDocId(@Param("regOptId") String regOptId);
    
    List<BasCollectPacuData> searchPacuObserveDataList(@Param("regOptId")String regOptId,@Param("time")Date time);
}