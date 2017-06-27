/*
 * EvtCheckEventItemRelationDao.java
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
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtCheckEventItemRelation;

@MyBatisDao
public interface EvtCheckEventItemRelationDao {
    int deleteByPrimaryKey(String itemId);

    int insert(EvtCheckEventItemRelation record);

    int insertSelective(EvtCheckEventItemRelation record);

    EvtCheckEventItemRelation selectByPrimaryKey(String itemId);

    int updateByPrimaryKeySelective(EvtCheckEventItemRelation record);

    int updateByPrimaryKey(EvtCheckEventItemRelation record);

	public List<EvtCheckEventItemRelation> serarchCheckevent(@Param("searchBean")SearchFormBean searchBean);
	
	public List<EvtCheckEventItemRelation> serarchCheckeventItemRelationList(@Param("searchBean")SearchFormBean searchBean);
	
	public void inserCheckeventItemRelationHis(@Param("checkeventItemRelation")EvtCheckEventItemRelation checkeventItemRelation);
	
	public int deleteCheckeventItemRelation(@Param("cheEventId")String cheEventId);
	
	public List<EvtCheckEventItemRelation> serarchAllValidCheckeventItem(@Param("docId")String docId);
}