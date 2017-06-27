/*
 * BasMedicalTakeWayDao.java
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
import com.digihealth.anesthesia.basedata.po.BasMedicalTakeWay;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasMedicalTakeWayDao {
    int insert(BasMedicalTakeWay record);

    int insertSelective(BasMedicalTakeWay record);

    BasMedicalTakeWay selectByPrimaryKey(String medTakeWayId);

    int updateByPrimaryKeySelective(BasMedicalTakeWay record);

    int update(BasMedicalTakeWay record);
    
    public List<BasMedicalTakeWay> findList(@Param("baseQuery")BaseInfoQuery baseQuery);
    
    public BasMedicalTakeWay queryMedicalTakeWayById(@Param("medTakeWayId") String medTakeWayId); 
    
    public List<BasMedicalTakeWay> queryMedicalTakeWayList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryMedicalTakeWayListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public void deleteMedicalTakeWay(@Param("medTakeWayId") String medTakeWayId); 
    
    public List<BasMedicalTakeWay> queryMedicalTakeWayByBeId(@Param("beid") String beid);

}