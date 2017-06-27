/*
 * BasRegionDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasRegion;
import com.digihealth.anesthesia.common.persistence.EntityDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasRegionDao extends EntityDao<String, BasRegion>{
    int insertSelective(BasRegion record);

    int updateByPrimaryKeySelective(BasRegion record);

    int update(BasRegion record);
    
    int insert(BasRegion record);
    
    public List<BasRegion> findList(@Param("baseQuery") BaseInfoQuery baseQuery);
    
    public BasRegion searchRegionById(@Param("regionId")String regionId);
    
    public List<BasRegion> queryRegionList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryRegionListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public List<BasRegion> selectByCode(@Param("code")String code);
    
    public int updateEnable(@Param("beid")String beid);
}