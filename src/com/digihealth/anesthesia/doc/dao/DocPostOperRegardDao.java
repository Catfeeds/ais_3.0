/*
 * DocPostOperRegardDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocPostOperRegard;
@MyBatisDao
public interface DocPostOperRegardDao {
    int deleteByPrimaryKey(String id);

    int insert(DocPostOperRegard record);

    int insertSelective(DocPostOperRegard record);

    DocPostOperRegard selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPostOperRegard record);

    int updateByPrimaryKey(DocPostOperRegard record);
}