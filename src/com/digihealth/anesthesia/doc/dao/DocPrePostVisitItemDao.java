/*
 * DocPrePostVisitItemDao.java
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
import com.digihealth.anesthesia.doc.po.DocPrePostVisitItem;
@MyBatisDao
public interface DocPrePostVisitItemDao extends CrudDao<DocPrePostVisitItem>{
    int deleteByPrimaryKey(String id);

    int insert(DocPrePostVisitItem record);

    int insertSelective(DocPrePostVisitItem record);

    DocPrePostVisitItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPrePostVisitItem record);

    int updateByPrimaryKey(DocPrePostVisitItem record);

    List<DocPrePostVisitItem> selectByPrePostId(@Param("prePostId") String prePostId);
}