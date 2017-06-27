/*
 * DocAccedeInformedDao.java
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
import com.digihealth.anesthesia.doc.po.DocAccedeInformed;
@MyBatisDao
public interface DocAccedeInformedDao extends CrudDao<DocAccedeInformed>{
    int deleteByPrimaryKey(String anasInformedId);

    int insert(DocAccedeInformed record);

    int insertSelective(DocAccedeInformed record);

    DocAccedeInformed selectByPrimaryKey(String anasInformedId);

    int updateByPrimaryKeySelective(DocAccedeInformed record);

    int updateByPrimaryKey(DocAccedeInformed record);

    void deleteByAccedeId(@Param("accedeId") String accedeId);

    List<DocAccedeInformed> queryAccedeInformList(@Param("accedeId") String accedeId);
}