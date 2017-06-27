package com.digihealth.anesthesia.common.utils;

import java.beans.PropertyDescriptor;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Copyright &reg; 2010 Powerise. All right reserved. <br/>
 * Description: <br/>
 * Author: liukui <br/>
 * Create Date: 2015-10-25 下午03:16:46 <br/>
 * Modify Info: <br/>
 * 
 * @version 1.0
 */
public class BeanHelper {

	/**
	 * 拷贝属性<br/>
	 * 有如下2个优势<br/>
	 * 1. 不会像apache的BeanUtils那样,给Long这种封装类型在为null时设值为0<br/>
	 * 2. 不会像spring的BeanHelper那样不会自动转换类型<br/>
	 * 注意：<br/>
	 * 如果源bean中字段是date，而目标bean值不是date，则根据yyyyMMdd的格式转换为String之后赋值<br/>
	 * 如果源bean中字段不是Date,而目标bean值是date，同理根据yyyyMMdd的格式转换成Date之后赋值
	 * 
	 * @param source
	 *            源
	 * @param target
	 *            目标
	 * @param ignoreNull
	 *            是否忽略空值，默认为否
	 */
	public static void copyProperties(Object source, Object target) {
		copyProperties(source, target, false);
	}

	/**
	 * 拷贝属性<br/>
	 * 有如下2个优势<br/>
	 * 1. 不会像apache的BeanUtils那样,给Long这种封装类型在为null时设值为0<br/>
	 * 2. 不会像spring的BeanHelper那样不会自动转换类型<br/>
	 * 注意：<br/>
	 * 如果源bean中字段是date，而目标bean值不是date，则根据yyyyMMdd的格式转换为String之后赋值<br/>
	 * 如果源bean中字段不是Date,而目标bean值是date，同理根据yyyyMMdd的格式转换成Date之后赋值
	 * 
	 * @param source
	 *            源
	 * @param target
	 *            目标
	 * @param ignoreNull
	 *            是否忽略空值，默认为否
	 */
	public static void copyProperties(Object source, Object target,
			boolean ignoreNull) {
		if (source instanceof Map) {
			Map sourceMap = (Map) source;
			Set<Entry<String, Object>> entrySet = sourceMap.entrySet();
			for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
				try {
					Entry<String, Object> entry = (Entry<String, Object>) iterator
							.next();
					PropertyHelper.setProperty(target, entry.getKey(),
							entry.getValue(), ignoreNull);
				} catch (Exception e) {
					System.out.println("warn:" + e.getMessage());
				}
			}
		} else {
			PropertyDescriptor[] sourceProperties = PropertyUtils
					.getPropertyDescriptors(source);
			for (int i = 0; i < sourceProperties.length; i++) {
				try {
					String sourcefieldName = sourceProperties[i].getName();
					Object sourcefieldValue = null;
					sourcefieldValue = PropertyUtils.getProperty(source,
							sourcefieldName);
					PropertyHelper.setProperty(target, sourcefieldName,
							sourcefieldValue, ignoreNull);
				} catch (Exception e) {
					System.out.println("warn:" + e.getMessage());
				}
			}
		}
	}

	/**
	 * 拷贝属性<br/>
	 * 有如下2个优势<br/>
	 * 1. 不会像apache的BeanUtils那样,给Long这种封装类型在为null时设值为0<br/>
	 * 2. 不会像spring的BeanHelper那样不会自动转换类型<br/>
	 * 注意：<br/>
	 * 如果源bean中字段是date，而目标bean值不是date，则根据yyyyMMdd的格式转换为String之后赋值<br/>
	 * 如果源bean中字段不是Date,而目标bean值是date，同理根据yyyyMMdd的格式转换成Date之后赋值
	 * 
	 * @param source
	 *            源
	 * @param target
	 *            目标
	 * @param PropertyName
	 *            只copy的属性名数组集合。
	 */
	public static void copyProperties(Object source, Object target,
			String[] PropertyName) {
		if (source instanceof Map) {
			Map sourceMap = (Map) source;
			Set<Entry<String, Object>> entrySet = sourceMap.entrySet();
			for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
				try {
					Entry<String, Object> entry = (Entry<String, Object>) iterator
							.next();
					for (String cname : PropertyName) {
						if (entry.getKey().equals(cname)) {
							PropertyHelper.setProperty(target, entry.getKey(),
									entry.getValue(), false);
						}
					}
				} catch (Exception e) {
					System.out.println("warn:" + e.getMessage());
				}
			}
		} else {
			PropertyDescriptor[] sourceProperties = PropertyUtils
					.getPropertyDescriptors(source);
			for (int i = 0; i < sourceProperties.length; i++) {
				try {
					String sourcefieldName = sourceProperties[i].getName();
					for (String cname : PropertyName) {
						if (sourcefieldName.equals(cname)) {

							Object sourcefieldValue = null;
							sourcefieldValue = PropertyUtils.getProperty(
									source, sourcefieldName);
							PropertyHelper.setProperty(target, sourcefieldName,
									sourcefieldValue, false);
						}
					}
				} catch (Exception e) {
					System.out.println("warn:" + e.getMessage());
				}
			}
		}
	}

}
