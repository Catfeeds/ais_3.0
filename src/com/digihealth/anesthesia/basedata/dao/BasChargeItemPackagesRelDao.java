/*
 * BasChargeItemPackagesRelDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasChargeItemPackagesRel;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasChargeItemPackagesRelDao {
    int deleteByPrimaryKey(String chgItmPkgId);

    int insert(BasChargeItemPackagesRel record);

    int insertSelective(BasChargeItemPackagesRel record);

    BasChargeItemPackagesRel selectByPrimaryKey(String chgItmPkgId);

    int updateByPrimaryKeySelective(BasChargeItemPackagesRel record);

    int updateByPrimaryKey(BasChargeItemPackagesRel record);
    
    public void deleteByChargePkgId(@Param("chargePkgId")String chargePkgId);
    
    public List<BasChargeItemPackagesRel> searchChargeItemByChargePackagesId(@Param("chargePkgId")String chargePkgId);
}