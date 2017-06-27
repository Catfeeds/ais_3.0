/*
 * EvtCheckEventDao.java
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
import com.digihealth.anesthesia.evt.po.EvtCheckEvent;

@MyBatisDao
public interface EvtCheckEventDao {
    int deleteByPrimaryKey(String cheEventId);

    int insert(EvtCheckEvent record);

    int insertSelective(EvtCheckEvent record);

    EvtCheckEvent selectByPrimaryKey(String cheEventId);

    int updateByPrimaryKeySelective(EvtCheckEvent record);

    int updateByPrimaryKey(EvtCheckEvent record);

	public List<EvtCheckEvent> searchCheckeventList(@Param("searchBean")SearchFormBean searchBean);
}