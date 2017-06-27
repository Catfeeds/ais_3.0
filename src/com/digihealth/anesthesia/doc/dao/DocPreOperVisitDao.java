/*
 * DocPreOperVisitDao.java
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
import com.digihealth.anesthesia.doc.po.DocPreOperVisit;

@MyBatisDao
public interface DocPreOperVisitDao extends CrudDao<DocPreOperVisit>{
    int deleteByPrimaryKey(String id);

    int insert(DocPreOperVisit record);

    int insertSelective(DocPreOperVisit record);

    DocPreOperVisit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPreOperVisit record);

    int updateByPrimaryKey(DocPreOperVisit record);

    DocPreOperVisit selectByRegOptId(@Param("regOptId") String regOptId);
}