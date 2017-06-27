/*
 * BasPropertiesDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import com.digihealth.anesthesia.basedata.po.BasProperties;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasPropertiesDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BasProperties record);

    int insertSelective(BasProperties record);

    BasProperties selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasProperties record);

    int updateByPrimaryKey(BasProperties record);
}