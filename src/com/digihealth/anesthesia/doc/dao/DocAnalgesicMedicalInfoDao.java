/*
 * DocAnalgesicMedicalInfoDao.java
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
import com.digihealth.anesthesia.doc.po.DocAnalgesicMedicalInfo;
@MyBatisDao
public interface DocAnalgesicMedicalInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(DocAnalgesicMedicalInfo record);

    int insertSelective(DocAnalgesicMedicalInfo record);

    DocAnalgesicMedicalInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocAnalgesicMedicalInfo record);

    int updateByPrimaryKey(DocAnalgesicMedicalInfo record);

    List<DocAnalgesicMedicalInfo> getByanalgesicId(@Param("analgesicId") String analgesicId);
    
    int deleteByanalgesicId(@Param("analgesicId") String analgesicId);
}