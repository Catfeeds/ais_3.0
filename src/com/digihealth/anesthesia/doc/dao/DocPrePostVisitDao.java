/*
 * DocPrePostVisitDao.java
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
import com.digihealth.anesthesia.doc.po.DocPrePostVisit;
@MyBatisDao
public interface DocPrePostVisitDao extends CrudDao<DocPrePostVisit>{
    int deleteByPrimaryKey(String id);

    int insert(DocPrePostVisit record);

    int insertSelective(DocPrePostVisit record);

    DocPrePostVisit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPrePostVisit record);

    int updateByPrimaryKey(DocPrePostVisit record);

    DocPrePostVisit selectByRegOptId(@Param("regOptId") String regOptId);
}