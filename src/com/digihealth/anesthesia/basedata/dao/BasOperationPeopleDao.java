/*
 * BasOperationPeopleDao.java
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
import com.digihealth.anesthesia.basedata.formbean.OperPeopleFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasOperationPeople;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.sysMng.formbean.UserInfoFormBean;

@MyBatisDao
public interface BasOperationPeopleDao extends CrudDao<BasOperationPeople>{
    public List<UserInfoFormBean> getSelectOperPeopleList(@Param("baseQuery")BaseInfoQuery baseQuery);
    
    public List<OperPeopleFormBean> findList(@Param("baseQuery")BaseInfoQuery baseQuery);
    
    public BasOperationPeople queryOperationPeopleById(@Param("operatorId") String operatorId); 
    
    public List<BasOperationPeople> queryOperationPeopleList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryOperationPeopleListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public void deleteOperationPeople(@Param("operatorId") String operationPeopleId);
    
    public List<BasOperationPeople> selectByCode(@Param("code")String code, @Param("beid") String beid);
    
    public int updateEnable(@Param("beid") String beid);
}