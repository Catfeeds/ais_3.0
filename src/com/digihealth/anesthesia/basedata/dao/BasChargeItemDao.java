/*
 * BasChargeItemDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.BasChargeItemFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasChargeItem;
import com.digihealth.anesthesia.basedata.po.BasChargeItemPackagesRel;
import com.digihealth.anesthesia.common.persistence.CrudDao;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasChargeItemDao extends CrudDao<BasChargeItem> {
    public List<BasChargeItemFormBean> findList(@Param("pinyin")String pinyin, @Param("beid")String beid);
    
    public BasChargeItem searchChargeItemById(@Param("chargeItemId")String chargeItemId, @Param("beid")String beid);
    
    public int findListTotal(@Param("filter")String filter, @Param("beid")String beid);
    
    public List<BasChargeItem> queryChargeItemByChargePackagesId(@Param("chargePkgId")String chargePkgId, @Param("beid")String beid);
    
    public List<BasChargeItem> queryChargeItemList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public List<BasChargeItem> selectByCode(@Param("code")String code, @Param("beid")String beid);

    int updateByPrimaryKey(BasChargeItem record);

    int insert(BasChargeItem record);

    int insertSelective(BasChargeItem record);
    
    public int updateEnable(@Param("beid")String beid);
}