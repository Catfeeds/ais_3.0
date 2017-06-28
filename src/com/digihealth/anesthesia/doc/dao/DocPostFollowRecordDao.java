/*
 * DocPostFollowRecordDao.java
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
import com.digihealth.anesthesia.doc.po.DocPostFollowRecord;

@MyBatisDao
public interface DocPostFollowRecordDao extends CrudDao<DocPostFollowRecord>{
    int deleteByPrimaryKey(String postFollowId);

    int insert(DocPostFollowRecord record);

    int insertSelective(DocPostFollowRecord record);

    DocPostFollowRecord selectByPrimaryKey(String postFollowId);

    int updateByPrimaryKeySelective(DocPostFollowRecord record);

    int updateByPrimaryKey(DocPostFollowRecord record);

    DocPostFollowRecord searchFollowRecordByRegOptId(@Param("regOptId") String regOptId, @Param("beid") String beid);

}