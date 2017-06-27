package com.digihealth.anesthesia.websocket;

public interface Constants {
	/**
	 * 打开websocket
	 */
	public static String WEBSOCKET_ONOPEN = "ONOPEN";
	/**
	 * websocket 关闭socket
	 */
	public static String WEBSOCKET_CLOSE = "CLOSE";
	/**
	 * websocket 接收前端发送过来的消息
	 */
	public static String WEBSOCKET_ONMESSAGE = "ONMESSAGE";

}
