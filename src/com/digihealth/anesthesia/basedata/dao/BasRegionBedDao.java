/*
 * BasRegionBedDao.java
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
import com.digihealth.anesthesia.basedata.po.BasRegionBed;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasRegionBedDao{
    int insertSelective(BasRegionBed record);

    int insert(BasRegionBed record);
    
    BasRegionBed selectByPrimaryKey(@Param("id")String id);
    
    int updateByPrimaryKey(BasRegionBed record);
    
    int updateByPrimaryKeySelective(BasRegionBed record);
    
    int deleteByPrimaryKey(@Param("id")String id);
    
    public List<BasRegionBed> getregionbedList(@Param("filters")String filters, @Param("beid")String beid);
    
    public void updateByPatId(BasRegionBed regionBed);
    
    public List<BasRegionBed> selectEntityList(BasRegionBed record);
    
    public List<BasRegionBed> queryRegionBedList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryRegionBedListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public BasRegionBed searchRegionBedById(@Param("id")String id);
    
    public BasRegionBed selectByRegOptId(@Param("regOptId")String regOptId, @Param("beid")String beid);
    
    public String getregpatIdByIpAndPort(@Param("ipAddr")String ip,@Param("port")int port, @Param("beid")String beid);
    
    public BasRegionBed selectByIpAddrPort(@Param("ipAddr")String ip,@Param("port")Integer port, @Param("beid")String beid);
}