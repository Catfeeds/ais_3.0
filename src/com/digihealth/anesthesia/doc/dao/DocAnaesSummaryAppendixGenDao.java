/*
 * DocAnaesSummaryAppendixGenDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixGen;

@MyBatisDao
public interface DocAnaesSummaryAppendixGenDao extends CrudDao<DocAnaesSummaryAppendixGen>{
    int deleteByPrimaryKey(String anaSumAppGenId);

    int insert(DocAnaesSummaryAppendixGen record);

    int insertSelective(DocAnaesSummaryAppendixGen record);

    DocAnaesSummaryAppendixGen selectByPrimaryKey(String anaSumAppGenId);

    int updateByPrimaryKeySelective(DocAnaesSummaryAppendixGen record);

    int updateByPrimaryKey(DocAnaesSummaryAppendixGen record);

    DocAnaesSummaryAppendixGen getPoByAnaSumId(String anaSumId);
}