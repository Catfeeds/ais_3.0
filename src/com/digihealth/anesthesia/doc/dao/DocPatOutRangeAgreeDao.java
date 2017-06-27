/*
 * DocPatOutRangeAgreeDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocPatOutRangeAgree;
@MyBatisDao
public interface DocPatOutRangeAgreeDao extends CrudDao<DocPatOutRangeAgree>{
    int deleteByPrimaryKey(String id);

    int insert(DocPatOutRangeAgree record);

    int insertSelective(DocPatOutRangeAgree record);

    DocPatOutRangeAgree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPatOutRangeAgree record);

    int updateByPrimaryKey(DocPatOutRangeAgree record);

    DocPatOutRangeAgree selectByRegOptId(@Param("regOptId") String regOptId);
}