/*
 * DocPrevisitAnaesplanDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocPrevisitAnaesplan;
@MyBatisDao
public interface DocPrevisitAnaesplanDao extends CrudDao<DocPrevisitAnaesplan>{
    int deleteByPrimaryKey(String id);

    int insert(DocPrevisitAnaesplan record);

    int insertSelective(DocPrevisitAnaesplan record);

    DocPrevisitAnaesplan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPrevisitAnaesplan record);

    int updateByPrimaryKey(DocPrevisitAnaesplan record);

    DocPrevisitAnaesplan selectByPreVisitId(String preVisitId);
}