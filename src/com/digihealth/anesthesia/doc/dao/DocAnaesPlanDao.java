/*
 * DocAnaesPlanDao.java
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
import com.digihealth.anesthesia.doc.po.DocAnaesPlan;

@MyBatisDao
public interface DocAnaesPlanDao extends CrudDao<DocAnaesPlan>{
    int deleteByPrimaryKey(String id);

    int insert(DocAnaesPlan record);

    int insertSelective(DocAnaesPlan record);

    DocAnaesPlan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocAnaesPlan record);

    int updateByPrimaryKey(DocAnaesPlan record);

    DocAnaesPlan selectByRegOptId(@Param("regOptId") String regOptId);
}