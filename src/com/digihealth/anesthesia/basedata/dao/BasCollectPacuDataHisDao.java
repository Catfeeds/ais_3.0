/*
 * BasCollectPacuDataHisDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import com.digihealth.anesthesia.basedata.po.BasCollectPacuDataHis;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface BasCollectPacuDataHisDao {
    int deleteByPrimaryKey(@Param("id") String id, @Param("time") Date time);

    int insert(BasCollectPacuDataHis record);

    int insertSelective(BasCollectPacuDataHis record);

    BasCollectPacuDataHis selectByPrimaryKey(@Param("id") String id, @Param("time") Date time);

    int updateByPrimaryKeySelective(BasCollectPacuDataHis record);

    int updateByPrimaryKey(BasCollectPacuDataHis record);
}