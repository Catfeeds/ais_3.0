package com.digihealth.anesthesia.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.digihealth.anesthesia.common.config.Global;

public class ConnectionManager {
	private static Logger logger = Logger.getLogger(ConnectionManager.class);
	
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

	private static String JDBC_DRIVER_CLASS = Global.getJdbcConfig("jdbc.driver.oracle");
	private static String JDBC_URL = Global.getJdbcConfig("jdbc.url.oracle");
	private static String JDBC_USERNAME = Global.getJdbcConfig("jdbc.username.oracle");
	private static String JDBC_PASSWORD = Global.getJdbcConfig("jdbc.password.oracle");

	/**
	 * 从连接池拿Connection
	 * 
	 * getConnection和connectionHolder.get()的区别
	 * connectionHolder.get()是尝试从ThreadLocal中获取Connection,如果没有,返回null,如果有,直接返回.
	 * getConnection也是尝试从ThreadLocal中获取Connection,如果没有,则创建一个,然后返回,如果有,直接返回.
	 */
	public static Connection getConnection() {

		Connection connection = connectionHolder.get();

		if (connection == null) {
			// 1.连接池可以理解是一个java类,必须实现接口DateSource
			// 2.DBCP连接池也是一个java类,Tomcat为其new了对象并注册到JNDI,同时Tomcat实现了JavaEE规范之一的JNDI
			// 3.Context接口的lookup()可以从JNDI获取对象,通过名值对的形式;下面语句获取连接池对象(DateSource类型)
			try {
				Class.forName(JDBC_DRIVER_CLASS); // classLoader,加载对应驱动
				connection = (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("ConnectionManager--getConnection(SQLException):"+e.getMessage());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.error("ConnectionManager--getConnection(ClassNotFoundException):"+e.getMessage());
			}
			// 直接从连接池拿连接,不是此时才让Oracle去创建连接
			connectionHolder.set(connection);
		}
		return connection;
	}

	/**
	 * Connection使用完毕,关闭
	 * 此处的Connection是从连接池中拿出来的,关闭Connection实质上是让Connection恢复空闲状态
	 */
	public static void closeConnection() {
		// 尝试从ThreadLocal获取Connection,如果没有,关闭Connection失去意义.
		Connection connection = connectionHolder.get();

		if (connection != null) {
			try {
				connection.close();
				connectionHolder.remove();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("ConnectionManager--closeConnection(SQLException):"+e.getMessage());
			}
		}
	}
}
