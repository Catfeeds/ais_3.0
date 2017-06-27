/*
 * BasMonitorDisplayChangeHisDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-07 Created
 */
package com.digihealth.anesthesia.operProceed.dao;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.operProceed.po.BasMonitorDisplayChangeHis;

@MyBatisDao
public interface BasMonitorDisplayChangeHisDao {
    int deleteByPrimaryKey(String id);

    int insert(BasMonitorDisplayChangeHis record);

    int insertSelective(BasMonitorDisplayChangeHis record);

    BasMonitorDisplayChangeHis selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasMonitorDisplayChangeHis record);

    int updateByPrimaryKey(BasMonitorDisplayChangeHis record);
}