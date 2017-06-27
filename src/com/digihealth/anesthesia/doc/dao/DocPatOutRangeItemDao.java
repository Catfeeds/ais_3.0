/*
 * DocPatOutRangeItemDao.java
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
import com.digihealth.anesthesia.doc.po.DocPatOutRangeItem;
@MyBatisDao
public interface DocPatOutRangeItemDao extends CrudDao<DocPatOutRangeItem>{
    int deleteByPrimaryKey(String id);

    int insert(DocPatOutRangeItem record);

    int insertSelective(DocPatOutRangeItem record);

    DocPatOutRangeItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPatOutRangeItem record);

    int updateByPrimaryKey(DocPatOutRangeItem record);

    List<DocPatOutRangeItem> selectByPatOutRangeId(@Param("patOutRangeId") String patOutRangeId);
}