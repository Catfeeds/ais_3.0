/*
 * DocInsuredItemDao.java
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
import com.digihealth.anesthesia.doc.po.DocInsuredItem;
@MyBatisDao
public interface DocInsuredItemDao {
    int deleteByPrimaryKey(String id);

    int insert(DocInsuredItem record);

    int insertSelective(DocInsuredItem record);

    DocInsuredItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocInsuredItem record);

    int updateByPrimaryKey(DocInsuredItem record);
    
    public List<DocInsuredItem> searchByInsuredId(@Param("insuredId") String insuredId);
    
    public DocInsuredItem searchByTypeAndCode(@Param("insuredId") String insuredId, @Param("code") String code, @Param("type") Integer type, @Param("kind") Integer kind);
}