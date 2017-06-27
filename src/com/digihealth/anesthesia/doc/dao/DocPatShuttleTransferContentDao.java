/*
 * DocPatShuttleTransferContentDao.java
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
import com.digihealth.anesthesia.doc.po.DocPatShuttleTransferContent;

@MyBatisDao
public interface DocPatShuttleTransferContentDao extends CrudDao<DocPatShuttleTransferContent>{
    int deleteByPrimaryKey(String id);

    DocPatShuttleTransferContent getContentBycheckPoint(@Param("patShuttleId")String patShuttleId,@Param("checkPoint")String checkPoint);

    int insert(DocPatShuttleTransferContent record);

    int insertSelective(DocPatShuttleTransferContent record);

    DocPatShuttleTransferContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPatShuttleTransferContent record);

    int updateByPrimaryKeyWithBLOBs(DocPatShuttleTransferContent record);

    int updateByPrimaryKey(DocPatShuttleTransferContent record);

    int deleteByPatShuttleId(@Param("patShuttleId")String patShuttleId);

}