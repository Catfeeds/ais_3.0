/*
 * BasMonitorConfigFreqDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasMonitorConfigFreqDao {
    int deleteByPrimaryKey(String id);

    int insert(BasMonitorConfigFreq record);

    int insertSelective(BasMonitorConfigFreq record);

    BasMonitorConfigFreq selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasMonitorConfigFreq record);

    int update(BasMonitorConfigFreq record);
    
    public BasMonitorConfigFreq queryMonitorConfigFreqById(@Param("id")String id);
    
    public List<BasMonitorConfigFreq> queryMonitorConfigFreqList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public BasMonitorConfigFreq searchMonitorFreqByType(@Param("type") String type, @Param("beid") String beid);

    public List<BasMonitorConfigFreq> searchMonitorFreqList(@Param("beid") String beid);
}