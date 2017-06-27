/*
 * BasRptTableDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import com.digihealth.anesthesia.basedata.po.BasRptTable;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasRptTableDao {
    int insert(BasRptTable record);

    int insertSelective(BasRptTable record);
}