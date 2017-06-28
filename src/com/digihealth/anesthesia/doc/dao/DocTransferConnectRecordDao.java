/*
 * DocTransferConnectRecordDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocTransferConnectRecord;
@MyBatisDao
public interface DocTransferConnectRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(DocTransferConnectRecord record);

    int insertSelective(DocTransferConnectRecord record);

    DocTransferConnectRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocTransferConnectRecord record);

    int updateByPrimaryKeyWithBLOBs(DocTransferConnectRecord record);

    int updateByPrimaryKey(DocTransferConnectRecord record);
    
    public DocTransferConnectRecord selectByRegOptId(@Param("regOptId") String regOptId);
}