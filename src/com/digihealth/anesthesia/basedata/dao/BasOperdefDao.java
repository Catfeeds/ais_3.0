/*
 * BasOperdefDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BaseInfoQuery;
import com.digihealth.anesthesia.basedata.formbean.OperDefFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasDiagnosedef;
import com.digihealth.anesthesia.basedata.po.BasOperdef;
import com.digihealth.anesthesia.common.persistence.EntityDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasOperdefDao extends EntityDao<String, BasOperdef>{
    int insertSelective(BasOperdef record);

    int updateByPrimaryKeySelective(BasOperdef record);
    
    int insert(BasOperdef record);

    int update(BasOperdef record);
    
    public List<OperDefFormBean> findList(@Param("baseQuery")BaseInfoQuery baseQuery);
    
    public BasOperdef queryOperdefById(@Param("operdefId") String operdefId); 
    
    public List<BasOperdef> queryOperdefList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryOperdefListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public void deleteOperdef(@Param("operdefId") String operdefId); 
    
    public List<BasOperdef> selectByCode(@Param("code")String code, @Param("beid")String beid);
    
    public int updateEnable(@Param("beid")String beid);
    
    public List<BasOperdef> selectByName(@Param("name")String name, @Param("beid")String beid);
    
    public List<BasOperdef> selectOrderByIdDesc();

	public int initData(@Param("basOperdef")BasOperdef basOperdef, @Param("random")String random);
}