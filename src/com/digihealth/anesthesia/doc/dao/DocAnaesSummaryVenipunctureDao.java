/*
 * DocAnaesSummaryVenipunctureDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryVenipuncture;
@MyBatisDao
public interface DocAnaesSummaryVenipunctureDao {
    int deleteByPrimaryKey(String anesSumVenId);

    int insert(DocAnaesSummaryVenipuncture record);

    int insertSelective(DocAnaesSummaryVenipuncture record);

    DocAnaesSummaryVenipuncture selectByPrimaryKey(String anesSumVenId);

    int updateByPrimaryKeySelective(DocAnaesSummaryVenipuncture record);

    int updateByPrimaryKey(DocAnaesSummaryVenipuncture record);

    DocAnaesSummaryVenipuncture getPoByAnaSumId(String anaSumId);
}