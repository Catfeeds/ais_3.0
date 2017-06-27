/*
 * BasRowStyleDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasRowStyle;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasRowStyleDao {
    int deleteByPrimaryKey(String id);

    int insert(BasRowStyle record);

    int insertSelective(BasRowStyle record);

    BasRowStyle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasRowStyle record);

    int updateByPrimaryKey(BasRowStyle record);
    
    List<BasRowStyle> findList(@Param("type")Integer type, @Param("beid")String beid);
    
    BasRowStyle getRowStyleByRowNum(BasRowStyle record);
}