/*
 * DocTransferConnectTypeDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocTransferConnectType;
@MyBatisDao
public interface DocTransferConnectTypeDao {
    int deleteByPrimaryKey(String id);

    int insert(DocTransferConnectType record);

    int insertSelective(DocTransferConnectType record);

    DocTransferConnectType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocTransferConnectType record);

    int updateByPrimaryKeyWithBLOBs(DocTransferConnectType record);

    int updateByPrimaryKey(DocTransferConnectType record);
    
    public List<DocTransferConnectType> selectByTransferId(@Param("transferId") String transferId);
}