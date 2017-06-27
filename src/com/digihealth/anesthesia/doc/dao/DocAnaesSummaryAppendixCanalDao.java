/*
 * DocAnaesSummaryAppendixCanalDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAppendixCanal;

@MyBatisDao
public interface DocAnaesSummaryAppendixCanalDao extends CrudDao<DocAnaesSummaryAppendixCanal>{
    int deleteByPrimaryKey(String anaSumAppCanId);

    int insert(DocAnaesSummaryAppendixCanal record);

    int insertSelective(DocAnaesSummaryAppendixCanal record);

    DocAnaesSummaryAppendixCanal selectByPrimaryKey(String anaSumAppCanId);

    int updateByPrimaryKeySelective(DocAnaesSummaryAppendixCanal record);

    int updateByPrimaryKey(DocAnaesSummaryAppendixCanal record);

    DocAnaesSummaryAppendixCanal getPoByAnaSumId(String anaSumId);
}