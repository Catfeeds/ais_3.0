package com.digihealth.anesthesia.basedata.formbean;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "pacu设备表参数对象")
public class PacuDeviceSpecFormBean {
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
	 * 设备协议名称
	 */
	@ApiModelProperty(value = "设备协议名称")
	private String protocol;

	@ApiModelProperty(value = "端口")
	private Integer netport;

	@ApiModelProperty(value = "端口")
	private Integer broadport;

	/**
	 * startbit
	 */
	@ApiModelProperty(value = "startbit")
	private Integer startbit;

	/**
	 * 串口停止位
	 */
	@ApiModelProperty(value = "串口停止位")
	private Integer stopbit;

	/**
	 * 串口数据位
	 */
	@ApiModelProperty(value = "串口数据位")
	private Integer databit;

	/**
	 * 串口奇偶校验
	 */
	@ApiModelProperty(value = "串口奇偶校验")
	private String paritybit;

	/**
	 * 接口类型
	 */
	@ApiModelProperty(value = "接口类型")
	private Integer interfaceType;

	@ApiModelProperty(value = "接口名称")
	private String interfaceName;

	/**
	 * 波特率
	 */
	@ApiModelProperty(value = "波特率")
	private Integer baudRate;

	/**
	 * 设备名称
	 */
	@ApiModelProperty(value = "设备名称")
	private String deviceName;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId == null ? null : deviceId.trim();
	}

	public String getDeviceFactory() {
		return deviceFactory;
	}

	public void setDeviceFactory(String deviceFactory) {
		this.deviceFactory = deviceFactory == null ? null : deviceFactory
				.trim();
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
		this.devicemodel = devicemodel == null ? null : devicemodel.trim();
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol == null ? null : protocol.trim();
	}

	public Integer getNetport() {
		return netport;
	}

	public void setNetport(Integer netport) {
		this.netport = netport;
	}

	public Integer getBroadport() {
		return broadport;
	}

	public void setBroadport(Integer broadport) {
		this.broadport = broadport;
	}

	public Integer getStartbit() {
		return startbit;
	}

	public void setStartbit(Integer startbit) {
		this.startbit = startbit;
	}

	public Integer getStopbit() {
		return stopbit;
	}

	public void setStopbit(Integer stopbit) {
		this.stopbit = stopbit;
	}

	public Integer getDatabit() {
		return databit;
	}

	public void setDatabit(Integer databit) {
		this.databit = databit;
	}

	public String getParitybit() {
		return paritybit;
	}

	public void setParitybit(String paritybit) {
		this.paritybit = paritybit == null ? null : paritybit.trim();
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
		this.interfaceName = interfaceName == null ? null : interfaceName
				.trim();
	}

	public Integer getBaudRate() {
		return baudRate;
	}

	public void setBaudRate(Integer baudRate) {
		this.baudRate = baudRate;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

}
