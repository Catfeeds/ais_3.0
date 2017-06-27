/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BasDeviceMonitorConfigFormBean;
import com.digihealth.anesthesia.basedata.po.BasDeviceMonitorConfig;
import com.digihealth.anesthesia.common.service.BaseService;

/**
 * 
 * Title: DeviceConfigService.java Description: 设备型号Service
 * 
 * @author liukui
 * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasDeviceMonitorConfigService extends BaseService {
	/**
	 * 根据房间号、设备id获取设备可采集项
	 * @param deviceId
	 * @return
	 */
	public List<BasDeviceMonitorConfigFormBean> getDeviceMonitorConfigList(String deviceId,String optional) {
		return basDeviceMonitorConfigDao.getDeviceMonitorConfigList(getBeid(),deviceId,optional);
	}

	/**
	 * 修改床旁设备配置监测项
	 * @param Device
	 */
	@Transactional
	public void updateDeviceMonitorConfig(BasDeviceMonitorConfig deviceMonitorConfig) {
	    if (StringUtils.isBlank(deviceMonitorConfig.getBeid()))
	    {
	        deviceMonitorConfig.setBeid(getBeid());
	    }
	    
		basDeviceMonitorConfigDao.update(deviceMonitorConfig);
	}
}
