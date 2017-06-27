/*
 * DocPrevisitAccessexamDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocPrevisitAccessexam;
@MyBatisDao
public interface DocPrevisitAccessexamDao extends CrudDao<DocPrevisitAccessexam>{
    int deleteByPrimaryKey(String id);

    int insert(DocPrevisitAccessexam record);

    int insertSelective(DocPrevisitAccessexam record);

    DocPrevisitAccessexam selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPrevisitAccessexam record);

    int updateByPrimaryKey(DocPrevisitAccessexam record);

    DocPrevisitAccessexam selectByPreVisitId(String preVisitId);
}