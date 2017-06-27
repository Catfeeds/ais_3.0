/*
 * DocInsuredItemDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocInsuredItem;
@MyBatisDao
public interface DocInsuredItemDao {
    int deleteByPrimaryKey(String id);

    int insert(DocInsuredItem record);

    int insertSelective(DocInsuredItem record);

    DocInsuredItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocInsuredItem record);

    int updateByPrimaryKey(DocInsuredItem record);
}