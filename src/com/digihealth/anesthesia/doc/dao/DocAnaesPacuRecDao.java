/*
 * DocAnaesPacuRecDao.java
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
import com.digihealth.anesthesia.doc.formbean.AnaesPacuRecFormBean;
import com.digihealth.anesthesia.doc.po.DocAnaesPacuRec;
import com.digihealth.anesthesia.evt.formbean.Filter;

@MyBatisDao
public interface DocAnaesPacuRecDao {
    int deleteByPrimaryKey(String id);

    int insert(DocAnaesPacuRec record);

    int insertSelective(DocAnaesPacuRec record);

    DocAnaesPacuRec selectByPrimaryKey(String id);
    
    DocAnaesPacuRec getAnaesPacuRecByRegOptId(String regOptId);

    int hasAnaesPacuRecByRegOptId(String regOptId);
    
    int updateByPrimaryKeySelective(DocAnaesPacuRec record);

    int updateByPrimaryKey(DocAnaesPacuRec record);
    
    List<AnaesPacuRecFormBean> searchAnaesPacuRecList(@Param("searchFormBean") SystemSearchFormBean searchFormBean,@Param("filters") List<Filter> filters,@Param("beid")String beid);
    
    int searchTotalAnaesPacuRecList(@Param("filters") List<Filter> filters,@Param("beid")String beid);
    
    List<AnaesPacuRecFormBean> getAnaesPacuRecCard(@Param("beid")String beid);
    
    AnaesPacuRecFormBean getOptInfoByPacuId(String id);
    
    DocAnaesPacuRec selectPacuByRegOptId(@Param("regOptId")String regOptId);
    
    public void updatePacuRecEnterRoomTime(@Param("enterTime")Date enterTime, @Param("pacuRecId")String pacuRecId);
}