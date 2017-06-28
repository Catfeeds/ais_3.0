/*
 * DocInsuredPatAgreeDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.formbean.SearchMedAndInstruFormBean;
import com.digihealth.anesthesia.doc.po.DocInsuredPatAgree;
@MyBatisDao
public interface DocInsuredPatAgreeDao {
    int deleteByPrimaryKey(String id);

    int insert(DocInsuredPatAgree record);

    int insertSelective(DocInsuredPatAgree record);

    DocInsuredPatAgree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocInsuredPatAgree record);

    int updateByPrimaryKey(DocInsuredPatAgree record);
    
    public DocInsuredPatAgree searchByRegOptId(@Param("regOptId") String regOptId);
    
    List<SearchMedAndInstruFormBean> searchMedAndInstru(@Param("filter")String filter, @Param("beid")String beid); 
}