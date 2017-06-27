/*
 * EvtMedicalEventDao.java
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
import com.digihealth.anesthesia.evt.formbean.RegOptOperMedicaleventFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchFormBean;
import com.digihealth.anesthesia.evt.formbean.SearchOptOperMedicalevent;
import com.digihealth.anesthesia.evt.po.EvtMedicalEvent;

@MyBatisDao
public interface EvtMedicalEventDao {
    int deleteByPrimaryKey(String medEventId);

    int insert(EvtMedicalEvent record);

    int insertSelective(EvtMedicalEvent record);

    EvtMedicalEvent selectByPrimaryKey(String medEventId);

    int updateByPrimaryKeySelective(EvtMedicalEvent record);

    int updateByPrimaryKey(EvtMedicalEvent record);
    
    //查询手术人员用药信息
  	public List<SearchOptOperMedicalevent> searchMedicaleventList(@Param("searchBean")SearchFormBean searchBean);
  	
  	public List<EvtMedicalEvent> queryMedicaleventListById(@Param("searchBean")SearchFormBean searchBean);
  	
	//查询手术人员用药信息后根据药品code进行分组查询
	public List<RegOptOperMedicaleventFormBean> getMedicalGroupByNameList(@Param("searchBean")SearchFormBean searchBean);
	
	public List<EvtMedicalEvent> checkMedicaleventCanInsert(@Param("searchBean")SearchFormBean searchBean,@Param("medicineId")String medicineId);
	
	//获取复苏记录观察项数据
	public List<SearchOptOperMedicalevent> getPacuMedicaleventList(@Param("docId")String docId,@Param("medIds")String medIds,@Param("medIdLs") List<String> medIdLs);
	
	//获取患者单个药品的汇总数据
	public List<RegOptOperMedicaleventFormBean> getUseMedicalGroupByNameList(@Param("searchBean")SearchFormBean searchBean);

	RegOptOperMedicaleventFormBean getUseMedicalTotalById(@Param("searchBean")SearchFormBean searchBean);
}