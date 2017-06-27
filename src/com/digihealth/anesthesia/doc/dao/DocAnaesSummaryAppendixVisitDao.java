/*
 * DocAnaesSummaryAppendixVisitDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixVisit;

@MyBatisDao
public interface DocAnaesSummaryAppendixVisitDao extends CrudDao<DocAnaesSummaryAppendixVisit>{
    int deleteByPrimaryKey(String anesSumVisId);

    int insert(DocAnaesSummaryAppendixVisit record);

    int insertSelective(DocAnaesSummaryAppendixVisit record);

    DocAnaesSummaryAppendixVisit selectByPrimaryKey(String anesSumVisId);

    int updateByPrimaryKeySelective(DocAnaesSummaryAppendixVisit record);

    int updateByPrimaryKey(DocAnaesSummaryAppendixVisit record);

    DocAnaesSummaryAppendixVisit getPoByAnaSumId(String anaSumId);
}