/*
 * EvtMeterialDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.po.EvtMaterial;

@MyBatisDao
public interface EvtMaterialDao {
    int deleteByPrimaryKey(String id);

    int insert(EvtMaterial record);

    int insertSelective(EvtMaterial record);

    EvtMaterial selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EvtMaterial record);

    int updateByPrimaryKey(EvtMaterial record);
    
    List<EvtMaterial> selectByDocId(@Param("docId")String docId);
}