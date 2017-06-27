package com.digihealth.anesthesia.operProceed.core;

public interface MyConstants {
	
	/*---------------------------------接收http请求发送过来的命令------------------------------------------*/
	
	/**
     * 接收http请求发送过来的命令，手术初始化
     */
    public static String OPERATION_STATUS_INIT = "init";
	
	/**
     * 接收http请求发送过来的命令，手术开始
     */
    public static String OPERATION_STATUS_START = "start";
    
    /**
     * 发送设备列表
     */
    public static String OPERATION_STATUS_CHECK  ="check";
    
    /**
     * 接收http请求发送过来的命令，手术 结束
     */
    public static String OPERATION_STATUS_END = "end";
    
    /**
     * 接收http请求发送过来的命令，手术强制 结束
     */
    public static String OPERATION_STATUS_FORCEEND = "forceEnd";
    
    /**
     * 接收http请求发送过来的命令，手术模式 普通模式
     */
    public static String OPERATION_MODEL_NORMAL = "normal";
    
    /**
     * 接收http请求发送过来的命令，手术模式 抢救模式
     */
    public static String OPERATION_MODEL_SAVE = "save";
    
    /**
     * 接收http请求发送过来的命令，修改频率
     */
    public static String OPERATION_UPDATE_FREQ = "updateFreq";
    
    /**
     * 手术准备
     */
    public static String OPERATION_STATUS_READY = "ready";
    
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
     * 开始手术
     */
    public static String COMMAND_OPERATION_START = "3";
    
    /*
     * 数据处理模块发送采集服务命令
     * 结束手术
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
    
    public static String DATA_SYNC_WORKSTATION_MAINQUEUE = "Slave2Master";
    
    public static String DATA_SYNC_WORKSTATION_MASTER = "master";
    
    public static String DATA_SYNC_WORKSTATION_SLAVE = "slave";
    
    
    
    public static String ERROR_MSG_DEVICE_INIT_FAILED = "设备连接失败，请检查";
    
    public static String ERROR_MSG_MONITOR_INIT_FAILED = "监测参数设置失败，请检查";
    
    public static String ERROR_MSG_OPERATION_ALREADY_STARTED = "当前手术室手术已经开始，请先结束当前手术";
    
    public static String ERROR_MSG_OPERATION_DEVICE_CONNECT_FAILED = "当前手术室采集设备连接失败，请检查";
}
