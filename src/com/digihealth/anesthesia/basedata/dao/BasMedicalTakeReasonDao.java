/*
 * BasMedicalTakeReasonDao.java
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
import com.digihealth.anesthesia.basedata.po.BasMedicalTakeReason;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasMedicalTakeReasonDao {
    public void deleteMedicalTakeReason(@Param("medTakeReasonId") String medTakeReasonId); 

    int insert(BasMedicalTakeReason record);

    int insertSelective(BasMedicalTakeReason record);

    BasMedicalTakeReason selectByPrimaryKey(String medTakeReasonId);

    int updateByPrimaryKeySelective(BasMedicalTakeReason record);

    int update(BasMedicalTakeReason record);
    
    public BasMedicalTakeReason queryMedicalTakeReasonById(@Param("medTakeReasonId") String medTakeReasonId); 
    
    public List<BasMedicalTakeReason> queryMedicalTakeReasonList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryMedicalTakeReasonListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public List<BasMedicalTakeReason> queryMedicalTakeReasonByBeid(@Param("beid")String beid);
}