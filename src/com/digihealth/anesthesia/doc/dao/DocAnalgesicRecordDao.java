/*
 * DocAnalgesicRecordDao.java
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
import com.digihealth.anesthesia.doc.po.DocAnalgesicRecord;

@MyBatisDao
public interface DocAnalgesicRecordDao extends CrudDao<DocAnalgesicRecord> {
    int deleteByPrimaryKey(@Param("id") String id, @Param("state") String state);

    int insert(DocAnalgesicRecord record);

    int insertSelective(DocAnalgesicRecord record);

    DocAnalgesicRecord selectByPrimaryKey(@Param("id") String id, @Param("state") String state);

    int updateByPrimaryKeySelective(DocAnalgesicRecord record);

    int updateByPrimaryKey(DocAnalgesicRecord record);
    
    DocAnalgesicRecord searchAnalgesicRecordByPatId(@Param("regOptId")String regOptId);
}