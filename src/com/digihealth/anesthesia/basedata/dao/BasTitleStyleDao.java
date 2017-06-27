/*
 * BasTitleStyleDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasTitleStyle;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasTitleStyleDao {
    int deleteByPrimaryKey(String id);

    int insert(BasTitleStyle record);

    int insertSelective(BasTitleStyle record);

    BasTitleStyle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasTitleStyle record);

    int updateByPrimaryKey(BasTitleStyle record);
    
    List<BasTitleStyle> findList(@Param("type")Integer type, @Param("beid")String beid);
}