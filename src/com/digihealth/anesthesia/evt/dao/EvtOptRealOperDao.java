/*
 * EvtOptRealOperDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.OperDefFormBean;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtOptRealOper;

@MyBatisDao
public interface EvtOptRealOperDao {
	int deleteByPrimaryKey(String optRealOperId);

	int insert(EvtOptRealOper record);

	int insertSelective(EvtOptRealOper record);

	EvtOptRealOper selectByPrimaryKey(String optRealOperId);

	int updateByPrimaryKeySelective(EvtOptRealOper record);

	int updateByPrimaryKey(EvtOptRealOper record);

	public List<OperDefFormBean> getSelectOptRealOperList(@Param("searchBean") SearchFormBean searchBean);

	public List<EvtOptRealOper> searchOptRealOperList(@Param("searchBean") SearchFormBean searchBean);
	
	int deleteByDocId(String docId);

}