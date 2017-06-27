/*
 * BasChargePackagesDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasChargePackages;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasChargePackagesDao {
    int deleteByPrimaryKey(String chargePkgId);

    int insert(BasChargePackages record);

    int insertSelective(BasChargePackages record);

    BasChargePackages selectByPrimaryKey(String chargePkgId);

    int updateByPrimaryKeySelective(BasChargePackages record);

    int update(BasChargePackages record);
    
    public List<BasChargePackages> queryChargePackagesList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryChargePackagesListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public BasChargePackages searchChargePackagesById(@Param("chargePkgId")String chargePkgId);
    
    public List<BasChargePackages> searchChargePackagesOrderId(@Param("beid")String beid);
}