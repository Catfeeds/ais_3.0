/*
 * EvtRealAnaesMethodDao.java
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
import com.digihealth.anesthesia.evt.formbean.EvtAnaesMethodFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtRealAnaesMethod;

@MyBatisDao
public interface EvtRealAnaesMethodDao {
    int deleteByPrimaryKey(String realAnaMedId);

    int insert(EvtRealAnaesMethod record);

    int insertSelective(EvtRealAnaesMethod record);

    EvtRealAnaesMethod selectByPrimaryKey(String realAnaMedId);

    int updateByPrimaryKeySelective(EvtRealAnaesMethod record);

    int updateByPrimaryKey(EvtRealAnaesMethod record);
    
    public List<EvtAnaesMethodFormBean> getSelectRealAnaesMethodList(@Param("searchBean")SearchFormBean searchBean);
	
	public List<EvtRealAnaesMethod> searchRealAnaesMethodList(@Param("searchBean")SearchFormBean searchBean);
	
	int deleteByDocId(@Param("docId")String docId);
}