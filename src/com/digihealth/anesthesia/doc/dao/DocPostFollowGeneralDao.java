/*
 * DocPostFollowGeneralDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocPostFollowGeneral;

@MyBatisDao
public interface DocPostFollowGeneralDao extends CrudDao<DocPostFollowGeneral>{
    int deleteByPrimaryKey(String generalFolllowId);

    int insert(DocPostFollowGeneral record);

    int insertSelective(DocPostFollowGeneral record);

    DocPostFollowGeneral selectByPrimaryKey(String generalFolllowId);

    int updateByPrimaryKeySelective(DocPostFollowGeneral record);

    int updateByPrimaryKey(DocPostFollowGeneral record);

    List<DocPostFollowGeneral> getInfoByPostFollowId(@Param("postFollowId") String postFollowId, @Param("beid") String beid);
    
    int deleteByPostFollowId(String postFollowId);
}