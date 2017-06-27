package com.digihealth.anesthesia.basedata.listener;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.NestedIOException;

/**
 * 解决MyBatis的Mapper XML错误，系统起不来，也不报错问题
     * Title: MySqlSessionFactoryBean.java    
     * Description: 
     * @author chenyong       
     * @created 2016年9月14日 上午11:27:26
 */
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{
	private Logger logger = Logger.getLogger(MySqlSessionFactoryBean.class);
	
	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
		try {  
		    return super.buildSqlSessionFactory();  
		} catch (NestedIOException e) { 
			logger.error("buildSqlSessionFactory---"+e.getMessage());
		    e.printStackTrace(); // XML 有错误时打印异常。  
			throw new NestedIOException("Failed to parse mapping resource:"+ e);
		} finally {  
		    //ErrorContext.instance().reset();  
		}
	}
}
