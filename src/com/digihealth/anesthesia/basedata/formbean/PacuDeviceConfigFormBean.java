package com.digihealth.anesthesia.basedata.formbean;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "pacu床旁设备配置参数对象")
public class PacuDeviceConfigFormBean {
	/**
	 * 设备id
	 */
	@ApiModelProperty(value = "设备id")
	private String deviceId;

	/**
	 * 设备厂商
	 */
	@ApiModelProperty(value = "设备厂商")
	private String deviceFactory;

	/**
	 * 设备类型：1.手术室终端；2：复苏室终端；3：心电监护仪、4：呼吸机、5：麻醉机
	 */
	@ApiModelProperty(value = "设备类型：1.手术室终端；2：复苏室终端；3：心电监护仪、4：呼吸机、5：麻醉机")
	private Integer deviceType;

	/**
	 * 设备型号
	 */
	@ApiModelProperty(value = "设备型号")
	private String devicemodel;

	/**
	 * 设备名称
	 */
	@ApiModelProperty(value = "设备名称")
	private String deviceName;

	/**
	 * 接口类型
	 */
	@ApiModelProperty(value = "接口类型")
	private Integer interfaceType;

	@ApiModelProperty(value = "接口名称")
	private String interfaceName;

	/**
	 * 床id
	 */
	@ApiModelProperty(value = "床位id")
	private String bedId;

	/**
	 * pacu室ID
	 */
	@ApiModelProperty(value = "pacu室ID")
	private String roomId;

	/**
	 * ip地址
	 */
	@ApiModelProperty(value = "ip地址")
	private String ipAddress;

	/**
	 * 串口设备接到电脑上的端口,COM1~COM10
	 */
	@ApiModelProperty(value = "串口设备接到电脑上的端口,COM1~COM10")
	private String serialPort;

	/**
	 * 是否有效 1有效 0 无效
	 */
	@ApiModelProperty(value = "是否有效 1有效 0 无效")
	private String enable;

	/**
	 * 床位设备对应的采集项列表
	 */
	@ApiModelProperty(value = "床位设备对应的采集项列表")
	private List<PacuBedEventConfigFormBean> bedEventConfigList;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceFactory() {
		return deviceFactory;
	}

	public void setDeviceFactory(String deviceFactory) {
		this.deviceFactory = deviceFactory;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getDevicemodel() {
		return devicemodel;
	}

	public void setDevicemodel(String devicemodel) {
		this.devicemodel = devicemodel;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Integer getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(Integer interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSerialPort() {
		return serialPort;
	}

	public void setSerialPort(String serialPort) {
		this.serialPort = serialPort;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public List<PacuBedEventConfigFormBean> getBedEventConfigList() {
		return bedEventConfigList;
	}

	public void setBedEventConfigList(
			List<PacuBedEventConfigFormBean> bedEventConfigList) {
		this.bedEventConfigList = bedEventConfigList;
	}

}
