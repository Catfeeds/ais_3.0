/*
 * ScoParsRecordDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.sco.dao;

import com.digihealth.anesthesia.sco.po.ScoParsRecord;

public interface ScoParsRecordDao {
    int deleteByPrimaryKey(String scoId);

    int insert(ScoParsRecord record);

    int insertSelective(ScoParsRecord record);

    ScoParsRecord selectByPrimaryKey(String scoId);

    int updateByPrimaryKeySelective(ScoParsRecord record);

    int updateByPrimaryKey(ScoParsRecord record);
}