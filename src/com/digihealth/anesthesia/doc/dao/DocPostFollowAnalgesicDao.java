/*
 * DocPostFollowAnalgesicDao.java
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
import com.digihealth.anesthesia.doc.po.DocPostFollowAnalgesic;

@MyBatisDao
public interface DocPostFollowAnalgesicDao extends CrudDao<DocPostFollowAnalgesic>{
    int deleteByPrimaryKey(String analgesicFollowId);

    int insert(DocPostFollowAnalgesic record);

    int insertSelective(DocPostFollowAnalgesic record);

    DocPostFollowAnalgesic selectByPrimaryKey(String analgesicFollowId);

    int updateByPrimaryKeySelective(DocPostFollowAnalgesic record);

    int updateByPrimaryKey(DocPostFollowAnalgesic record);

    int deleteByPostFollowId(String postFollowId);

    List<DocPostFollowAnalgesic> getInfoByPostFollowId(@Param("postFollowId")String postFollowId, @Param("beid") String beid);
}