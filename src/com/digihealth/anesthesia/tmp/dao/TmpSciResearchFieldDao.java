/*
 * TmpSciResearchFieldDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.tmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.research.formbean.SearchAnaesRegInfo;
import com.digihealth.anesthesia.tmp.po.TmpSciResearchField;

@MyBatisDao
public interface TmpSciResearchFieldDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TmpSciResearchField record);

    int insertSelective(TmpSciResearchField record);

    TmpSciResearchField selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TmpSciResearchField record);

    int updateByPrimaryKey(TmpSciResearchField record);
    
    List<TmpSciResearchField> getAllField();
    
    public List<SearchAnaesRegInfo> searchRegInfoBySciRes(@Param("sql")String sql);
    
    public List<String> searchMonitListByRegOpt(@Param("sql")String sql);
}