/*
 * TmpMedicineDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.tmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.tmp.po.TmpMedicine;

@MyBatisDao
public interface TmpMedicineDao {
    int delete(String medTempId);

    int insert(TmpMedicine record);

    int insertSelective(TmpMedicine record);

    TmpMedicine selectByPrimaryKey(String medTempId);

    int updateByPrimaryKeySelective(TmpMedicine record);

    int update(TmpMedicine record);
    
    public List<TmpMedicine> queryMedTempList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public TmpMedicine searchMedTempById(@Param("medTempId")String medTempId);
    
    public int queryMedTempListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public List<TmpMedicine> selectMedTempOrderById();
}