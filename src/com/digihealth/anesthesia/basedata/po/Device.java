package com.digihealth.anesthesia.basedata.po;

import java.io.Serializable;

/**
 * 设备型号
 * 
 * @author liukui
 * 
 */
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String deviceId;
	private String modelId;
	private String deviceName;
	private String roomId;
	private int interfaceType;
	private String ip;
	private String serialPort;
	private String protocol;
	private int netPort;
	private int baudRate;
	private int startBit;
	private int dataBit;
	private int stopBit;
	private String parityBit;
	private boolean connected;
	private int broadPort;// 广播端口
	private int status; // 1-设备检查成功；0-设备正在检查中；-1-设备检查失败；

	private String beid;

	/** 设备ID **/
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/** 型号ID */
	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	/** 设备名称（编码） */
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/** 手术室ID **/
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/** 接口类型，1网口、2串口 **/
	public int getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(int interfaceType) {
		this.interfaceType = interfaceType;
	}

	/** IP地址 **/
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	/** 设备的协议类型 **/
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/** 波特率 **/
	public int getBaudRate() {
		return baudRate;
	}

	public void setBaudRate(int baudRate) {
		this.baudRate = baudRate;
	}

	/** 开始位 **/
	public int getStartBit() {
		return startBit;
	}

	public void setStartBit(int startBit) {
		this.startBit = startBit;
	}

	/** 数据位 **/
	public int getDataBit() {
		return dataBit;
	}

	public void setDataBit(int dataBit) {
		this.dataBit = dataBit;
	}

	/** 停止位 **/
	public int getStopBit() {
		return stopBit;
	}

	public void setStopBit(int stopBit) {
		this.stopBit = stopBit;
	}

	/** 校验位 **/
	public String getParityBit() {
		return parityBit;
	}

	public void setParityBit(String parityBit) {
		this.parityBit = parityBit;
	}

	/** 是否连接成功 **/
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	/** 串口 **/
	public String getSerialPort() {
		return serialPort;
	}

	public void setSerialPort(String serialPort) {
		this.serialPort = serialPort;
	}

	/** 如果是网口，采集端口 **/
	public int getNetPort() {
		return netPort;
	}

	public void setNetPort(int netPort) {
		this.netPort = netPort;
	}

	public int getBroadPort() {
		return broadPort;
	}

	public void setBroadPort(int broadPort) {
		this.broadPort = broadPort;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getBeid() {
		return beid;
	}

	public void setBeid(String beid) {
		this.beid = beid;
	}

}