/*
 * EvtAnaesEventDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.evt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.po.EvtAnaesEvent;

@MyBatisDao
public interface EvtAnaesEventDao extends CrudDao<EvtAnaesEvent>{
    int deleteByPrimaryKey(String anaEventId);

    int insert(EvtAnaesEvent record);

    int insertSelective(EvtAnaesEvent record);

    EvtAnaesEvent selectByPrimaryKey(String anaEventId);

    int updateByPrimaryKeySelective(EvtAnaesEvent record);

    int updateByPrimaryKey(EvtAnaesEvent record);
    
    public List<EvtAnaesEvent> searchAnaeseventList(@Param("searchBean")SearchFormBean searchBean);
    
    public void deleteAnaeseventByDocId(@Param("anaesevent")EvtAnaesEvent anaesevent);
    
    public List<EvtAnaesEvent> selectCodeByDESC(@Param("docId")String docId,@Param("code")int code);
    
    public List<EvtAnaesEvent> selectCodeByASC(@Param("docId")String docId,@Param("code")int code);
    
    public List<EvtAnaesEvent> selectByCodeAndDocId(@Param("docId")String docId,@Param("code")int code);
    
    public int deleteByCodeAndDocId(@Param("docId")String docId,@Param("code")int code,@Param("anaEventId")String anaEventId);
    
    public EvtAnaesEvent selectAnaesEventByCodeAndDocId(@Param("docId")String docId,@Param("code")int code);
}