/*
 * BasIoDefinationDao.java
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
import com.digihealth.anesthesia.basedata.formbean.IoDefinationFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasIoDefination;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasIoDefinationDao {
    int deleteByPrimaryKey(String ioDefId);

    int insert(BasIoDefination record);

    int insertSelective(BasIoDefination record);

    BasIoDefination selectByPrimaryKey(String ioDefId);

    int updateByPrimaryKeySelective(BasIoDefination record);

    int updateByPrimaryKey(BasIoDefination record);
    
    public List<IoDefinationFormBean> findList(@Param("baseQuery")BaseInfoQuery baseQuery);
    
    public List<IoDefinationFormBean> findOutList(@Param("beid")String beid);
    
    public List<BasIoDefination> queryIoDefinationList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryIoDefinationListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public List<BasIoDefination> queryIoDefinationByBeid(@Param("beid")String beid);
}