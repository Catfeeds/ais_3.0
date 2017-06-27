/*
 * BasRegoptDocumentDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import com.digihealth.anesthesia.basedata.po.BasRegoptDocument;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasRegoptDocumentDao {
    int deleteByPrimaryKey(String id);

    int insert(BasRegoptDocument record);

    int insertSelective(BasRegoptDocument record);

    BasRegoptDocument selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasRegoptDocument record);

    int updateByPrimaryKey(BasRegoptDocument record);
}