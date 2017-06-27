/*
 * EvtRescueeventDao.java
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
import com.digihealth.anesthesia.evt.po.EvtRescueevent;

@MyBatisDao
public interface EvtRescueeventDao {
    int deleteByPrimaryKey(String rescueEventId);

    int insert(EvtRescueevent record);

    int insertSelective(EvtRescueevent record);

    EvtRescueevent selectByPrimaryKey(String rescueEventId);

    int updateByPrimaryKeySelective(EvtRescueevent record);

    int updateByPrimaryKey(EvtRescueevent record);
    
    public List<EvtRescueevent> searchRescueeventList(@Param("searchBean")SearchFormBean searchBean);
    
	public void updateCurrentState(@Param("docId")String docId,@Param("currentState")String currentState);
}