/*
 * EvtMedicalEventDetailDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.po.EvtMedicalEventDetail;

@MyBatisDao
public interface EvtMedicalEventDetailDao {
	int deleteByPrimaryKey(String id);

	int insert(EvtMedicalEventDetail record);

	int insertSelective(EvtMedicalEventDetail record);

	EvtMedicalEventDetail selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(EvtMedicalEventDetail record);

	int updateByPrimaryKey(EvtMedicalEventDetail record);

	List<EvtMedicalEventDetail> selectByMedEventandDocId(@Param("medEventId") String medEventId);

	List<EvtMedicalEventDetail> selectByStartTimeWithEndTime(@Param("medEventId") String medEventId, @Param("insertTime") Date insertTime);

	List<EvtMedicalEventDetail> getMedEventDetailListByTime(@Param("medEventId") String medEventId, @Param("insertTime") Date insertTime);

	int deleteByMedEventId(@Param("medEventId") String medEventId);
}