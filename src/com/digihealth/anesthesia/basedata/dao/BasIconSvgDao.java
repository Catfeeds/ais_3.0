/*
 * BasIconSvgDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasIconSvg;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasIconSvgDao {
    int deleteByPrimaryKey(String id);

    int insert(BasIconSvg record);

    int insertSelective(BasIconSvg record);

    BasIconSvg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasIconSvg record);

    int updateByPrimaryKeyWithBLOBs(BasIconSvg record);

    int updateByPrimaryKey(BasIconSvg record);
    
    String getSvgByIcon(@Param("icon") String icon, @Param("beid") String beid);
}