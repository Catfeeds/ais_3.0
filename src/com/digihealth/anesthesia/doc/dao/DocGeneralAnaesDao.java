/*
 * DocGeneralAnaesDao.java
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
import com.digihealth.anesthesia.doc.po.DocGeneralAnaes;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;

@MyBatisDao
public interface DocGeneralAnaesDao extends CrudDao<DocGeneralAnaes>{
    int deleteByPrimaryKey(String generalAnaesId);

    int insert(DocGeneralAnaes record);

    int insertSelective(DocGeneralAnaes record);

    DocGeneralAnaes selectByPrimaryKey(String generalAnaesId);

    int updateByPrimaryKeySelective(DocGeneralAnaes record);

    int updateByPrimaryKey(DocGeneralAnaes record);

	public List<DocGeneralAnaes> searchGeneralAnaesList(@Param("searchBean")SearchFormBean searchBean);
}