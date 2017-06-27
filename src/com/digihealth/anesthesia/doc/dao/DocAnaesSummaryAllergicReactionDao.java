/*
 * DocAnaesSummaryAllergicReactionDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocAnaesSummaryAllergicReaction;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
@MyBatisDao
public interface DocAnaesSummaryAllergicReactionDao {
    int deleteByPrimaryKey(String anaSumAllReaId);

    int insert(DocAnaesSummaryAllergicReaction record);

    int insertSelective(DocAnaesSummaryAllergicReaction record);

    DocAnaesSummaryAllergicReaction selectByPrimaryKey(String anaSumAllReaId);

    int updateByPrimaryKeySelective(DocAnaesSummaryAllergicReaction record);

    int updateByPrimaryKey(DocAnaesSummaryAllergicReaction record);

    public List<DocAnaesSummaryAllergicReaction> searchAllergicReactionList(@Param("searchBean")SearchFormBean searchBean);
    
    DocAnaesSummaryAllergicReaction getPoByAnaSumId(String anaSumId);
}