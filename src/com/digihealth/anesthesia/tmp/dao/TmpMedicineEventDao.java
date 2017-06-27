/*
 * TmpMedicineEventDao.java
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
import com.digihealth.anesthesia.evt.formbean.RegOptOperMedicaleventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperMedicalevent;
import com.digihealth.anesthesia.tmp.po.TmpMedicineEvent;

@MyBatisDao
public interface TmpMedicineEventDao {
    int delete(String medEventId);

    int insert(TmpMedicineEvent record);

    int insertSelective(TmpMedicineEvent record);

    TmpMedicineEvent selectByPrimaryKey(String medEventId);

    int updateByPrimaryKeySelective(TmpMedicineEvent record);

    int update(TmpMedicineEvent record);
    
    //查询手术人员用药信息
    public List<SearchOptOperMedicalevent> searchMedicaleventList(@Param("searchBean")SearchFormBean searchBean);
    
    public List<TmpMedicineEvent> queryMedicaleventListById(@Param("searchBean")SearchFormBean searchBean);
    //查询手术人员用药信息后根据药品code进行分组查询
    public List<RegOptOperMedicaleventFormBean> getMedicalGroupByNameList(@Param("searchBean")SearchFormBean searchBean);
    
    public List<TmpMedicineEvent> checkMedicaleventCanInsert(@Param("searchBean")SearchFormBean searchBean,@Param("medicineId")String medicineId);
    
    public int deleteByMedTempId(@Param("medTempId")String medTempId);
    
    public List<TmpMedicineEvent> selectMedTempEventByMedTempId(@Param("medTempId")String medTempId,@Param("type")String type);
    
    public TmpMedicineEvent queryMedTempEvemtById(@Param("medEventId")String medEventId);
}