/*
 * DocAnalgesicVisitInfoDao.java
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
import com.digihealth.anesthesia.doc.po.DocAnalgesicVisitInfo;
@MyBatisDao
public interface DocAnalgesicVisitInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(DocAnalgesicVisitInfo record);

    int insertSelective(DocAnalgesicVisitInfo record);

    DocAnalgesicVisitInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocAnalgesicVisitInfo record);

    int updateByPrimaryKey(DocAnalgesicVisitInfo record);

    List<DocAnalgesicVisitInfo> getByanalgesicId(@Param("analgesicId") String analgesicId);
    
    int deleteByanalgesicId(@Param("analgesicId") String analgesicId);
}