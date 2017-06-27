/*
 * BasConsultationDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasConsultation;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.SearchConditionFormBean;

@MyBatisDao
public interface BasConsultationDao {
    int deleteByPrimaryKey(String conttId);
    
    int insert(BasConsultation record);
    
    int insertSelective(BasConsultation record);
    
    BasConsultation selectByPrimaryKey(String conttId);
    
    int updateByPrimaryKeySelective(BasConsultation record);
    
    int update(BasConsultation record);
    
    public List<BasConsultation> searchConsultation(@Param("filter") String filter, @Param("loginName") String loginName, 
        @Param("administrativeLeve") String administrativeLeve, @Param("searchConditionFormBean") SearchConditionFormBean searchConditionFormBean);
    
    public BasConsultation searchConsultationById(@Param("conttId")
    String conttId);
    
    public int deleteConsultationById(@Param("conttId")
    String conttId);
}