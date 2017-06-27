/*
 * BasDeviceSpecificationDao.java
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
import com.digihealth.anesthesia.basedata.po.BasDeviceSpecification;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasDeviceSpecificationDao {
    int deleteByPrimaryKey(String deviceId);

    int insert(BasDeviceSpecification record);

    int insertSelective(BasDeviceSpecification record);

    BasDeviceSpecification selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(BasDeviceSpecification record);

    int updateByPrimaryKey(BasDeviceSpecification record);
    
    public List<BasDeviceSpecification> findAllList(@Param("beid") String beid);
    
    public BasDeviceSpecification queryDeviceSpecificationById(@Param("deviceId") String deviceId); 
    
    public List<BasDeviceSpecification> queryDeviceSpecificationList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryDeviceSpecificationListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
}