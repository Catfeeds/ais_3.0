/*
 * DocInsuredChargeInformDao.java
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
import com.digihealth.anesthesia.doc.po.DocInsuredChargeInform;

@MyBatisDao
public interface DocInsuredChargeInformDao extends CrudDao<DocInsuredChargeInform>{
    int deleteByPrimaryKey(String id);

    int insert(DocInsuredChargeInform record);

    int insertSelective(DocInsuredChargeInform record);

    DocInsuredChargeInform selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocInsuredChargeInform record);

    int updateByPrimaryKey(DocInsuredChargeInform record);

    DocInsuredChargeInform selectByRegOptId(@Param("regOptId") String regOptId);
}