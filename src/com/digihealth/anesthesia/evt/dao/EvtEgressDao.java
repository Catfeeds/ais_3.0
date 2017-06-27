/*
 * EvtEgressDao.java
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
import com.digihealth.anesthesia.evt.formbean.RegOptOperEgressFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperEgress;
import com.digihealth.anesthesia.evt.po.EvtEgress;

@MyBatisDao
public interface EvtEgressDao {
    int deleteByPrimaryKey(String egressId);

    int insert(EvtEgress record);

    int insertSelective(EvtEgress record);

    EvtEgress selectByPrimaryKey(String egressId);

    int updateByPrimaryKeySelective(EvtEgress record);

    int updateByPrimaryKey(EvtEgress record);
    
    public List<SearchOptOperEgress> searchEgressList(@Param("searchBean")SearchFormBean searchBean);
    
    public List<EvtEgress> queryEgressListById(@Param("searchBean")SearchFormBean searchBean);
    
    public List<EvtEgress> queryEgressListByCode(@Param("searchBean")SearchFormBean searchBean);
    
    public List<RegOptOperEgressFormBean> searchEgressGroupByDefIdList(@Param("searchBean")SearchFormBean searchBean);
    
    public Integer getEgressCountValueByIoDef(@Param("ioDefId")String ioDefId,@Param("docId")String docId);
    
    public List<AmountFormbean> getEgressAmountCountByDocId(@Param("docId")String docId);
    
    public float countAmountByDocId(@Param("docId")String docId);
    
}