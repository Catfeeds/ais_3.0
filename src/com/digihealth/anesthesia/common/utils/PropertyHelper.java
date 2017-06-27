package com.digihealth.anesthesia.common.utils;

import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Copyright &reg; 2010 Powerise. All right reserved. <br/>
 * Description: <br/>
 * Author: liukui <br/>
 * Create Date: 2015-10-25 下午03:16:46 <br/>
 * Modify Info: <br/>
 * 
 * @version 1.0
 */
public class PropertyHelper {

	public static final String DateFormatString = "yyyyMMdd";

	/**
	 * 自动转换类型设置参数<br/>
	 * 注意，如果字段是date，而值不是date，则抓换为String之后，根据yyyyMMdd的格式转换成date
	 * 如果字段是String而值是date，同理转换成string 如过时空值，拷贝空值
	 * 
	 * @param bean
	 * @param field
	 * @param value
	 */
	public static void setProperty(final Object bean, final String field,
			Object value) {
		setProperty(bean, field, value, false);
	}

	/**
	 * 自动转换类型设置参数<br/>
	 * 注意，如果字段是date，而值不是date，则抓换为String之后，根据yyyyMMdd的格式转换成date
	 * 如果字段是String而值是date，同理转换成string
	 * 
	 * @param bean
	 * @param field
	 * @param value
	 */
	public static void setProperty(final Object bean, final String field,
			Object value, boolean ingoreNull) {
		try {
			// 如果对象是Map
			if (bean instanceof Map) {
				if (value == null && ingoreNull) {
					// 什么也不做
				} else {
					((Map) bean).put(field, value);
				}

			} else {
				PropertyDescriptor dis = PropertyUtils.getPropertyDescriptor(
						bean, field);

				if (dis == null) {
					// System.err.println("警告未找到类" + bean.getClass().getName() +
					// "的"
					// + field + "属性");
					return;
				}
				String nameType = dis.getPropertyType().getSimpleName();

				if (value == null) {
					if (ingoreNull) {
						// 什么也不做
					} else {
						PropertyUtils.setProperty(bean, field, null);
					}
				} else {
					// 如果源是date
					if (nameType.equalsIgnoreCase("Date")
							|| nameType.equalsIgnoreCase("Timestamp")) {
						// 目标也是date，则赋值，返回
						if (value instanceof Date) {
							PropertyUtils.setProperty(bean, field, value);
						} else {// 目标不是date，尝试转换
							String tmp = value.toString();
							try {
								SimpleDateFormat sdf = new SimpleDateFormat(
										DateFormatString);
								if (tmp.indexOf("-") == -1) {
									Date date = sdf.parse(tmp);
									PropertyUtils
											.setProperty(bean, field, date);
								} else {
									Date date = sdf.parse(tmp.replaceAll("-",
											"").substring(0, 8));
									PropertyUtils
											.setProperty(bean, field, date);
								}
							} finally {

							}
						}
					} else {// 源不是date
							// 目标是date
						if (value instanceof Date) {
							SimpleDateFormat sdf = new SimpleDateFormat(
									DateFormatString);
							value = sdf.format((Date) value);
						}

						Object setValue = null;
						if (nameType.equalsIgnoreCase("BigDecimal")) {
							if (NumberUtils.isNumber(ObjectUtils
									.toString(value))) {
								setValue = stringToBigDecimal(ObjectUtils
										.toString(value));
								PropertyUtils
										.setProperty(bean, field, setValue);
							}
						} else if (nameType.equalsIgnoreCase("String")) {
							setValue = ObjectUtils.toString(value);
							PropertyUtils.setProperty(bean, field, setValue);
						} else if (nameType.equalsIgnoreCase("Integer")) {
							setValue = ObjectUtils.toString(value);

							if (StringUtils.isBlank((String) setValue)) {
								PropertyUtils.setProperty(bean, field, null);
							} else {
								if (NumberUtils.isNumber(ObjectUtils
										.toString(value))) {
									setValue = Integer
											.parseInt((String) setValue);
									PropertyUtils.setProperty(bean, field,
											setValue);
								}
							}
						} else if (nameType.equalsIgnoreCase("Boolean")) {
							PropertyUtils.setProperty(bean, field, Boolean
									.valueOf(ObjectUtils.toString(value)));
						} else if (nameType.equalsIgnoreCase("Long")) {
							setValue = ObjectUtils.toString(value);

							if (StringUtils.isBlank((String) setValue)) {
								PropertyUtils.setProperty(bean, field, null);
							} else {
								if (NumberUtils.isNumber(ObjectUtils
										.toString(value))) {
									PropertyUtils.setProperty(bean, field, Long
											.valueOf(ObjectUtils
													.toString(value)));
								}
							}

						} else if (nameType.equalsIgnoreCase("Float")) {
							setValue = ObjectUtils.toString(value);

							if (StringUtils.isBlank((String) setValue)) {
								PropertyUtils.setProperty(bean, field, null);
							} else {
								if (NumberUtils.isNumber(ObjectUtils
										.toString(value))) {
									PropertyUtils.setProperty(bean, field,
											Float.valueOf(ObjectUtils
													.toString(value)));
								}
							}

						} else if (nameType.equalsIgnoreCase("Double")) {
							setValue = ObjectUtils.toString(value);

							if (StringUtils.isBlank((String) setValue)) {
								PropertyUtils.setProperty(bean, field, null);
							} else {
								if (NumberUtils.isNumber(ObjectUtils
										.toString(value))) {
									PropertyUtils.setProperty(bean, field,
											Double.valueOf(ObjectUtils
													.toString(value)));
								}
							}
						} else if (nameType.equalsIgnoreCase("Short")) {
							setValue = ObjectUtils.toString(value);

							if (StringUtils.isBlank((String) setValue)) {
								PropertyUtils.setProperty(bean, field, null);
							} else {
								if (NumberUtils.isNumber(ObjectUtils
										.toString(value))) {
									PropertyUtils.setProperty(bean, field,
											Short.valueOf(ObjectUtils
													.toString(value)));
								}
							}
						} else {
							if (!"Class".equals(nameType)) {
								throw new Exception("不支持的类型" + nameType);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 比较2个object值，相等为true，不相等为false
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	public static boolean compareObj(Object srcValue, Object changedValue) {
		if (srcValue == null) {
			if (changedValue != null
					&& StringUtils.isNotBlank(changedValue.toString())) {
				return false;
			} else {
				return true;
			}
		} else {
			if (srcValue instanceof Date && changedValue instanceof Date) {
				// 不直接使用equals
				// 因为TimeStamp的equals方法比较了对象类型
				return ((Date) srcValue).getTime() == ((Date) changedValue)
						.getTime();
			} else {
				return srcValue.equals(changedValue);
			}
		}
	}

	public static BigDecimal stringToBigDecimal(String bigStr) {
		if (StringUtils.isBlank(bigStr)) {
			return BigDecimal.ZERO;
		} else {
			return new BigDecimal(bigStr);
		}
	}
}
