package com.digihealth.anesthesia.basedata.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.po.Device;
import com.digihealth.anesthesia.common.service.BaseService;

@Service
public class BasDeviceService extends BaseService {
	
	public List<Device> searchDeviceListByRoomId(String roomId,String beid) {
		if(StringUtils.isBlank(beid)){
			beid = getBeid();
		}
		return basDeviceConfigDao.searchDeviceListByRoomId(roomId,beid);
	}
	
	@Transactional
	public void updateDeviceList(List<Device> devices){
		for (int i = 0; i < devices.size(); i++) {
			Device device = devices.get(i);
			if(StringUtils.isBlank(device.getBeid())){
				device.setBeid(getBeid());
			}
			basDeviceConfigDao.updateStatus(device);
		}
	}

}
