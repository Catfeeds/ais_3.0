/*
 * BasOperateLogDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-24 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasOperateLog;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasOperateLogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BasOperateLog record);

    int insertSelective(BasOperateLog record);

    BasOperateLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasOperateLog record);

    int updateByPrimaryKeyWithBLOBs(BasOperateLog record);

    int updateByPrimaryKey(BasOperateLog record);
    
    List<BasOperateLog> selectLogionRecordByUserName(@Param("logionName")String logionName,@Param("beid")String beid);
}