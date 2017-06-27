/*
 * DocPatShuttleTransferDao.java
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
import com.digihealth.anesthesia.doc.po.DocPatShuttleTransfer;

@MyBatisDao
public interface DocPatShuttleTransferDao extends CrudDao<DocPatShuttleTransfer>{
    int deleteByPrimaryKey(String id);

    DocPatShuttleTransfer getPatShuttleTransferByRegOptId(@Param("regOptId")String regOptId);

    int insert(DocPatShuttleTransfer record);

    int insertSelective(DocPatShuttleTransfer record);

    DocPatShuttleTransfer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPatShuttleTransfer record);

    int updateByPrimaryKeyWithBLOBs(DocPatShuttleTransfer record);

    int updateByPrimaryKey(DocPatShuttleTransfer record);
}