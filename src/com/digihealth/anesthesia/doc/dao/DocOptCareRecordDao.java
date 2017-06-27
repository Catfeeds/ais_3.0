/*
 * DocOptCareRecordDao.java
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
import com.digihealth.anesthesia.doc.po.DocOptCareRecord;

@MyBatisDao
public interface DocOptCareRecordDao extends CrudDao<DocOptCareRecord>{
    int deleteByPrimaryKey(String id);

    int insert(DocOptCareRecord record);

    int insertSelective(DocOptCareRecord record);

    DocOptCareRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocOptCareRecord record);

    int updateByPrimaryKeyWithBLOBs(DocOptCareRecord record);

    int updateByPrimaryKey(DocOptCareRecord record);

    DocOptCareRecord selectByRegOptId(@Param("regOptId") String regOptId);
}