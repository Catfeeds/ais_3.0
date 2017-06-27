package com.digihealth.anesthesia.common.listener;

public class ConstantHolder {
	public static int IS_CUR_BE_UPDATE = 1; //是否当前局点id被修改；  1-修改，0-不修改
	public static int IS_PATH_ACCESS_UPDATE = 1; //是否路径被修改，被修改，则重新执行，并写入缓存；  1-修改  0-不修改
	
	public static final String CUR_BEID = "CUR_BEID"; //设置默认的当前CUR_BEID
	
	public static final String TOKEN_STATE = "token_state";
	
	public static final String TOKEN_CLAIMS = "claims";
	
	public static final String TOKEN_SUBFIX = "-token";
	
	public static final String TOKEN_LINK = "-";
	
	public static final String DEFAULT_BEID = "101"; //运营管理员的beid
	
	public static final String BASE_BEID = "100"; //基线的beid
	
	public static final String ROUTING_ACCESS_PREFIX = "routing_access_"; //路径
	
	public static final String ROUTING_ACCESS_LINK = "_";
	
	public static final String ROUTING_ACCESS_CACHE = "routingAccessCache";
}
