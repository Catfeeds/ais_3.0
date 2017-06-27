/*
 * TmpIoEventDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.tmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.tmp.po.TmpIoEvent;
@MyBatisDao
public interface TmpIoEventDao {
    int deleteByPrimaryKey(String ioeventId);

    int insert(TmpIoEvent record);

    int insertSelective(TmpIoEvent record);

    TmpIoEvent selectByPrimaryKey(String ioeventId);

    int updateByPrimaryKeySelective(TmpIoEvent record);

    int updateByPrimaryKey(TmpIoEvent record);
    
    public int deleteByMedTempId(@Param("medTempId")String medTempId);
    
    public List<TmpIoEvent> selectIoTempEventByMedTempId(@Param("medTempId")String medTempId);
    
    public TmpIoEvent queryIoTempEvemtById(@Param("ioeventId")String ioeventId);
}