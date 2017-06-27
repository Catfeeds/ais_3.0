package com.digihealth.anesthesia.pacu.core;

public interface MyConstants {
	
	/*---------------------------------接收http请求发送过来的命令------------------------------------------*/
	
	/**
     * 初始化
     */
    public static String OPERATION_STATUS_INIT = "init";
	
	/**
     * 复苏开始
     */
    public static String STATUS_START = "start";
    
    /**
     * 复苏结束
     */
    public static String STATUS_END = "end";
    
    /**
     * 接收http请求发送过来的命令，修改频率
     */
    public static String UPDATE_FREQ = "updateFreq";
    
    /**
     * 修改显示配置
     */
    public static String UPDATE_PACU_CONFIG = "updatePacuConfig";
    
    /*---------------------------------数据处理模块发送采集服务消息------------------------------------------*/
    
    /*
     * 采集服务端要求的结束标识符，每种消息发出去以后需要以此结尾防止消息无法分割
     */
    public static final String END = new String(new byte[] { 0x0D });
    
    /*
     * 数据处理模块发送采集服务命令
     * 发送心跳
     */
    public static final String DEFAULT_HEART_BEAT = "100";
    
    /*
     * 数据处理模块发送采集服务命令
     * 发送监测项数据
     */
    public static String COMMAND_OPERATION_MONITOR = "1";
    
    /*
     * 数据处理模块发送采集服务命令
     * 开始
     */
    public static String COMMAND_OPERATION_START = "3";
    
    /*
     * 数据处理模块发送采集服务命令
     * 结束
     */
    public static String COMMAND_OPERATION_END = "4";
    
    
    /*---------------------------------接收采集服务消息------------------------------------------*/
    
    /**
     * 接收数据采集服务消息类型 心跳 100
     */
    public static int DATA_COLLECTOR_HEARTBEAT = 100;
    
    /**
     * 接收数据处理与采集服务通信  命令： 0  发送设备列表，返回设备连接状态
     */
    public static int DATA_COLLECTOR_DEVICE = 0;
    
    /**
     * 接收 数据采集服务消息类型 监控项数据 1
     * 数据处理与采集服务通信  命令： 1  发送监测项数据observes，返回监测项数据
     */
    public static int DATA_COLLECTOR_MONITOR = 1;
    /*---------------------------------分割------------------------------------------*/
}
