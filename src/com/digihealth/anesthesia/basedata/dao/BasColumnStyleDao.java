/*
 * BasColumnStyleDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasColumnStyle;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasColumnStyleDao {
    int deleteByPrimaryKey(String id);

    int insert(BasColumnStyle record);

    int insertSelective(BasColumnStyle record);

    BasColumnStyle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasColumnStyle record);

    int updateByPrimaryKey(BasColumnStyle record);
    
    List<BasColumnStyle> findList(@Param("type")Integer type, @Param("beid")String beid);
}