/*
 * BasPacuDeviceSpecificationDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.PacuDeviceSpecFormBean;
import com.digihealth.anesthesia.basedata.po.BasPacuDeviceSpecification;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasPacuDeviceSpecificationDao {
    int deleteByPrimaryKey(String deviceId);

    int insert(BasPacuDeviceSpecification record);

    int insertSelective(BasPacuDeviceSpecification record);

    BasPacuDeviceSpecification selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(BasPacuDeviceSpecification record);

    int updateByPrimaryKey(BasPacuDeviceSpecification record);
    
    List<PacuDeviceSpecFormBean> getPacuDeviceByType(@Param("beid") String beid);
    
    public List<BasPacuDeviceSpecification> queryEntityByBeid(@Param("beid") String beid);
}