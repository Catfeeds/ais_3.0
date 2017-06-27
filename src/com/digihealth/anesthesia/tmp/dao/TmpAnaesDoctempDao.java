/*
 * TmpAnaesDoctempDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-04-06 Created
 */
package com.digihealth.anesthesia.tmp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SearchDoctempFormBean;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;
import com.digihealth.anesthesia.tmp.po.TmpAnaesDoctemp;
@MyBatisDao
public interface TmpAnaesDoctempDao {
    int deleteByPrimaryKey(String id);

    int insert(TmpAnaesDoctemp record);

    int insertSelective(TmpAnaesDoctemp record);

    TmpAnaesDoctemp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TmpAnaesDoctemp record);

    int updateByPrimaryKeyWithBLOBs(TmpAnaesDoctemp record);

    int updateByPrimaryKey(TmpAnaesDoctemp record);
    
    List<TmpAnaesDoctemp> selectAnaesDoctempByForbean(@Param("filters")List<Filter> filters,@Param("searchFormBean")SearchDoctempFormBean searchDoctempFormBean);
    
    int selectAnaesDoctempTotalByForbean(@Param("filters")List<Filter> filters,@Param("searchFormBean")SearchDoctempFormBean searchDoctempFormBean);
}