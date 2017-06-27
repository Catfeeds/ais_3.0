/*
 * TmpSciTempDao.java
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
import com.digihealth.anesthesia.research.formbean.SciTempFormBean;
import com.digihealth.anesthesia.tmp.po.TmpSciTemp;

@MyBatisDao
public interface TmpSciTempDao {
    int deleteByPrimaryKey(String id);

    int insert(TmpSciTemp record);

    int insertSelective(TmpSciTemp record);

    TmpSciTemp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TmpSciTemp record);

    int updateByPrimaryKeyWithBLOBs(TmpSciTemp record);

    int updateByPrimaryKey(TmpSciTemp record);
    
    List<SciTempFormBean> getSciTempList(@Param("beid")String beid);
}