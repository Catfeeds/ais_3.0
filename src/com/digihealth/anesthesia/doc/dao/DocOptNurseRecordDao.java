/*
 * DocOptNurseRecordDao.java
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
import com.digihealth.anesthesia.doc.po.DocOptNurseRecord;

@MyBatisDao
public interface DocOptNurseRecordDao extends CrudDao<DocOptNurseRecord>{
    int deleteByPrimaryKey(String id);

    int insert(DocOptNurseRecord record);

    int insertSelective(DocOptNurseRecord record);

    DocOptNurseRecord selectByPrimaryKey(String id);

    DocOptNurseRecord selectByRegOptId(@Param("regOptId") String regOptId);
    
    int updateByPrimaryKeySelective(DocOptNurseRecord record);

    int updateByPrimaryKey(DocOptNurseRecord record);

    void updateBloodAndInfusion(DocOptNurseRecord record);
}