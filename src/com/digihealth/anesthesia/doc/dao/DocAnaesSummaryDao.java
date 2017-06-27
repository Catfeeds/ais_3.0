/*
 * DocAnaesSummaryDao.java
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
import com.digihealth.anesthesia.doc.po.DocAnaesSummary;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;

@MyBatisDao
public interface DocAnaesSummaryDao extends CrudDao<DocAnaesSummary>{
    int deleteByPrimaryKey(String anaSumId);

    int insert(DocAnaesSummary record);

    int insertSelective(DocAnaesSummary record);

    DocAnaesSummary selectByPrimaryKey(String anaSumId);

    int updateByPrimaryKeySelective(DocAnaesSummary record);

    int updateByPrimaryKey(DocAnaesSummary record);

	public List<DocAnaesSummary> searchAnaesSummaryList(@Param("searchBean")SearchFormBean searchBean);
	
	public DocAnaesSummary getAnaesSummaryByRegOptId(@Param("regOptId")String regOptId);
}