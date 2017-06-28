/*
 * BasMedicineDao.java
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
import com.digihealth.anesthesia.basedata.formbean.MedicineFormBean;
import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasMedicine;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasMedicineDao {
    int deleteByPrimaryKey(String medicineId);

    int insert(BasMedicine record);

    int insertSelective(BasMedicine record);

    BasMedicine selectByPrimaryKey(String medicineId);

    int updateByPrimaryKeySelective(BasMedicine record);

    int update(BasMedicine record);
    
    public List<MedicineFormBean> findList(@Param("baseQuery") BaseInfoQuery baseQuery);

    public List<BasMedicine> queryMedicineByBeid(@Param("beid")String beid);
    
    public BasMedicine queryMedicineById(@Param("medicineId") String medicineId); 
    
    public List<BasMedicine> queryMedicineList(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);

    public int queryMedicineListTotal(@Param("filter")String filter,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    public void deleteMedicine(@Param("medicineId") String medicineId); 
    
    public List<BasMedicine> selectByCode(@Param("code")String code, @Param("beid")String beid);
    
    public int updateEnable(@Param("beid")String beid);
}