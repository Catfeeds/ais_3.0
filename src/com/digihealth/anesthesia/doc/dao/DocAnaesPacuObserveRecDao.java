/*
 * DocAnaesPacuObserveRecDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-30 Created
 */
package com.digihealth.anesthesia.doc.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocAnaesPacuObserveRec;
import com.digihealth.anesthesia.evt.formbean.Filter;
@MyBatisDao
public interface DocAnaesPacuObserveRecDao {
    int deleteByPrimaryKey(String id);

    int insert(DocAnaesPacuObserveRec record);

    int insertSelective(DocAnaesPacuObserveRec record);

    DocAnaesPacuObserveRec selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocAnaesPacuObserveRec record);

    int updateByPrimaryKey(DocAnaesPacuObserveRec record);
    
    List<DocAnaesPacuObserveRec> selectByPacuRecId(@Param("searchFormBean")SystemSearchFormBean searchFormBean,@Param("filters")List<Filter> filters);
    
    DocAnaesPacuObserveRec getObserveRecordByTime(@Param("pacuRecId")String pacuRecId,@Param("recordTime")Date recordTime);
    
    List<DocAnaesPacuObserveRec> selectPacuObByPacuRecId(@Param("searchFormBean")SystemSearchFormBean searchFormBean,@Param("pacuRecId")String pacuRecId);
}