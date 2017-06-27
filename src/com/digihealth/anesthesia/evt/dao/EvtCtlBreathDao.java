/*
 * EvtCtlBreathDao.java
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
import com.digihealth.anesthesia.evt.po.EvtCtlBreath;

@MyBatisDao
public interface EvtCtlBreathDao {
    int deleteByPrimaryKey(String ctlBreId);

    int insert(EvtCtlBreath record);

    int insertSelective(EvtCtlBreath record);

    EvtCtlBreath selectByPrimaryKey(String ctlBreId);

    int updateByPrimaryKeySelective(EvtCtlBreath record);

    int updateByPrimaryKey(EvtCtlBreath record);
    
    public List<EvtCtlBreath> searchCtlBreathList(@Param("searchBean")SearchFormBean searchBean);
	
	public void updateCurrentState(@Param("docId")String docId,@Param("currentState")String currentState);
	
	/**
	 * 获取当前的呼吸事件
	 * @param regOptId
	 * @return
	 */
	public EvtCtlBreath selCtlBreathCur(@Param("regOptId")String regOptId);
	
	/**
	 * 根据regOptId获取所有的呼吸事件，根据current_state 降序，start_time 升序 
	 * @param regOptId
	 * @return
	 */
	public List<EvtCtlBreath> searchBreathListOrder(@Param("regOptId")String regOptId);
	
	public EvtCtlBreath queryCurCtlBreath(@Param("docId")String docId);
}