/*
 * EvtOptLatterDiagDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.DiagnosedefFormBean;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptLatterDiag;

@MyBatisDao
public interface EvtOptLatterDiagDao {
	int deleteByPrimaryKey(String optLatterDiagId);

	int insert(EvtOptLatterDiag record);

	int insertSelective(EvtOptLatterDiag record);

	EvtOptLatterDiag selectByPrimaryKey(String optLatterDiagId);

	int updateByPrimaryKeySelective(EvtOptLatterDiag record);

	int updateByPrimaryKey(EvtOptLatterDiag record);

	public List<DiagnosedefFormBean> getSelectOptLatterDiagList(@Param("searchBean") SearchFormBean searchBean);

	public List<EvtOptLatterDiag> searchOptLatterDiagList(@Param("searchBean") SearchFormBean searchBean);

	int deleteByDocId(@Param("docId") String docId);
}