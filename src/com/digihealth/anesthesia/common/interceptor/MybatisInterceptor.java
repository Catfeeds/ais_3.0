package com.digihealth.anesthesia.common.interceptor;

/**
 * <p>Title: digihealth  anestesia</p>
 * <p>Description: Digi-AIS</p>
 * <p>Copyright: Copyright (c) Reserved by digihealth 2015</p>
 * <p>Company: digihealth</p>
 * @author wg
 * @version 1.0
 */
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;




import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;
import com.digihealth.anesthesia.common.utils.SpringContextHolder;
import com.digihealth.anesthesia.common.task.DataSyncJob;

@Intercepts({ @Signature(type = Executor.class, method = "update", args = {
        MappedStatement.class, Object.class }) })
public class MybatisInterceptor implements Interceptor {
	
	private static Logger logger = Logger.getLogger(MybatisInterceptor.class);
	
    private DataSyncJob job;
    
    private static List<String> slaveTables = Arrays.asList("bas_observe_data","bas_operate_log","bas_user");

    @SuppressWarnings("unused")
    private Properties properties;

    public Object intercept(Invocation invocation) throws Throwable {
        if (job == null) {
            job = (DataSyncJob) SpringContextHolder
                    .getBean("dataSyncJob");
        }
        
        Object returnValue = null;
        MappedStatement mappedStatement = (MappedStatement) invocation
                .getArgs()[0];
        Object parameter = null;
        if (invocation.getArgs().length > 1) {
            parameter = invocation.getArgs()[1];
        }
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        Configuration configuration = mappedStatement.getConfiguration();
        returnValue = invocation.proceed();
        String sql = getSql(configuration, boundSql);
        //logger.info("拦截的sql语句========"+sql);
        boolean flag = true;
        for (int i = 0; i < slaveTables.size(); i++) {//控制不存入bas_observe_data表数据，不存入bas_operate_log表数据
        	String table = slaveTables.get(i);
        	boolean contains = sql.contains(table);
        	if(contains){
        		logger.info("拦截的sql="+sql+",包含"+table+"表数据，不处理"+",contains="+contains);
        		flag = false;
        		break;//不存入b_message
        	}
		}
        
        if(flag){
       		 job.saveMsg(sql);
        }
        return returnValue;
    }

    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj == null) {
            value = "null";
        } else {
            if (obj instanceof String) {
                value = "'" + obj.toString() + "'";
            } else if (obj instanceof Date) {
                DateFormat formatter = DateFormat.getDateTimeInstance(
                        DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
                value = "'" + formatter.format(obj) + "'";
                //logger.info("Date类型的obj的值为============"+value+",当前时间==="+ SysUtil.getTimeFormat(new Date()) );
            } else {
                value = obj.toString();
            }
        }
        return value;
    }

    public static String getSql(Configuration configuration, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql
                .getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (parameterMappings.size() > 0 && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration
                    .getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst("\\?",
                        getParameterValue(parameterObject));
            } else {
                MetaObject metaObject = configuration
                        .newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?", getParameterValue(obj));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql
                                .getAdditionalParameter(propertyName);
                        sql = sql.replaceFirst("\\?", getParameterValue(obj));
                    }
                }
            }
        }
        return sql;
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties0) {
        this.properties = properties0;
    }
}
