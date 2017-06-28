/*
 * DocPostFollowSpinalDao.java
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
import com.digihealth.anesthesia.doc.po.DocPostFollowSpinal;

@MyBatisDao
public interface DocPostFollowSpinalDao extends CrudDao<DocPostFollowSpinal>{
    int deleteByPrimaryKey(String spinalFollowId);

    int insert(DocPostFollowSpinal record);

    int insertSelective(DocPostFollowSpinal record);

    DocPostFollowSpinal selectByPrimaryKey(String spinalFollowId);

    int updateByPrimaryKeySelective(DocPostFollowSpinal record);

    int updateByPrimaryKey(DocPostFollowSpinal record);

    List<DocPostFollowSpinal> getInfoByPostFollowId(@Param("postFollowId")String postFollowId, @Param("beid") String beid);
    
    int deleteByPostFollowId(String postFollowId);
}