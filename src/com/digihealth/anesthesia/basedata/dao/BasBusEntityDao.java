/*
 * BasBusEntityDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-23 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.formbean.SystemSearchFormBean;
import com.digihealth.anesthesia.basedata.po.BasBusEntity;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
import com.digihealth.anesthesia.evt.formbean.Filter;

@MyBatisDao
public interface BasBusEntityDao {
    int deleteByPrimaryKey(String beid);

    int insert(BasBusEntity record);

    int insertSelective(BasBusEntity record);

    BasBusEntity selectByPrimaryKey(String beid);

    int updateByPrimaryKeySelective(BasBusEntity record);

    int updateByPrimaryKey(BasBusEntity record);
    
    /**
     * 获得当前局点beid 
     */
    public String getBeid();
    
    /**
     * 查询局点信息列表 
     */
    List<BasBusEntity> selectBusEntityList(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
    
    /**
     * 查询局点信息列表数量 
     */
    Integer selectBusEntityTotal(@Param("filters")List<Filter> filters,@Param("systemSearchFormBean")SystemSearchFormBean systemSearchFormBean);
}