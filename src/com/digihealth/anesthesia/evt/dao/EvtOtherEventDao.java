/*
 * EvtOtherEventDao.java
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
import com.digihealth.anesthesia.evt.po.EvtOtherEvent;

@MyBatisDao
public interface EvtOtherEventDao {
    int deleteByPrimaryKey(String otherEventId);

    int insert(EvtOtherEvent record);

    int insertSelective(EvtOtherEvent record);

    EvtOtherEvent selectByPrimaryKey(String otherEventId);

    int updateByPrimaryKeySelective(EvtOtherEvent record);

    int updateByPrimaryKey(EvtOtherEvent record);
    
    public List<EvtOtherEvent> searchOthereventList(@Param("searchBean")SearchFormBean searchBean);
	
}