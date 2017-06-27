/*
 * BasMessageDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import com.digihealth.anesthesia.basedata.po.BasMessage;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasMessageDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BasMessage record);

    int insertSelective(BasMessage record);

    BasMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasMessage record);

    int updateByPrimaryKey(BasMessage record);
}