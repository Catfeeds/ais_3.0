/*
 * DocPrevisitPhyexamDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocPrevisitPhyexam;
@MyBatisDao
public interface DocPrevisitPhyexamDao extends CrudDao<DocPrevisitPhyexam>{
    int deleteByPrimaryKey(String id);

    int insert(DocPrevisitPhyexam record);

    int insertSelective(DocPrevisitPhyexam record);

    DocPrevisitPhyexam selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPrevisitPhyexam record);

    int updateByPrimaryKey(DocPrevisitPhyexam record);

    DocPrevisitPhyexam selectByPreVisitId(String preVisitId);
}