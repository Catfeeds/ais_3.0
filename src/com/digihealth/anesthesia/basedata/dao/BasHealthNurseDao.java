/*
 * HealthNurseDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2016-08-05 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasHealthNurse;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;
@MyBatisDao
public interface BasHealthNurseDao {
    int deleteByPrimaryKey(String id);

    int insert(BasHealthNurse record);

    int insertSelective(BasHealthNurse record);

    BasHealthNurse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasHealthNurse record);

    int updateByPrimaryKey(BasHealthNurse record);
    
    public BasHealthNurse selectHealNurse(@Param("operaDate")String operaDate,@Param("operRoomId")String operRoomId,@Param("beid")String beid);
}