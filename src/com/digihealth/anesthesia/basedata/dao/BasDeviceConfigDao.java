/*
 * BasDeviceConfigDao.java
 * Copyright(C) 2016 digihealth
 * All rights reserved.
 * ----------------------------------------
 * @author cy
 * 2017-03-31 Created
 */
package com.digihealth.anesthesia.basedata.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.digihealth.anesthesia.basedata.po.BasDeviceConfig;
import com.digihealth.anesthesia.basedata.po.Device;
import com.digihealth.anesthesia.common.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface BasDeviceConfigDao {
    int delete(BasDeviceConfig record);

    int insert(BasDeviceConfig record);

    int insertSelective(BasDeviceConfig record);

    BasDeviceConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BasDeviceConfig record);

    int update(BasDeviceConfig record);
    
    public List<BasDeviceConfig> getDeviceConfigList(String beid);
    
    public List<String> getUseSerialPortList(@Param("beid") String beid);
    
    public List<BasDeviceConfig> getEnableDeviceConfigList(@Param("beid") String beid);
    
    public List<Device> searchDeviceListByRoomId(@Param("roomId") String roomId,@Param("beid") String beid);
    
    public void updateStatus(Device device);
}