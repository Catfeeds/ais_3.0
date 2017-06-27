/*
 * DocInsuredChargeItemDao.java
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
import com.digihealth.anesthesia.doc.po.DocInsuredChargeItem;

@MyBatisDao
public interface DocInsuredChargeItemDao extends CrudDao<DocInsuredChargeItem>{
    int deleteByPrimaryKey(String id);

    int insert(DocInsuredChargeItem record);

    int insertSelective(DocInsuredChargeItem record);

    DocInsuredChargeItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocInsuredChargeItem record);

    int updateByPrimaryKey(DocInsuredChargeItem record);

    List<DocInsuredChargeItem> selectByInsuredId(@Param("insuredId") String insuredId);
    
    DocInsuredChargeItem selectByNameAndPrice(@Param("insuredId") String insuredId, @Param("name") String name, @Param("price") Float price);
}