package com.digihealth.anesthesia.doc.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.doc.po.DocPlacentaHandleAgree;

@MyBatisDao
public interface DocPlacentaHandleAgreeDao {
    int deleteByPrimaryKey(String id);

    int insert(DocPlacentaHandleAgree record);

    int insertSelective(DocPlacentaHandleAgree record);

    DocPlacentaHandleAgree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocPlacentaHandleAgree record);

    int updateByPrimaryKey(DocPlacentaHandleAgree record);
    
    DocPlacentaHandleAgree selectByRegOptId(@Param("regOptId") String regOptId);
}