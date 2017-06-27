/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.basedata.service;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digihealth.anesthesia.basedata.formbean.BasDeviceConfigOperateFormBean;
import com.digihealth.anesthesia.basedata.formbean.BasDeviceMonitorConfigFormBean;
import com.digihealth.anesthesia.basedata.po.BasDeviceConfig;
import com.digihealth.anesthesia.basedata.po.BasDeviceMonitorConfig;
import com.digihealth.anesthesia.basedata.po.BasMonitorConfigFreq;
import com.digihealth.anesthesia.basedata.po.BasSysCode;
import com.digihealth.anesthesia.common.config.Global;
import com.digihealth.anesthesia.common.service.BaseService;
import com.digihealth.anesthesia.common.utils.GenerateSequenceUtil;

/**
 * 
 * Title: DeviceConfigService.java Description: 设备型号Service
 * 
 * @author liukui
 * @created 2015-10-7 下午6:00:54
 */
@Service
public class BasDeviceConfigService extends BaseService {
	private static final Integer ENBLE = 1; // 床旁设备可用

	public List<BasDeviceConfig> getDeviceConfigList() {
		return basDeviceConfigDao.getDeviceConfigList(getBeid());
	}

	public List<BasDeviceConfig> getEnableDeviceConfigList() {
		return basDeviceConfigDao.getEnableDeviceConfigList(getBeid());
	}

	@Transactional
	public void saveDeviceConfig(BasDeviceConfigOperateFormBean deviceConfigOperateFormBean) {
		if (deviceConfigOperateFormBean != null) {

			String roomId = Global.getConfig("roomId").toString();
			// 只有当传入的deviceConfig及子集不为空才保存当下数据
			if (deviceConfigOperateFormBean.getDeviceConfig() != null && deviceConfigOperateFormBean.getDeviceMonitorConfigList() != null) {

				BasDeviceConfig deviceConfig = deviceConfigOperateFormBean.getDeviceConfig();
				if (StringUtils.isBlank(deviceConfig.getBeid())) {
					deviceConfig.setBeid(getBeid());
				}

				deviceConfig.setRoomId(roomId);
				deviceConfig.setId(GenerateSequenceUtil.generateSequenceNo());
				// 先删除床旁设备配置表的数据，再做新增处理
				basDeviceConfigDao.delete(deviceConfig);
				if (null == deviceConfig.getEnable()) {
					deviceConfig.setEnable(ENBLE);
				}
				basDeviceConfigDao.insert(deviceConfig);

				// 获取之前设置的设备监测项勾选配置信息，设置监测项为空。注：必选项不做修改
				List<BasDeviceMonitorConfigFormBean> isChecklist = basDeviceMonitorConfigDao.getDeviceMonitorConfigList(deviceConfig.getBeid(), deviceConfig.getDeviceId(), "O");
				for (BasDeviceMonitorConfigFormBean checkPo : isChecklist) {
					BasDeviceMonitorConfig deviceMonitorConfig = new BasDeviceMonitorConfig();
					deviceMonitorConfig.setOptional(null);
					deviceMonitorConfig.setRoomId(roomId);
					deviceMonitorConfig.setDeviceId(deviceConfig.getDeviceId());
					deviceMonitorConfig.setEventId(checkPo.getEventId());
					if (StringUtils.isBlank(deviceMonitorConfig.getBeid())) {
						deviceMonitorConfig.setBeid(getBeid());
					}

					basDeviceMonitorConfigDao.update(deviceMonitorConfig);
				}
				// 将页面传入的监测项设置为勾选
				List<BasDeviceMonitorConfig> list = deviceConfigOperateFormBean.getDeviceMonitorConfigList();
				for (BasDeviceMonitorConfig deviceMonitorConfig : list) {
					deviceMonitorConfig.setRoomId(roomId);
					deviceMonitorConfig.setDeviceId(deviceConfig.getDeviceId());
					deviceMonitorConfig.setOptional("O");
					if (StringUtils.isBlank(deviceMonitorConfig.getBeid())) {
						deviceMonitorConfig.setBeid(getBeid());
					}
					basDeviceMonitorConfigDao.update(deviceMonitorConfig);
				}
			}
			// 保存采集频率配置
			if (deviceConfigOperateFormBean.getMonitorConfigFreqList() != null) {
				List<BasMonitorConfigFreq> freqList = deviceConfigOperateFormBean.getMonitorConfigFreqList();
				for (BasMonitorConfigFreq monitorConfigFreq : freqList) {
					if (StringUtils.isBlank(monitorConfigFreq.getBeid())) {
						monitorConfigFreq.setBeid(getBeid());
					}
					basMonitorConfigFreqDao.update(monitorConfigFreq);
				}
			}
		}
	}

	/**
	 * 获取串口信息
	 */
	public List<String> getUseSerialPortList() {
		List<String> serList = basDeviceConfigDao.getUseSerialPortList(getBeid());
		return serList;
	}

	/**
	 * 获取可用串口信息列表
	 */
	@Transactional
	@SuppressWarnings("rawtypes")
	public void listPortChoices() {
		logger.info(" ---- start get Serial port ---- ");
		CommPortIdentifier portId;
		Enumeration en = CommPortIdentifier.getPortIdentifiers();
		// iterate through the ports.
		// 删除码表中配置的串口信息
		basSysCodeDao.deleteByGroupId("serial_port", getBeid());

		boolean hasSerial = en.hasMoreElements();

		if (!hasSerial) {
			logger.info(" ---- current system has no Serial port ---- ");
		}
		int i = 1;
		while (en.hasMoreElements()) {
			portId = (CommPortIdentifier) en.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				String str = portId.getName();
				logger.info("listPortChoices------" + str);

				BasSysCode sysCode = new BasSysCode();
				sysCode.setGroupId("serial_port");
				sysCode.setGroupName("串口");
				sysCode.setCodeValue(str);
				sysCode.setCodeName(str);
				sysCode.setOrder(i++);
				sysCode.setBeid(getBeid());
				sysCode.setSysCodeId(GenerateSequenceUtil.generateSequenceNo());
				basSysCodeDao.insert(sysCode);
			}
		}
	}

}
