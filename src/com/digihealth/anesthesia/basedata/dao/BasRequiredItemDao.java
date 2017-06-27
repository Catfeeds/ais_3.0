/*
 * BasRequiredItemDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasRequiredItem;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasRequiredItemDao {
    int deleteByPrimaryKey(String id);

    int insert(BasRequiredItem record);

    int insertSelective(BasRequiredItem record);

    BasRequiredItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasRequiredItem record);

    int updateByPrimaryKey(BasRequiredItem record);
    
    List<BasRequiredItem> selectByType(@Param("type") Integer type, @Param("beid") String beid);
    
    List<BasRequiredItem> selectBasRequiredItemByBeid(@Param("beid") String beid);
}