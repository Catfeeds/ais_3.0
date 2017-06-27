/*
 * BasObserveDataHisDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-07 Created
 */
package com.digihealth.anesthesia.operProceed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.po.BasObserveDataHis;

@MyBatisDao
public interface BasObserveDataHisDao {
    int deleteByPrimaryKey(String id);

    int insert(BasObserveDataHis record);

    int insertSelective(BasObserveDataHis record);

    BasObserveDataHis selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasObserveDataHis record);

    int updateByPrimaryKey(BasObserveDataHis record);
    
    public List<BasObserveDataHis> searchObserveDataHisListByDocId(@Param("regOptId")String regOptId);
    
    public int searchObserveDataHisById(@Param("id")String id);
    
    public void addBatchObserveData(@Param("list")List<BasObserveDataHis> observeDataHisList);
}