/*
 * EvtInEventDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.AmountFormbean;
import com.digihealth.anesthesia.evt.formbean.RegOptOperIoeventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperIoevent;
import com.digihealth.anesthesia.evt.po.EvtInEvent;

@MyBatisDao
public interface EvtInEventDao {
    int deleteByPrimaryKey(String inEventId);

    int insert(EvtInEvent record);

    int insertSelective(EvtInEvent record);

    EvtInEvent selectByPrimaryKey(String inEventId);

    int updateByPrimaryKeySelective(EvtInEvent record);

    int updateByPrimaryKey(EvtInEvent record);
    
    public List<SearchOptOperIoevent> searchIoeventList(@Param("searchBean")SearchFormBean searchBean);
	
	
	public List<EvtInEvent> queryIoeventById(@Param("searchBean")SearchFormBean searchBean);
	
	
	public List<RegOptOperIoeventFormBean> searchIoeventGroupByDefIdList(@Param("searchBean")SearchFormBean searchBean);
	
	public List<EvtInEvent> checkIoeventCanInsert(@Param("searchBean")SearchFormBean searchBean,@Param("ioDefId")String ioDefId);
	
	public Integer getIoeventCountValueByIoDef(@Param("docId")String docId, @Param("ioDefId")String ioDefId);
	
	public String seleteIoeventSumByDocId(@Param("docId")String docId);
	
	public String seleteEgressSumByDocId(@Param("docId")String docId);
	
	public String seleteEmictionSumByDocId(@Param("docId")String docId);
	
	public String seleteBloodSumByDocId(@Param("docId")String docId);
	
	public String seleteOtherSumByDocId(@Param("docId")String docId);
	
	public String getBloodByDocId(@Param("docId")String docId);
	
	public List<AmountFormbean> getIoAmountCountByDocId(@Param("docId")String docId);
	
	public float countAmountByDocId(@Param("docId")String docId);
	
	public List<SearchOptOperIoevent> queryIoeventTotalGroupByDefId(@Param("searchBean")SearchFormBean searchBean);

	SearchOptOperIoevent queryIoeventTotalByDefId(@Param("searchBean") SearchFormBean searchBean);
}