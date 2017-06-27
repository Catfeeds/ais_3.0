/*
 * DocNursingDiagnosisDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocNursingDiagnosis;
@MyBatisDao
public interface DocNursingDiagnosisDao {
    int deleteByPrimaryKey(String nursingDiagnosisId);

    int insert(DocNursingDiagnosis record);

    int insertSelective(DocNursingDiagnosis record);

    DocNursingDiagnosis selectByPrimaryKey(String nursingDiagnosisId);

    int updateByPrimaryKeySelective(DocNursingDiagnosis record);

    int updateByPrimaryKey(DocNursingDiagnosis record);
}