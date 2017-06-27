/*
 * DocNurseInterviewRecordDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocNurseInterviewRecord;
@MyBatisDao
public interface DocNurseInterviewRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(DocNurseInterviewRecord record);

    int insertSelective(DocNurseInterviewRecord record);

    DocNurseInterviewRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocNurseInterviewRecord record);

    int updateByPrimaryKeyWithBLOBs(DocNurseInterviewRecord record);

    int updateByPrimaryKey(DocNurseInterviewRecord record);
}