/*
 * DocInsuredPatAgreeDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocInsuredPatAgree;
@MyBatisDao
public interface DocInsuredPatAgreeDao {
    int deleteByPrimaryKey(String id);

    int insert(DocInsuredPatAgree record);

    int insertSelective(DocInsuredPatAgree record);

    DocInsuredPatAgree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocInsuredPatAgree record);

    int updateByPrimaryKey(DocInsuredPatAgree record);
}