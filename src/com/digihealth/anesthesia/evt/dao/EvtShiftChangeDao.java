/*
 * EvtShiftChangeDao.java
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
import com.digihealth.anesthesia.evt.po.EvtShiftChange;

@MyBatisDao
public interface EvtShiftChangeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EvtShiftChange record);

    int insertSelective(EvtShiftChange record);

    EvtShiftChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EvtShiftChange record);

    int updateByPrimaryKey(EvtShiftChange record);
    
    public List<EvtShiftChange> searchShiftChangeList(@Param("searchBean")SearchFormBean searchBean);
	
	public List<EvtShiftChange> getAllShiftChangeList(@Param("searchBean")SearchFormBean searchBean);
}