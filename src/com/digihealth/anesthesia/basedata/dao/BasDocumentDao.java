/*
 * BasDocumentDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasDocument;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasDocumentDao {
    int deleteByPrimaryKey(String docId);

    int insert(BasDocument record);

    int insertSelective(BasDocument record);

    BasDocument selectByPrimaryKey(String docId);

    int updateByPrimaryKeySelective(BasDocument record);

    int updateByPrimaryKey(BasDocument record);
    
    public List<BasDocument> searchDocument(@Param("roleId")String roleId,@Param("operationState")String operationState,@Param("beid")String beid);
    
    List<BasDocument> searchAllDocumentMenu(@Param("beid")String beid);
}